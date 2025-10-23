
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
     ArrayList<Contacto> agenda;

public Agenda(){
    agenda = new ArrayList<Contacto>();
}

Scanner sc = new Scanner(System.in);
//variables
String nombre;
String email;
int tlf;

public void Crear() throws IOException{
    String decision;
     try{
        System.out.println("Quieres un archivo VACIO o con CONTACTOS: ");
        decision = sc.nextLine();
    
            if(decision.equals("vacio")){ //si escoge vacio -> fichero vacio
                BufferedWriter bw = Files.newBufferedWriter(Path.of("D:\\ElenaGonzalez\\AD\\Practica\\ArchivoSinCOntactos.txt"));
                agenda.removeAll(agenda);
                System.out.println("Se ha creado el fichero");
           
            } else {
                if(decision.equals("contactos")){ //si escoge vacio -> fichero con contactos
                   BufferedWriter bw = Files.newBufferedWriter(Path.of("D:\\ElenaGonzalez\\AD\\Practica\\ArchivoConContactos.txt"));

                agenda.removeAll(agenda);

                agenda.add(new Contacto("Clara", "claraMS@gmail.com", 659873201));
                agenda.add(new Contacto("Lucas", "Lucas456@gmail.com", 668597421));
                agenda.add(new Contacto("Ana", "ana4@gmail.com", 669234598));
                agenda.add(new Contacto("Manuel", "ManuelRD@gmail.com", 675456526));
            
            System.out.println("Se ha creado el fichero");
        }
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
    System.out.println("Que contacto quieres consultar: ");
    nombre = sc.nextLine();
        if(agenda.contains(nombre)){
            System.out.println(nombre + " " + email + " " + tlf);
        }
    
 }
}

public void Modificar(){
    System.out.println("Escribe el nombre para modificar el contacto: ");
    nombre = sc.nextLine();
    Contacto contacto = new Contacto(nombre, email, tlf);
    if(! agenda.contains(contacto)){
        System.out.println("El contacto a modificar no existe");
    }
}

public void Borrar(){
    System.out.println("Qué contacto quieres borrar: ");
    nombre= sc.nextLine();

   
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
                Path path = Path.of(ruta);
                System.out.println("Ubicación: " + path.toAbsolutePath());
                System.out.println("Tamaño del archivo: " + path.toFile().length() + " bytes");
                System.out.println("Permisos: " + (path.toFile().canRead() ? "lectura " : "") +
                                                  (path.toFile().canWrite() ? "escritura " : "") +
                                                  (path.toFile().canExecute() ? "ejecución" : ""));
                System.out.println("Última modificación: " + path.toFile().lastModified());
                break;
        case 2:
            agenda.clone();
            System.out.println("Copia de seguridad realizada correctamente");
            break;
        case 3:
            
            break;
        case 4:
            System.out.println("Saliendo del Menú 2...");
            System.out.println();
           
            break;
        default:
               agenda.Menu2();
    }
}

public void Salir(){
    System.out.println("Saliendo...");
    
}

    public void Menu1(){
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

    public void Menu2(){
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
        Menu1();
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

