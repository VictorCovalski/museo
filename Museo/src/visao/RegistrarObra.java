/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Principal;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

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
           initComponents();
           maskData(jFormattedTextDataAquisi);
           maskData(jFormattedTextDataPublic);
       
           jPanelEstilo.setLayout(new java.awt.CardLayout());
           card = (CardLayout)jPanelEstilo.getLayout();
           control = Principal.getInstance();
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
        jTextFieldPaisOrigem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldProcedencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxObrasRelacionadas = new javax.swing.JComboBox<>();
        jButtonAdicionarObra = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonAdicionarMaterial = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextDataPublic = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextDataAquisi = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
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
        jButtonRegistrar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        jLabel1.setText("Registrar obra");

        jLabel2.setText("Nome");

        jLabel3.setText("Título");

        jLabelPaisOrigem.setText("País de origem");

        jLabel5.setText("Procedência");

        jLabel6.setText("Obras relacionadas");

        jComboBoxObrasRelacionadas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "vazio" }));

        jButtonAdicionarObra.setText("adicionar");

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

        jLabel10.setText("Local");

        jLabel11.setText("Estante");

        jLabel12.setText("Prateleira");

        jLabel13.setText("Número");

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

        jPanelEstilo.setBorder(null);

        javax.swing.GroupLayout jPanelEstiloLayout = new javax.swing.GroupLayout(jPanelEstilo);
        jPanelEstilo.setLayout(jPanelEstiloLayout);
        jPanelEstiloLayout.setHorizontalGroup(
            jPanelEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstiloLayout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel18)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanelEstiloLayout.setVerticalGroup(
            jPanelEstiloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstiloLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel18)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jComboBoxMateriais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Materiais" }));

        jButtonRemoverMaterial.setText("Remover");
        jButtonRemoverMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverMaterialActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelPaisOrigem)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldPaisOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxObrasRelacionadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonAdicionarObra)))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAdicionarMaterial)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonRemoverMaterial))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextDataPublic, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextDataAquisi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldEstante, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabel12)))
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPrateleira, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addComponent(jTextFieldPaisOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxObrasRelacionadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarObra)
                    .addComponent(jLabel7)
                    .addComponent(jButtonAdicionarMaterial)
                    .addComponent(jTextFieldMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMateriais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemoverMaterial))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextDataPublic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jFormattedTextDataAquisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldEstante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrateleira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButtonRegistrar)
                        .addGap(220, 220, 220)
                        .addComponent(jButtonLimpar)
                        .addGap(206, 206, 206)
                        .addComponent(jButtonVoltar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextDataAquisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextDataAquisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextDataAquisiActionPerformed

    private void jFormattedTextDataPublicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextDataPublicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextDataPublicActionPerformed

    private void jComboBoxEstiloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEstiloItemStateChanged
    
        
    }//GEN-LAST:event_jComboBoxEstiloItemStateChanged

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

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        int op;
        Object[] options = {"Não", "Sim"};
        op = JOptionPane.showOptionDialog(null, "Deseja confirmar registro?", "Registrar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if(op == 1){
            
            
            String nome = jTextFieldNome.getText();
            String titulo = jTextFieldTitulo.getText();
            String paisOrigem = jTextFieldPaisOrigem.getText();
            String procedencia = jTextFieldProcedencia.getText();
            ArrayList<String> material = new ArrayList<String>();
            for(int i=1;i<jComboBoxMateriais.getItemCount();i++){
                material.add(jComboBoxMateriais.getItemAt(i));
            }
            ArrayList<String> obrasRelacionadas = new ArrayList<String>(); 
            for(int i=1;i<jComboBoxObrasRelacionadas.getItemCount();i++){
                obrasRelacionadas.add(jComboBoxObrasRelacionadas.getItemAt(i));
            }
            String dataPublicacao = jFormattedTextDataPublic.getText(); 
            String dataAquisicao = jFormattedTextDataAquisi.getText(); 
            String localEstante = jTextFieldEstante.getText();
            String localPrateleira = jTextFieldPrateleira.getText();
            int localNumero=0;
            if(!jTextFieldNumero.getText().isEmpty())
                localNumero = Integer.parseInt(jTextFieldNumero.getText());
            
            if(jComboBoxEstilo.getSelectedItem().toString().equals("Pintura")){
                ArrayList<String> autores = rp.getjComboBoxAutores();
                double altura = rp.getjTextFieldAltura();
                double comprimento = rp.getjTextFieldComprimento();
                String estado = rp.getjTextFieldEstado();
                double largura = rp.getjTextFieldLargura();
                double peso = rp.getjTextFieldPeso();
                String tecnica = rp.getjTextFieldTecnica();
                
                control.registrarPintura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao
                        , dataAquisicao, localEstante, localPrateleira, localNumero, autores, altura, comprimento, estado
                        , largura, peso, tecnica);
                
            }
            if(jComboBoxEstilo.getSelectedItem().toString().equals("Arquitetura")){
                ArrayList<String> artistas = ra.getjTextFieldArtista();
                String estilo = ra.getjTextFieldEstilo();
                String linguagem = ra.getjTextFieldLinguagem();
                
                control.registrarArquitetura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao
                        , dataAquisicao, localEstante, localPrateleira, localNumero, artistas, estilo, linguagem);
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
                
                control.registrarEscultura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao
                        , dataAquisicao, localEstante, localPrateleira, localNumero, autores, materiais, altura, comprimento
                        , espessura, forma, largura, maiorCirc, menorCirc, peso, profundidade, tecnica);
            }
            
            
            JOptionPane.showMessageDialog(null, "Registrado com sucesso");
            limpar();
      
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        
        limpar();  
       
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonAdicionarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarMaterialActionPerformed
        if(!jTextFieldMaterial.getText().isEmpty()){
            jComboBoxMateriais.addItem(jTextFieldMaterial.getText());
            jTextFieldMaterial.setText("");
        }
    }//GEN-LAST:event_jButtonAdicionarMaterialActionPerformed

    private void jButtonRemoverMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverMaterialActionPerformed
        if(!jComboBoxMateriais.getSelectedItem().toString().equals("Materiais"))
            jComboBoxMateriais.removeItem(jComboBoxMateriais.getSelectedItem());
    }//GEN-LAST:event_jButtonRemoverMaterialActionPerformed

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
    private javax.swing.JButton jButtonAdicionarObra;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonRemoverMaterial;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxEstilo;
    private javax.swing.JComboBox<String> jComboBoxMateriais;
    private javax.swing.JComboBox<String> jComboBoxObrasRelacionadas;
    private javax.swing.JFormattedTextField jFormattedTextDataAquisi;
    private javax.swing.JFormattedTextField jFormattedTextDataPublic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPaisOrigem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEstilo;
    private javax.swing.JTextField jTextFieldEstante;
    private javax.swing.JTextField jTextFieldMaterial;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPaisOrigem;
    private javax.swing.JTextField jTextFieldPrateleira;
    private javax.swing.JTextField jTextFieldProcedencia;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
