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
public class Diretor extends Tecnico{
    
    private int codigoDiretor;
    
    public Diretor(String nome, String cpf, String endereco, String dataNascimento,String usuario,String senha,int codigoDiretor)
    {
        super(nome, cpf, endereco, dataNascimento,usuario,senha);
        this.codigoDiretor = codigoDiretor;
    }
    
}
