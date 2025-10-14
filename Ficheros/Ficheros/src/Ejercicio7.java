import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio7 {
    public static void main(String[] args) {
        int contador = 0;
        String mejorAlumno = "";
        double mejorNota = -1;

        Path ruta = Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\alumnos.csv");

        try (BufferedReader br = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                // Verificar que haya suficientes columnas
                if (datos.length < 5) continue;

                String nombre = datos[0];
                double nota1 = Double.parseDouble(datos[2]);
                double nota2 = Double.parseDouble(datos[3]);
                double nota3 = Double.parseDouble(datos[4]);

                double notafinal = nota1 * 0.2 + nota2 * 0.3 + nota3 * 0.5;

                if (notafinal >= 5) {
                    contador++;
                }

                // Comprobar si es la mejor nota
                if (notafinal > mejorNota) {
                    mejorNota = notafinal;
                    mejorAlumno = nombre;
                }
            }

            // Mostrar resultados al final
            System.out.println("Alumnos aprobados: " + contador);
            System.out.println("Alumno con la mejor nota: " + mejorAlumno + " (" + mejorNota + ")");
        } 
        catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
