import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio2 {


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

public void buscaActores() throws SQLException{
          Connection conn = DriverManager.getConnection(url, user, password);

        String query = "SELECT * FROM actor WHERE first_name LIKE ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
 
        System.out.println("Introduce el nombre del actor: ");
        String nombre= sc.nextLine(); 

        pstmt.setString(1, nombre);
         ResultSet rs = pstmt.executeQuery();

         while(rs.next()){
                System.out.println("Resultados de la búsqueda:");
            System.out.println(rs.getInt("actor_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
        }
}

public void borraActores() throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);

        String query =" DELETE FROM actores WHERE actor_id = ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);

        System.out.println("Introduce el id del actor al que quieres borrar: ");
        String id = sc.nextLine();

        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
                System.out.println( "Se ha eliminado el actor: " + rs.getInt("actor_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));

        }
}

public void actualizaActores() throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);
}

public void insertaActores() throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, password);

}
}

