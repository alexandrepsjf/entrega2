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

/**
 *
 * @author negro
 */
public class FuncionarioAtendenteDAO {

    private static FuncionarioAtendenteDAO instance = new FuncionarioAtendenteDAO();

    public static FuncionarioAtendenteDAO getInstance() {
        return instance;
    }

    private FuncionarioAtendenteDAO() {
    }

    public void save(Funcionario atendente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into funcionario (nome,cargo,codCargo)"
                    + " values ('" + atendente.getNome() + "', 'Atendente',1)");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public void load(FuncionarioAtendente funcionario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        int id = funcionario.getId();
        String nome = funcionario.getNome();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE funcionario SET nome ='" + nome + "' WHERE id=" + id + " ");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE from funcionario  WHERE id=" + id + " ");
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

    public ArrayList consultar() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        ArrayList funcionarios = new ArrayList<Funcionario>();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("select * from funcionario");
            //resultado=st.getResultSet();
            // resultado.first();

            while (resultado.next()) {
                Funcionario funcionario = new FuncionarioAtendente();
                funcionario.setId(resultado.getInt("id"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCodCargo(resultado.getInt("codCargo"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
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
        Funcionario funcionario = new FuncionarioAtendente();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("SELECT * FROM `funcionario` where id=" + id);
            while (resultado.next()) {
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
}
