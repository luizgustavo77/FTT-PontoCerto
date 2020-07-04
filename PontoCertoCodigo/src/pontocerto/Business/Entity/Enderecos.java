package pontocerto.Business.Entity;

public class Enderecos
{

    private int Id;
    private String CEP;
    private String Bairro;
    private String Rua;
    private String Cidade;
    private String Estado;

    public int getId()
    {
        return Id;
    }
    
    public void setId(int id)
    {
        Id = id;
    }

    public String getCEP()
    {
        return CEP;
    }

    public void setCEP(String cEP)
    {
        CEP = cEP;
    }

    public String getBairro()
    {
        return Bairro;
    }

    public void setBairro(String bairro)
    {
        Bairro = bairro;
    }

    public String getRua()
    {
        return Rua;
    }

    public void setRua(String rua)
    {
        Rua = rua;
    }

    public String getCidade()
    {
        return Cidade;
    }

    public void setCidade(String cidade)
    {
        Cidade = cidade;
    }

    public String getEstado()
    {
        return Estado;
    }

    public void setEstado(String estado)
    {
        Estado = estado;
    }

    public Enderecos(int id, String cEP, String bairro, String rua, String cidade, String estado)
    {
        Id = id;
        CEP = cEP;
        Bairro = bairro;
        Rua = rua;
        Cidade = cidade;
        Estado = estado;
    }

    public Enderecos(int id)
    {
        Id = id;
    }
    
    public Enderecos()
    {
        
    }
}
