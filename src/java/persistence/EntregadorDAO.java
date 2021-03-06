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
import model.Entregador;

/**
 *
 * @author negro
 */
public class EntregadorDAO {

    private static EntregadorDAO instance = new EntregadorDAO();

    public static EntregadorDAO getInstance() {
        return instance;
    }

    private EntregadorDAO() {
    }

    public void save(Entregador entregador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into entregador (nome)"
                    + " values ('" + entregador.getNome() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public void load(Entregador entregador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        int id = entregador.getId();
        String nome = entregador.getNome();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE entregador SET nome ='" + nome + "' WHERE id=" + id + " ");
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
            st.execute("DELETE from entregador  WHERE id=" + id + " ");
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
        ArrayList entregadores = new ArrayList<Entregador>();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("select * from entregador");
            //resultado=st.getResultSet();
            // resultado.first();
            while (resultado.next()) {
                Entregador entregador = new Entregador();
                entregador.setId(resultado.getInt("id"));
                entregador.setNome(resultado.getString("nome"));
                entregadores.add(entregador);
            }
            return entregadores;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public Entregador Buscar(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        Entregador entregador = new Entregador();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("SELECT * FROM `entregador` where id=" + id);
            while (resultado.next()) {
                entregador.setId(resultado.getInt("id"));
                entregador.setNome(resultado.getString("nome"));

            }
            return entregador;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }
}
