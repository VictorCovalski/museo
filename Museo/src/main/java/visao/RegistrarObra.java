/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import com.fasterxml.jackson.databind.JsonNode;
import controle.Elasticsearch;
import controle.Principal;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import modelo.*;

/**
 *
 * @author gleider
 */
public class RegistrarObra extends javax.swing.JFrame {
     CardLayout card;
     Object obj;
     RegistrarPintura rp;
     RegistrarArquitetura ra;
     RegistrarEscultura re;
     MaskFormatter mask;
     Principal control;
    /**
     * Creates new form RegistrarObra
     */
    public RegistrarObra() {
        
           control = Principal.getInstance();
           initComponents();
           maskData(jFormattedTextDataAquisi);
           maskData(jFormattedTextDataPublic);
       
           jPanelEstilo.setLayout(new java.awt.CardLayout());
           card = (CardLayout)jPanelEstilo.getLayout();
           
    }
    public RegistrarObra(Obra o)
    {
        this();
        
        
        //text field
        jTextFieldNome.setText(o.getNome());
        jTextFieldID.setText(o.getIdentificador());
        jTextAreaDesc.setText(o.getDescricao());
        jTextFieldProcedencia.setText(o.getProcedencia());
        jTextFieldPrateleira.setText(o.getPrateleira());
        jTextFieldEstante.setText(o.getLocalEstante());
        jTextFieldTitulo.setText(o.getTitulo());
        jTextFieldNumero.setText(String.valueOf(o.getLocalNumero()));
        jTextFieldProcedencia.setText(o.getProcedencia());
        
        //formatted text field
        jFormattedTextDataAquisi.setText(o.getDataAquisicao());
        jFormattedTextDataPublic.setText(o.getDataPublicacao());
        //checkbox
        jCheckBoxOverwrite.setSelected(true);
        
        //combobox
        jComboBoxPais.setSelectedItem(o.getPaisOrigem());
        jComboBoxColecao.setSelectedItem(o.getColecao());
        String classe = o.getClass().getSimpleName();
        jComboBoxEstilo.setSelectedItem(classe);
        for(String material : o.getMaterial())
        {
            jComboBoxMateriais.addItem(material);
        }
        JsonNode root = Elasticsearch.serializaObra(o);
        switch(root.path("@type").asText())
        {
            case "Pintura":
            {
                
               rp.setVisible(true);
               String altura = root.path("altura").asText();
               String largura = root.path("largura").asText();
               String comprimento = root.path("comprimento").asText();
               String peso = root.path("peso").asText();
               String tecnica = root.path("tecnica").asText();
               String estado = root.path("estadoConservacao").asText();
               JsonNode arrayAutores = root.get("autor");
               ArrayList<String> autores = new ArrayList<>();
               for(JsonNode a : arrayAutores)
               {
                   autores.add(a.asText());
               }
               rp.setFields(altura, autores, comprimento, estado, largura, peso, tecnica);
               
                
            }
            case "Arquitetura":
            {
                ra.setVisible(true);
                String linguagem = root.path("linguagem").asText();
                String estilo = root.path("estilo").asText();
                ArrayList<String> artistas = new ArrayList<>();
                JsonNode arrayAutores = root.get("autor");
                for(JsonNode a : arrayAutores){
                    artistas.add(a.asText());
                 
                }
                ra.setFields(linguagem, estilo, artistas);
            }
            case "Escultura":
            {
                re.setVisible(true);
                String altura = root.path("altura").asText();
                ArrayList<String> autores = new ArrayList<>();
                JsonNode arrayAutores = root.get("autor");
                for(JsonNode a : arrayAutores){
                    autores.add(a.asText());
                }
                String comprimento = root.path("comprimento").asText();
                       
                String espessura = root.path("espessura").asText();
                String forma = root.path("forma").asText();
                String largura = root.path("largura").asText();
                String maiorCirc = root.path("circunferenciaMaior").asText();
                
                ArrayList<String> materiais = new ArrayList<>();
                JsonNode arrayMateriais = root.get("materialUtilizado");
                for(JsonNode a : arrayMateriais){
                    materiais.add(a.asText());
                }
                String menorCirc = root.path("circunferenciaMenor").asText(); 
                String peso = root.path("peso").asText();
                String profundidade = root.path("profundidade").asText();
                String tecnica  = root.path("tecnica").asText();
                re.setFields(altura, autores, comprimento, espessura, forma, largura, maiorCirc, materiais, menorCirc, peso, profundidade, tecnica);
            }
        }
        
    }
    
    private void showTela(Object ob){
        jPanelEstilo.remove(this);
        jPanelEstilo.add((Component) ob, "Mostrar");
        jPanelEstilo.add((Component) ob, "Mostrar");
        card.show(jPanelEstilo, "Mostrar");    
    }
    
