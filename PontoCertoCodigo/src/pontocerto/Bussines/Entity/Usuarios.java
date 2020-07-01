package pontocerto.Bussines.Entity;

public class Usuarios {
    public int Id;

    public String CPF;

    public String Nome;

    public Enderecos Endereco;

    public TabelaGeralDependente Perfil;
    
    public String Senha;

    public int getId() {
        return Id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Enderecos getEndereco() {
        return Endereco;
    }

    public void setEndereco(Enderecos endereco) {
        Endereco = endereco;
    }

    public TabelaGeralDependente getPerfil() {
        return Perfil;
    }

    public void setPerfil(TabelaGeralDependente perfil) {
        Perfil = perfil;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public Usuarios(int id, String cPF, String nome, Enderecos endereco, TabelaGeralDependente perfil, String senha) {
        Id = id;
        CPF = cPF;
        Nome = nome;
        Endereco = endereco;
        Perfil = perfil;
        Senha = senha;
    }

    
}