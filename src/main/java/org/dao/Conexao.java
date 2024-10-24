package org.dao;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
<<<<<<< HEAD
import java.sql.Date;
=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    static Connection conn;
    public static void conectar() {
<<<<<<< HEAD
        // Carreg
        // a o dotenv
=======

>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        assert url != null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
<<<<<<< HEAD


=======
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
    }

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

<<<<<<< HEAD
    public static Date getDataAtual() {
        return new Date(System.currentTimeMillis());
    }



=======
//    public static Date getDataAtual() {
//        return new Date(System.currentTimeMillis());
//    }
>>>>>>> c5580918d96592a8c60201406ebbde11b39c3130
}
