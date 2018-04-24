package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Entregador;
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
            st.execute("insert into pedido ( cliente)"
                    + " values ('"  + pedido.getCliente() + "')");
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
        try {
            
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE pedido SET  cliente='"+cliente+ "' WHERE id="+id+" " );
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

    public ArrayList consultar() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet  resultado=null;
           ArrayList pedidos=new ArrayList<Pedido>(); 
        try {
            
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();           
          resultado= st.executeQuery("select * from pedido");
          if(!resultado.isBeforeFirst()){
              System.out.println("Não Tem dados");
          }else{
                        System.out.println(" Tem dados");}

            //resultado=st.getResultSet();
           // resultado.first();
            while (resultado.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(resultado.getInt("id"));
				pedido.setCliente(resultado.getString("cliente"));
				pedidos.add(pedido);
			}
            return pedidos;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }}

