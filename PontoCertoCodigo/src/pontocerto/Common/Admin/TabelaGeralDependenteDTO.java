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
public class TabelaGeralDependenteDTO
{

    public int getId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public String getDescricao()
    {
        return Descricao;
    }

    public void setDescricao(String Descricao)
    {
        this.Descricao = Descricao;
    }

    public String getSigla()
    {
        return Sigla;
    }

    public void setSigla(String Sigla)
    {
        this.Sigla = Sigla;
    }
    public int Id;
    public String Descricao;
    public String Sigla;
}
