/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
/**
 *
 * @author Gui
 */
public class ConexaoSQL {
    
    String server;
    String base;
    private modelo.Usuario currentUser;
    
    public ConexaoSQL(String server, String base)
    {
        this.server = server;
        this.base = base;
    }
    public Connection connect() throws Exception{
        String driverName = "org.gjt.mm.mysql.Driver";
        Class.forName(driverName);

        String url = "jdbc:mysql://" + server + ":3306/" + base;

        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public void atualizaUsuario(modelo.Usuario atualizado, String opt) throws Exception{
        System.out.println("Atualizando usuario no Banco de Dados...");
        
        Connection conn = connect();
        String query = "update usuario set cpf = ?, nome = ?, email = ?, senha = ?, tipo = ? where cpf='" + atualizado.getCpf() +"';";
        PreparedStatement psmt = conn.prepareStatement(query);        
        
        int tipo = 0;        
        if(opt.equals("Pesquisador")){
            tipo = 0;
        }else if(opt.equals("Tecnico")){
            tipo = 1;
        }else if(opt.equals("Diretor")){
            tipo = 2;
        }else{
            tipo = 3;
        }
        
        psmt.setString(1, atualizado.getCpf());
        psmt.setString(2, atualizado.getNome());
        psmt.setString(3, atualizado.getEmail());
        psmt.setString(4, atualizado.getSenha());
        psmt.setInt(5, tipo);
        
        psmt.execute();
        conn.close();       
        
        atualizaPermissoes(atualizado.getMuseusPermitidos(), atualizado.getCpf());
        
        
        
    }
    public void registraUsuario(modelo.Usuario user, int tipo) throws Exception{
        System.out.println("Museus do usuario adicionado: ");
        user.showMuseus();
        
        Connection conn = connect();
        String query = "insert into usuario (cpf, nome, email, senha, tipo) values (?, ?, ?, ?, ?)";
        PreparedStatement psmt = conn.prepareStatement(query);
        
        psmt.setString(1, user.getCpf());
        psmt.setString(2, user.getNome());
        psmt.setString(3, user.getEmail());
        psmt.setString(4, user.getSenha());
        psmt.setInt(5, tipo);
       
        
        psmt.execute();
        
        atualizaPermissoes(user.getMuseusPermitidos(), user.getCpf());
        conn.close();
        
    }
    public void atualizaPermissoes(String m[], String cpf) throws Exception{
        Connection conn = connect();
        String query = "delete from usuario_museu where cpfUsuario ='" + cpf + "';";
        PreparedStatement psmt = conn.prepareStatement(query);
        //Primeiro remove todas as permissoes atuais do BD
        psmt.execute();
        
        //Pega ids dos museus para adicionar
        Statement stmt = conn.createStatement();
        ResultSet rs;
        String names = new String();
        //Escreve array com os museus para pesquisar no BD
        for(int i = 0; i < m.length; i++){
            names += "'" + m[i] + "'";
            if(i < m.length-1){
                names += ", ";
            }
        }
        System.out.println("NOMES: " + names);
        query = "select id from museu where nome in(" + names + ")";
        rs = stmt.executeQuery(query);
        ArrayList<Integer> idPermissoes = new ArrayList<>();
        
        while(rs.next()){
            idPermissoes.add(rs.getInt("id"));
            
        }
        
        //Insere as novas permissoes
        for(int i = 0; i< idPermissoes.size(); i++){
            int curr_id = idPermissoes.get(i);
            System.out.println("Inserindo id = " + curr_id);
            query = "insert into usuario_museu (cpfUsuario, idMuseu) values (?, ?)";
            psmt = conn.prepareStatement(query);
            psmt.setString(1, cpf);
            psmt.setInt(2, curr_id);
            psmt.execute();
        }
        
        
        conn.close();
        
    }
    public void registraMuseu(modelo.Museu m) throws Exception
    {
        Connection conn = connect();
        String query = "insert into museu (nome, site, data, telefone, horaAberto, horaFechado) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement psmt = conn.prepareStatement(query);            
        psmt.setString(1, m.getNome());
        psmt.setString(2, m.getSite());
        psmt.setString(3, m.getData());
        psmt.setString(4, m.getTelefone());
        psmt.setString(5, m.getHorarioAbertura());
        psmt.setString(6, m.getHorarioFechamento());
        
        psmt.execute();
        conn.close();

    }
    public void registraColecao(modelo.Colecao c) throws Exception
    {
        Connection conn = connect();
        String query = "insert into colecao (idMuseu, nome, descricao, data) values (?, ?, ?, ?);";
        PreparedStatement psmt = conn.prepareStatement(query);
        
        
        //Pegar o id do museu
        int mId = getMuseuIdByName(c.getMuseu(), conn);
        psmt.setInt(1, mId);
        psmt.setString(2, c.getNome());
        psmt.setString(3, c.getDescricao());
        psmt.setString(4, c.getData());
        
        psmt.execute();
        conn.close();
    }
    public int getMuseuIdByName(String name, Connection conn) throws Exception
    {
        String query = "select id from museu where nome = '" + name + "';";
         Statement stmt = conn.createStatement();
         ResultSet rs;
         rs = stmt.executeQuery(query);
         int result = -1;
         if(rs.next() != false){
             result = rs.getInt("id");
         }
        return result;
    }
    public int autenticaUsuario(String cpf, String senha) throws Exception
    {
        Connection conn = connect();
        int tipo = -1;
        
        if(conn.isClosed() == false)
        {
            Statement stmt = conn.createStatement();            
            //Verifica se o usuario existe no banco de dados
            String query = "select * from usuario where cpf='" + cpf + "' AND senha='" + senha + "';";
            ResultSet rs ;
            rs = stmt.executeQuery(query);
            if(rs.next() == false)
            {
                conn.close();
                return -1;
            }
            String m[] = {""};
            tipo = rs.getInt("tipo");    
            
            //Cria o usuario de acordo com o tipo            
            if(tipo == 3){                
                currentUser = new modelo.Coordenador(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), m);
            }else if(tipo == 2)
            {
                currentUser = new modelo.Diretor(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), m);
            }else if(tipo == 1)
            {
                currentUser = new modelo.Tecnico(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), m);
            }else{
                currentUser = new modelo.Pesquisador(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), m);
            }
            
            //Pega os museus onde o usuario é autorizado
            m = getUsuarioMuseus(cpf, conn);
            currentUser.setMuseusPermitidos(m);
        }
        
        conn.close();
        return tipo;
        
    }
    public modelo.Usuario getCurrentUser(){
        return currentUser;
    }
    public void getUsuarios(ArrayList destino) throws Exception{
        Connection conn = connect();
        Statement stmt = conn.createStatement();
        String query = "select * from usuario";
        ResultSet rs;
        rs = stmt.executeQuery(query);
        modelo.Usuario user = null;
        
        while(rs.next()){
            
            int tipo = rs.getInt("tipo");
            
            String m[] = {""};
            
            switch (tipo) {
                case 0:
                    user = new modelo.Pesquisador(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), m);
                    break;
                case 1:
                    user = new modelo.Tecnico(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), m);
                    break;
                case 2:
                    user = new modelo.Diretor(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), m);
                    break;
                case 3:
                     user = new modelo.Coordenador(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"), m);
                    break;
                default:
                    break;
            }
            
            destino.add(user);
            
           
        }
        
        conn.close();
    }
    public void getMuseus(ArrayList destino) throws Exception{
        Connection conn = connect();
        Statement stmt = conn.createStatement();
        String query = "select * from museu";
        ResultSet rs;
        rs = stmt.executeQuery(query);
        
        while(rs.next()){
            
            modelo.Museu novoMus = new modelo.Museu(rs.getString("nome"), rs.getString("data"), rs.getString("endereco"), rs.getString("cidade"), rs.getString("estado"), rs.getString("horaAberto"), rs.getString("horaFechado"), rs.getString("site"), rs.getString("telefone"), rs.getString("descricao"));
            destino.add(novoMus);
        }
        
        conn.close();
    }
    public void getColecoes(ArrayList destino) throws Exception{
        Connection conn = connect();
        Statement stmt = conn.createStatement();   
        String query = "select * from colecao";
        ResultSet rs;
        rs = stmt.executeQuery(query);
        
        while(rs.next()){
            
            modelo.Colecao novaCol = new modelo.Colecao(rs.getString("nome"), rs.getString("data"), getMuseuNameById(rs.getInt("idMuseu")), rs.getString("descricao"));
            destino.add(novaCol);
        }
        
         conn.close();
    }
    public String getMuseuNameById(int id) throws Exception{
        
        Connection temp = connect();
        Statement stmt = temp.createStatement();  
        String query = "select nome from museu where id='" + id + "'";
        ResultSet rs;
        rs = stmt.executeQuery(query);
        String result = "Null";
        if(rs.next()!=false){
            result = rs.getString("nome");
        }
        return result;
    }
    public String[] getUsuarioMuseus(String cpf, Connection conn) throws Exception
    {
         System.out.println("Buscando os museus do usuario...");
        Statement stmt = conn.createStatement();  
        String query = "select museu.nome\n" +
                        "from museu\n" +
                        "join usuario_museu\n" +
                        "on usuario_museu.idMuseu = museu.id\n" +
                        "join usuario\n" +
                        "on usuario.cpf = usuario_museu.cpfUsuario\n" +
                        "where usuario.cpf = '" + cpf + "'";
        ResultSet rs ;
        ResultSetMetaData rsmd;
        rs = stmt.executeQuery(query);       
        
        //Caso o usuario nao tenha nenhum museu autorizado
        if(rs.next() == false)
        {
            System.out.println("-- Nenhum museu encontrado");
          return new String[]{""};
        }
        
        rs.beforeFirst();
        int results = 0;
        //Contar o numero de resultados (quantidade de museus do usuario)
        while(rs.next() != false){
            results++;
        }
        
        rs.beforeFirst();
        
        String[] museus = new String[results];
        
        int i = 0;
        while(rs.next())
        {
            museus[i] = rs.getString("nome");
            i++;
        }
        
        return museus;        
        
        
        
    }
}