    private void maskData(JFormattedTextField ft){
        
        try {
            mask = new MaskFormatter("##/##/####");
            mask.install(ft);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrarObra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void limpar(){
        jTextFieldNome.setText("");
        jTextFieldEstante.setText("");
        jTextFieldNumero.setText("");
        jTextFieldPrateleira.setText("");
        jTextFieldProcedencia.setText("");
        jTextFieldTitulo.setText("");
        jTextFieldID.setText("");
        jTextAreaDesc.setText("");
        if(jComboBoxEstilo.getSelectedItem().toString().equals("Pintura")){
            rp.apagar();
        }
        if(jComboBoxEstilo.getSelectedItem().toString().equals("Arquitetura")){
            ra.apagar();
        }
        if(jComboBoxEstilo.getSelectedItem().toString().equals("Escultura")){
            re.apagar();
        }
        
        jTextFieldMaterial.setText("");
        jComboBoxMateriais.removeAllItems();
        jComboBoxMateriais.addItem("Materiais");
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabelPaisOrigem = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldProcedencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonAdicionarMaterial = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextDataPublic = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextDataAquisi = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldMaterial = new javax.swing.JTextField();
        jTextFieldEstante = new javax.swing.JTextField();
        jTextFieldPrateleira = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxEstilo = new javax.swing.JComboBox<>();
        jPanelEstilo = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxMateriais = new javax.swing.JComboBox<>();
        jButtonRemoverMaterial = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxMuseu = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxColecao = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jComboBoxPais = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDesc = new javax.swing.JTextArea();
        jTextFieldImagem = new javax.swing.JTextField();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jCheckBoxOverwrite = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Registrar obra");

        jLabel2.setText("Nome");

        jLabel3.setText("Título");

        jLabelPaisOrigem.setText("País de origem");

        jLabel5.setText("Procedência");

        jLabel7.setText("Material");

        jButtonAdicionarMaterial.setText("adicionar");
        jButtonAdicionarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarMaterialActionPerformed(evt);
            }
        });

        jLabel8.setText("Data publicação");

