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
    
    
    public Tecnico(String nome,String cpf,String email,String senha,String museus[])
    {
        super(nome,cpf,email,senha,museus);
        this.permissaoCadastro = new String[]{"Pesquisador"};
    }
    
}
