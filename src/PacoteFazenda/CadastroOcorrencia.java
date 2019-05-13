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
 * @author wesll
 */
public class CadastroOcorrencia extends javax.swing.JFrame {
    
    public void statusSelect(){
        //vai dar um select na tabela setor e mostrar as opções em um ComboBox
        //vai dar um select na tabela setor e mostrar as opções em um ComboBox
        
        //Consulta MYSQL
        try{
            conecta_bd con = new conecta_bd();
            Statement st = con.conexao.createStatement();
            st.executeQuery("SELECT cod_status, tipo_status FROM tb_status");
            
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                ClassesAbstratas.Setor set = new ClassesAbstratas.Setor();
                set.setCodigo_set(rs.getInt("cod_status"));
                set.setDescricao_set(rs.getString("tipo_status"));
                cmb_status_ocor.addItem(set);
            }
            
            con.conexao.close();
        }catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastraOcor(){
        Setor setor = (Setor) cmb_setorOcorr.getSelectedItem();
        int setor_cod= setor.getCodigo_set();
        
        Setor status = (Setor) cmb_status_ocor.getSelectedItem();
        int status_cad = status.getCodigo_set();
        
        try {
            conecta_bd con = new conecta_bd();
            
            String sql = "INSERT INTO ocorrencia(`cod_setor`, `titulo_ocor`, `desc_ocor`, `data_ocor`, `cod_status`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.conexao.prepareStatement(sql);
            ps.setInt(1, setor_cod);
            ps.setString(2, txt_tituloOcorr.getText());
            ps.setString(3, txt_descOcorr.getText());
            ps.setString(4, txt_cadastro_OcorreAno1.getText()+"/"+ txt_cadastro_OcorreMes2.getText() + "/" + txt_cadastro_OcorreDia2.getText());
            ps.setInt(5, status_cad);
            
            //Insert
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ocorrência Cadastrada com Sucesso!", "CADASTRADO", JOptionPane.INFORMATION_MESSAGE);
            
            con.conexao.close();
            
            TelaInicial inic = new TelaInicial();
            inic.setVisible(true);
            dispose();
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean checkCampos(){
        boolean retorna = false;
        //Vai checkar se todos os campos foram preenchidos
        String Message="";
        int erros=0;
        if(txt_tituloOcorr.getText().equals("")){
            Message = "Preencher o titulo.";
            erros++;
        }
        
        //Chck se a data de nascimento foi preenchida corretamente
        if(     !txt_cadastro_OcorreDia2.getText().equals("")&&
                !txt_cadastro_OcorreMes2.getText().equals("")&&
                !txt_cadastro_OcorreAno1.getText().equals("")){
            
            //check se o mês está correto
            if(Integer.parseInt(txt_cadastro_OcorreMes2.getText())>12){
                Message += "\nMês informado não é valido.";
                erros++;
            }
            
        }else{
            Message += "\nPreencher campo Data da Tarefa Corretamente.";
            erros++;
        }
        
        
        //Verifica se o campo email foi preenchido
        if(txt_descOcorr.getText().equals("")){
            Message += "\nDigite uma descrição.";
            erros++;
        }
        
        if(erros==0){
            retorna = true;
        }else{
            JOptionPane.showMessageDialog(null, Message, "Erro nos dados informados", JOptionPane.ERROR_MESSAGE);
        }
        
        return retorna;
    }
    
    public void SelectSetores(){
        //vai dar um select na tabela setor e mostrar as opções em um ComboBox
        
        //Consulta MYSQL
        try{
            conecta_bd con = new conecta_bd();
            Statement st = con.conexao.createStatement();
            st.executeQuery("SELECT cod_setor, nome_setor FROM setor ORDER BY nome_setor");
            
            ResultSet rs = st.getResultSet();
            
            while(rs.next()){
                Setor set = new Setor();
                set.setCodigo_set(rs.getInt("cod_setor"));
                set.setDescricao_set(rs.getString("nome_setor"));
                cmb_setorOcorr.addItem(set);
            }
            
            con.conexao.close();
        }catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates new form CadastroOcorrencia
     */
    public CadastroOcorrencia() {
        initComponents();
        SelectSetores();
        statusSelect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel_cad_ocorr1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cadastro_OcorreDia2 = new javax.swing.JTextField();
        txt_cadastro_OcorreMes2 = new javax.swing.JTextField();
        txt_cadastro_OcorreAno1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_tituloOcorr = new javax.swing.JTextField();
        cmb_setorOcorr = new javax.swing.JComboBox<>();
        cmb_status_ocor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        EnviarOcorr = new javax.swing.JButton();
        EditarOcorr = new javax.swing.JButton();
        ApagarOcorr = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descOcorr = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 245, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_cad_ocorr1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_cad_ocorr1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel_cad_ocorr1.setText("Cadastro de Ocorrência");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_cad_ocorr1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_cad_ocorr1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 50));

        jLabel4.setText("Digite um titulo para a ocorrência:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, 20));

        jLabel5.setText("Digite a data da ocorrência:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 170, 20));

        txt_cadastro_OcorreDia2.setToolTipText("Dia");
        txt_cadastro_OcorreDia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_OcorreDia2ActionPerformed(evt);
            }
        });
        jPanel4.add(txt_cadastro_OcorreDia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 50, 34));

