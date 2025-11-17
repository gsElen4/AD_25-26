import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Ejercicio1 {

public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";
        Scanner sc = new Scanner(System.in);

    //    Connection conn = DriverManager.getConnection(url, user, password);
//facer un programa que permita buscar peliculas, sin que o nome sexa unha coincidencia exacta
       /*  String query = "SELECT title FROM film WHERE title LIKE ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
 
        System.out.println("Introduce el titulo de la pelicula: ");
        String titulo= sc.nextLine();

        pstmt.setString(1, "%"+titulo+"%");

         ResultSet rs = pstmt.executeQuery();

         while(rs.next()){
            System.out.println(rs.getInt("film_id") + " " +rs.getString("title"));
        }
*/
        //Buscar peliculas por duración mínima (que a duración sexa maior que o dato introducido polo usuario)
      /* 
        String query = "SELECT * FROM film WHERE length > ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
 
        System.out.println("Introduce la duración de la pelicula: ");
        String duracion= sc.nextLine();

        pstmt.setString(1, duracion);

         ResultSet rs = pstmt.executeQuery();

         while(rs.next()){
            System.out.println(rs.getInt("film_id") + " " +rs.getString("title")+ " " +rs.getInt("length"));
        }
       */
        //Buscar peliculas que a duración esté entre dous valores dados
        /* 
        String query = "SELECT * FROM film WHERE (length > ?) AND (length<?);";
        PreparedStatement pstmt = conn.prepareStatement(query);
 
        System.out.println("Introduce la duración mínima de la pelicula: ");
        int duracionMin= sc.nextInt();

        System.out.println("Introduce la duración máxima de la pelicula: ");
        int duracionMax= sc.nextInt();

        pstmt.setInt(1, duracionMin);
        pstmt.setInt(2, duracionMax);

         ResultSet rs = pstmt.executeQuery();

         while(rs.next()){
            System.out.println(rs.getInt("film_id") + " " +rs.getString("title")+ " " +rs.getInt("length"));
        }

*/

/*PROBA a: Usa try with resources para a conexión e o statement. 
Con un solo Statement Obter 2 ResultSET (todos os actores e todas as peliculas, con LIMIT 5) 
Despois imprime as tablas*/
        try(Connection conn = DriverManager.getConnection(url, user, password); 
            Statement stmt= conn.createStatement()){

            String query1 = "SELECT * FROM actor LIMIT 5;";
            String query2 = "SELECT * FROM film LIMIT 5;";


            try(ResultSet rs1 = stmt.executeQuery(query1)){
                while(rs1.next()){
                    System.out.println(rs1.getString("first_name"));
                }
            }
            try(ResultSet rs2 = stmt.executeQuery(query2)){
                while(rs2.next()){
                    System.out.println(rs2.getString("title"));
                }
          }catch (SQLException e){
              e.printStackTrace();
        }
                    /*  rs.close();
                        stmt.close();
                        conn.close();
                        */
            }
        }
}

