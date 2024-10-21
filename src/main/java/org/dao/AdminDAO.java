package org.dao;
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
    public boolean inserir(Admin admin) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO admin (usuario, senha) values (?,?)");

            //Setando valor
            pstmt.setString(1, admin.getEmail() );
            pstmt.setString(2, admin.getSenha() );
//            admin.setDt_atualizacao(conexao.dt_atualizacao());
            pstmt.execute(); //Executa o comando sql do preparedStatement
            return true;//Executa o comando sql do preparedStatement
        } catch (SQLException sqle) {
            sqle.printStackTrace();

        } finally {
            Conexao.desconectar();

        }
        return false;
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

        do {
            admins.add(new Admin(
                    rs.getInt("id_admin"),
                    rs.getString("usuario"),
                    rs.getString("senha")
            ));
        } while (rs.next());
        return admins;
    }

    public boolean isUsuarioValido(String email, String senha) {
        List<Admin> admins = visualizar();

        for (Admin adm : admins) {
            if (adm.matches(new Admin(adm.getId_admin(), email, senha))) {
                return true;
            }
        }
        return false;
    }
}
