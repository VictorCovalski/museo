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
public class Visitante extends Usuario{
    
    public Visitante()
    {
        this.nome = "Visitante";
    }
    public Visitante(String nome,String cpf,String email,String senha)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    
}
