/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteFazenda;

import ClassesAbstratas.Setor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author mathe
 */
public class Altera_cad_func extends javax.swing.JFrame {

    public void cadastraNoBanco(){
        Setor setor = (Setor) cb_setor.getSelectedItem();
        int set_cad = setor.getCodigo_set();
        
        Setor permissao = (Setor) cb_permissao.getSelectedItem();
        int permissao_cad = permissao.getCodigo_set();
        
        try {
            conecta_bd con = new conecta_bd();
            
            String sql = "UPDATE funcionario SET `nome_func`=?,`dta_adm`=?,`usuario_func`=?,`senha_func`=?,`cod_permis`=?,`cod_setor`=?,`email_func`=?,`nasc_func`=? WHERE `cod_func`=?";
            PreparedStatement ps = con.conexao.prepareStatement(sql);
            ps.setString(1, txt_Altera_nome.getText());
            ps.setString(2, txt_Dta_adm.getText());
            ps.setString(3, txt_usuario_cadastro.getText());
            ps.setString(4, String.valueOf(txt_senha_altera.getPassword()));
            ps.setInt(5, permissao_cad);
            ps.setInt(6, set_cad);
            ps.setString(7, txt_Alt_email.getText());
            ps.setString(8, txt_Alt_DtaNasc.getText());
            ps.setInt(9, Integer.parseInt(txt_cod_Func.getText()));
            //Insert
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário Alterado com Sucesso", "CADASTRADO", JOptionPane.INFORMATION_MESSAGE);
            
            con.conexao.close();
            
            TelaInicial inic = new TelaInicial();
            inic.setVisible(true);
            dispose();
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void setorSelect(){
        //vai dar um select na tabela setor e mostrar as opções em um ComboBox
        //vai dar um select na tabela setor e mostrar as opções em um ComboBox
        
        //Consulta MYSQL
        try{
            conecta_bd con = new conecta_bd();
            Statement st = con.conexao.createStatement();
            st.executeQuery("SELECT cod_setor, nome_setor FROM setor ORDER BY nome_setor");
            
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                ClassesAbstratas.Setor set = new ClassesAbstratas.Setor();
                set.setCodigo_set(rs.getInt("cod_setor"));
                set.setDescricao_set(rs.getString("nome_setor"));
                cb_setor.addItem(set);
            }
            
            con.conexao.close();
        }catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void permisSelect(){
        //vai dar um select na tabela permissoes e mostrar as opções em um ComboBox
        
        //Consulta MYSQL
        try{
            conecta_bd con = new conecta_bd();
            Statement st = con.conexao.createStatement();
            st.executeQuery("SELECT * FROM permissao ORDER BY tipo_permis");
            
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                ClassesAbstratas.Setor permis = new ClassesAbstratas.Setor();
                permis.setCodigo_set(rs.getInt("cod_permis"));
                permis.setDescricao_set(rs.getString("tipo_permis"));
                cb_permissao.addItem(permis);
            }
            
            con.conexao.close();
        }catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void getDadosFunc(){
            try{
            conecta_bd con = new conecta_bd();
            Statement st = con.conexao.createStatement();
            st.executeQuery("SELECT * FROM funcionario WHERE cod_func ='" + txt_cod_Func.getText()+"'");
            
            
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                txt_Altera_nome.setText(rs.getString("nome_func"));
                txt_Alt_DtaNasc.setText(rs.getString("nasc_func"));
                txt_Alt_email.setText(rs.getString("email_func"));
                txt_Dta_adm.setText(rs.getString("dta_adm"));
                txt_usuario_cadastro.setText(rs.getString("usuario_func"));
                txt_senha_altera.setText(rs.getString("senha_func"));
            }
            
            con.conexao.close();
            rs.close();
            st.close();
        }catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates new form Altera_cad_func
     */
    public Altera_cad_func() {
        initComponents();
        setorSelect();
        permisSelect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        txt_usuario_cadastro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel_dadosacesso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_senha_altera = new javax.swing.JPasswordField();
        cb_permissao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bnt_alterar = new javax.swing.JButton();
        btn_cancela = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_Altera_nome = new javax.swing.JTextField();
        txt_Alt_email = new javax.swing.JTextField();
        txt_Alt_DtaNasc = new javax.swing.JTextField();
        jLabel_DataNasc1 = new javax.swing.JLabel();
        JLabel_Nome = new javax.swing.JLabel();
        cb_setor = new javax.swing.JComboBox<>();
        jLabel_Setor = new javax.swing.JLabel();
        txt_Dta_adm = new javax.swing.JTextField();
        jLabel_DataAdmi = new javax.swing.JLabel();
        jLabel_Email = new javax.swing.JLabel();
        jLabel_cadastrese = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_busca_func = new javax.swing.JButton();
        txt_cod_Func = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_usuario_cadastro.setEditable(false);
        txt_usuario_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuario_cadastroActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário:");

        jLabel_dadosacesso.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel_dadosacesso.setText("DADOS DE ACESSO");

        jLabel3.setText("Senha:");

        cb_permissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_permissaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Permissão do usuário:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(jLabel_dadosacesso, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_senha_altera, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel_dadosacesso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(txt_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(txt_senha_altera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(cb_permissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bnt_alterar.setBackground(new java.awt.Color(204, 204, 204));
        bnt_alterar.setText("Alterar");
        bnt_alterar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bnt_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_alterarActionPerformed(evt);
            }
        });

        btn_cancela.setBackground(new java.awt.Color(204, 204, 204));
        btn_cancela.setText("Cancelar");
        btn_cancela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bnt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnt_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        jPanel1.setBackground(new java.awt.Color(226, 245, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Altera_nome.setToolTipText("");
        txt_Altera_nome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_Altera_nome.setName(""); // NOI18N
        txt_Altera_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Altera_nomeActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Altera_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 34));

        txt_Alt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Alt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Alt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 460, 34));

        txt_Alt_DtaNasc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Alt_DtaNasc.setToolTipText("Dia");
        txt_Alt_DtaNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Alt_DtaNascActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Alt_DtaNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, 34));

