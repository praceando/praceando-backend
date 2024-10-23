package org.dao;
import java.util.ArrayList;
import org.common.SqlExitDML;
import org.model.FraseSustentavel;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FraseSustentavelDAO {
//    Conexao conexao = new Conexao();
    private PreparedStatement pstmt;
    private ResultSet rs;


    // Método para Insert

    public SqlExitDML inserir(FraseSustentavel fs) {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("INSERT INTO frase_sustentavel (ds_frase) values (?)");

            //Setando valor
            pstmt.setString(1, fs.getDs_frase() );
//            fs.setDt_atualizacao(conexao.dt_atualizacao());
            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1);

        } finally {
            Conexao.desconectar();
        }
    }

    // Método para Alterar
    public SqlExitDML alterar(FraseSustentavel fs) {
        Conexao.conectar();

        try {
            pstmt = Conexao.conn.prepareStatement("update frase_sustentavel set ds_frase = ? where id_frase = ?");
            // SETANDO O VALOR DOS PARÂMETROS
            pstmt.setString(1, fs.getDs_frase());
            pstmt.setInt(2, fs.getId_frase());

            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1, sqle);
        } finally {
            Conexao.desconectar();
        }
    }

    // Método para Remover
    public SqlExitDML remover(FraseSustentavel fs) {
        Conexao.conectar();
        try {
            String remover = "DELETE FROM frase_sustentavel WHERE id_frase = ?";
            // Instanciando o objeto preparedStatement (pstmt)
            pstmt = Conexao.conn.prepareStatement(remover);
            //Setando o valor do parâmetro
            pstmt.setInt(1, fs.getId_frase());

            int cod = (pstmt.executeUpdate() > 0 ? 1 : 0);  // Executa o comando sql do preparedStatement, retorna um código
            return new SqlExitDML(cod);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return new SqlExitDML(-1);
        }
        finally {
            Conexao.desconectar();
        }

    }

    // Método para Select

    private List<FraseSustentavel> visualizar() {
        Conexao.conectar();
        try {
            pstmt = Conexao.conn.prepareStatement("SELECT * FROM frase_sustentavel");
            return getLinhas(pstmt.executeQuery());
        } catch (SQLException sqe){
            sqe.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        return new LinkedList<>();

    }


    private List<FraseSustentavel> getLinhas(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        List<FraseSustentavel> frase = new ArrayList<>();

        while (rs.next()) {
            frase.add(new FraseSustentavel(
                    rs.getString("ds_frase"),
                    rs.getInt("id_frase")
            ));
        }
        return frase;
    }
}