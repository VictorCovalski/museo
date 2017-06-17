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
public class Pesquisador extends Visitante{  
   
    public Pesquisador(String nome,String cpf,String email,String senha,String museus[]) 
   {
       super(nome,cpf,email,senha);
       this.museusPermitidos = museus;
   }
     

}
