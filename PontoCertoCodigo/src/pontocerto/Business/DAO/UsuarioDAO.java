package pontocerto.Business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Business.Entity.Usuarios;

public class UsuarioDAO extends BancoDAO
{

    private Connection connection;

    public UsuarioDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        connection = abrirConexao();
    }

    public void insert(Usuarios entidade) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        String sql = "insert into Usuarios (CPF, Nome, Endereco, Perfil, Senha) values (?,?,?,?,?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setLong(1, entidade.getCPF());
            comando.setString(2, entidade.getNome());
            comando.setInt(3, entidade.getEndereco().getId());
            comando.setInt(4, entidade.getPerfil().getId());
            comando.setString(5, entidade.getSenha());

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuarios entidade)
    {
        String sql = "update Usuarios set Nome = ?, Endereco = ?, Perfil = ? where CPF = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setString(1, entidade.getNome());
            comando.setInt(2, entidade.getEndereco().getId());
            comando.setInt(3, entidade.getPerfil().getId());
            comando.setLong(4, entidade.getCPF());

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void delete(long cpf)
    {
        String sql = "delete from Usuarios where cpf = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setLong(1, cpf);
            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Usuarios> listar() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        List<Usuarios> retorno = new ArrayList<Usuarios>();
        String sql = "select * from Usuarios";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.execute();
            transformarLista(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public Usuarios buscarPorCPF(long CPF) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        Usuarios retorno = null;
        String sql = "select * from Usuarios where CPF = ?"; // 

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) //PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        {
            comando.setLong(1, CPF);
            comando.execute();
            retorno = transformar(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public List<Usuarios> buscaPorNome(String nome) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        List<Usuarios> retorno = new ArrayList<Usuarios>();
        String sql = "select * from Usuarios where nome like '%?%'";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setString(1, nome);
            comando.execute();
            transformarLista(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public List<Usuarios> buscaPorCpfNome(String nome, long cpf) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        List<Usuarios> retorno = new ArrayList<Usuarios>();
        String sql = "select * from Usuarios where cpf = ? and nome like '%?%'";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setLong(1, cpf);
            comando.setString(2, nome);
            comando.execute();
            transformarLista(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public Usuarios buscaCpfEndereco(long cpf, String cep) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        Usuarios retorno = null;
        String sql = "select Usuarios.*\n"
                + "from Usuarios\n"
                + "inner join Enderecos\n"
                + "	on Enderecos.Id = Usuarios.Endereco\n"
                + "where Usuarios.CPF = ?\n"
                + "and Enderecos.CEP = ?"; // 

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) //PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        {
            comando.setLong(1, cpf);
            comando.setString(2, cep);
            comando.execute();
            retorno = transformar(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    private void transformarLista(List<Usuarios> entidade, PreparedStatement comando) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            while (resultado.next())
            {
                Usuarios item = new Usuarios(Long.parseLong(resultado.getString("CPF")),
                        resultado.getString("Nome"),
                        new EnderecosDAO().buscar(resultado.getInt("Endereco")),
                        new TabelaGeralDependenteDAO().buscar(resultado.getInt("Perfil")),
                        resultado.getString("Senha"));

                entidade.add(item);
            }
        }
    }

    private Usuarios transformar(Usuarios entidade, PreparedStatement comando) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            if (resultado.next())
            {
                entidade = new Usuarios(Long.parseLong(resultado.getString("CPF")),
                        resultado.getString("Nome"),
                        new EnderecosDAO().buscar(resultado.getInt("Endereco")),
                        new TabelaGeralDependenteDAO().buscar(resultado.getInt("Perfil")),
                        resultado.getString("Senha"));
            }
        }

        return entidade;
    }
}
