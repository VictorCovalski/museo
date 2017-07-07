/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.Locale;
import modelo.Arquitetura;
import modelo.Colecao;
import modelo.Coordenador;
import modelo.Diretor;
import modelo.Escultura;
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
    private ArrayList<Obra> obras;
    private ArrayList<Colecao> colecoesCadastros;
    
    private static Principal instancia;
    private Elasticsearch elastic;
    public static String currentBusca;
    
    private void init()
    {
       usuarioAutenticado = new modelo.Visitante();
       museusCadastrados = new ArrayList<>();
       usuariosCadastrados = new ArrayList<>();
       colecoesCadastros = new ArrayList<>();
       obras = new ArrayList<>();
       elastic = new Elasticsearch("localhost","9200");
       
    }
    private Principal()
    {
        init();
        museusCadastrados.add(new Museu("Museu A"));
        museusCadastrados.add(new Museu("Museu B"));
        String m[] = {"Museu A"};
        String mAB[] = {"Museu A", "Museu B"};
        Usuario pesqTeste = new modelo.Pesquisador("Usuario Pesquisador","000.000.000-00","pesquisador@ufpel.edu.br","0",m);
        Usuario dirTeste = new Diretor("Usuario Diretor","111.111.111-11","diretor@ufpel.edu.br","1",m);
        Usuario coordenador = new modelo.Coordenador("Usuario Coordenador", "222.222.222-22", "coordenador@ufpel.edu.br","2", m);
       // Usuario tecnicoA = new modelo.Tecnico("Tecnico A", "333.333.333-33", "3", m);        
       // Usuario tecnicoAB = new modelo.Tecnico("Tecnico A B", "444.444.444-44","4", mAB);
        
        //usuariosCadastrados.add(tecnicoA);
        //usuariosCadastrados.add(tecnicoAB);
        usuariosCadastrados.add(dirTeste);
        usuariosCadastrados.add(pesqTeste);
       // usuariosCadastrados.add(coordenador);
        
        
                                            
    }
    public static Principal getInstance()
    {
        if(instancia == null)
        {
            instancia = new Principal();
        }
        return instancia;
    }
    public ArrayList<Obra> getObras(){
        return obras;
    }
    public Obra getObra(int index){
        return obras.get(index);
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
    public void registraPesquisador(String nome,String cpf,String email,String senha,String museusSelecionados[])
    {
        usuariosCadastrados.add(new Pesquisador(nome,cpf,email,senha,museusSelecionados));
    }
    public void registraTecnico(String nome,String cpf,String email,String senha,String museusSelecionados[])
    {
        usuariosCadastrados.add(new Tecnico(nome,cpf,email,senha,museusSelecionados));
    }
    public void registraDiretor(String nome,String cpf,String email,String senha,String museusSelecionados[])
    {  
         usuariosCadastrados.add(new Diretor(nome,cpf,email,senha,museusSelecionados));
    }
    public void registraCoordenador(String nome,String cpf,String email,String senha,String museusSelecionados[])
    {
        usuariosCadastrados.add(new Coordenador(nome,cpf,email,senha,museusSelecionados));
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
    public boolean autenticaUsuario(String cpf,String senha)
    {
        for(Usuario user : usuariosCadastrados)
        {
            if(user.getCpf().equals(cpf) && user.getSenha().equals(senha)) //se usuario e senha batem, autentica
            {
                usuarioAutenticado = user;
                return true;
            }
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
            //paises[i] = obj.getCountry();
            System.out.println("Country Code = " + obj.getCountry()
		+ ", Country Name = " + paises[i]);//obj.getDisplayCountry(locale));
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
    
    public static int LevDistance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
    public static void main(String[] args) {
        
        Principal p = getInstance();
        p.autenticaUsuario("111.111.111-11","1");
        VisaoPrincipal vp = new VisaoPrincipal();
        vp.setVisible(true);
    }
    
}