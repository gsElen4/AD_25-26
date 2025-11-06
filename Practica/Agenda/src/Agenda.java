
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class Agenda {
    private ArrayList<Contacto> agenda;
    private  Path archivo = Path.of("D:\\ElenaGonzalez\\AD\\Practica\\Agenda.txt");
    Scanner sc = new Scanner(System.in);

    public Agenda() {
        agenda = new ArrayList<>();
        cargarAgenda();
    }


    // Crear agenda (vacía o con contactos)
    public void Crear() {
        try {
            System.out.println("¿Quieres un archivo VACIO o con CONTACTOS?");
            String decision = sc.nextLine().trim().toLowerCase();

            if (decision.equals("vacio")) {
                agenda.clear();
                guardarAgenda();
                System.out.println("Archivo vacío creado ");
            } else if (decision.equals("contactos")) {
                agenda.clear();
                agenda.add(new Contacto("Clara", "claraMS@gmail.com", 659873201));
                agenda.add(new Contacto("Lucas", "lucas456@gmail.com", 668597421));
                agenda.add(new Contacto("Ana", "ana4@gmail.com", 669234598));
                agenda.add(new Contacto("Manuel", "ManuelRD@gmail.com", 675456526));

                guardarAgenda();
                System.out.println("Archivo con contactos creado");
            } else {
                System.out.println("Opción no válida");
            }
        } catch (Exception e) {
            System.out.println("Error al crear la agenda: " + e.getMessage());
        }
    }

    // Añadir contacto
    public void Anhadir() {
        try {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();
            System.out.print("Correo electrónico: ");
            String email = sc.nextLine().trim();
            System.out.print("Teléfono: ");
            int tlf = Integer.parseInt(sc.nextLine());

            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
                System.out.println("Formato de email no válido.");
                return;
            }

            if (buscarPorNombre(nombre) != null) {
                System.out.println("Este contacto ya existe");
                return;
            }

            agenda.add(new Contacto(nombre, email, tlf));
            guardarAgenda();
            System.out.println("Contacto añadido correctamente");
        } catch (Exception e) {
            System.out.println("Error al añadir contacto: " + e.getMessage());
        }
    }

    // Consultar contacto
    public void Consultar() {
        System.out.print("Introduce el nombre del contacto a consultar: ");
        String nombre = sc.nextLine();
        Contacto c = buscarPorNombre(nombre);
        if (c == null) {
            System.out.println("No se encontró el contacto.");
        } else {
            System.out.println(c);
        }
    }

    // Modificar contacto
    public void Modificar() {
        System.out.print("Introduce el nombre del contacto a modificar: ");
        String nombre = sc.nextLine();
        Contacto c = buscarPorNombre(nombre);
        if (c == null) {
            System.out.println("El contacto no existe.");
            return;
        }
        System.out.println("Nombre nuevo: ");
        String nNombre = sc.nextLine();
        if (!nNombre.isBlank()) c.setNombre(nNombre);

        System.out.println("Correo electrónico nuevo: ");
        String nEmail = sc.nextLine();
        if (!nEmail.isBlank()) c.setEmail(nEmail);

        System.out.println("Teléfono nuevo: ");
        String nTlf = sc.nextLine();
        if (!nTlf.isBlank()) c.setTlf(Integer.parseInt(nTlf));

        guardarAgenda();
        System.out.println("Contacto modificado correctamente");
    }

    
    public void Borrar() { // Borrado lógico
        System.out.print("Introduce el nombre del contacto a borrar: ");
        String nombre = sc.nextLine();
        Contacto c = buscarPorNombre(nombre);
        if (c == null) {
            System.out.println("No existe ese contacto");
            return;
        }
        c.setBorrado(true);
        guardarAgenda();
        System.out.println("Contacto borrado");
    }

     public void Vaciar() { //Borrado físico
        agenda.clear();
        guardarAgenda();
        System.out.println("Agenda vaciada");
    }

    // Restaurar contacto borrado
    public void Restaurar() {
        System.out.print("Introduce el nombre del contacto a restaurar: ");
        String nombre = sc.nextLine();
        Contacto c = buscarPorNombre(nombre);
        if (c == null) {  //si el contacto es nulo
            System.out.println("No se encontró el contacto.");
            return;
        }
        if (!c.isBorrado()) { //si el contacto no está borrado
            System.out.println("El contacto ya existe.");
        } else {
            c.setBorrado(false);
            guardarAgenda();
            System.out.println("Contacto restaurado correctamente.");
        }
    }

    // Ver todos los contactos
    public void Ver() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía");
            return;
        }
        int contador = 0;
        for (Contacto c : agenda) {
            System.out.println(c);
            if (!c.isBorrado()) contador++; //suma cada que pase un contacto
        }
        System.out.println("La agenda contiene " + contador + " contactos.");
    }

    private void guardarAgenda() {
        try (BufferedWriter bw = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)) {
            for (Contacto c : agenda) {
                bw.write(c.getNombre() + "," + c.getEmail() + "," + c.getTlf() + "," + c.isBorrado());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar la agenda: " + e.getMessage());
        }
    }

    private void cargarAgenda() {
        if (!Files.exists(archivo)) return;
        try (BufferedReader br = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    Contacto c = new Contacto(datos[0], datos[1], Integer.parseInt(datos[2]));
                    c.setBorrado(Boolean.parseBoolean(datos[3]));
                    agenda.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar la agenda: " + e.getMessage());
        }
    }


    public Contacto buscarPorNombre(String nombre) { //ahorro de código a la hora de búsqueda de contacto
        for (Contacto c : agenda) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }
