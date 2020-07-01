/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.Admin;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import pontocerto.Business.DAO.FretadoDAO;
import pontocerto.Business.DAO.UsuarioDAO;
import pontocerto.Business.Entity.Fretados;
import pontocerto.Business.Entity.Usuarios;
import pontocerto.Common.DTO.FretadosDTO;

/**
 *
 * @author thiag
 */
public class CadastraFretadoValidation
{

    public static boolean validaCampos(FretadosDTO fretado)
    {
        if (fretado.getNumero() == -1 || fretado.getMotorista() == -1 || fretado.getEntrada() == LocalTime.parse("00:00") || fretado.getSaida() == LocalTime.parse("00:00"))
        {
            return false;
        }

        return true;
    }

    public static boolean validaSeExisteMotorista(long codigoMotorista)
    {
        try
        {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuarios usuario = usuarioDAO.buscarPorCPF(codigoMotorista);

            if (usuario != null)
            {
                return true;
            }
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static boolean validaMotoristaPorFretadoHorario(FretadosDTO fretado)
    {
        try
        {
            ModelMapper modelMapper = new ModelMapper();
            Fretados fretadosEntity = modelMapper.map(fretado, Fretados.class);
            
            FretadoDAO fretadoDao = new FretadoDAO();
            Fretados retorno = fretadoDao.buscarMotoristaFretadoHora(fretadosEntity);
            
            if (retorno == null)
            {
                return true;
            }
        }
        catch (RuntimeException | InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public static void cadastraFretado(FretadosDTO fretado)
    {
        try
        {
            ModelMapper modelMapper = new ModelMapper();
            Fretados fretadosEntity = modelMapper.map(fretado, Fretados.class);
            
            FretadoDAO fretadoDao = new FretadoDAO();
            fretadoDao.insert(fretadosEntity);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void alteraFretado(FretadosDTO fretado)
    {
        try
        {
            ModelMapper modelMapper = new ModelMapper();
            Fretados fretadosEntity = modelMapper.map(fretado, Fretados.class);
            
            FretadoDAO fretadoDao = new FretadoDAO();
            fretadoDao.update(fretadosEntity);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastraFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
