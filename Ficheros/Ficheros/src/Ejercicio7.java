import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) throws Exception{
    try(BufferedReader br = Files.newBufferedReader(Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\alumnos.csv"),StandardCharsets.UTF_8)){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Introduce nombre del alumno: ");
            String nombre = sc.nextLine();
            if (nombre.equals("Z")) {
                break;
            }
            br.write(nombre);
            br.write(";");

            System.out.println("Introduce la fecha: ");
            String fecha = sc.nextLine();
            br.write(fecha);
            for(int i = 1; i<=3;i++){
                br.write(";");
                System.out.println("Introduce la nota de la " + i + "ª evaluación: ");
                String nota = sc.nextLine();
                br.write(nota);
            }
            br.newLine();
        }
        } catch (Exception e){

        }

    }
}

