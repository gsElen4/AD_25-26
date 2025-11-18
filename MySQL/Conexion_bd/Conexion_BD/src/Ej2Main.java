
import java.io.IOException;
import java.util.Scanner;

public class Ej2Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        Ejercicio2 ej2 = new Ejercicio2();
        Menu menu = new Menu();
        int num = 0;
        do { 
            num = menu.DameOpcion();
            if(num>0 && num<5){
                switch (num) {
                    case 1:
                        
                        break;
                    case 2:
                        
                    break;
                    case 3:
                        
                        break;
                    case 4:
                        
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
 