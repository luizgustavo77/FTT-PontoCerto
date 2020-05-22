package pontocerto.Bussines.Entity;

import java.sql.Date;

public class Fretados {
    public int Id;
    public int Numero;
    public int Motorista;
    public String Descricao;
    public Date Entrada;
    public Date Saida;

    public int getId() {
        return Id;
    }
    
    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public int getMotorista() {
        return Motorista;
    }

    public void setMotorista(int motorista) {
        Motorista = motorista;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Date getEntrada() {
        return Entrada;
    }

    public void setEntrada(Date entrada) {
        Entrada = entrada;
    }

    public Date getSaida() {
        return Saida;
    }

    public void setSaida(Date saida) {
        Saida = saida;
    }

    public Fretados(int id, int numero, int motorista, String descricao, Date entrada, Date saida) {
        Id = id;
        Numero = numero;
        Motorista = motorista;
        Descricao = descricao;
        Entrada = entrada;
        Saida = saida;
    }
    public Fretados(int id) {
        Id = id;
    }
}