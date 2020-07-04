/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.Admin;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pontocerto.Business.DAO.UsuarioDAO;
import pontocerto.Business.Entity.Usuarios;
import pontocerto.Common.Admin.UsuarioDTO;

/**
 *
 * @author thiag
 */
public class ConsultaUsuarioValidation
{
    public static List<UsuarioDTO> buscaUsuario(String cpf, String nome)
    {
        try
        {
            List<Usuarios> listaUsuarioEntity = new ArrayList<Usuarios>();
            UsuarioDAO usuarioDao = new UsuarioDAO();
            
            if (cpf.equals("") && cpf.equals(""))
            {
                listaUsuarioEntity = usuarioDao.listar();
            }
            else
            {
                if (!cpf.equals("") && !nome.equals(""))
                {
                    listaUsuarioEntity = usuarioDao.buscaPorCpfNome(nome, Long.parseLong(cpf));
                }
                else if (!cpf.equals(""))
                {
                    Usuarios usuarioEntity = usuarioDao.buscarPorCPF(Long.parseLong(cpf));
                    
                    if (usuarioEntity != null)
                    {
                        listaUsuarioEntity.add(usuarioEntity);
                    }   
                }
                else if (!nome.equals(""))
                {
                    listaUsuarioEntity = usuarioDao.buscaPorNome(nome);
                }
            }
            
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<UsuarioDTO>>(){}.getType();
            List<UsuarioDTO> listaUsuariosDto = modelMapper.map(listaUsuarioEntity, listType);
            
            return listaUsuariosDto;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(ConsultaUsuarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
