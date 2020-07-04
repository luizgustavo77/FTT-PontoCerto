/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.DTO;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pontocerto.Business.DAO.RotasDAO;
import pontocerto.Business.Entity.Rotas;
import pontocerto.Common.Admin.RotasDTO;

/**
 *
 * @author thiag
 */
public class ConsultaRotaValidation
{
    public static List<RotasDTO> buscarRotaPorFretado(int idFretado)
    {
        try
        {
            RotasDAO rotasDao = new RotasDAO();
            List<Rotas> listaRotaEntity = rotasDao.buscarPorFretado(idFretado);
            
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<RotasDTO>>(){}.getType();
            List<RotasDTO> listaRotasDto = modelMapper.map(listaRotaEntity, listType);
            
            return listaRotasDto;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(ConsultaRotaValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
