package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.PedidoMemento;

public class PedidoMementoDAO {

    private static PedidoMementoDAO instance = new PedidoMementoDAO();

    public static PedidoMementoDAO getInstance() {
        return instance;
    }

    private PedidoMementoDAO() {
    }

    public void save(PedidoMemento pedidoMemento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedidoMemento (historico,id,idPedido,estado)"
                    + " values ('" + pedidoMemento.getHistorico() + "','" + pedidoMemento.getId() + "','" + pedidoMemento.getIdPedido() + "','" + pedidoMemento.getEstadoAnterior().getEstado() + "')");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public void load(PedidoMemento pedidoMemento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        int id = pedidoMemento.getId();
        String historico = pedidoMemento.getHistorico();
        String estadoAnterior = pedidoMemento.getEstadoAnterior().getEstado();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE pedidoMemento SET  estado='" + estadoAnterior + "' , historico='" + historico + "' WHERE id=" + id + " ");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public void atualiza(PedidoMemento pedidoMemento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        int id = pedidoMemento.getId();
        String historico = pedidoMemento.getHistorico();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE pedidoMemento SET  historico='" + historico + "' WHERE id=" + id + " ");
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
            st.execute("DELETE from pedidoMemento  WHERE id=" + id + " ");
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

    public ArrayList consultar() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        ArrayList pedidoMementos = new ArrayList<PedidoMemento>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("select * from pedidoMemento");
            while (resultado.next()) {
                PedidoMemento pedidoMemento = new PedidoMemento();
                pedidoMemento.setId(resultado.getInt("id"));
                pedidoMemento.criarEstado(resultado.getString("estadoAnterior"));
                pedidoMementos.add(pedidoMemento);
            }
            return pedidoMementos;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public PedidoMemento Buscar(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        PedidoMemento pedidoMemento = new PedidoMemento();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("SELECT * FROM `pedidoMemento` where id=" + id);
            while (resultado.next()) {
                pedidoMemento.setId(resultado.getInt("id"));
                pedidoMemento.setIdPedido(resultado.getInt("idPedido"));
                pedidoMemento.criarEstado(resultado.getString("estado"));
                pedidoMemento.setHistorico(resultado.getString("historico"));
            }
            return pedidoMemento;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }
}
