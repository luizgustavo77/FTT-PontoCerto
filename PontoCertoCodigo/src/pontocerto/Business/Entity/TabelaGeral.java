package pontocerto.Business.Entity;

public class TabelaGeral {
    public int Id;
    public String Descricao;

    public int getId() {
        return Id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public TabelaGeral(int id, String descricao) {
        Id = id;
        Descricao = descricao;
    }
    
    public TabelaGeral()
    {
        
    }
}