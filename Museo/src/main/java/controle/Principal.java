/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import modelo.Colecao;
import modelo.Coordenador;
import modelo.Diretor;
import modelo.Museu;
import modelo.Obra;
import modelo.Pesquisador;
import modelo.Pintura;
import modelo.Tecnico;
import modelo.Usuario;

import visao.VisaoPrincipal;

/**
 *
 * @author Gleider
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    private Usuario usuarioAutenticado;
    private ArrayList<Museu> museusCadastrados;
    private ArrayList<Usuario> usuariosCadastrados;
    private ArrayList<Colecao> colecoesCadastros;
    
    private static Principal instancia;
    private Elasticsearch elastic;
    private ConexaoSQL conn;
    
    private void init()
    {
       usuarioAutenticado = new modelo.Visitante();
       museusCadastrados = new ArrayList<>();
       usuariosCadastrados = new ArrayList<>();
       colecoesCadastros = new ArrayList<>();
       elastic = new Elasticsearch("localhost","9200");
       conn = new ConexaoSQL("localhost", "museo");

    }
    private Principal()
    {
        System.setProperty("swing.aatext", "true" );
        System.setProperty("awt.useSystemAAFontSettings","on"); 
        init();
        
    }
    public static Principal getInstance()
    {
        if(instancia == null)
        {
            instancia = new Principal();
        }
        return instancia;
    }
    public Usuario getUsuarioAutenticado(){
        return usuarioAutenticado;
    }
    public void registraMuseu(String nome, String data, String endereco, String cidade, String estado, String fun1, String fun2, String site, String telefone, String descricao){    
        if(usuarioAutenticado instanceof modelo.Coordenador)
        {
             museusCadastrados.add(new Museu(nome, data, endereco, cidade, estado, fun1, fun2, site, telefone, descricao));
         }
        
    }
    public boolean registraObra(Obra o,boolean update)
    {
        return elastic.insereObra(o, update);
    }
    public void registraColecao(String nome, String data, String museu, String descricao)
    {
        colecoesCadastros.add(new Colecao(nome, data, museu, descricao));
                
    }
    public void atualizaUsuario(String nome, String cpf, String email, String senha, String museusSelecionados[], String opt, String oldCpf) throws Exception{
        System.out.println("Atualizando usuario no sistema...");
        //Encontrar o usuario
        Usuario atualizado = getUsuario(oldCpf); 
        removerUsuario(oldCpf);
        atualizado.setNome(nome);
        atualizado.setEmail(email);
        atualizado.setCpf(cpf);
        atualizado.setSenha(senha);
        atualizado.setMuseusPermitidos(museusSelecionados);
        
        
        usuariosCadastrados.add(atualizado);
        conn.atualizaUsuario(atualizado, opt);
                
    }
    public void removerUsuario(String cpf) throws Exception{
        for(int i = 0; i < usuariosCadastrados.size(); i++){
            if(usuariosCadastrados.get(i).getCpf().equals(cpf)){
                usuariosCadastrados.remove(usuariosCadastrados.get(i));
            }
        }
    }
    public void registraPesquisador(String nome,String cpf,String email,String senha,String museusSelecionados[])
    {
        Pesquisador user = new Pesquisador(nome,cpf,email,senha,museusSelecionados);
        usuariosCadastrados.add(user);
        try{
            registraUsuarioDB(user, 0);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    public void registraTecnico(String nome,String cpf,String email,String senha,String museusSelecionados[])
    {
        Tecnico user = new Tecnico(nome,cpf,email,senha,museusSelecionados);
        usuariosCadastrados.add(user);
        try{
            registraUsuarioDB(user, 1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void registraDiretor(String nome,String cpf,String email,String senha,String museusSelecionados[])
    {  
         Diretor user = new Diretor(nome,cpf,email,senha,museusSelecionados);
         usuariosCadastrados.add(user);
         try{
            registraUsuarioDB(user, 2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void registraCoordenador(String nome,String cpf,String email,String senha,String museusSelecionados[])
    {
        Coordenador user = new Coordenador(nome,cpf,email,senha,museusSelecionados);
        usuariosCadastrados.add(user);
        try{
            registraUsuarioDB(user, 3);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void registraUsuarioDB(Usuario user, int tipo) throws Exception{
        conn.registraUsuario(user, tipo);
    }
    public boolean checaPermissaoTecnico()
    {
        return usuarioAutenticado instanceof modelo.Tecnico;
    }
    public boolean checaPermissaoDiretor()
    {
        return usuarioAutenticado instanceof modelo.Diretor;
    }
    public boolean checaPermissaoCoordenador()
    {
        return usuarioAutenticado instanceof modelo.Coordenador;
    }
    
    /*
        Retorna lista de usuarios que contem em seu nome, o valor passado
        @param nome -  nome utilizado na busca
        @return lista de usuarios 
    */
    public ArrayList<Usuario> buscaUsuariosNome(String nome)
    {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        for(Usuario u : usuariosCadastrados)
        {
            if(u.getNome().toLowerCase().contains(nome.toLowerCase()))
            {
                if(u.getClass().isInstance(usuarioAutenticado))
                {
                    listaUsuarios.add(u);       
                }
            }
        }
        return listaUsuarios;
    }
    
    public ArrayList<Usuario> buscaUsuariosCPF(String cpf)
    {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        for(Usuario u : usuariosCadastrados)
        {
            if(u.getCpf().contains(cpf))
            {
                if(u.getClass().isInstance(usuarioAutenticado))
                {
                    listaUsuarios.add(u);
                }
            }
        }
        return listaUsuarios;
    }
    /*
        Retorna lista de museus a qual o usuario autenticado pertence
    */
    public String[] getMuseusUsuario()
    {
        return usuarioAutenticado.getMuseusPermitidos();
    }
    
    /*
        Devolve a lista de museus cadastrados no controle
    */
    public ArrayList<Museu> getMuseusCadastrados() {
        return museusCadastrados;
    }
    
    public ArrayList<Usuario> getUsuariosCadastrados() {
        return usuariosCadastrados;      
    }

    public void setUsuariosCadastrados(ArrayList<Usuario> usuariosCadastrados) {
        this.usuariosCadastrados = usuariosCadastrados;
    }

    /*
        Retorna permissao de cadastro do usuario autenticado
        Um tecnico so pode cadastrar Pesquisadores
        Um Diretor pode cadastrar Pesquisadores e tecnicos
        Um coordenador pode cadastrar todos acima
    */
    public String[] getPermissaoCadastro()
    {
        return usuarioAutenticado.getPermissaoCadastro();
    }
    /*
        Retorna tipo do usuario autenticado
        Visitante,Pesquisador,Tecnico,Diretor ou coordenador
    */
    public String getTipoUsuarioAutenticado()
    {
        return String.valueOf(usuarioAutenticado.getClass());
    }
    /*
        Retorna nome do usuario autenticado
        @return string nome do usuario autenticado
    */
    public String getNomeUsuarioAutenticado()
    {
        return usuarioAutenticado.getNome();
    }
    /*
        Este método é responsável por realizar a autenticação de um usuário com o sistema.
        @param cpf - cpf do usuario a ser autenticado
        @param senha - senha do usuario a ser autenticado
        @return true - se a autenticação ocorreu com sucesso
        
    */
    public boolean autenticaUsuario(String cpf,String senha) throws Exception
    {
        for(Usuario user : usuariosCadastrados)
        {
            if(user.getCpf().equals(cpf) && user.getSenha().equals(senha)) //se usuario e senha batem, autentica
            {
                usuarioAutenticado = user;
                return true;
            }
        }
        
        //Não achou nas configs local vai procurar no Banco de Dados
        int userStatus = conn.autenticaUsuario(cpf, senha);
        if(userStatus != -1)
        {            
            usuarioAutenticado = conn.getCurrentUser();
            
            loadMuseus();
            loadColecoes();
            loadUsuarios();
            return true;
        }
        return false;
    }
    
    public Usuario getUsuario(String cpf)
    {
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            if(usuariosCadastrados.get(i).getCpf().equals(cpf))
            {
                return usuariosCadastrados.get(i);
            }
        }
        return null;
    }
   
    /*
        Classe utilitaria, retorna lista de paises
    */
    public static String[] getListaPais()
    {
        String[] locales = Locale.getISOCountries();
        String[] paises = new String[locales.length];
        Locale locale = new Locale("pt","BR");
        int i = 0;
	for (String countryCode : locales) {
	    Locale obj = new Locale("", countryCode);
	    paises[i] = obj.getDisplayCountry(locale);
            i++;
        }
        return paises;
    }
    /*
    Verifica se o cpf informado já consta no cadastro
    */
    public boolean checaCpfCadastro(String cpf)
    {
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            if(usuariosCadastrados.get(i).getCpf().equals(cpf)) //se o cpf ja existe, retorna true
            {
                return true;
            }
        }
        return false;
    }
    public void autenticaVisitante()
    {
        this.usuarioAutenticado = new modelo.Visitante();
    }
    
    
    public String[] getColecaoOfMuseu(String m)
    {
        int size = 0;
        for(int i = 0; i < colecoesCadastros.size(); i++)
        {
            if(colecoesCadastros.get(i).getMuseu().equals(m))
            {
                size++;
            }
        }
        
        String selecionados[] = new String[size];
        int j = 0;
        
        for(int i=0; i < colecoesCadastros.size(); i++)
        { 
            if(colecoesCadastros.get(i).getMuseu().equals(m))
            {
                selecionados[j] = colecoesCadastros.get(i).getNome();
                j++;

            }
        }
        return selecionados;
    }

    public ArrayList<Colecao> getColecoesCadastros() {
        return colecoesCadastros;
    }

    public void setColecoesCadastros(ArrayList<Colecao> colecoesCadastros) {
        this.colecoesCadastros = colecoesCadastros;
    }
    public Obra[] buscaObra(String query,String filtro)
    {
        try
        {
            return elastic.buscaObra(query,filtro);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Obra o[] = new Obra[1]; //hackzinho
        o[0] = new Pintura();
        return o;
    }
    public boolean deletaObra(Obra o)
    {
        return elastic.deletaObra(o);
    }
    public void saveMuseuToDB(Museu m) throws Exception
    {
        conn.registraMuseu(m);
    }
    public void saveColecaoToDB(Colecao c) throws Exception
    {
        conn.registraColecao(c);
    }
    public void loadColecoes() throws Exception
    {
        conn.getColecoes(colecoesCadastros);
    }
    public void loadMuseus() throws Exception{
        conn.getMuseus(museusCadastrados);        
    }
    public void loadUsuarios() throws Exception{
        conn.getUsuarios(usuariosCadastrados);
    }
    public static void main(String[] args) throws Exception {
        
        Principal p = getInstance();
        p.autenticaUsuario("111.111.111-11","1");
        VisaoPrincipal vp = new VisaoPrincipal();
        vp.setVisible(true);
        vp.setTitle("Museo - Sistema Integrado de Museus");
        vp.setLocationRelativeTo(null); //centraliza janela
        
        //vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
