package pontocerto.Bussines.Entity;

public class Rotas {
    public Enderecos Parada;
    public Fretados Fretado;

    public Enderecos getParada() {
        return Parada;
    }

    public void setParada(Enderecos parada) {
        Parada = parada;
    }

    public Fretados getFretado() {
        return Fretado;
    }

    public void setFretado(Fretados fretado) {
        Fretado = fretado;
    }

    public Rotas(Enderecos parada, Fretados fretado) {
        Parada = parada;
        Fretado = fretado;
    }
}