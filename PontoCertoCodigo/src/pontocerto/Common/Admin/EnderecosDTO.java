/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontocerto.Common.Admin;

/**
 *
 * @author thiag
 */
public class EnderecosDTO
{

    public int getId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public String getCEP()
    {
        return CEP;
    }

    public void setCEP(String CEP)
    {
        this.CEP = CEP;
    }

    public String getBairro()
    {
        return Bairro;
    }

    public void setBairro(String Bairro)
    {
        this.Bairro = Bairro;
    }

    public String getRua()
    {
        return Rua;
    }

    public void setRua(String Rua)
    {
        this.Rua = Rua;
    }

    public String getCidade()
    {
        return Cidade;
    }

    public void setCidade(String Cidade)
    {
        this.Cidade = Cidade;
    }

    public String getEstado()
    {
        return Estado;
    }

    public void setEstado(String Estado)
    {
        this.Estado = Estado;
    }
    public int Id;
    public String CEP;
    public String Bairro;
    public String Rua;
    public String Cidade;
    public String Estado;
}
