import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";
        Scanner sc = new Scanner(System.in);

       
        Connection conn = DriverManager.getConnection(url, user, password);

        String query = "SELECT * FROM actor WHERE first_name=? AND last_name=?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
 
        System.out.println("Introduce el nombre del actor: ");
        String nombre= sc.nextLine();

        System.out.println("Introduce el apellido del actor: ");
        String apellido= sc.nextLine();

        pstmt.setString(1, nombre);
        pstmt.setString(2, apellido);

         ResultSet rs = pstmt.executeQuery();

         while(rs.next()){
            System.out.println(rs.getInt("actor_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
        }

      //  Statement stmt = conn.createStatement();
     
        /*String query = "SELECT title AS titulo, film_id AS id FROM film LIMIT 5";
      System.out.println("Introduce el nombre del titulo a buscar: ");
      
      Scanner sc = new Scanner(System.in);
      String variable = sc.nextLine();
      
        String query = "SELECT * FROM film WHERE title LIKE \"%"+ variable +"%\";";


        ResultSet rs = stmt.executeQuery(query);

        //rs.next(); 

        //System.out.println(rs.getString("title"));
        //System.out.println(rs.getString(2));

        while(rs.next()){
            System.out.println(rs.getString("title   "));
        }
        */
    
       rs.close();
       pstmt.close();
        conn.close();
    }
}



