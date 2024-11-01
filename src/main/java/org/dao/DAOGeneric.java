package org.dao;
import org.common.SqlExitDML;
import org.model.Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class DAOGeneric<T extends Model> implements DAO<T> {


    public T visualizar(int id) throws ConnectionIsNullException {
        Conexao.conectar();
        try {
            PreparedStatement ps = Conexao.conn.prepareStatement("SELECT * FROM \"" + this.getNomeBanco() + "\" WHERE id_"+ getNomeBanco()+" = ?");
            System.out.println(ps.toString());
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extrairEntidade(rs);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public List<T> visualizar() {
        Conexao.conectar();
        List<T> retorno = new LinkedList<>();
        try {
            PreparedStatement ps = Conexao.conn.prepareStatement("SELECT * FROM \"" + this.getNomeBanco() + "\"");
            System.out.println(ps.toString());

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                retorno.add(extrairEntidade(rs));
            }
            return retorno;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    public SqlExitDML inserir(T entidade) throws ConnectionIsNullException {
        Conexao.conectar();
        Throwable throwable;
        try {
            PreparedStatement ps = getInserirQuery(entidade);
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throwable = sqle;
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML(throwable);
    }

    public SqlExitDML alterar(T entidade) throws ConnectionIsNullException {
        Conexao.conectar();

        Throwable throwable;
        try {
            PreparedStatement ps = getAlterarQuery(entidade);
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throwable = sqle;
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML(throwable);
    }

    public SqlExitDML remover(int id) throws ConnectionIsNullException {
        Conexao.conectar();
        Throwable throwable;
        try {
            PreparedStatement ps = Conexao.conn.prepareStatement("DELETE FROM \""+ this.getNomeBanco() + "\" WHERE id_"+ getNomeBanco() +" = ?");
            ps.setInt(1, id);
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throwable = sqle;
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML(throwable);

    }

    /** Nome da tabela para visualização no front
    * @return Retorna o nome da tabela no banco capitalizado por default
    *  */
    public String getNomeInterface() {
        return getNomeBanco().substring(0, 1).toUpperCase() + getNomeBanco().substring(1);
    }

    protected abstract T extrairEntidade(ResultSet rs) throws SQLException;
    protected abstract PreparedStatement getInserirQuery(T entidade) throws SQLException;
    protected abstract PreparedStatement getAlterarQuery(T entidade) throws SQLException;
    public abstract String getNomeBanco();

}