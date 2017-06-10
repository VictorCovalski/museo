/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import modelo.Obra;

/**
 *
 * @author guilhermelagemann
 */
public class ListModelObra extends AbstractListModel {
    String[] strings = new String[1000];
    
    public ListModelObra(ArrayList<Obra> param){
        
        System.out.println(param.size());
        
        for(int i = 0; i < param.size(); i++)
        {
            strings[i] = param.get(i).getNome();
            System.out.println(strings[i]);
        }
         System.out.println(strings[1]);
        
    
    }
    @Override
    public int getSize() {
    return strings.length;
  }

    @Override
  public Object getElementAt(int index) {
    return strings[index];
  }
    
}
