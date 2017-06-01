/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;

/**
 *
 * @author tech
 */
public class Visitante implements Usuario{
    
    public Visitante()
    {
        
    }
    @Override
    public ArrayList<Obra> buscaObra(String titulo)
    {
        ArrayList<Obra> retorno = new ArrayList();
        
        return retorno;
    }
}
