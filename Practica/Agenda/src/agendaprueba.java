import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class agendaprueba {
    private ArrayList<Contacto> agenda;
    private Scanner sc = new Scanner(System.in);

    // Constructor
    public agendaprueba() {
        agenda = new ArrayList<>();
    }

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

    
    public void Anhadir() {
        try {
            sc.nextLine(); // limpiar buffer si viene de un nextInt()
            System.out.println("Nombre: ");
            String nombreN = sc.nextLine();

            System.out.println("Correo electrónico: ");
            String emailN = sc.nextLine();

            System.out.println("Número de teléfono: ");
            int tlfN = Integer.parseInt(sc.nextLine());

            for (Contacto c : agenda) {
                if (c.getNombre().equalsIgnoreCase(nombreN)) {
                    System.out.println("Este contacto ya existe.");
                    return;
                }
            }

            agenda.add(new Contacto(nombreN, emailN, tlfN));
            System.out.println("Contacto añadido con éxito.");

        } catch (Exception e) {
            System.out.println("Error al añadir contacto: " + e.getMessage());
        }
    }

    public void Consultar() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.println("Introduce el nombre del contacto que quieres consultar:");
        String nombreBuscado = sc.nextLine();

        boolean encontrado = false;
        for (Contacto c : agenda) {
            if (c.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println(c);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }


    public void Modificar() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.println("Introduce el nombre del contacto que quieres modificar:");
        String nombreMod = sc.nextLine();

        for (Contacto c : agenda) {
            if (c.getNombre().equalsIgnoreCase(nombreMod)) {
                System.out.println("Nuevo email: ");
                c.setEmail(sc.nextLine());

                System.out.println("Nuevo teléfono: ");
                c.setTlf(Integer.parseInt(sc.nextLine()));

                System.out.println("Contacto modificado.");
                return;
            }
        }
        System.out.println("No se ha encontrado el contacto.");
    }

    public void Borrar() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.println("Introduce el nombre del contacto que quieres borrar:");
        String nombreBorrar = sc.nextLine();

        agenda.removeIf(c -> c.getNombre().equalsIgnoreCase(nombreBorrar));
        System.out.println("Contacto eliminado (si existía).");
    }

    public void Restaurar() {
        System.out.println("Función 'Restaurar' aún no implementada.");
    }

    public void Ver() {
        if (agenda.isEmpty()) {
            System.out.println("📭 La agenda está vacía.");
            return;
        }

        System.out.println("ALUMNOS EN LA AGENDA:");
        for (Contacto c : agenda) {
            System.out.println(c);
        }
    }

    public void Vaciar() {
        agenda.clear();
        System.out.println("La agenda se ha vaciado.");
    }

    public void MasOpciones() {
        int opcion2 = DameOpcion2();
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
                System.out.println(" Copia de seguridad pendiente de implementar.");
                break;

            case 3:
                System.out.println(" Restaurar copia pendiente de implementar.");
                break;

            case 4:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println(" Opción no válida.");
                break;
        }
    }

    public void Menu1() {
        System.out.println("\n    M E N Ú  P R I N C I P A L");
        System.out.println("================================");
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
        System.out.print("Dame opción: ");
    }

    public void Menu2() {
        System.out.println("\n    M E N Ú  2");
        System.out.println("=================");
        System.out.println("1. Información del archivo");
        System.out.println("2. Hacer copia de seguridad");
        System.out.println("3. Restaurar copia de seguridad");
        System.out.println("4. Volver");
        System.out.print("Dame opción: ");
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

    public void Salir() {
        System.out.println("Saliendo...");
    }
}

