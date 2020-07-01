/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Common.DTO;

import java.time.LocalTime;

/**
 *
 * @author thiag
 */
public class FretadosDTO
{

    public int getId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public int getNumero()
    {
        return Numero;
    }

    public void setNumero(int Numero)
    {
        this.Numero = Numero;
    }

    public long getMotorista()
    {
        return Motorista;
    }

    public void setMotorista(long Motorista)
    {
        this.Motorista = Motorista;
    }

    public String getDescricao()
    {
        return Descricao;
    }

    public void setDescricao(String Descricao)
    {
        this.Descricao = Descricao;
    }

    public LocalTime getEntrada()
    {
        return Entrada;
    }

    public void setEntrada(LocalTime Entrada)
    {
        this.Entrada = Entrada;
    }

    public LocalTime getSaida()
    {
        return Saida;
    }

    public void setSaida(LocalTime Saida)
    {
        this.Saida = Saida;
    }
    private int Id;
    private int Numero;
    private long Motorista;
    private String Descricao;
    private LocalTime Entrada;
    private LocalTime Saida;
}