        jFormattedTextDataPublic.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/y"))));
        jFormattedTextDataPublic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextDataPublicActionPerformed(evt);
            }
        });

        jLabel9.setText("Data aquisição");

        jFormattedTextDataAquisi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/y"))));
        jFormattedTextDataAquisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextDataAquisiActionPerformed(evt);
            }
        });

        jLabel11.setText("Estante");

        jLabel12.setText("Prateleira");

        jLabel13.setText("Número");

        jTextFieldPrateleira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrateleiraActionPerformed(evt);
            }
        });

        jLabel15.setText("Estilo da obra");

        jComboBoxEstilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Pintura", "Arquitetura", "Escultura" }));
        jComboBoxEstilo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEstiloItemStateChanged(evt);
            }
        });
        jComboBoxEstilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstiloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEstiloLayout = new javax.swing.GroupLayout(jPanelEstilo);
        jPanelEstilo.setLayout(jPanelEstiloLayout);
        jPanelEstiloLayout.setHorizontalGroup(
            jPanelEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstiloLayout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel18)
                .addContainerGap(414, Short.MAX_VALUE))
        );
        jPanelEstiloLayout.setVerticalGroup(
            jPanelEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstiloLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel18)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jComboBoxMateriais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Materiais" }));

        jButtonRemoverMaterial.setText("Remover");
        jButtonRemoverMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverMaterialActionPerformed(evt);
            }
        });

        jLabel4.setText("Museu");

        jComboBoxMuseu.setModel(new DefaultComboBoxModel(control.getMuseusUsuario()));
        jComboBoxMuseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMuseuActionPerformed(evt);
            }
        });
        jComboBoxMuseu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxMuseuPropertyChange(evt);
            }
        });

        jLabel14.setText("Coleção");

        String museuSelected = jComboBoxMuseu.getSelectedItem().toString();
        String [] cols = control.getColecaoOfMuseu(museuSelected);
        jComboBoxColecao.setModel(new DefaultComboBoxModel(cols));

        jLabel17.setText("ID Obra:");

        jComboBoxPais.setModel(new javax.swing.DefaultComboBoxModel<>(Principal.getListaPais()));

        jLabel6.setText("Descrição");

        jTextAreaDesc.setColumns(20);
        jTextAreaDesc.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDesc);

        jTextFieldImagem.setText("/var/www/imagens/");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(462, 462, 462))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabelPaisOrigem)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTitulo))
                            .addComponent(jComboBoxColecao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxEstilo, javax.swing.GroupLayout.Alignment.LEADING, 0, 181, Short.MAX_VALUE)
                                    .addComponent(jComboBoxPais, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextDataPublic, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextDataAquisi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEstante, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxMuseu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane1)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jTextFieldPrateleira, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldImagem))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(24, 24, 24)
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel13)
                                                        .addGap(6, 6, 6)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jComboBoxMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jTextFieldMaterial))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonAdicionarMaterial)
                                            .addComponent(jButtonRemoverMaterial))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 140, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPaisOrigem)
                    .addComponent(jTextFieldProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButtonAdicionarMaterial)
                    .addComponent(jTextFieldMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextDataPublic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFormattedTextDataAquisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jComboBoxMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRemoverMaterial))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldEstante, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldPrateleira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxMuseu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxColecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jPanelEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jCheckBoxOverwrite.setText("Sobrescrever cadastro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButtonRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxOverwrite)
                        .addGap(79, 79, 79)
                        .addComponent(jButtonLimpar)
                        .addGap(206, 206, 206)
                        .addComponent(jButtonVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxOverwrite))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed
    private boolean validaCampos()
    {
        if(jTextFieldNome.getText().equalsIgnoreCase("") ||         //se Nome
                jTextFieldTitulo.getText().equalsIgnoreCase("") ||  //se Titulo
                jTextFieldID.getText().equalsIgnoreCase("") ||         //se Identificador
                jComboBoxColecao.getSelectedItem().toString().equalsIgnoreCase("")){ //obriga ter uma coleção selecionada
            return false;
        }
        return true;
    }
    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        int op;
        if(!validaCampos())
        {
            JOptionPane.showMessageDialog(this,"Favor preencher todos os campos com *","Erro no cadastro",JOptionPane.ERROR_MESSAGE);
            return;
        }
        Object[] options = {"Sim", "Não"};
        op = JOptionPane.showOptionDialog(null, "Deseja confirmar registro?", "Registrar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if(op == 0){ //sim
            
            
            String nome = jTextFieldNome.getText();
            String titulo = jTextFieldTitulo.getText();
            String paisOrigem = (String)jComboBoxPais.getSelectedItem();
            String procedencia = jTextFieldProcedencia.getText();
            ArrayList<String> material = new ArrayList<String>();
            String identificador = jTextFieldID.getText();
            for(int i=1;i<jComboBoxMateriais.getItemCount();i++){
                material.add(jComboBoxMateriais.getItemAt(i));
            }
            String dataPublicacao = jFormattedTextDataPublic.getText(); 
            String dataAquisicao = jFormattedTextDataAquisi.getText(); 
            String localEstante = jTextFieldEstante.getText();
            String localPrateleira = jTextFieldPrateleira.getText();
            int localNumero=0;
            if(!jTextFieldNumero.getText().isEmpty())
                localNumero = Integer.parseInt(jTextFieldNumero.getText());
            Obra obra = new Pintura(); //so para nao haver erros
            if(jComboBoxEstilo.getSelectedItem().toString().equals("Pintura")){
                ArrayList<String> autores = rp.getjComboBoxAutores();
                double altura = rp.getjTextFieldAltura();
                double comprimento = rp.getjTextFieldComprimento();
                String estado = rp.getjTextFieldEstado();
                double largura = rp.getjTextFieldLargura();
                double peso = rp.getjTextFieldPeso();
                String tecnica = rp.getjTextFieldTecnica();
                
                /*control.registrarPintura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao
                        , dataAquisicao, localEstante, localPrateleira, localNumero, autores, altura, comprimento, estado
                        , largura, peso, tecnica);
                */
                obra = new Pintura(nome, titulo, paisOrigem, procedencia, material, dataPublicacao, dataAquisicao, localEstante, localPrateleira, localNumero, tecnica, peso, comprimento, largura, altura, estado, autores);
            }
            if(jComboBoxEstilo.getSelectedItem().toString().equals("Arquitetura")){
                ArrayList<String> artistas = ra.getjTextFieldAutor();
                String estilo = ra.getjTextFieldEstilo();
                String linguagem = ra.getjTextFieldLinguagem();
                
                /*control.registrarArquitetura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao
                        , dataAquisicao, localEstante, localPrateleira, localNumero, artistas, estilo, linguagem);*/
                obra = new Arquitetura(nome, titulo, paisOrigem, procedencia, material, dataPublicacao, dataAquisicao, localEstante, localPrateleira, localNumero, estilo, linguagem, artistas);
            }
            if(jComboBoxEstilo.getSelectedItem().toString().equals("Escultura")){
                ArrayList<String> autores = re.getjComboBoxAutores();
                ArrayList<String> materiais = re.getjComboBoxMateriais();
                double altura = re.getjTextFieldAltura();
                double comprimento = re.getjTextFieldComprimento();
                double espessura = re.getjTextFieldEspessura();
                String forma = re.getjTextFieldForma();
                double largura = re.getjTextFieldLargura();
                double maiorCirc = re.getjTextFieldMaiorCirc();
                double menorCirc = re.getjTextFieldMenorCirc();
                double peso = re.getjTextFieldPeso();
                double profundidade = re.getjTextFieldProfundidade();
                String tecnica = re.getjTextFieldTecnica();
                
                obra = new Escultura(nome, titulo, paisOrigem, procedencia, material, dataPublicacao, dataAquisicao, localEstante, localPrateleira, localNumero, tecnica, forma, materiais, autores, peso, comprimento, largura, altura, espessura, profundidade, profundidade, comprimento);

            }
            String caminhoImagem = jTextFieldImagem.getText();
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH.mm.ss").format(new Date());
            
            obra.setCaminhoImagem(caminhoImagem);
            obra.setDataCadastro(timeStamp);
            obra.setIdentificador(identificador);
            obra.setMuseu((String)jComboBoxMuseu.getSelectedItem());
            obra.setColecao((String)jComboBoxColecao.getSelectedItem());
            obra.setDescricao(jTextAreaDesc.getText());
            obra.setPrateleira(localPrateleira);
            if(control.registraObra(obra,jCheckBoxOverwrite.isSelected()))
            {
                JOptionPane.showMessageDialog(null, "Registrado com sucesso");
                limpar();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Erro no cadastro");
            }
            
      
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        
        limpar();  
       
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jComboBoxMuseuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxMuseuPropertyChange

    }//GEN-LAST:event_jComboBoxMuseuPropertyChange

    private void jComboBoxMuseuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMuseuActionPerformed
        String museuSelected = jComboBoxMuseu.getSelectedItem().toString();
        String [] cols = control.getColecaoOfMuseu(museuSelected);
        jComboBoxColecao.setModel(new DefaultComboBoxModel(cols));
    }//GEN-LAST:event_jComboBoxMuseuActionPerformed

    private void jButtonRemoverMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverMaterialActionPerformed
        if(!jComboBoxMateriais.getSelectedItem().toString().equals("Materiais"))
        jComboBoxMateriais.removeItem(jComboBoxMateriais.getSelectedItem());
    }//GEN-LAST:event_jButtonRemoverMaterialActionPerformed

    private void jComboBoxEstiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstiloActionPerformed

        if(jComboBoxEstilo.getSelectedItem().toString().equals("Pintura")){
            rp = new RegistrarPintura();
            showTela(rp);
        }
        if(jComboBoxEstilo.getSelectedItem().toString().equals("Arquitetura")){
            ra = new RegistrarArquitetura();
            showTela(ra);
        }
        if(jComboBoxEstilo.getSelectedItem().toString().equals("Escultura")){
            re = new RegistrarEscultura();
            showTela(re);
        }
    }//GEN-LAST:event_jComboBoxEstiloActionPerformed

    private void jComboBoxEstiloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEstiloItemStateChanged

    }//GEN-LAST:event_jComboBoxEstiloItemStateChanged

    private void jTextFieldPrateleiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrateleiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrateleiraActionPerformed

    private void jFormattedTextDataAquisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextDataAquisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextDataAquisiActionPerformed

    private void jFormattedTextDataPublicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextDataPublicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextDataPublicActionPerformed

    private void jButtonAdicionarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarMaterialActionPerformed
        if(!jTextFieldMaterial.getText().isEmpty()){
            jComboBoxMateriais.addItem(jTextFieldMaterial.getText());
            jTextFieldMaterial.setText("");
        }
    }//GEN-LAST:event_jButtonAdicionarMaterialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarObra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarMaterial;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonRemoverMaterial;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JCheckBox jCheckBoxOverwrite;
    private javax.swing.JComboBox<String> jComboBoxColecao;
    private javax.swing.JComboBox<String> jComboBoxEstilo;
    private javax.swing.JComboBox<String> jComboBoxMateriais;
    private javax.swing.JComboBox<String> jComboBoxMuseu;
    private javax.swing.JComboBox<String> jComboBoxPais;
    private javax.swing.JFormattedTextField jFormattedTextDataAquisi;
    private javax.swing.JFormattedTextField jFormattedTextDataPublic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPaisOrigem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEstilo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDesc;
    private javax.swing.JTextField jTextFieldEstante;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldImagem;
    private javax.swing.JTextField jTextFieldMaterial;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPrateleira;
    private javax.swing.JTextField jTextFieldProcedencia;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
