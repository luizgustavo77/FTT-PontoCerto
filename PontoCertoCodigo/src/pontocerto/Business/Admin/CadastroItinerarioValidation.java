/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Business.Admin;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pontocerto.Business.DAO.EnderecosDAO;
import pontocerto.Business.DAO.FretadoDAO;
import pontocerto.Business.DAO.RotasDAO;
import pontocerto.Business.Entity.Enderecos;
import pontocerto.Business.Entity.Fretados;
import pontocerto.Business.Entity.Rotas;
import pontocerto.Common.Admin.RotasDTO;
import pontocerto.Common.DTO.FretadosDTO;

/**
 *
 * @author thiag
 */
public class CadastroItinerarioValidation
{

    public static List<FretadosDTO> buscaFretados()
    {
        try
        {
            FretadoDAO fretadoDao = new FretadoDAO();
            List<Fretados> listaFretadosEntity = fretadoDao.listar();

            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<FretadosDTO>>()
            {
            }.getType();
            List<FretadosDTO> listaFretadosDto = modelMapper.map(listaFretadosEntity, listType);

            return listaFretadosDto;
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastroItinerarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean validaCampos(RotasDTO rota)
    {
        if (rota.getFretado().getNumero() == -1 || rota.getParada().getCEP().equals("") || rota.getParada().getRua().equals(""))
        {
            return true;
        }

        return false;
    }

    public static void cadastrarRota(RotasDTO rota)
    {
        try
        {
            ModelMapper modelMapper = new ModelMapper();
            Rotas rotaEntity = modelMapper.map(rota, Rotas.class);
            Enderecos enderecoEntity = modelMapper.map(rota.getParada(), Enderecos.class);

            EnderecosDAO enderecoDao = new EnderecosDAO();
            Enderecos retornoEnderecoEntity = enderecoDao.buscarPorCep(enderecoEntity.getCEP());

            if (retornoEnderecoEntity == null)
            {
                enderecoDao.insert(enderecoEntity);
                retornoEnderecoEntity = enderecoDao.buscarPorCep(enderecoEntity.getCEP());
            }

            rotaEntity.getParada().setId(retornoEnderecoEntity.getId());

            RotasDAO rotaDao = new RotasDAO();
            rotaDao.insert(rotaEntity);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastroItinerarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void excluiRota(RotasDTO rota)
    {
        try
        {
            ModelMapper modelMapper = new ModelMapper();
            Rotas rotaEntity = modelMapper.map(rota, Rotas.class);

            EnderecosDAO enderecoDao = new EnderecosDAO();
            rotaEntity.setParada(enderecoDao.buscarPorCep(rotaEntity.getParada().getCEP()));
            
            RotasDAO rotaDao = new RotasDAO();
            rotaDao.delete(rotaEntity);
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex)
        {
            Logger.getLogger(CadastroItinerarioValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
