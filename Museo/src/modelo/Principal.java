/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    public static ArrayList<Usuario> usuariosCadastrados;
    public static Usuario usuarioAutenticado;
    
    public static void main(String[] args) {
        
        usuariosCadastrados = new ArrayList();
        usuarioAutenticado = new Visitante();
        Usuario pesqTeste = new Coordenador("victor","0","rua sem nome,22","01/01/1991","0");
        Usuario dirTeste = new Diretor("janine","12345678912","rua sem nome,22","02/01/1991","321");
        usuariosCadastrados.add(pesqTeste);
        usuariosCadastrados.add(dirTeste);
        VisaoPrincipal vp = new VisaoPrincipal();
        vp.setVisible(true);
    }
    
}
