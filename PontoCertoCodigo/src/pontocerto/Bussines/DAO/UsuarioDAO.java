package pontocerto.Bussines.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Bussines.Entity.Usuarios;

public class UsuarioDAO extends BancoDAO {

    private Connection connection;

    public UsuarioDAO()  throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        connection = abrirConeccao();
    }

    public void insert(Usuarios entidade) {
        String sql = "insert into Usuarios (CPF, Nome, Endereco, Perfil, Senha) values (?,?,?,?,?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setString(1, entidade.getCPF());
            comando.setString(2, entidade.getNome());
            comando.setInt(3, entidade.getEndereco().getId());
            comando.setInt(4, entidade.getPerfil().getId());
            comando.setString(5, entidade.getSenha());

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuarios entidade) {
        String sql = "update Usuarios set (CPF, Nome, Endereco, Perfil, Senha) values (?,?,?,?,?) where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setString(1, entidade.getCPF());
            comando.setString(2, entidade.getNome());
            comando.setInt(3, entidade.getEndereco().getId());
            comando.setInt(4, entidade.getPerfil().getId());
            comando.setString(5, entidade.getSenha());
            comando.setInt(6, entidade.getId());

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int Id) {
        String sql = "delete table Usuarios where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, Id);

            comando.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuarios> listar() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<Usuarios> retorno = new ArrayList<Usuarios>();
        String sql = "select * from Usuarios";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            comando.execute();

            transformarLista(retorno, comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public Usuarios buscarPorCPF(int CPF)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Usuarios retorno = null ;
        String sql = "select * from Usuarios where CPF = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setInt(1, CPF);

            comando.execute();

            transformar(retorno, comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    private void transformarLista(List<Usuarios> entidade, PreparedStatement comando) throws SQLException,
            InstantiationException, IllegalAccessException, ClassNotFoundException {
        try (ResultSet resultado = comando.getResultSet()) {
            while (resultado.next()) {
                Usuarios item = new Usuarios( resultado.getInt(1), 
                                                resultado.getString(2), 
                                                resultado.getString(3), 
                                                new EnderecosDAO().buscar(resultado.getInt(4)),
                                                new TabelaGeralDependenteDAO().buscar(resultado.getInt(5)), 
                                                resultado.getString(6));

                entidade.add(item);
            }
        }
    }
    private void transformar(Usuarios entidade, PreparedStatement comando) throws SQLException, InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        try (ResultSet resultado = comando.getResultSet()) {
            entidade = new Usuarios( resultado.getInt(1), 
                                        resultado.getString(2), 
                                        resultado.getString(3), 
                                        new EnderecosDAO().buscar(resultado.getInt(4)),
                                        new TabelaGeralDependenteDAO().buscar(resultado.getInt(5)), 
                                        resultado.getString(6));
        }
    }
}