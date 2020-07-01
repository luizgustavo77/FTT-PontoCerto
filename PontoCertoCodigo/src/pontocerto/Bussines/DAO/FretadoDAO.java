package pontocerto.Bussines.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Bussines.Entity.Fretados;

public class FretadoDAO extends BancoDAO  {
    private Connection connection;

    public FretadoDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        connection = abrirConeccao();
    }

    public void insert(Fretados entidade) {
        String sql = "insert into Fretados (Numero, Motorista, Descricao, Entrada, Saida) values (?,?,?,?,?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, entidade.getNumero());
            comando.setInt(2, entidade.getMotorista());
            comando.setString(3, entidade.getDescricao());
            comando.setDate(4, entidade.getEntrada());
            comando.setDate(5, entidade.getSaida());

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Fretados entidade) {
        String sql = "update Fretados set (Numero, Motorista, Descricao, Entrada, Saida) values (?,?,?,?,?) where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, entidade.getNumero());
            comando.setInt(2, entidade.getMotorista());
            comando.setString(3, entidade.getDescricao());
            comando.setDate(4, entidade.getEntrada());
            comando.setDate(5, entidade.getSaida());
            comando.setInt(6, entidade.getId());

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int Id) {
        String sql = "delete table Fretados where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, Id);

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Fretados> listar() {
        List<Fretados> retorno = new ArrayList<Fretados>();
        String sql = "select * from Fretados";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            comando.execute();

            transformarLista(retorno, comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public Fretados buscar(int Id) {
        Fretados retorno = null ;
        String sql = "select * from Fretados where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, Id);

            comando.execute();

            transformar(retorno, comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    private void transformarLista(List<Fretados> entidade, PreparedStatement comando) throws SQLException {
        try (ResultSet resultado = comando.getResultSet()) {
            while (resultado.next()) {
                Fretados item = new Fretados( resultado.getInt(1), 
                                                resultado.getInt(2), 
                                                resultado.getInt(3), 
                                                resultado.getString(4),
                                                resultado.getDate(5), 
                                                resultado.getDate(6));

                entidade.add(item);
            }
        }
    }
    private void transformar(Fretados entidade, PreparedStatement comando) throws SQLException {
        try (ResultSet resultado = comando.getResultSet()) {
            entidade = new Fretados( resultado.getInt(1), 
                                        resultado.getInt(2), 
                                        resultado.getInt(3), 
                                        resultado.getString(4),
                                        resultado.getDate(5), 
                                        resultado.getDate(6));
        }
    }
}