
package conexionMysql;
import java.sql.*;

public class ConexionMysql {
    public static void main(String[] args) {
        
          try{
              // 1) Se crea la conexiòn 
                 Connection conexion = DriverManager.getConnection(
                         "jdbc:mysql://localhost/agenda", "root","");
                 
               //  2) Se crea un objeto Statement a partir de la conexión establecida,que
                 //permite enviar consultas SQL al servidor de la base de datos.
                 Statement statement = conexion.createStatement();
                 
               // 3) La consulta se envía al servidor de la base de datos
              
                /*ResultSet resultset = statement.executeQuery("SELECT VERSION()");
               if (resultset.next()) {
                System.out.println("MySQL Version: " + resultset.getString(1));
                      }*/
                ResultSet resultset = statement.executeQuery("SELECT * FROM contacto");
                
                // 4) Recorrer el ResulSet , la tabla
                while(resultset.next())
                    System.out.println(resultset.getString("DNI") + " " + resultset.getString("NOMBRES") + " "+ resultset.getString("APELLIDOS"));
              
              
           }
           catch(SQLException  e){
                System.out.println("No conectado a la base de datos" + e.getMessage());
                e.printStackTrace();
           }
        
   }
               
}
