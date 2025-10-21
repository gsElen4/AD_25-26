
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Contacto> agenda;

public Agenda(){
    agenda = new ArrayList<Contacto>();
}

Scanner sc = new Scanner(System.in);
//variables
String nombre;
String email;
int tlf;

public void Crear(){
    String decision;
    System.out.println("Quieres un archivo VACIO o con CONTACTOS: ");
    decision = sc.nextLine();

    try(BufferedWriter bw = Files.newBufferedWriter(Path.of("D:\\ElenaGonzalez\\AD\\Practica\\Archivo.txt"),StandardCharsets.UTF_8)){
        if(decision.equals("vacio")){ //si escoge vacio -> fichero vacio
            agenda.removeAll(agenda);
            System.out.println("Se ha creado el fichero");
        } else if(decision.equals("contactos")){ //si escoge vacio -> fichero con contactos
            agenda.removeAll(agenda);

            agenda.add(new Contacto("Clara", "claraMS@gmail.com", 659873201));
            agenda.add(new Contacto("Lucas", "Lucas456@gmail.com", 668597421));
            agenda.add(new Contacto("Ana", "ana4@gmail.com", 669234598));
            agenda.add(new Contacto("Manuel", "ManuelRD@gmail.com", 675456526));
        
        System.out.println("Se ha creado el fichero");
    
            System.out.println("No es una opción válida");
            Crear(); //hace recursivo   
        }
    }catch (Exception e){
        e.printStackTrace();
        System.out.println("No es una opción válida");
        Crear(); //hace recursivo
}
    
}
public void Anhadir(){
    String nombreN;
    String emailN;
    String tlfN;
    try (BufferedReader br = Files.newBufferedReader(Path.of("D:\\ElenaGonzalez\\AD\\Practica\\Archivo.txt"),StandardCharsets.UTF_8)){
        System.out.println("Nombre: ");
        nombreN = sc.nextLine();

        System.out.println("Correo electrónico: ");
        emailN = sc.nextLine();

    System.out.println("Número de telefono: ");
    tlfN = sc.nextLine();

    for(Contacto c : agenda){
        if(c.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Este contacto ya existe en el archivo");
                return;
            
        } else{
         agenda.add(new Contacto(nombre, email, tlf));
         System.out.println("Archivo añadido");
    }
}
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}

public void Consultar(){
 if(agenda.isEmpty()){
    System.out.println("La agenda está vacia");
 }
 else{
    
 }
}

public void Modificar(){
    
}

public void Borrar(){
}

public void Restaurar(){

}

public void Ver(){
    String nombre;
    
}

public void Vaciar(){
    agenda.removeAll(agenda);
    System.out.println("La agenda se ha vaciado");
}

public void MasOpciones(){
    Menu2();
    int opcion2 = 0;
    String ruta = "D:\\ElenaGonzalez\\AD\\Practica\\Archivo.txt";

    switch (opcion2) {
        case 1: 
                System.out.println("Ubicación: ");
                 String ubi = ruta;
                System.out.println("Tamaño del archivo: ");
                int tamanho = ruta.length();
                System.out.println("Permisos del archivo: ");
                
                System.out.println("Fecha y hora de la última del archivo: ");
            break;
        case 2:
            agenda.clone();
            break;
        case 3:

            break;
        case 4:
            
            break;
        default:
            throw new AssertionError();
    }
}

    public static void Menu(){
        System.out.println("    M E N U    ");
        System.out.println("=================");
        System.out.println("1. Crear agenda");
        System.out.println("2. Añadir contacto");
        System.out.println("3. Consultar contacto");
        System.out.println("4. Modificar contacto");
        System.out.println("5. Borrar contacto");
        System.out.println("6. Restaurar contacto");
        System.out.println("7. Ver contactos");
        System.out.println("8. Vaciar agenda");
        System.out.println("9. Más opciones");
        System.out.println("10. Salir");
        System.out.println("Dame opción: ");
    
    }

    public static void Menu2(){
         System.out.println("    M E N U 2    ");
        System.out.println("===================");
        System.out.println("1. Informarcion del archvio");
        System.out.println("2. Hacer copia de seguridad");
        System.out.println("3. Restaurar copia de seguridad");
        System.out.println("4. Volver");
        System.out.println("Dame opción: ");

    }

    public int DameOpcion(){
        int opcion = 0;
        Menu();
        opcion = sc.nextInt();
        return opcion;
    }
    
    public int DameOpcion2(){
        int opcion2= 0;
        Menu2();
        opcion2 = sc.nextInt();
        return opcion2;
    }
}

