package org.dao;

import org.common.Senha;
import org.model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AdminDAO extends DAOGeneric<Admin> {
    public boolean isReadOnly() {
        return false;
    }

    @Override
    protected Admin extrairEntidade(ResultSet rs) throws SQLException {
        return new Admin(
                rs.getInt("id_admin"),
                rs.getString("usuario"),
                rs.getString("email"),
                new Senha(rs.getString("senha")),
                rs.getBoolean("is_ativo")
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

    public int usuarioExiste(String email, String senha) {
        Conexao.conectar();
        List<Admin> retorno = new LinkedList<>();
        try {
            PreparedStatement ps = Conexao.conn.prepareStatement("SELECT * FROM admin " +
                                                                      "WHERE senha = crypt(?, senha) AND email = ?");
            ps.setString(1, senha);
            ps.setString(2, email);

            System.out.println(ps);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                retorno.add(extrairEntidade(rs));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            Conexao.desconectar();
        }

        int hasAdmin = retorno.isEmpty() ? 0 : 1;

        if (hasAdmin == 1) {
            Admin admin = retorno.get(0);
            if (admin.isAtivo()) {
                return hasAdmin;
            }
            return 0;
        }
        return hasAdmin;
    }


    @Override
    public String getNome() {
        return "admin";
    }

    // Método para Select

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
