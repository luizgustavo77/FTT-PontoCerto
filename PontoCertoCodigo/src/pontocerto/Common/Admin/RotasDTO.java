/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Common.Admin;

import pontocerto.Common.DTO.FretadosDTO;

/**
 *
 * @author thiag
 */
public class RotasDTO
{
    public RotasDTO()
    {
        Parada = new EnderecosDTO();
        Fretado = new FretadosDTO();
    }
    
    public EnderecosDTO getParada()
    {
        return Parada;
    }

    public void setParada(EnderecosDTO Parada)
    {
        this.Parada = Parada;
    }

    public FretadosDTO getFretado()
    {
        return Fretado;
    }

    public void setFretado(FretadosDTO Fretado)
    {
        this.Fretado = Fretado;
    }
    private EnderecosDTO Parada;
    private FretadosDTO Fretado;
}
