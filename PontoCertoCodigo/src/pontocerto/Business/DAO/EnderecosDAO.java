package pontocerto.Business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Business.Entity.Enderecos;

public class EnderecosDAO extends BancoDAO
{

    private Connection connection;

    public EnderecosDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        connection = abrirConexao();
    }

    public void insert(Enderecos entidade)
    {
        String sql = "insert into Enderecos (CEP, Bairro, Rua, Cidade, Estado) values (?,?,?,?,?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setString(1, entidade.getCEP());
            comando.setString(2, entidade.getBairro());
            comando.setString(3, entidade.getRua());
            comando.setString(4, entidade.getCidade());
            comando.setString(5, entidade.getEstado());

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void update(Enderecos entidade)
    {
        String sql = "update Enderecos set CEP = ?, Bairro = ?, Rua = ?, Cidade = ?, Estado = ? where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setString(1, entidade.getCEP());
            comando.setString(2, entidade.getBairro());
            comando.setString(3, entidade.getRua());
            comando.setString(4, entidade.getCidade());
            comando.setString(5, entidade.getEstado());
            comando.setInt(6, entidade.getId());

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void delete(int Id)
    {
        String sql = "delete from Enderecos where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setInt(1, Id);

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Enderecos> listar()
    {
        List<Enderecos> retorno = new ArrayList<Enderecos>();
        String sql = "select * from Enderecos";

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

    public Enderecos buscar(int Id)
    {
        Enderecos retorno = null;
        String sql = "select * from Enderecos where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setInt(1, Id);

            comando.execute();

            retorno = transformar(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }
    
    public Enderecos buscarPorCep(String cep)
    {
        Enderecos retorno = null;
        String sql = "select * from Enderecos where CEP = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setString(1, cep);
            comando.execute();
            retorno = transformar(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    private void transformarLista(List<Enderecos> entidade, PreparedStatement comando) throws SQLException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            while (resultado.next())
            {
                Enderecos item = new Enderecos(resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getString(5),
                        resultado.getString(6));

                entidade.add(item);
            }
        }
    }

    private Enderecos transformar(Enderecos entidade, PreparedStatement comando) throws SQLException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            if (resultado.next())
            {
                entidade = new Enderecos(resultado.getInt("Id"),
                        resultado.getString("CEP"),
                        resultado.getString("Bairro"),
                        resultado.getString("Rua"),
                        resultado.getString("Cidade"),
                        resultado.getString("Estado"));
            }
        }

        return entidade;
    }
}
