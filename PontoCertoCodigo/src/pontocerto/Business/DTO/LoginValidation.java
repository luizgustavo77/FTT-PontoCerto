/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.DTO;

import java.util.logging.Level;
import java.util.logging.Logger;
import pontocerto.Business.DAO.UsuarioDAO;
import pontocerto.Business.Entity.Usuarios;
import pontocerto.Common.DTO.LoginDTO;
import pontocerto.Global.GerenciadorNivelAcesso;

/**
 *
 * @author thiag
 */
public class LoginValidation
{

    public static boolean validacaoComponentes(LoginDTO loginDTO)
    {
        return !(loginDTO.getCpf().equals("") || loginDTO.getSenha().equals(("")));
    }
    
    public static boolean validacaoUsuario(LoginDTO loginDTO)
    {
        try
        {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuarios usuario = usuarioDAO.buscarPorCPF(Long.parseLong(loginDTO.getCpf()));
            
            if (usuario != null)
            {
                if (usuario.getSenha().equals(loginDTO.getSenha()))
                {
                    GerenciadorNivelAcesso.obterInstancia().setNivelAcesso(usuario.Perfil.Descricao);
                    return true;
                }
            }
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(LoginValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
