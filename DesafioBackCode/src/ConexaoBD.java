import java.sql.*;

public class ConexaoBD {

   static {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } 
      catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      }
   }

   public static Connection conectar() throws SQLException {
      String servidor = "localhost";
      String porta = "3306";	//porta mysql
      String database = "testeback"; //nome_do_database
      String usuario = "testeback"; 	//usuario
      String senha = "testeback"; 		//senha
      String timeZone = "&useTimezone=true&serverTimezone=UTC";

      return DriverManager
         	.getConnection("jdbc:mysql://"+servidor+":"+porta+
            "/"+database+"?user="+usuario+"&password="+senha + timeZone);
   }

   public static void desconectar(Connection conn, Statement stmt, ResultSet rs) {
	   try {
           if (conn!= null) {
               conn.close();
           }
           if (stmt!= null) {
               stmt.close();
           }
           if (rs!= null) {
               rs.close();
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
