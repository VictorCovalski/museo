/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author tech
 */
public class Tecnico extends Pesquisador{
    
    private String permissaoCadastro[] = new String[]{"Pesquisador"};

    public Tecnico(String nome,String cpf,String endereco,String dataNascimento,String senha)
    {
        super(nome,cpf,endereco,dataNascimento,senha);
    }
    
}