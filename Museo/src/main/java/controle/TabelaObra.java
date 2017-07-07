/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import modelo.Obra;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tech
 */
public class TabelaObra extends AbstractTableModel{
        
        //Two arrays used for the table data
        String[] columnNames = {"Identificador","Autor", "Titulo","Coleção","País Origem", "Museu", "Data cadastro", "Data publicação"};
        
        Object[][] data;// = {
         //   {"César Cielo", "Filho", "Brazil", "50m freestyle",1 , "21.30", false,"akak" },
       // };
        
        /*
            Inicializa tabela já com resultados da busca!
        */
        public TabelaObra(Obra resultado[])
        {
            data = new Object[resultado.length][columnNames.length];
            int i = 0;
            for(Obra ox : resultado)
            {
                data[i++] = ox.toTabela(columnNames.length);
            }
        }
        public TabelaObra()
        {
            
        }
        @Override
        public int getRowCount()
        {
            return data.length;
        }
        
        @Override
        public int getColumnCount()            
        {
            return columnNames.length;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {        
            return data[row][column];
        }
        
        //Used by the JTable object to set the column names
        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
        
        //Used by the JTable object to render different
        //functionality based on the data type
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
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
