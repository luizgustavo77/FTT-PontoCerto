/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.DTO;

import java.util.List;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pontocerto.Business.DAO.FretadoDAO;
import pontocerto.Business.DAO.RotasDAO;
import pontocerto.Business.Entity.Fretados;
import pontocerto.Common.DTO.FretadosDTO;

/**
 *
 * @author thiag
 */
public class ConsultaFretadoValidation
{
    public static boolean validaCampos(String cep, String rua)
    {
        if (!cep.equals("") && !rua.equals(""))
        {
            return true;
        }
        
        return false;
    }
    
    public static List<FretadosDTO> pesquisaFretado(String cep, String rua)
    {
        try
        {
            FretadoDAO fretadoDao = new FretadoDAO();
            List<Fretados> listaFretadosEntity = fretadoDao.buscaPorCepRua(cep, rua);
            
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<FretadosDTO>>(){}.getType();
            List<FretadosDTO> listaFretadosDto = modelMapper.map(listaFretadosEntity, listType);
            
            return listaFretadosDto;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(ConsultaFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static List<FretadosDTO> listaFretados()
    {
        try
        {
            FretadoDAO fretadoDao = new FretadoDAO();
            List<Fretados> listaFretadosEntity = fretadoDao.listar();
            
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<FretadosDTO>>(){}.getType();
            List<FretadosDTO> listaFretadosDto = modelMapper.map(listaFretadosEntity, listType);
            
            return listaFretadosDto;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(ConsultaFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static FretadosDTO buscaFretadoPorNumeroHorario(FretadosDTO fretado)
    {
        try
        {
            ModelMapper modelMapper = new ModelMapper();
            Fretados fretadosEntity = modelMapper.map(fretado, Fretados.class);
            
            FretadoDAO fretadoDao = new FretadoDAO();
            Fretados retorno = fretadoDao.buscaFretadoPorNumeroHorario(fretadosEntity);
            
            FretadosDTO fretadoDTO = modelMapper.map(retorno, FretadosDTO.class);
            return fretadoDTO;
        }
        catch (RuntimeException | InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(ConsultaFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static void deletaFretado(FretadosDTO fretado)
    {
        try
        {
            RotasDAO rotasDao = new RotasDAO();
            rotasDao.delete(fretado.getId());
            
            FretadoDAO fretadoDao = new FretadoDAO();
            fretadoDao.delete(fretado.getId());
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(ConsultaFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
