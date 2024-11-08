package org.dao;
import org.common.SqlExitDML;
import org.model.Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe genérica contendo a lógica JDBC dos métodos de visualizar, criar, remover e alterar
 * Os comandos SQL específicos de cada tabela recebem um próprio DAO e implementam os métodos
 * restantes da interface DAO e os métodos abstratos de DAOGeneric
 * @param <T> A qual Model esse DAO se refere?
 */
public abstract class DAOGeneric<T extends Model> implements DAO<T> {


    /** Método para visualizar uma linha da tabela no banco de dados
     * @param id Id do registro a ser visualizado
     * @return Retorna o registro do banco de dados
     * @throws ConnectionIsNullException Caso a conexão não esteja aberta
     */
    public T visualizar(int id) throws ConnectionIsNullException {
        Conexao.conectar();

        try {
            PreparedStatement ps = Conexao.conn.prepareStatement(
                    "SELECT * FROM \""
                    + this.getTabela().getNomeBanco() + "\" WHERE id_"
                    + this.getTabela().getNomeBanco() + " = ?");
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extrairEntidade(rs);
            }

            // Se não encontrar o registro, retorna null
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return null;
    }

    /** Método para visualizar todos os registros da tabela no banco
     * @return Retorna uma lista de models com todos os registros da tabela no banco
     */
    public List<T> visualizar() {
        Conexao.conectar();
        List<T> retorno = new LinkedList<>();

        try {
            PreparedStatement ps = Conexao.conn.prepareStatement("SELECT * FROM \"" + this.getTabela().getNomeBanco() + "\"");

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

    /** Método para inserir um registro no banco de dados
     * @param entidade Entidade de tipo T a ser inserida
     * @return Retorna um objeto SqlExitDML contendo a saída da operação
     * @throws ConnectionIsNullException Caso a conexão não esteja aberta
     */
    public SqlExitDML inserir(T entidade) throws ConnectionIsNullException {
        Conexao.conectar();
        Throwable throwable;  // Objeto de erro usado para saída
        try {
            // Utiliza a query de inserir vinda do método
            PreparedStatement ps = getInserirQuery(entidade);

            // Executa e produz a saída
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throwable = sqle;
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML(throwable);
    }

    /** Método para alterar um registro no banco de dados
     * @param entidade Entidade de tipo T a ser alterada
     * @return Retorna um objeto SqlExitDML contendo a saída da operação
     * @throws ConnectionIsNullException Caso a conexão não esteja aberta
     */
    public SqlExitDML alterar(T entidade) throws ConnectionIsNullException {
        Conexao.conectar();
        Throwable throwable; // Objeto de erro usado para saída

        try {
            // Utiliza a query de alterar vinda do método
            PreparedStatement ps = getAlterarQuery(entidade);

            // Executa e produz a saída
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throwable = sqle;
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML(throwable);
    }

    /** Método para remover um registro do banco de dados
     * @param id Id do registro a ser removido
     * @return Retorna um objeto SqlExitDML contendo a saída da operação
     * @throws ConnectionIsNullException Caso a conexão não esteja aberta
     */
    public SqlExitDML remover(int id) throws ConnectionIsNullException {
        Conexao.conectar();
        Throwable throwable; // Objeto de erro usado para saída
        try {
            // Cria a query de delete
            PreparedStatement ps = Conexao.conn.prepareStatement(
                    "DELETE FROM \""
                    + this.getTabela().getNomeBanco() + "\" WHERE id_"
                    + this.getTabela().getNomeBanco() +" = ?");
            ps.setInt(1, id);
            // Executa e produz a saída
            return new SqlExitDML(ps.executeUpdate() > 0 ? 1 : 0);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throwable = sqle;
        } finally {
            Conexao.desconectar();
        }
        return new SqlExitDML(throwable);

    }

    /**
     * Extrai uma entidade da linha atual de um objeto ResultSet
     * @param rs O ResultSet
     * @return A entidade extraída
     * @throws SQLException Em caso de erros no processamento do ResultSet
     */
    protected abstract T extrairEntidade(ResultSet rs) throws SQLException;

    /**
     * Retorna um PreparedStatement de inserção de uma entidade na tabela do banco
     * @param entidade Entidade a ser inserida
     * @return PreparedStatement com o SQL
     * @throws SQLException Em caso de erros na construção da PreparedStatement
     */
    protected abstract PreparedStatement getInserirQuery(T entidade) throws SQLException;

    /**
     * Retorna um PreparedStatement de alteração de uma entidade na tabela do banco
     * @param entidade Entidade a ser inserida
     * @return PreparedStatement com o SQL
     * @throws SQLException Em caso de erros na construção da PreparedStatement
     */
    protected abstract PreparedStatement getAlterarQuery(T entidade) throws SQLException;
}