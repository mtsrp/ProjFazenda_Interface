
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wesll
 */
public class TelaInicio2 extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicio2
     */
    public TelaInicio2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_usuario = new javax.swing.JTextField();
        txt_login_senha = new javax.swing.JTextField();
        btn_login_entrar = new javax.swing.JToggleButton();
        btn_login_cadastro = new javax.swing.JToggleButton();
        Imagem_Inicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 450));
        getContentPane().setLayout(null);

        txt_usuario.setText("Digite o seu Usuário");
        getContentPane().add(txt_usuario);
        txt_usuario.setBounds(170, 300, 433, 34);

        txt_login_senha.setText("Digite a sua senha");
        getContentPane().add(txt_login_senha);
        txt_login_senha.setBounds(170, 350, 433, 34);

        btn_login_entrar.setText("Entrar");
        btn_login_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_login_entrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login_entrar);
        btn_login_entrar.setBounds(620, 360, 70, 23);

        btn_login_cadastro.setText("Cadastre-se");
        btn_login_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_login_cadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login_cadastro);
        btn_login_cadastro.setBounds(10, 420, 120, 23);

        Imagem_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PacoteFazenda/Redimensionado.png"))); // NOI18N
        getContentPane().add(Imagem_Inicio);
        Imagem_Inicio.setBounds(0, 0, 800, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_login_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_login_entrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_login_entrarActionPerformed

    private void btn_login_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_login_cadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_login_cadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        TelaInicio2 telainicio = new TelaInicio2();
            telainicio.setVisible(true);
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicio2().setVisible(true);
            }
            
        
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagem_Inicio;
    private javax.swing.JToggleButton btn_login_cadastro;
    private javax.swing.JToggleButton btn_login_entrar;
    private javax.swing.JTextField txt_login_senha;
    javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}

