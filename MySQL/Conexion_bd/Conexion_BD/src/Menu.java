
import java.util.Scanner;

public class Menu {
//Facer un programa de gestión de actores. Que permita:
//-Buscar actores
//-Borrar actores por id
//-Actualizar actores por id
//-Insertar novos actores
//Usa Statement y PreparedStatement cando corresponda

Scanner sc = new Scanner(System.in);
public void Menu(){
    System.out.println("M E N U ");
    System.out.println("===========");
    System.out.println("1. Buscar actores");
    System.out.println("2. Borrar actores por id");
    System.out.println("3. Actualizar actores por id");
    System.out.println("4. Insertar novos actores");
    System.out.println("Dame una opción: ");

    
}
 public int DameOpcion() {
        Menu();
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }
}
