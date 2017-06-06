/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author tech
 */
public class Tecnico extends Pesquisador{
    
    
    public Tecnico(String nome,String cpf,String endereco,String dataNascimento,String senha,ArrayList<String> museus)
    {
        super(nome,cpf,endereco,dataNascimento,senha,museus);
        this.permissaoCadastro = new String[]{"Pesquisador"};
    }
    
}
