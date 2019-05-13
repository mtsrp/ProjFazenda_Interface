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
public class CadastroTarefa extends javax.swing.JFrame {
    
    public void cadastraTarefa(){
        Setor setor = (Setor) cmb_setorTarefa.getSelectedItem();
        int set_cad = setor.getCodigo_set();
        
        Setor status = (Setor) cmb_status_tarefa.getSelectedItem();
        int status_cad = status.getCodigo_set();
        
        try {
            conecta_bd con = new conecta_bd();
            
            String sql = "INSERT INTO tarefa(`cod_setor`, `titulo_tarefa`, `desc_tarefa`, `data_tarefa`, `cod_status`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.conexao.prepareStatement(sql);
            ps.setInt(1, set_cad);
            ps.setString(2, txt_tituloTarefa.getText());
            ps.setString(3, txt_desc_tarefa.getText());
            ps.setString(4, txt_cadastro_TarefaAno.getText()+"/"+ txt_cadastro_TarefaMes.getText() + "/" + txt_cadastro_TarefaDia.getText());
            ps.setInt(5, status_cad);
            
            //Insert
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tarefa Cadastrada com Sucesso!", "CADASTRADO", JOptionPane.INFORMATION_MESSAGE);
            
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
        if(txt_tituloTarefa.getText().equals("")){
            Message = "Preencher o titulo da tarefa.";
            erros++;
        }
        
        //Chck se a data de nascimento foi preenchida corretamente
        if(     !txt_cadastro_TarefaDia.getText().equals("")&&
                !txt_cadastro_TarefaMes.getText().equals("")&&
                !txt_cadastro_TarefaAno.getText().equals("")){
            
            //check se o mês está correto
            if(Integer.parseInt(txt_cadastro_TarefaMes.getText())>12){
                Message += "\nMês informado não é valido.";
                erros++;
            }
            
        }else{
            Message += "\nPreencher campo Data da Tarefa Corretamente.";
            erros++;
        }
        
        
        //Verifica se o campo email foi preenchido
        if(txt_desc_tarefa.getText().equals("")){
            Message += "\nDigite uma descrição para a tarefa.";
            erros++;
        }
        
        if(erros==0){
            retorna = true;
        }else{
            JOptionPane.showMessageDialog(null, Message, "Erro nos dados informados", JOptionPane.ERROR_MESSAGE);
        }
        
        return retorna;
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
                cmb_setorTarefa.addItem(set);
            }
            
            con.conexao.close();
        }catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
                cmb_status_tarefa.addItem(set);
            }
            
            con.conexao.close();
        }catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates new form CadastroTarefa
     */
    public CadastroTarefa() {
        initComponents();
        setorSelect();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_tituloTarefa = new javax.swing.JTextField();
        cmb_setorTarefa = new javax.swing.JComboBox<>();
        jLabel_setorTarefa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_cadastro_TarefaDia = new javax.swing.JTextField();
        txt_cadastro_TarefaMes = new javax.swing.JTextField();
        txt_cadastro_TarefaAno = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel_descreverTarefa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_desc_tarefa = new javax.swing.JTextPane();
        btn_apagarTarefa = new javax.swing.JButton();
        btn_editarTarefa = new javax.swing.JButton();
        btn_SalvarTarefa = new javax.swing.JButton();
        cmb_status_tarefa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(226, 245, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de Tarefas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Digite um titulo para a tarefa");

        txt_tituloTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tituloTarefaActionPerformed(evt);
            }
        });

        cmb_setorTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_setorTarefaActionPerformed(evt);
            }
        });

        jLabel_setorTarefa.setText("Escolha um setor para a tarefa:");

        jLabel3.setText("Digite a data para realização da tarefa:");
        jLabel3.setToolTipText("");

        txt_cadastro_TarefaDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_TarefaDia.setToolTipText("Dia");
        txt_cadastro_TarefaDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_TarefaDiaActionPerformed(evt);
            }
        });

        txt_cadastro_TarefaMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_TarefaMes.setToolTipText("Mês");
        txt_cadastro_TarefaMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_TarefaMesActionPerformed(evt);
            }
        });

        txt_cadastro_TarefaAno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_TarefaAno.setToolTipText("Ano");
        txt_cadastro_TarefaAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_TarefaAnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_setorTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txt_cadastro_TarefaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cadastro_TarefaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cadastro_TarefaAno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_setorTarefa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tituloTarefa, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tituloTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_setorTarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_setorTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cadastro_TarefaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cadastro_TarefaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cadastro_TarefaAno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(226, 245, 250));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_descreverTarefa.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel_descreverTarefa.setText("Descreva a tarefa:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_descreverTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_descreverTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(txt_desc_tarefa);

        btn_apagarTarefa.setText("Apagar");

        btn_editarTarefa.setText("Editar");

        btn_SalvarTarefa.setText("Salvar");
        btn_SalvarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarTarefaActionPerformed(evt);
            }
        });

        jLabel4.setText("Status da tarefa:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 68, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_SalvarTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_editarTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_apagarTarefa)
                                .addGap(21, 21, 21))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_status_tarefa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(cmb_status_tarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_apagarTarefa)
                    .addComponent(btn_editarTarefa)
                    .addComponent(btn_SalvarTarefa))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tituloTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tituloTarefaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tituloTarefaActionPerformed

    private void cmb_setorTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_setorTarefaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_setorTarefaActionPerformed

    private void txt_cadastro_TarefaDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_TarefaDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_TarefaDiaActionPerformed

    private void txt_cadastro_TarefaMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_TarefaMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_TarefaMesActionPerformed

    private void txt_cadastro_TarefaAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_TarefaAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_TarefaAnoActionPerformed

    private void btn_SalvarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarTarefaActionPerformed
        // TODO add your handling code here:
        if(checkCampos()==true){
            cadastraTarefa();
            
        }
    }//GEN-LAST:event_btn_SalvarTarefaActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTarefa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SalvarTarefa;
    private javax.swing.JButton btn_apagarTarefa;
    private javax.swing.JButton btn_editarTarefa;
    private javax.swing.JComboBox<Object> cmb_setorTarefa;
    private javax.swing.JComboBox<Object> cmb_status_tarefa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_descreverTarefa;
    private javax.swing.JLabel jLabel_setorTarefa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTextField txt_cadastro_TarefaAno;
    javax.swing.JTextField txt_cadastro_TarefaDia;
    javax.swing.JTextField txt_cadastro_TarefaMes;
    private javax.swing.JTextPane txt_desc_tarefa;
    javax.swing.JTextField txt_tituloTarefa;
    // End of variables declaration//GEN-END:variables
}
