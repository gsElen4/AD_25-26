import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";


       

        Connection conn = DriverManager.getConnection(url, user, password);
        
        Statement stmt = conn.createStatement();
        

        // String query = "SELECT title AS titulo, film_id AS id FROM film LIMIT 5";
      System.out.println("Introduce el nombre del titulo a buscar: ");
      
      Scanner sc = new Scanner(System.in);
      String variable = sc.nextLine();
      
        String query = "SELECT * FROM film WHERE title LIKE \"%"+ variable +"%\";";


        ResultSet rs = stmt.executeQuery(query);

        //rs.next(); 

        //System.out.println(rs.getString("title"));
        //System.out.println(rs.getString(2));

        while(rs.next()){
            System.out.println(rs.getString("title"));
        }
        
        rs.close();
        stmt.close();
        conn.close();
    }
}


