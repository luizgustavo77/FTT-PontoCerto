package pontocerto.Business.Entity;

public class TabelaGeralDependente {
    public int Id;
    public TabelaGeral TabelaGeral;
    public String Descricao;
    public String Sigla;

    public int getId() {
        return Id;
    }
    
    public void setId(int id)
    {
        Id = id;
    }

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String sigla) {
        Sigla = sigla;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public TabelaGeral getTabelaGeral() {
        return TabelaGeral;
    }

    public void setTabelaGeral(TabelaGeral tabelaGeral) {
        TabelaGeral = tabelaGeral;
    }

    public TabelaGeralDependente(int id, pontocerto.Business.Entity.TabelaGeral tabelaGeral, String descricao, String sigla) {
        Id = id;
        TabelaGeral = tabelaGeral;
        Descricao = descricao;
        Sigla = sigla;
    }
    
    public TabelaGeralDependente()
    {
        
    }
}