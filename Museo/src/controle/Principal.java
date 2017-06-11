/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.Arquitetura;
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
    
    private static Principal instancia;
    
    private void init()
    {
       usuarioAutenticado = new modelo.Visitante();
       museusCadastrados = new ArrayList<>();
       usuariosCadastrados = new ArrayList<>();
       obras = new ArrayList<>();
       
       
    }
    private Principal()
    {
        init();
        museusCadastrados.add(new Museu("Museu A"));
        museusCadastrados.add(new Museu("Museu B"));
        String m[] = {"Museu A"};
        Usuario pesqTeste = new modelo.Coordenador("victor","0","rua sem nome,22","01/01/1991","0",m);
        Usuario dirTeste = new Diretor("janine","1","rua sem nome,22","02/01/1991","1",m);
        
        usuariosCadastrados.add(dirTeste);
        usuariosCadastrados.add(pesqTeste);
    }
    public static Principal getInstance()
    {
        if(instancia == null)
        {
            instancia = new Principal();
        }
        return instancia;
    }
    
    public void registraPesquisador(String nome,String cpf,String endereco,String dataNascimento,String senha,String museusSelecionados[])
    {
        usuariosCadastrados.add(new Pesquisador(nome,cpf,endereco,dataNascimento,senha,museusSelecionados));
    }
    public void registraTecnico(String nome,String cpf,String endereco,String dataNascimento,String senha,String museusSelecionados[])
    {
        usuariosCadastrados.add(new Tecnico(nome,cpf,endereco,dataNascimento,senha,museusSelecionados));
    }
    public void registraDiretor(String nome,String cpf,String endereco,String dataNascimento,String senha,String museusSelecionados[])
    {  
         usuariosCadastrados.add(new Diretor(nome,cpf,endereco,dataNascimento,senha,museusSelecionados));
    }
    public void registraCoordenador(String nome,String cpf,String endereco,String dataNascimento,String senha,String museusSelecionados[])
    {
        usuariosCadastrados.add(new Coordenador(nome,cpf,endereco,dataNascimento,senha,museusSelecionados));
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
    

    public void registrarPintura(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , ArrayList<String> obrasRelacionadas, String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero, ArrayList<String> autores, double altura
            , double comprimento, String estado, double largura, double peso, String tecnica){
     
        
        obras.add(new Pintura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao, dataAquisicao
                , localEstante, localPrateleira, localNumero, tecnica, peso, comprimento, largura, altura, estado, autores));
        
      
    }
    public void registrarEscultura(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , ArrayList<String> obrasRelacionadas, String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero, ArrayList<String> autores, ArrayList<String> materiais, double altura
            , double comprimento, double espessura, String forma, double largura, double maiorCirc, double menorCirc
            , double peso, double profundidade, String tecnica){
        
        obras.add(new Escultura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao, dataAquisicao
            , localEstante, localPrateleira, localNumero, tecnica, forma, materiais, autores, peso, comprimento, largura
            , altura, espessura, profundidade, maiorCirc, menorCirc));
    }
    
    public void registrarArquitetura(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , ArrayList<String> obrasRelacionadas, String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero, ArrayList<String> artistas, String estilo, String linguagem){
        
        obras.add(new Arquitetura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas,  dataPublicacao
                , dataAquisicao, localEstante, localPrateleira, localNumero, estilo, linguagem, artistas));
    }
    public static void main(String[] args) {
        
        Principal p = getInstance();
        VisaoPrincipal vp = new VisaoPrincipal();
        vp.setVisible(true);
    }
    
}