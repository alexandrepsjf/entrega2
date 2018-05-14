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
import model.Cliente;
import model.Entregador;

/**
 *
 * @author negro
 */
public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    private ClienteDAO() {
    }

    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente (nome)"
                    + " values ('" + cliente.getNome() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public void load(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        int id = cliente.getId();
        String nome = cliente.getNome();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE cliente SET nome ='" + nome + "' WHERE id=" + id + " ");
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
            st.execute("DELETE from cliente  WHERE id=" + id + " ");
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
        ArrayList clientes = new ArrayList<Cliente>();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("select * from cliente");
            //resultado=st.getResultSet();
            // resultado.first();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public Cliente Buscar(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        Cliente cliente = new Cliente();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("SELECT * FROM `cliente` where id=" + id);
            while (resultado.next()) {
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));

            }
            return cliente;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }
}
