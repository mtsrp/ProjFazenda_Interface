/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteFazenda;

import ClassesAbstratas.Setor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wesll
 */
public class TelaCadastro extends javax.swing.JFrame {

    public void cadastraNoBanco(){
        Setor setor = (Setor) cb_setor.getSelectedItem();
        int set_cad = setor.getCodigo_set();
        
        Setor permissao = (Setor) cb_permissao.getSelectedItem();
        int permissao_cad = permissao.getCodigo_set();
        
        try {
            conecta_bd con = new conecta_bd();
            
            String sql = "INSERT INTO funcionario( `nome_func`, `dta_adm`, `usuario_func`, `senha_func`, `cod_permis`, `cod_setor`, `email_func`, `nasc_func`, `sexo_func`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.conexao.prepareStatement(sql);
            ps.setString(1, txt_cadastro_nome.getText());
            ps.setString(2, txt_cadastro_AdmiAno.getText()+"/"+ txt_cadastro_AdmiMes.getText() + "/" + txt_cadastro_AdmiDia.getText());
            ps.setString(3, txt_usuario_cadastro.getText());
            ps.setString(4, String.valueOf(txt_senha_cadastro.getPassword()));
            ps.setInt(5, permissao_cad);
            ps.setInt(6, set_cad);
            ps.setString(7, txt_cadastro_email.getText());
            ps.setString(8, txt_cadastro_NascAno.getText()+"/"+ txt_cadastro_NascMes.getText() + "/" + txt_cadastro_NascDia.getText());
            ps.setString(9, checkSexo());
            //Insert
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso", "CADASTRADO", JOptionPane.INFORMATION_MESSAGE);
            
            con.conexao.close();
            
            TelaInicial inic = new TelaInicial();
            inic.setVisible(true);
            dispose();
            
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean ver_Usuario_repetido(){
        boolean resulta = false;
        conecta_bd con;
        try {
            con = new conecta_bd();
            Statement st = con.conexao.createStatement();
            st.executeQuery("SELECT usuario_func FROM funcionario WHERE usuario_func='"+txt_usuario_cadastro.getText()+"'");
            ResultSet rs = st.getResultSet();
            if(rs.next()){
                resulta = true;
            }
            con.conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resulta;
    }
    public boolean checkCampos(){
        boolean retorna = false;
        //Vai checkar se todos os campos foram preenchidos
        String Message="";
        int erros=0;
        if(txt_cadastro_nome.getText().equals("")){
            Message = "Preencher campo Nome.";
            erros++;
        }
        
        //Chck se a data de nascimento foi preenchida corretamente
        if(     !txt_cadastro_NascDia.getText().equals("")&&
                !txt_cadastro_NascMes.getText().equals("")&&
                !txt_cadastro_NascAno.getText().equals("")){
            
            //check se o mês está correto
            if(Integer.parseInt(txt_cadastro_NascMes.getText())>12){
                Message += "\nPreencher campo Data de Nascimento Corretamente.";
                erros++;
            }
            
        }else{
            Message += "\nPreencher campo Data de Nascimento Corretamente.";
            erros++;
        }
        
        //Verifica se uma das opções de sexo foi selecionada
        if(!rdb_fem.isSelected()&&!rdb_masc.isSelected()){
            Message += "\nSelecione o sexo.";
            erros++;
        }
        
        //Verifica se o campo email foi preenchido
        if(txt_cadastro_email.getText().equals("")){
            Message += "\nDigite o E-mail.";
            erros++;
        }
        
        //Chck se a data de Admissão foi preenchida corretamente
        if(     !txt_cadastro_AdmiDia.getText().equals("")&&
                !txt_cadastro_AdmiMes.getText().equals("")&&
                !txt_cadastro_AdmiAno.getText().equals("")){
            
            //check se o mês está correto
            if(Integer.parseInt(txt_cadastro_AdmiMes.getText())>12){
                Message += "\nO mês selecionado em Data de Admissão é inválido.";
                erros++;
            }
            
        }else{
            Message += "\nPreencher campo Data de Nascimento Corretamente.";
            erros++;
        }
        //Verifica se o campo Usuario foi preenchido, e se o mesmo existe no banco
        if(!txt_usuario_cadastro.getText().equals("")){
            if(ver_Usuario_repetido()==true){
                Message += "\nNome de Usuário não disponível.";
                erros++;
            }
            
        }else{
            Message += "\nPreencher campo Usuário Corretamente.";
            erros++;
        }
        if(String.valueOf(txt_senha_cadastro.getPassword()).equals("")||txt_senha_cadastro.getPassword().length > 20){
            Message += "\nPreencher campo Senha Corretamente.";
            erros++;
        }
        if(erros==0){
            retorna = true;
        }else{
            JOptionPane.showMessageDialog(null, Message, "Erro nos dados informados", JOptionPane.ERROR_MESSAGE);
        }
        
        return retorna;
    }
    public String checkSexo(){
        //Olha qual opção foi selecionada
        String sexo="";  
            if(rdb_fem.isSelected()){
                sexo = "F";
            }else if(rdb_masc.isSelected()){
                sexo = "M";
            }
        return sexo;
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
    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro(){
 
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_usuario_cadastro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel_dadosacesso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_senha_cadastro = new javax.swing.JPasswordField();
        cb_permissao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bnt_cadastro_salvar = new javax.swing.JButton();
        btn_cadastro_sair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_cadastro_nome = new javax.swing.JTextField();
        txt_cadastro_email = new javax.swing.JTextField();
        txt_cadastro_NascDia = new javax.swing.JTextField();
        txt_cadastro_NascMes = new javax.swing.JTextField();
        txt_cadastro_NascAno = new javax.swing.JTextField();
        jLabel_DataNasc1 = new javax.swing.JLabel();
        JLabel_Nome = new javax.swing.JLabel();
        cb_setor = new javax.swing.JComboBox<>();
        jLabel_Setor = new javax.swing.JLabel();
        txt_cadastro_AdmiDia = new javax.swing.JTextField();
        jLabel_DataAdmi = new javax.swing.JLabel();
        txt_cadastro_AdmiMes = new javax.swing.JTextField();
        txt_cadastro_AdmiAno = new javax.swing.JTextField();
        jLabel_Email = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        rdb_masc = new javax.swing.JRadioButton();
        rdb_fem = new javax.swing.JRadioButton();
        jLabel_cadastrese = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_usuario_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuario_cadastroActionPerformed(evt);
            }
        });
        jPanel4.add(txt_usuario_cadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 30));

        jLabel1.setText("Usuário:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel_dadosacesso.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel_dadosacesso.setText("DADOS DE ACESSO");
        jPanel4.add(jLabel_dadosacesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 180, 30));

        jLabel3.setText("Senha:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel4.add(txt_senha_cadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 30));

        cb_permissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_permissaoActionPerformed(evt);
            }
        });
        jPanel4.add(cb_permissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, -1));

        jLabel4.setText("Permissão do usuário:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 290, 360));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bnt_cadastro_salvar.setBackground(new java.awt.Color(0, 204, 0));
        bnt_cadastro_salvar.setText("Cadastrar");
        bnt_cadastro_salvar.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        bnt_cadastro_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_cadastro_salvarActionPerformed(evt);
            }
        });
        jPanel5.add(bnt_cadastro_salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, 40));

        btn_cadastro_sair.setBackground(new java.awt.Color(255, 0, 0));
        btn_cadastro_sair.setText("Cancelar");
        btn_cadastro_sair.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102)));
        btn_cadastro_sair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_cadastro_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastro_sairActionPerformed(evt);
            }
        });
        jPanel5.add(btn_cadastro_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 40));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 290, 80));

        jPanel1.setBackground(new java.awt.Color(226, 245, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cadastro_nome.setToolTipText("");
        txt_cadastro_nome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_cadastro_nome.setName(""); // NOI18N
        txt_cadastro_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_nomeActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cadastro_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 34));
        txt_cadastro_nome.getAccessibleContext().setAccessibleName("");

        txt_cadastro_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cadastro_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 460, 34));

        txt_cadastro_NascDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_NascDia.setToolTipText("Dia");
        txt_cadastro_NascDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_NascDiaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cadastro_NascDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 50, 34));

        txt_cadastro_NascMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_NascMes.setToolTipText("Mês");
        txt_cadastro_NascMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_NascMesActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cadastro_NascMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 50, 34));

        txt_cadastro_NascAno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_NascAno.setToolTipText("Ano");
        txt_cadastro_NascAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_NascAnoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cadastro_NascAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 50, 34));

        jLabel_DataNasc1.setText("Data de nascimento:");
        jPanel1.add(jLabel_DataNasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        JLabel_Nome.setText("Nome Completo:");
        jPanel1.add(JLabel_Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel1.add(cb_setor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 160, 20));

        jLabel_Setor.setText("Setor:");
        jPanel1.add(jLabel_Setor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        txt_cadastro_AdmiDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_AdmiDia.setToolTipText("Dia");
        txt_cadastro_AdmiDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_AdmiDiaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cadastro_AdmiDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 50, 34));

        jLabel_DataAdmi.setText("Data de Admissão:");
        jPanel1.add(jLabel_DataAdmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        txt_cadastro_AdmiMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_AdmiMes.setToolTipText("Mês");
        txt_cadastro_AdmiMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_AdmiMesActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cadastro_AdmiMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 50, 34));

        txt_cadastro_AdmiAno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cadastro_AdmiAno.setToolTipText("Ano");
        txt_cadastro_AdmiAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cadastro_AdmiAnoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cadastro_AdmiAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 50, 34));

        jLabel_Email.setText("E-mail:");
        jPanel1.add(jLabel_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sexo:"));

        buttonGroup1.add(rdb_masc);
        rdb_masc.setText("Masculino");
        jPanel6.add(rdb_masc);

        buttonGroup1.add(rdb_fem);
        rdb_fem.setText("Feminino");
        rdb_fem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_femActionPerformed(evt);
            }
        });
        jPanel6.add(rdb_fem);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 210, -1));

        jLabel_cadastrese.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel_cadastrese.setText("CADASTRO DE FUNCIONÁRIO");
        jPanel1.add(jLabel_cadastrese, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 270, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnt_cadastro_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_cadastro_salvarActionPerformed
        
        if(checkCampos()==true){
            cadastraNoBanco();
        }
    }//GEN-LAST:event_bnt_cadastro_salvarActionPerformed

    private void txt_usuario_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuario_cadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuario_cadastroActionPerformed

    private void btn_cadastro_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastro_sairActionPerformed
        // TODO add your handling code here:
        TelaInicial inic = new TelaInicial();
        inic.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_cadastro_sairActionPerformed

    private void cb_permissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_permissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_permissaoActionPerformed

    private void rdb_femActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_femActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_femActionPerformed

    private void txt_cadastro_AdmiAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_AdmiAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_AdmiAnoActionPerformed

    private void txt_cadastro_AdmiMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_AdmiMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_AdmiMesActionPerformed

    private void txt_cadastro_AdmiDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_AdmiDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_AdmiDiaActionPerformed

    private void txt_cadastro_NascAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_NascAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_NascAnoActionPerformed

    private void txt_cadastro_NascMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_NascMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_NascMesActionPerformed

    private void txt_cadastro_NascDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_NascDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_NascDiaActionPerformed

    private void txt_cadastro_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_emailActionPerformed

    private void txt_cadastro_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cadastro_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cadastro_nomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel_Nome;
    private javax.swing.JButton bnt_cadastro_salvar;
    private javax.swing.JButton btn_cadastro_sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Object> cb_permissao;
    private javax.swing.JComboBox<Object> cb_setor;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton rdb_fem;
    private javax.swing.JRadioButton rdb_masc;
    javax.swing.JTextField txt_cadastro_AdmiAno;
    javax.swing.JTextField txt_cadastro_AdmiDia;
    javax.swing.JTextField txt_cadastro_AdmiMes;
    javax.swing.JTextField txt_cadastro_NascAno;
    javax.swing.JTextField txt_cadastro_NascDia;
    javax.swing.JTextField txt_cadastro_NascMes;
    javax.swing.JTextField txt_cadastro_email;
    javax.swing.JTextField txt_cadastro_nome;
    private javax.swing.JPasswordField txt_senha_cadastro;
    private javax.swing.JTextField txt_usuario_cadastro;
    // End of variables declaration//GEN-END:variables
}
