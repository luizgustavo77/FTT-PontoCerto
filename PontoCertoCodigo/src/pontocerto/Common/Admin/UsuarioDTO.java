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
public class UsuarioDTO
{
    private int Id;
    private long CPF;
    private String Nome;
    private EnderecosDTO Endereco;
    private TabelaGeralDependenteDTO Perfil;
    private String Senha;

    public EnderecosDTO getEndereco()
    {
        return Endereco;
    }

    public void setEndereco(EnderecosDTO Endereco)
    {
        this.Endereco = Endereco;
    }

    public TabelaGeralDependenteDTO getPerfil()
    {
        return Perfil;
    }

    public void setPerfil(TabelaGeralDependenteDTO Perfil)
    {
        this.Perfil = Perfil;
    }

    public String getSenha()
    {
        return Senha;
    }

    public void setSenha(String Senha)
    {
        this.Senha = Senha;
    }
    
    public int getId()
    {
        return Id;
    }

    public void setId(int Id)
    {
        this.Id = Id;
    }

    public long getCPF()
    {
        return CPF;
    }

    public void setCPF(long CPF)
    {
        this.CPF = CPF;
    }

    public String getNome()
    {
        return Nome;
    }

    public void setNome(String Nome)
    {
        this.Nome = Nome;
    }
    
    public UsuarioDTO()
    {
        Endereco = new EnderecosDTO();
        Perfil = new TabelaGeralDependenteDTO();
    }
}
