
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Ej2Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        
        Ejercicio2 ej2 = new Ejercicio2();
        Menu menu = new Menu();
        int num;
        do { 
            num = menu.DameOpcion();
            if(num>0 && num<5){
                switch (num) {
                    case 1:
                        ej2.buscaActores();
                        break;
                    case 2:
                        ej2.borraActores();
                        break;
                    case 3:
                        ej2.actualizaActores();
                        break;
                    case 4:
                        ej2.insertaActores();
                        break;
                    default:
                        menu.Menu();
                        break;
                }
            } else {
                System.out.println("Opción no válida");
            }
        } while (true);
    }

}
 