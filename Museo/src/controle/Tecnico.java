/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author tech
 */
public class Tecnico extends Pesquisador{
    
    private int codigoTecnico;
    
    public Tecnico(String nome,String cpf,String endereco,String dataNascimento, String usuario, String senha, int codigoTecnico)
    {
        super(nome,cpf,endereco,dataNascimento,usuario,senha);
        this.codigoTecnico = codigoTecnico;
    }
    
    public Tecnico(String nome,String cpf,String endereco,String dataNascimento,String usuario,String senha)
    {
        super(nome,cpf,endereco,dataNascimento,usuario,senha);
    }
    
    
}
