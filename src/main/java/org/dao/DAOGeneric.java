package org.dao;
import org.common.SqlExitDML;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class DAOGeneric<T> implements DAO<T> {

    public T visualizar(int id) {
        Conexao.conectar();
        try {
            PreparedStatement ps = Conexao.conn.prepareStatement("SELECT * FROM \"" + this.getNome() + "\" WHERE id = ?");
            System.out.println(ps.toString());
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extrairEntidade(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public List<T> visualizar() {
        Conexao.conectar();
        List<T> retorno = new LinkedList<>();
        try {
            PreparedStatement ps = Conexao.conn.prepareStatement("SELECT * FROM \"" + this.getNome() + "\"");
            System.out.println(ps.toString());

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                retorno.add(extrairEntidade(rs));
            }
            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public SqlExitDML inserir(T entidade) {
        Conexao.conectar();
        try {
            PreparedStatement ps = getInserirQuery(entidade);
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML();
    }

    public SqlExitDML alterar(T entidade) {
        Conexao.conectar();
        try {
            PreparedStatement ps = getAlterarQuery(entidade);
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML();
    }

    public SqlExitDML remover(int id) {
        Conexao.conectar();
        try {
            PreparedStatement ps = Conexao.conn.prepareStatement("DELETE FROM \""+ this.getNome() + "\" WHERE id = ?");
            ps.setString(1, this.getNome());
            ps.setInt(2, id);
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML();

    }

    protected abstract T extrairEntidade(ResultSet rs) throws SQLException;
    protected abstract PreparedStatement getInserirQuery(T entidade) throws SQLException;
    protected abstract PreparedStatement getAlterarQuery(T entidade) throws SQLException;
    public abstract String getNome();
}