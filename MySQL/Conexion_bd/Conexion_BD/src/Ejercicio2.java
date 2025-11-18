import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2 {
public static void main(String[] args) {

     String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";
        Scanner sc = new Scanner(System.in);
    
//Facer un programa de gestión de actores. Que permita:
//-Buscar actores
//-Borrar actores por id
//-Actualizar actores por id
//-Insertar novos actores
//Usa Statement y PreparedStatement cando corresponda

 try(Connection conn = DriverManager.getConnection(url, user, password); 
            Statement stmt= conn.createStatement()){

            String query = ";";

           int rows = stmt.executeUpdate(query);
           System.out.println("Se han modificado "+ rows + " filas");
           
          } catch (SQLException e){
              e.printStackTrace();
        }
}
}
