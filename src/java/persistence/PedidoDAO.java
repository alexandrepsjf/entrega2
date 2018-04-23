package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Pedido;

public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    public static PedidoDAO getInstance() {
        return instance;
    }

    private PedidoDAO() {
    }

    public void save(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedido (nome, cliente)"
                    + " values ('" + pedido.getNome() + "', '" + pedido.getCliente() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }
  public void load(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        int id = pedido.getId();
        String cliente=pedido.getCliente();
                String nome=pedido.getNome();
        try {
            
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE pedido SET nome ='"+nome +"', email='"+cliente+ "' WHERE id="+id+" " );
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
            st.execute("DELETE from pedido  WHERE id="+id+" " );
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
