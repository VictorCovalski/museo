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
    private String permissaoCadastro[] = new String[]{"Pesquisador","Tecnico","Diretor","Coordenador"};


    public Coordenador(String nome,String cpf,String endereco,String dataNascimento,String senha) {
          super(nome,cpf,endereco,dataNascimento,senha);
    }
   
}
