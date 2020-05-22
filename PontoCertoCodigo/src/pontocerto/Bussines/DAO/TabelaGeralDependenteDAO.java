package pontocerto.Bussines.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Bussines.Entity.TabelaGeral;
import pontocerto.Bussines.Entity.TabelaGeralDependente;

public class TabelaGeralDependenteDAO extends BancoDAO {

    private Connection connection;

    public TabelaGeralDependenteDAO()  throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        connection = abrirConeccao();
    }

    public void insert(TabelaGeralDependente entidade) {
        String sql = "insert into TabelaGeralDependente (TabelaGeral, Descricao, Sigla) values (?,?,?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setObject(1, entidade.getTabelaGeral());
            comando.setString(2, entidade.getDescricao());
            comando.setString(3, entidade.getSigla());

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(TabelaGeralDependente entidade) {
        String sql = "update TabelaGeralDependente set (TabelaGeral, Descricao, Sigla) values (?,?,?) where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setObject(1, entidade.getTabelaGeral());
            comando.setString(2, entidade.getDescricao());
            comando.setString(3, entidade.getSigla());
            comando.setInt(6, entidade.getId());

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int Id) {
        String sql = "delete table TabelaGeralDependente where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, Id);

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TabelaGeralDependente> listar()
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<TabelaGeralDependente> retorno = new ArrayList<TabelaGeralDependente>();
        String sql = "select * from TabelaGeralDependente";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            comando.execute();

            transformarLista(retorno, comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public List<TabelaGeralDependente> buscarPorTabelaGeral(int TabelaGeral)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<TabelaGeralDependente> retorno = null;
        String sql = "select * from TabelaGeralDependente where TabelaGeral = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, TabelaGeral);

            comando.execute();

            transformarLista(retorno, comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public TabelaGeralDependente buscar(int TabelaGeral)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        TabelaGeralDependente retorno = null;
        String sql = "select * from TabelaGeralDependente where TabelaGeral = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, TabelaGeral);

            comando.execute();

            transformar(retorno, comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    private void transformarLista(List<TabelaGeralDependente> entidade, PreparedStatement comando) throws SQLException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {
        try (ResultSet resultado = comando.getResultSet()) {
            while (resultado.next()) {
                TabelaGeralDependente item = new TabelaGeralDependente(resultado.getInt(1),
                                                                        new TabelaGeralDAO().buscar(resultado.getInt(2)) ,
                                                                        resultado.getString(3), 
                                                                        resultado.getString(4));

                entidade.add(item);
            }
        }
    }
    private void transformar(TabelaGeralDependente entidade, PreparedStatement comando) throws SQLException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {
        try (ResultSet resultado = comando.getResultSet()) {
            entidade = new TabelaGeralDependente(resultado.getInt(1),
                                                    new TabelaGeralDAO().buscar(resultado.getInt(2)) ,
                                                    resultado.getString(3), 
                                                    resultado.getString(4));
        }
    }
}