        jLabel_DataNasc1.setText("Data de nascimento:");
        jPanel1.add(jLabel_DataNasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        JLabel_Nome.setText("Nome Completo:");
        jPanel1.add(JLabel_Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel1.add(cb_setor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 160, 20));

        jLabel_Setor.setText("Setor:");
        jPanel1.add(jLabel_Setor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        txt_Dta_adm.setEditable(false);
        txt_Dta_adm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Dta_adm.setToolTipText("Dia");
        txt_Dta_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Dta_admActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Dta_adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 230, 34));

        jLabel_DataAdmi.setText("Data de Admissão:");
        jPanel1.add(jLabel_DataAdmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel_Email.setText("E-mail:");
        jPanel1.add(jLabel_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel_cadastrese.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel_cadastrese.setText("DADOS DE FUNCIONÁRIO");
        jPanel1.add(jLabel_cadastrese, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_busca_func.setText("Busca");
        btn_busca_func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busca_funcActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Código do Funcionário:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cod_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_busca_func)
                .addGap(145, 145, 145))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cod_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_busca_func)
                    .addComponent(jLabel2))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuario_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuario_cadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuario_cadastroActionPerformed

    private void cb_permissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_permissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_permissaoActionPerformed

    private void bnt_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_alterarActionPerformed

        cadastraNoBanco();
    }//GEN-LAST:event_bnt_alterarActionPerformed

    private void btn_cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelaActionPerformed
        // TODO add your handling code here:
        TelaInicial ini = new TelaInicial();
        ini.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_cancelaActionPerformed

    private void txt_Dta_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Dta_admActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Dta_admActionPerformed

    private void txt_Alt_DtaNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Alt_DtaNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Alt_DtaNascActionPerformed

    private void txt_Alt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Alt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Alt_emailActionPerformed

    private void txt_Altera_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Altera_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Altera_nomeActionPerformed

    private void btn_busca_funcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busca_funcActionPerformed
        // TODO add your handling code here:
        getDadosFunc();
    }//GEN-LAST:event_btn_busca_funcActionPerformed

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
            java.util.logging.Logger.getLogger(Altera_cad_func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Altera_cad_func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Altera_cad_func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Altera_cad_func.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Altera_cad_func().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel_Nome;
    private javax.swing.JButton bnt_alterar;
    private javax.swing.JButton btn_busca_func;
    private javax.swing.JButton btn_cancela;
    private javax.swing.JComboBox<Object> cb_permissao;
    private javax.swing.JComboBox<Object> cb_setor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_DataAdmi;
    private javax.swing.JLabel jLabel_DataNasc1;
    private javax.swing.JLabel jLabel_Email;
    private javax.swing.JLabel jLabel_Setor;
    private javax.swing.JLabel jLabel_cadastrese;
    private javax.swing.JLabel jLabel_dadosacesso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txt_Alt_DtaNasc;
    private javax.swing.JTextField txt_Alt_email;
    private javax.swing.JTextField txt_Altera_nome;
    private javax.swing.JTextField txt_Dta_adm;
    private javax.swing.JTextField txt_cod_Func;
    private javax.swing.JPasswordField txt_senha_altera;
    private javax.swing.JTextField txt_usuario_cadastro;
    // End of variables declaration//GEN-END:variables
}
