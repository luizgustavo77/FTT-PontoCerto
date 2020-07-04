/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Application.Login;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pontocerto.Application.Home.HomeUI;
import pontocerto.Business.DTO.LoginValidation;
import pontocerto.Common.DTO.LoginDTO;

/**
 *
 * @author thiag
 */
public class LoginUI extends javax.swing.JFrame
{

    /**
     * Creates new form LoginUI
     */
    public LoginUI()
    {
        initComponents();

        inicializacaoEstadoDefaultComponente();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        painelPrincipal = new javax.swing.JPanel();
        painelLateral = new javax.swing.JPanel();
        imgIconePainelLateral = new javax.swing.JLabel();
        lblTituloPainelLiteralLogin = new javax.swing.JLabel();
        lblTituloPainelPrincipalLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JFormattedTextField();
        lblUsuario = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnLogar = new javax.swing.JButton();
        lblMensagemErro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/busIcon.png")).getImage());
        setResizable(false);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        painelLateral.setBackground(new java.awt.Color(51, 102, 255));

        imgIconePainelLateral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/UserLogin.png"))); // NOI18N

        lblTituloPainelLiteralLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTituloPainelLiteralLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPainelLiteralLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloPainelLiteralLogin.setText("Ponto Certo Login");

        javax.swing.GroupLayout painelLateralLayout = new javax.swing.GroupLayout(painelLateral);
        painelLateral.setLayout(painelLateralLayout);
        painelLateralLayout.setHorizontalGroup(
            painelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLateralLayout.createSequentialGroup()
                .addGroup(painelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLateralLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(imgIconePainelLateral))
                    .addGroup(painelLateralLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblTituloPainelLiteralLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        painelLateralLayout.setVerticalGroup(
            painelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLateralLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(imgIconePainelLateral)
                .addGap(40, 40, 40)
                .addComponent(lblTituloPainelLiteralLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        lblTituloPainelPrincipalLogin.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTituloPainelPrincipalLogin.setForeground(new java.awt.Color(0, 0, 0));
        lblTituloPainelPrincipalLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloPainelPrincipalLogin.setText("Login");

        lblSenha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(0, 0, 0));
        lblSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSenha.setText("Senha");

        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        try
        {
            txtUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex)
        {
            ex.printStackTrace();
        }
        txtUsuario.setToolTipText("Informe o CPF");
        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Usuário");

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));
        txtSenha.setToolTipText("Digite sua senha");
        txtSenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLogar.setBackground(new java.awt.Color(51, 102, 255));
        btnLogar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogar.setForeground(new java.awt.Color(255, 255, 255));
        btnLogar.setText("Logar");
        btnLogar.setBorder(null);
        btnLogar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLogarActionPerformed(evt);
            }
        });

        lblMensagemErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(painelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(lblTituloPainelPrincipalLogin))
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(233, Short.MAX_VALUE))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsuario)
                            .addComponent(lblSenha)
                            .addComponent(txtSenha)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(lblMensagemErro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTituloPainelPrincipalLogin)
                .addGap(21, 21, 21)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensagemErro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLogarActionPerformed
    {//GEN-HEADEREND:event_btnLogarActionPerformed
        try
        {
            LoginDTO login = ObtemLogin();

            boolean validacao = LoginValidation.validacaoComponentes(login);
            boolean validacaoUsuario = LoginValidation.validacaoUsuario(login);

            if (validacao && validacaoUsuario)
            {
                this.dispose();

                HomeUI paginaHome = new HomeUI();
                paginaHome.setVisible(true);
            }
            else
            {
                MensagemAlertaErro("Usuário ou senha inválidos ou não cadastrado", true);
            }
        }
        catch (Exception ex)
        {
            MensagemAlertaErro("Ocorreu um erro ao obter o usuário", true);
        }
    }//GEN-LAST:event_btnLogarActionPerformed

    private LoginDTO ObtemLogin()
    {
        String usuario = txtUsuario.getValue() == null ? "" : txtUsuario.getValue().toString();
        String senha = new String(txtSenha.getPassword());

        LoginDTO login = new LoginDTO();
        login.setCpf(usuario);
        login.setSenha(senha);

        return login;
    }

    private void MensagemAlertaErro(String mensagem, boolean erro)
    {
        Color cor = erro ? Color.red : Color.blue;

        lblMensagemErro.setVisible(true);
        lblMensagemErro.setForeground(cor);
        lblMensagemErro.setText(mensagem);
    }

    private void inicializacaoEstadoDefaultComponente()
    {
        lblMensagemErro.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel imgIconePainelLateral;
    private javax.swing.JLabel lblMensagemErro;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTituloPainelLiteralLogin;
    private javax.swing.JLabel lblTituloPainelPrincipalLogin;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel painelLateral;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}