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
    public void registraMuseu(modelo.Museu m) throws Exception{
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
            if(tipo == 3)
            {                
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
        System.out.println("QUantidade deve ser 2: " + results);
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