        txt_cadastro_OcorreMes2.setToolTipText("Mês");
        txt_cadastro_OcorreMes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_OcorreMes2ActionPerformed(evt);
            }
        });
        jPanel4.add(txt_cadastro_OcorreMes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 50, 34));

        txt_cadastro_OcorreAno1.setToolTipText("Ano");
        txt_cadastro_OcorreAno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_OcorreAno1ActionPerformed(evt);
            }
        });
        jPanel4.add(txt_cadastro_OcorreAno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 50, 34));

        jLabel1.setText("Escolha um setor para a ocorrência:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 30));

        txt_tituloOcorr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tituloOcorrActionPerformed(evt);
            }
        });
        jPanel4.add(txt_tituloOcorr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 240, 34));

        cmb_setorOcorr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_setorOcorrActionPerformed(evt);
            }
        });
        jPanel4.add(cmb_setorOcorr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 240, 20));

        jPanel4.add(cmb_status_ocor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, -1));

        jLabel2.setText("Status da Ocorrência");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 380, 400));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Descreva a ocorrência:");

        EnviarOcorr.setText("Enviar");
        EnviarOcorr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarOcorrActionPerformed(evt);
            }
        });

        EditarOcorr.setText("Editar");

        ApagarOcorr.setText("Apagar");

        jScrollPane1.setViewportView(txt_descOcorr);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 111, Short.MAX_VALUE)
                        .addComponent(EnviarOcorr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditarOcorr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ApagarOcorr))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnviarOcorr)
                    .addComponent(ApagarOcorr)
                    .addComponent(EditarOcorr))
                .addGap(29, 29, 29))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 340, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cadastro_OcorreAno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_OcorreAno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_OcorreAno1ActionPerformed

    private void txt_cadastro_OcorreMes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_OcorreMes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_OcorreMes2ActionPerformed

    private void txt_cadastro_OcorreDia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_OcorreDia2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_OcorreDia2ActionPerformed

    private void txt_tituloOcorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tituloOcorrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tituloOcorrActionPerformed

    private void cmb_setorOcorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_setorOcorrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_setorOcorrActionPerformed

    private void EnviarOcorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarOcorrActionPerformed
        // TODO add your handling code here:
        if(checkCampos()==true){
            cadastraOcor();
        }
    }//GEN-LAST:event_EnviarOcorrActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroOcorrencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApagarOcorr;
    private javax.swing.JButton EditarOcorr;
    private javax.swing.JButton EnviarOcorr;
    private javax.swing.JComboBox<Object> cmb_setorOcorr;
    private javax.swing.JComboBox<Object> cmb_status_ocor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_cad_ocorr1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTextField txt_cadastro_OcorreAno1;
    javax.swing.JTextField txt_cadastro_OcorreDia2;
    javax.swing.JTextField txt_cadastro_OcorreMes2;
    private javax.swing.JTextPane txt_descOcorr;
    javax.swing.JTextField txt_tituloOcorr;
    // End of variables declaration//GEN-END:variables
}
