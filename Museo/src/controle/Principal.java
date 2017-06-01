/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import visao.VisaoPrincipal;

/**
 *
 * @author Gleider
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Usuario> usuariosCadastrados;
        usuariosCadastrados = new ArrayList();
        Usuario pesqTeste = new Pesquisador("victor","11122233312","rua sem nome,22","01/01/1991","victor","123");
        Usuario dirTeste = new Diretor("janine","12112112112","rua sem nome,22","02/01/1991","janine","321",1);
        usuariosCadastrados.add(pesqTeste);
        usuariosCadastrados.add(dirTeste);
        VisaoPrincipal vp = new VisaoPrincipal();
        vp.setVisible(true);
    }
    
}
