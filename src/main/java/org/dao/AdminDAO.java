package org.dao;

import org.common.SqlExitDML;
import org.model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdminDAO {
    private PreparedStatement pstmt;

    //Método Para Insert
    public SqlExitDML inserir(Admin admin) {
        Conexao.conectar();

        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO admin (usuario, senha) VALUES (?,?)");

            //Setando valor
            pstmt.setString(1, admin.getEmail() );
            pstmt.setString(2, admin.getSenha() );

            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1, sqle);
        } finally {
            Conexao.desconectar();
        }
    }

    // Método para Select

    private List<Admin> visualizar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM admin");
            return getLinhas(pstmt.executeQuery());
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return new LinkedList<>();

    }
    private List<Admin> getLinhas(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        List<Admin> admins = new ArrayList<>();

        while (rs.next()) {
            admins.add(new Admin(
                    rs.getInt("id_admin"),
                    rs.getString("usuario"),
                    rs.getString("senha")
            ));
        }
        return admins;
    }

    public boolean usuarioExiste(String email, String senha) {
        List<Admin> admins = visualizar();

        for (Admin adm : admins) {
            if (adm.matches(email, senha)) {
                return true;
            }
        }
        return false;
    }

    public boolean usuarioExiste(String email) {
        List<Admin> admins = visualizar();

        for (Admin adm : admins) {
            if (adm.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public String getDBAccess() {
        Conexao.conectar();
        String result = null;

        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM bdkey");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                result = rs.getString("bd_key");
            }

        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }

        return result;
    }
}
