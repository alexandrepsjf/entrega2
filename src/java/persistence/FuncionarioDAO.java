/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import funcionario.Funcionario;
import funcionario.FuncionarioAtendente;
import model.Pedido;

/**
 *
 * @author negro
 */
public class FuncionarioDAO {

    private static FuncionarioDAO instance = new FuncionarioDAO();

    public static FuncionarioDAO getInstance() {
        return instance;
    }

    private FuncionarioDAO() {
    }
public Funcionario buscarFuncionario(int codCargo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        Funcionario funcionario=null;
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("SELECT * FROM `funcionario` where codCargo=" + codCargo+" ORDER by rand() LIMIT 1");
            while (resultado.next()) {
                 funcionario=Funcionario.criarFuncionario(resultado.getString("cargo"));
                 funcionario.setNome(resultado.getString("nome"));
                 funcionario.setId(resultado.getInt("id"));
            }
            return funcionario;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

public Funcionario Buscar(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        Funcionario funcionario = null;
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("SELECT * FROM `funcionario` where id=" + id);
            while (resultado.next()) {
                funcionario=Funcionario.criarFuncionario(resultado.getString("cargo"));
                funcionario.setId(resultado.getInt("id"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCodCargo(resultado.getInt("codCargo"));
            }
            return funcionario;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }
    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

        }
    }

    
}
