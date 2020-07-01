/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.Admin;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import pontocerto.Business.DAO.EnderecosDAO;
import pontocerto.Business.DAO.TabelaGeralDependenteDAO;
import pontocerto.Business.DAO.UsuarioDAO;
import pontocerto.Business.Entity.Enderecos;
import pontocerto.Business.Entity.TabelaGeralDependente;
import pontocerto.Business.Entity.Usuarios;
import pontocerto.Common.Admin.UsuarioDTO;

/**
 *
 * @author thiag
 */
public class AlteraUsuarioValidation
{
    public static UsuarioDTO buscarUsuarioPorCpf(long cpf)
    {
        try
        {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            Usuarios usuarioEntity = usuarioDao.buscarPorCPF(cpf);
            
            ModelMapper modelMapper = new ModelMapper();
            UsuarioDTO usuarioDTO = modelMapper.map(usuarioEntity, UsuarioDTO.class);
            
            return usuarioDTO;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(AlteraUsuarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void autalizaUsuario(UsuarioDTO usuario)
    {
        try
        {            
            ModelMapper modelMapper = new ModelMapper();
            Usuarios usuarioEntity = modelMapper.map(usuario, Usuarios.class);
            Enderecos enderecoEntity = modelMapper.map(usuario.getEndereco(), Enderecos.class);
            
            EnderecosDAO enderecoDao = new EnderecosDAO();
            enderecoDao.update(enderecoEntity);
            
            enderecoEntity = enderecoDao.buscarPorCep(enderecoEntity.getCEP());
            usuarioEntity.getEndereco().setId(enderecoEntity.getId());
            
            TabelaGeralDependenteDAO perfilDao = new TabelaGeralDependenteDAO();
            TabelaGeralDependente perfilEntity = perfilDao.buscarPorDescricao(usuario.getPerfil().getDescricao());
            usuarioEntity.getPerfil().setId(perfilEntity.getId());
            
            UsuarioDAO usuarioDao = new UsuarioDAO();
            usuarioDao.update(usuarioEntity);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraUsuarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
