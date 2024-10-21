package org.dao;

import java.sql.*;

public class LogDAO {
    Conexao conexao = new Conexao();
    private PreparedStatement pstmt;
    private ResultSet rs;

    public ResultSet buscar(){
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM Log");
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        } finally {
            Conexao.desconectar();
        }
    }

}
