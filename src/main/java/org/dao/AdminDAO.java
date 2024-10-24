package org.dao;

import org.model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDAO extends DAOGeneric<Admin> {


    @Override
    protected Admin extrairEntidade(ResultSet rs) throws SQLException {
        return new Admin(
                rs.getInt("id_admin"),
                rs.getString("usuario"),
                rs.getString("senha")
        );
    }

    @Override
    protected PreparedStatement getInserirQuery(Admin admin) throws SQLException {
        PreparedStatement ps = Conexao.conn.prepareStatement("INSERT INTO admin (usuario, senha) VALUES (?,?)");

        //Setando valor
        ps.setString(1, admin.getEmail() );
        ps.setString(2, admin.getSenha() );
        return ps;
    }

    @Override
    protected PreparedStatement getAlterarQuery(Admin admin) throws SQLException {
        return null;
    }

    @Override
    protected String getNome() {
        return "admin";
    }

    // Método para Select


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
            PreparedStatement ps = Conexao.conn.prepareStatement("SELECT * FROM bdkey");
            ResultSet rs = ps.executeQuery();

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
