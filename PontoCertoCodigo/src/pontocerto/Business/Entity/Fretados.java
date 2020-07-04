package pontocerto.Business.Entity;

import java.sql.Date;
import java.time.LocalTime;

public class Fretados
{

    public int Id;
    public int Numero;
    public long Motorista;
    public String Descricao;
    public LocalTime Entrada;
    public LocalTime Saida;

    public int getId()
    {
        return Id;
    }
    
    public void setId(int id)
    {
        Id = id;
    }

    public int getNumero()
    {
        return Numero;
    }

    public void setNumero(int numero)
    {
        Numero = numero;
    }

    public long getMotorista()
    {
        return Motorista;
    }

    public void setMotorista(long motorista)
    {
        Motorista = motorista;
    }

    public String getDescricao()
    {
        return Descricao;
    }

    public void setDescricao(String descricao)
    {
        Descricao = descricao;
    }

    public LocalTime getEntrada()
    {
        return Entrada;
    }

    public void setEntrada(LocalTime entrada)
    {
        Entrada = entrada;
    }

    public LocalTime getSaida()
    {
        return Saida;
    }

    public void setSaida(LocalTime saida)
    {
        Saida = saida;
    }

    public Fretados(int id, int numero, long motorista, String descricao, LocalTime entrada, LocalTime saida)
    {
        Id = id;
        Numero = numero;
        Motorista = motorista;
        Descricao = descricao;
        Entrada = entrada;
        Saida = saida;
    }

    public Fretados(int id)
    {
        Id = id;
    }
    
    public Fretados()
    {
        
    }
}
