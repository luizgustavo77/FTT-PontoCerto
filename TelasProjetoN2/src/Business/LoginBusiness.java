/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Model.UsuarioModel;

/**
 *
 * @author thiag
 */
public class LoginBusiness {

    private boolean LoginValidation(UsuarioModel usuarioModel) {
        if (usuarioModel.getUsuario().isEmpty() || usuarioModel.getSenha().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean LogarUsuario(UsuarioModel usuarioModel) {
        if (!LoginValidation(usuarioModel)) {
            return false;
        } else {
            
            // Logar o usuário e direcioná-lo para a respectiva tela
            return true;
        }
    }
}
