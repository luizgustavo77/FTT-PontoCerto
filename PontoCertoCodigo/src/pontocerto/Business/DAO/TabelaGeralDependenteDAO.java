package pontocerto.Business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Business.Entity.TabelaGeral;
import pontocerto.Business.Entity.TabelaGeralDependente;

public class TabelaGeralDependenteDAO extends BancoDAO
{

    private Connection connection;

    public TabelaGeralDependenteDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        connection = abrirConexao();
    }

    public void insert(TabelaGeralDependente entidade)
    {
        String sql = "insert into TabelaGeralDependente (TabelaGeral, Descricao, Sigla) values (?,?,?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setObject(1, entidade.getTabelaGeral());
            comando.setString(2, entidade.getDescricao());
            comando.setString(3, entidade.getSigla());

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void update(TabelaGeralDependente entidade)
    {
        String sql = "update TabelaGeralDependente set TabelaGeral = ?, Descricao = ?, Sigla = ? where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setObject(1, entidade.getTabelaGeral());
            comando.setString(2, entidade.getDescricao());
            comando.setString(3, entidade.getSigla());
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
        String sql = "delete from TabelaGeralDependente where Id = ?";

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

    public List<TabelaGeralDependente> listar() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        List<TabelaGeralDependente> retorno = new ArrayList<TabelaGeralDependente>();
        String sql = "select * from TabelaGeralDependente";

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

    public List<TabelaGeralDependente> buscarPorTabelaGeral(int TabelaGeral) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        List<TabelaGeralDependente> retorno = null;
        String sql = "select * from TabelaGeralDependente where TabelaGeral = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setInt(1, TabelaGeral);

            comando.execute();

            transformarLista(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public TabelaGeralDependente buscar(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        TabelaGeralDependente retorno = null;
        String sql = "select * from TabelaGeralDependente where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setInt(1, id);
            comando.execute();
            retorno = transformar(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }
    
    public TabelaGeralDependente buscarPorDescricao(String descricao) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        TabelaGeralDependente retorno = null;
        String sql = "select * from TabelaGeralDependente where Descricao = ?";
        
        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setString(1, descricao);
            comando.execute();
            retorno = transformar(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        
        return retorno;
    }

    private void transformarLista(List<TabelaGeralDependente> entidade, PreparedStatement comando) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            while (resultado.next())
            {
                TabelaGeralDependente item = new TabelaGeralDependente(resultado.getInt("Id"),
                        new TabelaGeralDAO().buscar(resultado.getInt("TabelaGeral")),
                        resultado.getString("Descricao"),
                        resultado.getString("Sigla"));

                entidade.add(item);
            }
        }
    }

    private TabelaGeralDependente transformar(TabelaGeralDependente entidade, PreparedStatement comando) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            if (resultado.next())
            {
                entidade = new TabelaGeralDependente(resultado.getInt("Id"),
                        new TabelaGeralDAO().buscar(resultado.getInt("TabelaGeral")),
                        resultado.getString("Descricao"),
                        resultado.getString("Sigla"));
            }
        }

        return entidade;
    }
}
