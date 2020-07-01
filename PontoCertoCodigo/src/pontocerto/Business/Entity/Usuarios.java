package pontocerto.Business.Entity;

public class Usuarios
{
    private Long CPF;

    private String Nome;

    public Enderecos Endereco;

    public TabelaGeralDependente Perfil;

    private String Senha;

    public Long getCPF()
    {
        return CPF;
    }

    public void setCPF(Long cPF)
    {
        CPF = cPF;
    }

    public String getNome()
    {
        return Nome;
    }

    public void setNome(String nome)
    {
        Nome = nome;
    }

    public Enderecos getEndereco()
    {
        return Endereco;
    }

    public void setEndereco(Enderecos endereco)
    {
        Endereco = endereco;
    }

    public TabelaGeralDependente getPerfil()
    {
        return Perfil;
    }

    public void setPerfil(TabelaGeralDependente perfil)
    {
        Perfil = perfil;
    }

    public String getSenha()
    {
        return Senha;
    }

    public void setSenha(String senha)
    {
        Senha = senha;
    }

    public Usuarios(Long cpf, String nome, Enderecos endereco, TabelaGeralDependente perfil, String senha)
    {
        CPF = cpf;
        Nome = nome;
        Endereco = endereco;
        Perfil = perfil;
        Senha = senha;
    }
    
    public Usuarios()
    {
        Endereco = new Enderecos();
        Perfil = new TabelaGeralDependente();
    }
}