//Métodos del Menú 2
    public void MasOpciones() {
        int opcion;
        do {
            opcion = DameOpcion2();
            switch (opcion) {
                case 1 :
                     mostrarInfoArchivo();
                     break;
                case 2:
                    copiaSeguridad();
                    break;
                case 3 :
                    restaurarCopia();
                    break;
                case 4 :
                    System.out.println("Volviendo al Menú 1...");
                    break;
                default : 
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);
    }
    //Opción 1
    private void mostrarInfoArchivo() {
        try {
            System.out.println("Ubicación: " + archivo.toAbsolutePath());
            System.out.println("Tamaño: " + Files.size(archivo) + " bytes");
            System.out.println("Permisos: lectura=" + Files.isReadable(archivo)
                    + ", escritura=" + Files.isWritable(archivo));
            System.out.println("Última modificación: " + new Date(Files.getLastModifiedTime(archivo).toMillis()));
        } catch (IOException e) {
            System.out.println("Error al obtener información: " + e.getMessage());
        }
    }
    //Opción 2: Crea copia de seguridad
    private void copiaSeguridad() {
        try {
            String fecha = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); //muestra fehca exacta
            
            Path copia = Path.of(archivo.getParent().toString(), "Copia_Seguridad_Agenda" + fecha + ".txt");
         
            Files.copy(archivo, copia, StandardCopyOption.REPLACE_EXISTING);
         
            System.out.println("Copia de seguridad creada: " + copia.getFileName());
        } catch (IOException e) {
            System.out.println("Error al crear copia de seguridad: " + e.getMessage());
        }
    }
    //Opción 3: Lista de copias de seguridad y cuando se escoja 1, la restaura
 private void restaurarCopia() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(archivo.getParent(), "Copia_Seguridad_Agenda*.txt")) {
            List<Path> copias = new ArrayList<>();
            int i = 1;
            for (Path p : stream) {
                System.out.println(i++ + ". " + p.getFileName());
                copias.add(p); //añade el objeto p a copias
            }
            if (copias.isEmpty()) {
                System.out.println("No hay copias disponibles.");
                return;
            }
            System.out.print("Selecciona número de copia: ");
            int sel = Integer.parseInt(sc.nextLine()); //número de copia
            Files.copy(copias.get(sel - 1), archivo, StandardCopyOption.REPLACE_EXISTING); //si el archivo de destino ya existe se sobreescribe
            cargarAgenda();
            System.out.println("Agenda restaurada desde la copia seleccionada");
        } catch (Exception e) {
            System.out.println("Error al restaurar copia: " + e.getMessage());
        }
    }



    public void Menu1() {
        System.out.println("\n");
        System.out.println(" M E N Ú  1 ");
        System.out.println("==============");
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
        System.out.print("Elige una opción: ");
    }

    public void Menu2() {
        System.out.println("\n");
        System.out.println(" M E N Ú  2 ");
        System.out.println("=============");
        System.out.println("1. Mostrar información del archivo");
        System.out.println("2. Hacer copia de seguridad");
        System.out.println("3. Restaurar copia de seguridad");
        System.out.println("4. Volver");
        System.out.print("Elige una opción: ");
    }

    public int DameOpcion() {
        Menu1();
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    public int DameOpcion2() {
        Menu2();
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }
}
