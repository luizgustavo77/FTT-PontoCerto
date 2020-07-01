package pontocerto.Business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Business.Entity.Enderecos;
import pontocerto.Business.Entity.Fretados;
import pontocerto.Business.Entity.Rotas;

public class RotasDAO extends BancoDAO
{

    private Connection connection;

    public RotasDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        connection = abrirConexao();
    }

    public void insert(Rotas entidade)
    {
        String sql = "insert into Rotas (Parada, Fretado) values (?,?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setInt(1, entidade.getParada().getId());
            comando.setInt(2, entidade.getFretado().getId());

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void update(Rotas entidade, Rotas atualizacao)
    {
        String sql = "update Rotas set Parada = ?, Fretado = ? where Parada = ? and Fretado= = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setInt(1, atualizacao.getParada().getId());
            comando.setInt(2, atualizacao.getFretado().getId());
            comando.setInt(3, entidade.getParada().getId());
            comando.setInt(4, entidade.getFretado().getId());

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void delete(Rotas entidade)
    {
        String sql = "delete from Rotas where Parada = ? and Fretado = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setInt(1, entidade.getParada().getId());
            comando.setInt(2, entidade.getFretado().getId());

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(int fretadoId)
    {
        String sql = "delete from Rotas where Fretado = ?";
        
        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setInt(1, fretadoId);

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Rotas> listar() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        List<Rotas> retorno = new ArrayList<Rotas>();
        String sql = "select * from Rotas";

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

    public List<Rotas> buscarPorFretado(int Fretado)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        List<Rotas> retorno = new ArrayList<Rotas>();;
        String sql = "select * from Rotas where Fretado = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setInt(1, Fretado);
            comando.execute();
            transformarLista(retorno, comando);

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public List<Rotas> buscarPorEndereco(int Endereco)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        List<Rotas> retorno = new ArrayList<Rotas>();;
        String sql = "select * from Rotas where Endereco = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            comando.setInt(1, Endereco);
            comando.execute();
            transformarLista(retorno, comando);

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    private void transformarLista(List<Rotas> entidade, PreparedStatement comando) throws SQLException,
            InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            while (resultado.next())
            {
                Rotas item = new Rotas(new EnderecosDAO().buscar(resultado.getInt(1)),
                    new FretadoDAO().buscar((resultado.getInt(2))));

                entidade.add(item);
            }
        }
    }
    // private void transformar(Rotas entidade, PreparedStatement comando) throws SQLException {
    //     try (ResultSet resultado = comando.getResultSet()) {
    //         entidade = new Rotas( resultado.getInt(1), 
    //                                     resultado.getInt(2));
    //     }
    // }
}
