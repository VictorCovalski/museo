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
public class Coordenador extends Diretor{
    
    public Coordenador(String nome,String cpf,String endereco,String dataNascimento,String senha,String museus[]) {
          super(nome,cpf,endereco,dataNascimento,senha,museus);
          this.permissaoCadastro = new String[]{"Pesquisador","Tecnico","Diretor","Coordenador"};
    }
   
}
