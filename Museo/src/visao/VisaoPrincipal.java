/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import controle.Principal;
import javax.swing.JButton;
import modelo.Tecnico;

/**
 *
 * @author Gleider
 */
public class VisaoPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form Principal
     */
    private Principal control;
    public VisaoPrincipal() {
        initComponents();
        control = Principal.getInstance();
        jLabelNomeUsuario.setText(control.getNomeUsuarioAutenticado());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButtonLogin = new javax.swing.JButton();
        jLabelNomeUsuario = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItemRegObra = new javax.swing.JMenuItem();
        jMenuItemRegMuseu = new javax.swing.JMenuItem();
        jMenuItemRegColecao = new javax.swing.JMenuItem();
        jMenuItemRegUsuario = new javax.swing.JMenuItem();
        jMenuConUsuario = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItemConObra = new javax.swing.JMenuItem();
        jMenuItemConMuseu = new javax.swing.JMenuItem();
        jMenuItemConColecao = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Museo");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Bem-vindo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Buscar");
        jLabel2.setEnabled(false);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Filtro de busca");

        jCheckBox1.setText("Tudo");

        jCheckBox2.setText("Usuário");

        jCheckBox3.setText("Obra");

        jButton2.setText("Opções avançadas");

        jButtonLogin.setText("Autenticar");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonLogout.setText("Encerrar sessão");
        jButtonLogout.setEnabled(false);
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(12, 12, 12)))
                        .addGap(0, 216, Short.MAX_VALUE)))
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonLogin)
                    .addComponent(jLabelNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLogout)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2)
                    .addComponent(jButton2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu7.setText("Registrar");

        jMenuItemRegObra.setText("Obra");
        jMenuItemRegObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegObraActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemRegObra);

        jMenuItemRegMuseu.setText("Museu");
        jMenuItemRegMuseu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegMuseuActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemRegMuseu);

        jMenuItemRegColecao.setText("Coleção");
        jMenu7.add(jMenuItemRegColecao);

        jMenuItemRegUsuario.setText("Usuário");
        jMenuItemRegUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegUsuarioActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemRegUsuario);

        jMenuBar1.add(jMenu7);

        jMenuConUsuario.setText("Consultar");

        jMenuItem11.setText("Usuário");
        jMenuConUsuario.add(jMenuItem11);

        jMenuItemConObra.setText("Obra");
        jMenuConUsuario.add(jMenuItemConObra);

        jMenuItemConMuseu.setText("Museu");
        jMenuConUsuario.add(jMenuItemConMuseu);

        jMenuItemConColecao.setText("Coleção");
        jMenuConUsuario.add(jMenuItemConColecao);

        jMenuBar1.add(jMenuConUsuario);

        jMenu6.setText("Sobre");
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
       SelecaoUsuario su = new SelecaoUsuario();
       su.setVisible(true);
    }//GEN-LAST:event_jButtonLoginActionPerformed
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        if(control.checaPermissaoTecnico())
        {
                RegistrarUsuario ru = new RegistrarUsuario();
                ru.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Acesso restrito","Voce nao tem as permissoes necessarias para acessar esta opcao.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void uiAutentica(String nome)
    {
        jLabelNomeUsuario.setText(nome);
        jButtonLogout.setEnabled(true);
    }
    private void jMenuItemRegObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegObraActionPerformed
        if(control.checaPermissaoTecnico()) //RESTRINGIR SOMENTE A TECNICOS NO FUTURO!!
        {
            RegistrarObra ro = new RegistrarObra();
            ro.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Acesso restrito","Voce nao tem as permissoes necessarias para acessar esta opcao.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemRegObraActionPerformed

    private void jMenuItemRegUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegUsuarioActionPerformed
        if(control.checaPermissaoTecnico())
        {
            RegistrarUsuario ru = new RegistrarUsuario();
            ru.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Area restrita","Usuário sem permissão de cadastro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemRegUsuarioActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja finalizar sua sessão?", "", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
          control.autenticaVisitante();
          jButtonLogout.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jMenuItemRegMuseuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegMuseuActionPerformed
        if(control.checaPermissaoCoordenador())
        {
            RegistrarMuseu rm = new RegistrarMuseu();
            rm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Área Restrita", "Usuário não autorizado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemRegMuseuActionPerformed

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
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonLogin;
    private static javax.swing.JButton jButtonLogout;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabelNomeUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConUsuario;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItemConColecao;
    private javax.swing.JMenuItem jMenuItemConMuseu;
    private javax.swing.JMenuItem jMenuItemConObra;
    private javax.swing.JMenuItem jMenuItemRegColecao;
    private javax.swing.JMenuItem jMenuItemRegMuseu;
    private javax.swing.JMenuItem jMenuItemRegObra;
    private javax.swing.JMenuItem jMenuItemRegUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
