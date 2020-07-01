/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Application.DefaultCode;

import pontocerto.Application.ConsultaFretado.ConsultaFretadoUI;
import pontocerto.Application.ConsultaUsuario.ConsultaUsuarioUI;
import pontocerto.Application.Home.HomeUI;
import pontocerto.Application.Login.LoginUI;
import pontocerto.Global.GerenciadorNivelAcesso;

/**
 *
 * @author thiag
 */
public abstract class DefaultCode extends javax.swing.JFrame
{
    protected abstract void validaAcessoUsuario();

    protected void abrirPaginaHome()
    {
        HomeUI paginaHome = new HomeUI();
        paginaHome.setVisible(true);
    }

    protected void abrirPaginaFretado()
    {
        ConsultaFretadoUI paginaConsultaFretado = new ConsultaFretadoUI();
        paginaConsultaFretado.setVisible(true);
    }

    protected void abrirPaginaUsuario()
    {
        ConsultaUsuarioUI paginaConsultaUsuario = new ConsultaUsuarioUI();
        paginaConsultaUsuario.setVisible(true);
    }

    protected void abrirPaginaLogin()
    {
        GerenciadorNivelAcesso.obterInstancia().setNivelAcesso(null);
        LoginUI paginaLogin = new LoginUI();
        paginaLogin.setVisible(true);
    }
}
