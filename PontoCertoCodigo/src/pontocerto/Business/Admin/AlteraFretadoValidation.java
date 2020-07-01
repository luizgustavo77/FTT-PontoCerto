/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.Admin;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import pontocerto.Business.DAO.FretadoDAO;
import pontocerto.Business.Entity.Fretados;
import pontocerto.Common.DTO.FretadosDTO;

/**
 *
 * @author thiag
 */
public class AlteraFretadoValidation
{
    public static FretadosDTO buscaFretadoPorId(int id)
    {
        try
        {
            FretadoDAO fretadoDao = new FretadoDAO();
            Fretados fretadoEntity = fretadoDao.buscar(id);
            
            ModelMapper modelMapper = new ModelMapper();
            FretadosDTO fretadoDTO = modelMapper.map(fretadoEntity, FretadosDTO.class);
            
            return fretadoDTO;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(AlteraFretadoValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
