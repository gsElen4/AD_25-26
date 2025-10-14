import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) throws Exception{
    try(BufferedWriter bw = Files.newBufferedWriter(Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\alumnos.csv"),StandardCharsets.UTF_8)){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Introduce nombre del alumno: ");
            String nombre = sc.nextLine();
            if (nombre.equals("Z")) {
                break;
            }
            bw.write(nombre);
            bw.write(";");

            System.out.println("Introduce la fecha: ");
            String fecha = sc.nextLine();
            bw.write(fecha);

            for(int i = 1; i<=3;i++){
                bw.write(";");
                System.out.println("Introduce la nota de la " + i + "ª evaluación: ");
                String nota = sc.nextLine();
                bw.write(nota);
            }
            bw.newLine();
        }
        } catch (Exception e){

        }
        
    }
}

