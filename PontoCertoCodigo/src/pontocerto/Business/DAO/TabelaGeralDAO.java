package pontocerto.Business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Business.Entity.TabelaGeral;

public class TabelaGeralDAO extends BancoDAO
{

    private Connection connection;

    public TabelaGeralDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        connection = abrirConexao();
    }

    public void insert(TabelaGeral entidade)
    {
        String sql = "insert into TabelaGeral (Descricao) values (?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setString(1, entidade.getDescricao());
            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void update(TabelaGeral entidade)
    {
        String sql = "update TabelaGeral set Descricao = ? where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setString(1, entidade.getDescricao());
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
        String sql = "delete from TabelaGeral where Id = ?";

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

    public List<TabelaGeral> listar()
    {
        List<TabelaGeral> retorno = new ArrayList<TabelaGeral>();
        String sql = "select * from TabelaGeral";

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

    public TabelaGeral buscar(int Id)
    {
        TabelaGeral retorno = null;
        String sql = "select * from TabelaGeral where Id = ?";

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

    private void transformarLista(List<TabelaGeral> entidade, PreparedStatement comando) throws SQLException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            while (resultado.next())
            {
                TabelaGeral item = new TabelaGeral(resultado.getInt(1),
                        resultado.getString(2));

                entidade.add(item);
            }
        }
    }

    private TabelaGeral transformar(TabelaGeral entidade, PreparedStatement comando) throws SQLException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            if (resultado.next())
            {
                entidade = new TabelaGeral(resultado.getInt("Id"),
                        resultado.getString("Descricao"));
            }
        }

        return entidade;
    }
}
