/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.Admin;

import java.lang.reflect.Type;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pontocerto.Business.DAO.EnderecosDAO;
import pontocerto.Business.DAO.TabelaGeralDependenteDAO;
import pontocerto.Business.DAO.UsuarioDAO;
import pontocerto.Business.Entity.Enderecos;
import pontocerto.Business.Entity.TabelaGeralDependente;
import pontocerto.Business.Entity.Usuarios;
import pontocerto.Common.Admin.TabelaGeralDependenteDTO;
import pontocerto.Common.Admin.UsuarioDTO;

/**
 *
 * @author thiag
 */
public class CadastraUsuarioValidation
{

    public static boolean validaCampos(UsuarioDTO usuario)
    {
        if (usuario.getNome().equals("") || usuario.getCPF() == -1 || usuario.getEndereco().getCEP().equals("") || usuario.getEndereco().getRua().equals(""))
        {
            return true;
        }
        
        
        return false;
    }
    
    public static boolean validaUsuarioEndereco(UsuarioDTO usuario)
    {
        try
        {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            Usuarios usuarioEntity = usuarioDao.buscaCpfEndereco(usuario.getCPF(), usuario.getEndereco().getCEP());
            
            if (usuarioEntity != null)
            {
                return true;
            }
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraUsuarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public static boolean validaUsuarioExistente(UsuarioDTO usuario)
    {
        try
        {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            Usuarios usuarioEntity = usuarioDao.buscarPorCPF(usuario.getCPF());
            
            if (usuarioEntity != null)
            {
                return true;
            }
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraUsuarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public static void cadastraUsuario(UsuarioDTO usuario)
    {
        try
        {            
            ModelMapper modelMapper = new ModelMapper();
            Usuarios usuarioEntity = modelMapper.map(usuario, Usuarios.class);
            Enderecos enderecoEntity = modelMapper.map(usuario.getEndereco(), Enderecos.class);
            
            EnderecosDAO enderecoDao = new EnderecosDAO();
            enderecoDao.insert(enderecoEntity);
            
            enderecoEntity = enderecoDao.buscarPorCep(enderecoEntity.getCEP());
            usuarioEntity.getEndereco().setId(enderecoEntity.getId());
            
            TabelaGeralDependenteDAO perfilDao = new TabelaGeralDependenteDAO();
            TabelaGeralDependente perfilEntity = perfilDao.buscarPorDescricao(usuario.getPerfil().getDescricao());
            usuarioEntity.getPerfil().setId(perfilEntity.getId());
            
            UsuarioDAO usuarioDao = new UsuarioDAO();
            usuarioDao.insert(usuarioEntity);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraUsuarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void excluiUsuario(long cpf)
    {
        try
        {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            Usuarios usuarioEntity = usuarioDao.buscarPorCPF(cpf);
            usuarioDao.delete(cpf);
            
            EnderecosDAO enderecoDao = new EnderecosDAO();
            enderecoDao.delete(usuarioEntity.getEndereco().getId());
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraUsuarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean validaCPF(String CPF)
    {
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11))
        {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try
        {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++)
            {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0         
                // (48 eh a posicao de '0' na tabela ASCII)         
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
            {
                dig10 = '0';
            }
            else
            {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++)
            {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
            {
                dig11 = '0';
            }
            else
            {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
            {
                return (true);
            }
            else
            {
                return (false);
            }
        }
        catch (InputMismatchException erro)
        {
            return (false);
        }
    }
    
    public static List<TabelaGeralDependenteDTO> PreencherCampoNivelAcesso()
    {
        try
        {
            TabelaGeralDependenteDAO perfilDao = new TabelaGeralDependenteDAO();
            List<TabelaGeralDependente> listaPerfilEntity = perfilDao.listar();
            
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<TabelaGeralDependenteDTO>>(){}.getType();
            List<TabelaGeralDependenteDTO> listaPerfilDto = modelMapper.map(listaPerfilEntity, listType);
            
            return listaPerfilDto;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraUsuarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
