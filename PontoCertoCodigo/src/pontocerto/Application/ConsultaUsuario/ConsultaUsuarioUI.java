/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Application.ConsultaUsuario;

import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import pontocerto.Application.AlteraUsuario.AlteraUsuarioUI;
import pontocerto.Application.CadastroUsuario.CadastroUsuarioUI;
import pontocerto.Application.DefaultCode.DefaultCode;
import pontocerto.Business.Admin.CadastraUsuarioValidation;
import pontocerto.Business.Admin.ConsultaUsuarioValidation;
import pontocerto.Common.Admin.UsuarioDTO;
import pontocerto.Global.Enumeradores.NivelAcesso;
import pontocerto.Global.GerenciadorNivelAcesso;

/**
 *
 * @author thiag
 */
public class ConsultaUsuarioUI extends DefaultCode
{

    DefaultTableModel model;

    /**
     * Creates new form ConsultaUsuarioUI
     */
    public ConsultaUsuarioUI()
    {
        initComponents();
        validaAcessoUsuario();
        instanciaTableModel();

        lblMensagemErroConsultaUsuario.setVisible(false);
        tbConsultaUsuario.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        painelPrincipal = new javax.swing.JPanel();
        painelMenuLateral = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblSair = new javax.swing.JLabel();
        lblFretado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        painelConsultaUsuario = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        lblMensagemErroConsultaUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbConsultaUsuario = new javax.swing.JTable();
        btnNovoUsuario = new javax.swing.JButton();
        btnAlterarUsuario = new javax.swing.JButton();
        btnDeletarUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PONTO CERTO");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/busIcon.png")).getImage());
        setResizable(false);

        painelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        painelMenuLateral.setBackground(new java.awt.Color(51, 102, 255));

        lblHome.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblHome.setForeground(new java.awt.Color(255, 255, 255));
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/home.png"))); // NOI18N
        lblHome.setText("  Home");
        lblHome.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblHomeMouseClicked(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/user.png"))); // NOI18N
        lblUsuario.setText("  Usuário");
        lblUsuario.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblUsuarioMouseClicked(evt);
            }
        });

        lblSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/sair.png"))); // NOI18N
        lblSair.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblSairMouseClicked(evt);
            }
        });

        lblFretado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblFretado.setForeground(new java.awt.Color(255, 255, 255));
        lblFretado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/bus.png"))); // NOI18N
        lblFretado.setText("  Fretado");
        lblFretado.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lblFretadoMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PONTO");

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CERTO");

        javax.swing.GroupLayout painelMenuLateralLayout = new javax.swing.GroupLayout(painelMenuLateral);
        painelMenuLateral.setLayout(painelMenuLateralLayout);
        painelMenuLateralLayout.setHorizontalGroup(
            painelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMenuLateralLayout.createSequentialGroup()
                        .addComponent(lblSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFretado, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelMenuLateralLayout.setVerticalGroup(
            painelMenuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMenuLateralLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(75, 75, 75)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lblFretado, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(lblSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        painelConsultaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        painelConsultaUsuario.setPreferredSize(new java.awt.Dimension(728, 585));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Consulta de Usuários");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("CPF");

        txtCpf.setBackground(new java.awt.Color(255, 255, 255));
        txtCpf.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCpf.setForeground(new java.awt.Color(0, 0, 0));
        txtCpf.setToolTipText("Digite o número do fretado");
        txtCpf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Nome");

        txtNome.setBackground(new java.awt.Color(255, 255, 255));
        txtNome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNome.setForeground(new java.awt.Color(0, 0, 0));
        txtNome.setToolTipText("Digite a descrição do fretado");
        txtNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPesquisar.setBackground(new java.awt.Color(51, 102, 255));
        btnPesquisar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/search.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setBorder(null);
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnPesquisarMouseClicked(evt);
            }
        });

        lblMensagemErroConsultaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblMensagemErroConsultaUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        tbConsultaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "CPF", "Nome", "Rua", "Bairro", "Cidade", "Estado"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbConsultaUsuario);

        btnNovoUsuario.setBackground(new java.awt.Color(51, 102, 255));
        btnNovoUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnNovoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/plus.png"))); // NOI18N
        btnNovoUsuario.setText("Novo");
        btnNovoUsuario.setBorder(null);
        btnNovoUsuario.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnNovoUsuarioMouseClicked(evt);
            }
        });

        btnAlterarUsuario.setBackground(new java.awt.Color(51, 102, 255));
        btnAlterarUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAlterarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/update.png"))); // NOI18N
        btnAlterarUsuario.setText("Alterar");
        btnAlterarUsuario.setBorder(null);
        btnAlterarUsuario.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnAlterarUsuarioMouseClicked(evt);
            }
        });

        btnDeletarUsuario.setBackground(new java.awt.Color(51, 102, 255));
        btnDeletarUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDeletarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocerto/Images/delete.png"))); // NOI18N
        btnDeletarUsuario.setText("Deletar");
        btnDeletarUsuario.setBorder(null);
        btnDeletarUsuario.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                btnDeletarUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelConsultaUsuarioLayout = new javax.swing.GroupLayout(painelConsultaUsuario);
        painelConsultaUsuario.setLayout(painelConsultaUsuarioLayout);
        painelConsultaUsuarioLayout.setHorizontalGroup(
            painelConsultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaUsuarioLayout.createSequentialGroup()
                .addGroup(painelConsultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConsultaUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelConsultaUsuarioLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(painelConsultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelConsultaUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMensagemErroConsultaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelConsultaUsuarioLayout.createSequentialGroup()
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelConsultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlterarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeletarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelConsultaUsuarioLayout.setVerticalGroup(
            painelConsultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaUsuarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(lblMensagemErroConsultaUsuario)
                .addGap(33, 33, 33)
                .addGroup(painelConsultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(painelConsultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConsultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelConsultaUsuarioLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnAlterarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(painelMenuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelConsultaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelMenuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelConsultaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
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

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblHomeMouseClicked
    {//GEN-HEADEREND:event_lblHomeMouseClicked
        // TODO add your handling code here:
        this.dispose();
        abrirPaginaHome();
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblUsuarioMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblUsuarioMouseClicked
    {//GEN-HEADEREND:event_lblUsuarioMouseClicked
        // TODO add your handling code here:
        this.dispose();
        abrirPaginaUsuario();
    }//GEN-LAST:event_lblUsuarioMouseClicked

    private void lblFretadoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblFretadoMouseClicked
    {//GEN-HEADEREND:event_lblFretadoMouseClicked
        // TODO add your handling code here:
        this.dispose();
        abrirPaginaFretado();
    }//GEN-LAST:event_lblFretadoMouseClicked

    private void lblSairMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_lblSairMouseClicked
    {//GEN-HEADEREND:event_lblSairMouseClicked
        // TODO add your handling code here:
        this.dispose();
        abrirPaginaLogin();
    }//GEN-LAST:event_lblSairMouseClicked

    private void btnNovoUsuarioMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnNovoUsuarioMouseClicked
    {//GEN-HEADEREND:event_btnNovoUsuarioMouseClicked
        // TODO add your handling code here:
        this.dispose();

        CadastroUsuarioUI paginaCadastroUsuario = new CadastroUsuarioUI();
        paginaCadastroUsuario.setVisible(true);
    }//GEN-LAST:event_btnNovoUsuarioMouseClicked

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnPesquisarMouseClicked
    {//GEN-HEADEREND:event_btnPesquisarMouseClicked
        // TODO add your handling code here:
        lblMensagemErroConsultaUsuario.setVisible(false);

        String cpf = txtCpf.getText().trim();
        String nome = txtNome.getText().trim();

        if (!cpf.equals("") && !CadastraUsuarioValidation.validaCPF(cpf))
        {
            MensagemAlertaErro("CPF inválido", true);
        }
        else
        {
            List<UsuarioDTO> listaUsuarioDto = ConsultaUsuarioValidation.buscaUsuario(cpf, nome);
            PreencheGrid(listaUsuarioDto);
        }
    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void btnAlterarUsuarioMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnAlterarUsuarioMouseClicked
    {//GEN-HEADEREND:event_btnAlterarUsuarioMouseClicked
        // TODO add your handling code here:
        if (tbConsultaUsuario.getRowCount() != 0 && tbConsultaUsuario.getSelectedRow() != -1)
        {
            long cpf = Long.parseLong(model.getValueAt(tbConsultaUsuario.getSelectedRow(), 0).toString());

            this.dispose();

            AlteraUsuarioUI paginaAlteraUsuario = new AlteraUsuarioUI(cpf);
            paginaAlteraUsuario.setVisible(true);
        }
        else
        {
            MensagemAlertaErro("Nenhum usuário selecionado", true);
        }
    }//GEN-LAST:event_btnAlterarUsuarioMouseClicked

    private void btnDeletarUsuarioMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btnDeletarUsuarioMouseClicked
    {//GEN-HEADEREND:event_btnDeletarUsuarioMouseClicked
        // TODO add your handling code here:
        if (tbConsultaUsuario.getRowCount() != 0 && tbConsultaUsuario.getSelectedRow() != -1)
        {
            long cpf = Long.parseLong(model.getValueAt(tbConsultaUsuario.getSelectedRow(), 0).toString());
            CadastraUsuarioValidation.excluiUsuario(cpf);

            String campoCpf = txtCpf.getText().trim();
            String campoNome = txtNome.getText().trim();

            List<UsuarioDTO> listaUsuarioDto = ConsultaUsuarioValidation.buscaUsuario(campoCpf, campoNome);
            PreencheGrid(listaUsuarioDto);

            MensagemAlertaErro("Usuário excluído com sucesso", false);
        }
        else
        {
            MensagemAlertaErro("Nenhum usuário selecionado", true);
        }
    }//GEN-LAST:event_btnDeletarUsuarioMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaUsuarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ConsultaUsuarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ConsultaUsuarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ConsultaUsuarioUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ConsultaUsuarioUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarUsuario;
    private javax.swing.JButton btnDeletarUsuario;
    private javax.swing.JButton btnNovoUsuario;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFretado;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblMensagemErroConsultaUsuario;
    private javax.swing.JLabel lblSair;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel painelConsultaUsuario;
    private javax.swing.JPanel painelMenuLateral;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTable tbConsultaUsuario;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void validaAcessoUsuario()
    {
        String nivelAcesso = GerenciadorNivelAcesso.obterInstancia().getNivelAcesso();

        if (nivelAcesso.equals(NivelAcesso.Comum.name()))
        {
            this.dispose();
            abrirPaginaLogin();
        }
    }

    private void MensagemAlertaErro(String mensagem, boolean erro)
    {
        Color cor = erro ? Color.red : Color.blue;

        lblMensagemErroConsultaUsuario.setVisible(true);
        lblMensagemErroConsultaUsuario.setForeground(cor);
        lblMensagemErroConsultaUsuario.setText(mensagem);
    }

    private void instanciaTableModel()
    {
        model = (DefaultTableModel) tbConsultaUsuario.getModel();
    }

    private void PreencheGrid(List<UsuarioDTO> listaUsuarioDto)
    {
        tbConsultaUsuario.setVisible(true);

        model.setRowCount(0);

        listaUsuarioDto.forEach((item) ->
        {
            model.insertRow(model.getRowCount(), new Object[]
            {
                item.getCPF(), item.getNome(), item.getEndereco().getRua(), item.getEndereco().getBairro(), item.getEndereco().getCidade(), item.getEndereco().getEstado()
            });
        });
    }
}