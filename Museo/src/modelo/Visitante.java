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
public class Visitante extends Usuario{
    
    public Visitante()
    {
        this.nome = "Visitante";
    }
    public Visitante(String nome,String cpf,String endereco,String dataNascimento,String senha)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }
    @Override
   public ArrayList<Obra> buscaObra(String titulo)
   {
       ArrayList<Obra> obras = new ArrayList<>();
       return obras;
   }
    
}
