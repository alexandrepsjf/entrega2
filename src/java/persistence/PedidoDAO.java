package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            st.execute("insert into pedido (idCliente, estado)"
                    + " values ('" + pedido.getIdCliente() + "' , '"+pedido.getEstado().getEstado()+"')");
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
        int idCliente = pedido.getIdCliente();
        String estado=pedido.getEstado().getEstado();
        try {
            
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE pedido SET  idCliente='" + idCliente + "' , estado='"+estado+"' WHERE id=" + id + " ");
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
            st.execute("DELETE from pedido  WHERE id=" + id + " ");
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
        ArrayList pedidos = new ArrayList<Pedido>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("select * from pedido");
            while (resultado.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultado.getInt("id"));
                pedido.setIdCliente(resultado.getInt("idCliente"));
                 pedido.setCliente(ClienteDAO.getInstance().Buscar(pedido.getIdCliente()));
                 pedido.setNomeEstado(resultado.getString("estado"));
                 pedido.setEstado(pedido.criarEstado(resultado.getString("estado")));
                pedidos.add(pedido);
            }
            return pedidos;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }
    
    public Pedido Buscar(int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        Pedido pedido = new Pedido();
        try {
            
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("SELECT * FROM `pedido` where id=" + id);
            while (resultado.next()) {
                pedido.setId(resultado.getInt("id"));
                pedido.setIdCliente(resultado.getInt("idCliente"));
                pedido.setCliente(ClienteDAO.getInstance().Buscar(pedido.getIdCliente()));
                pedido.setEstado(pedido.criarEstado(resultado.getString("estado")));
                pedido.setNomeEstado(resultado.getString("estado"));
            }
            return pedido;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }
}
