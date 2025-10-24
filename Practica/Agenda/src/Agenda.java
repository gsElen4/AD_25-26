
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

 public void Crear() throws IOException {
        System.out.println("¿Quieres un archivo VACIO o con CONTACTOS?");
        String decision = sc.nextLine().trim().toLowerCase();

        try {
            if (decision.equals("vacio")) {
                Path ruta = Path.of("D:\\ElenaGonzalez\\AD\\Practica\\ArchivoSinContactos.txt");
                try (BufferedWriter bw = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8)) {
                    // Creamos archivo vacío
                }
                agenda.clear();
                System.out.println("Se ha creado el fichero vacío.");

            } else if (decision.equals("contactos")) {
                Path ruta = Path.of("D:\\ElenaGonzalez\\AD\\Practica\\ArchivoConContactos.txt");
                try (BufferedWriter bw = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8)) {
                    agenda.clear();
                    agenda.add(new Contacto("Clara", "claraMS@gmail.com", 659873201));
                    agenda.add(new Contacto("Lucas", "Lucas456@gmail.com", 668597421));
                    agenda.add(new Contacto("Ana", "ana4@gmail.com", 669234598));
                    agenda.add(new Contacto("Manuel", "ManuelRD@gmail.com", 675456526));

                    for (Contacto c : agenda) {
                        bw.write(c.getNombre() + "," + c.getEmail() + "," + c.getTlf());
                        bw.newLine();
                    }
                }
                System.out.println("Se ha creado el fichero con contactos.");
            } else {
                System.out.println("Opción no válida. Escribe 'vacio' o 'contactos'.");
                Crear(); // vuelve a preguntar
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    

public void Anhadir(){
   try {
        System.out.println("Nombre: ");
         String nombreN = sc.nextLine();

        System.out.println("Correo electrónico: ");
         String emailN = sc.nextLine();

        System.out.println("Númemro de telefono: ");
        int tlfN = Integer.parseInt(sc.nextLine());

        for(Contacto c: agenda){
            if(c.getNombre().equalsIgnoreCase(nombreN)){
                System.out.println("Este contacto ya existe");
                return;
            }
        }
        agenda.add(new Contacto(nombreN, emailN, tlfN));
            System.out.println("Contacto añadido");

   } catch (Exception e) {
        System.out.println("Error al añadir contacto: " + e.getMessage());

   }
    
}

public void Consultar(){
 if(agenda.isEmpty()){
    System.out.println("La agenda está vacia");
    return;
 }
 else{
    System.out.println("Que contacto quieres consultar: ");
    String consulta = sc.nextLine();
    boolean encontrado ;
        if(agenda.contains(consulta)){
            for (Contacto c : agenda) {
                 if (c.getNombre().equalsIgnoreCase(consulta)) {
                System.out.println(c);
                encontrado = true;
                break;
            }
            }

           
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

    public int DameOpcion() {
        Menu1();
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        return opcion;
    }

    public int DameOpcion2() {
        Menu2();
        int opcion2 = sc.nextInt();
        sc.nextLine();
        return opcion2;
    }
}


