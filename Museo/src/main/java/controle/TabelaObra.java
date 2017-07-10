/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import java.util.ArrayList;
import modelo.Obra;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tech
 */
public class TabelaObra extends AbstractTableModel{
        
        //Two arrays used for the table data
        String[] columnNames = {"Identificador","Nome", "Titulo","Coleção","País Origem", "Museu", "Data cadastro", "Data publicação"};
        
        ArrayList<Obra> data; //{
            //{"César Cielo", "Filho", "Brazil", "50m freestyle",1 , "21.30", false,"akak" }};
        //new Object[columnNames.length][1];//
        /*
            Inicializa tabela já com resultados da busca!
        */
        public TabelaObra(ArrayList<Obra> resultado)
        {
            data = resultado;
        }

        public Obra getDataByIndex(int i) {
            return data.get(i);
        }

        public void setData(ArrayList<Obra> resultado) {
            data = resultado;
        }
        
        @Override
        public int getRowCount()
        {
            if (data == null)
            {
                return 0;
            }
            return data.size();
        }
        
        @Override
        public int getColumnCount()            
        {
            return columnNames.length;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {   
            Obra o = data.get(row);
            switch(column)
            {
                case 0: //identificador
                {
                    return o.getIdentificador();
                }
                case 1: //Autor
                {
                    return o.getNome();
                }
                case 2: //titulo
                {
                    return o.getTitulo();
                }
                case 3: //colecao
                {
                    return o.getColecao();
                }
                case 4: //pais origem
                {
                    return o.getPaisOrigem();
                }
                case 5: //Museu
                {
                    return o.getMuseu();
                }
                case 6: //datacadastro
                {
                    return o.getDataCadastro();
                }
                case 7: //datapublicacao
                {
                    return o.getDataPublicacao();
                }
            }
            return null;
        }
        
        //Used by the JTable object to set the column names
        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
        
        public void deleteRow(int row)
        {
            data.remove(row);
        }
        //Used by the JTable object to render different
        //functionality based on the data type
        /*@Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }*/
        
       /* @Override
        public boolean isCellEditable(int row, int column)
        {
           if (column == 0 || column == 1)
	   {
	        return false;
	   }
	   else
	   {
		return true;
	   }
        }
        */
   
}
