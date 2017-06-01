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
public class Pesquisador extends Visitante{
    
    
    public Pesquisador(String nome,String cpf,String endereco,String dataNascimento,String senha)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }
     

}
