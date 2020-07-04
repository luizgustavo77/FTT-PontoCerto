package pontocerto.Business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import pontocerto.Business.Entity.Fretados;

public class FretadoDAO extends BancoDAO
{

    private Connection connection;

    public FretadoDAO() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        connection = abrirConexao();
    }

    public void insert(Fretados entidade)
    {
        String sql = "insert into Fretados (Numero, Motorista, Descricao, Entrada, Saida) values (?,?,?,?,?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setInt(1, entidade.getNumero());
            comando.setLong(2, entidade.getMotorista());
            comando.setString(3, entidade.getDescricao());
            comando.setTime(4, Time.valueOf(entidade.getEntrada()));
            comando.setTime(5, Time.valueOf(entidade.getSaida()));

            comando.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void update(Fretados entidade)
    {
        String sql = "update Fretados set Numero = ?, Motorista = ?, Descricao = ?, Entrada = ?, Saida = ? where Id = ?";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setInt(1, entidade.getNumero());
            comando.setLong(2, entidade.getMotorista());
            comando.setString(3, entidade.getDescricao());
            comando.setTime(4, Time.valueOf(entidade.getEntrada()));
            comando.setTime(5, Time.valueOf(entidade.getSaida()));
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
        String sql = "delete from Fretados where Id = ?";

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

    public List<Fretados> listar()
    {
        List<Fretados> retorno = new ArrayList<Fretados>();
        String sql = "select * from Fretados";

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

    public Fretados buscar(int Id)
    {
        Fretados retorno = null;
        String sql = "select * from Fretados where Id = ?";

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

    public List<Fretados> buscaPorCepRua(String cep, String rua)
    {
        List<Fretados> retorno = new ArrayList<Fretados>();
        String sql = "select Fretados.*\n"
                + "from Fretados\n"
                + "inner join Rotas\n"
                + "	on Rotas.Fretado = Fretados.Id\n"
                + "inner join Enderecos\n"
                + "	on Enderecos.Id = Rotas.Parada";

        if (!cep.equals(""))
        {
            sql += " where Enderecos.CEP = ?";
        }
        else if (!rua.equals(""))
        {
            sql += " where lower(Enderecos.Rua) like '%' + lower(?) + '%'";
        }

        sql += " order by Fretados.Id";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            if (!cep.equals(""))
            {
                comando.setString(1, cep);
            }
            else if (!rua.equals(""))
            {
                comando.setString(1, rua);
            }
            
            comando.execute();
            transformarLista(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    public Fretados buscarMotoristaFretadoHora(Fretados fretado)
    {
        Fretados retorno = null;
        String sql = "select * from Fretados where Motorista = ? and Numero = ? and convert(time(0), Entrada) = convert(time(0), ?) and convert(time(0), Saida) = convert(time(0), ?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setLong(1, fretado.getMotorista());
            comando.setInt(2, fretado.getNumero());
            comando.setTime(3, Time.valueOf(fretado.getEntrada()));
            comando.setTime(4, Time.valueOf(fretado.getSaida()));
            comando.execute();
            retorno = transformar(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }
    
    public Fretados buscaFretadoPorNumeroHorario(Fretados fretado)
    {
        Fretados retorno = null;
        String sql = "select * from Fretados where Numero = ? and convert(time(0), Entrada) = convert(time(0), ?) and convert(time(0), Saida) = convert(time(0), ?)";

        try (PreparedStatement comando = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            comando.setInt(1, fretado.getNumero());
            comando.setTime(2, Time.valueOf(fretado.getEntrada()));
            comando.setTime(3, Time.valueOf(fretado.getSaida()));
            comando.execute();
            retorno = transformar(retorno, comando);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return retorno;
    }

    private void transformarLista(List<Fretados> entidade, PreparedStatement comando) throws SQLException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            while (resultado.next())
            {
                Fretados item = new Fretados(resultado.getInt("Id"),
                        resultado.getInt("Numero"),
                        resultado.getLong("Motorista"),
                        resultado.getString("Descricao"),
                        LocalTime.parse(resultado.getTime("Entrada").toString()),
                        LocalTime.parse(resultado.getTime("Saida").toString()));

                entidade.add(item);
            }
        }
    }

    private Fretados transformar(Fretados entidade, PreparedStatement comando) throws SQLException
    {
        try (ResultSet resultado = comando.getResultSet())
        {
            if (resultado.next())
            {
                entidade = new Fretados(resultado.getInt("Id"),
                        resultado.getInt("Numero"),
                        resultado.getLong("Motorista"),
                        resultado.getString("Descricao"),
                        LocalTime.parse(resultado.getTime("Entrada").toString()),
                        LocalTime.parse(resultado.getTime("Saida").toString()));
            }
        }

        return entidade;
    }
}
