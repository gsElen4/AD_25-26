import java.io.IOException;
import java.util.Scanner;

public class Practica {
    public static void main(String[]args) throws IOException{
       Scanner sc = new Scanner(System.in);
        
        Agenda agenda = new Agenda();
        int num = 0;
    
            do {
            System.out.println("Dame una opción: ");
            num = agenda.DameOpcion();

            if (num > 0 && num < 11) {
                switch (num) {
                    case 1:
                        agenda.Crear();
                        break;
                    case 2:
                        agenda.Anhadir();
                        break;
                    case 3:
                        agenda.Consultar();
                        break;
                    case 4:
                        agenda.Modificar();
                        break;
                    case 5:
                        agenda.Borrar();
                        break;
                    case 6:
                        agenda.Restaurar();
                        break;
                    case 7:
                        agenda.Ver();
                        break;
                    case 8:
                        agenda.Vaciar();
                        break;
                    case 9:
                        agenda.MasOpciones();
                        break;
                    default:
                        agenda.Menu1();
                        break;
                }
            } else {
                System.out.println("Opción no válida");
            }

        } while (num != 0); 

        sc.close();
    }
}