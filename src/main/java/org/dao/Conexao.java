package org.dao;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para gerenciar o Dotenv e a conexão com o banco de dados pelo JDBC
 */
public class Conexao {

    static Connection conn;

    /**
     * Conecta com o banco, atualiza o atributo conn para a conexão gerada pelo JDBC
     * @throws ConnectionIsNullException
     */
    public static void conectar() throws ConnectionIsNullException {

        // Pegando dados da conexão pelo dotenv
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        assert url != null;

        // Estabelecendo a conexão
        try {
            Class.forName("org.postgresql.Driver"); // Pegando o driver do postgres
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        // Lançar a exceção caso a conexão for null
        if (conn == null) {
            throw new ConnectionIsNullException("Não foi possível se conectar com o banco de dados do Praceando.");
        }
    }

    /**
     * Fecha a conexão com o banco
     */
    public static void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                //Desconecta BD
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
