import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio6ExprRegulares {
public static void main(String[] args) {
    try(BufferedWriter bw = Files.newBufferedWriter(Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\alumnos.csv"),StandardCharsets.UTF_8)){
        Scanner sc = new Scanner(System.in);
        
        while(true){
        
            System.out.println("Introduce nombre del alumno: ");
            String nombre= sc.nextLine();
            if(nombre.matches("[A-Za-z]")){
                bw.write(nombre);
                bw.write(";");
            }
            if (nombre.equals("Z")) {
                break;
            }

            System.out.println("Introduce la fecha: ");
            String fecha = sc.nextLine();
            if(fecha.matches(("\\d{1,2}-\\d{1,2}-\\d{4}")))
            bw.write(fecha);

            else{
                System.out.println("El formato de fecha no es válido");
            }

            for(int i = 1; i<=3;i++){
                bw.write(";");
                
                System.out.println("Introduce la nota de la " + i + "ª evaluación: ");
                String nota = sc.nextLine();
                if(nota.matches("^[0-9]+([.][0-9]+)?$")){
                    bw.write(nota);
                 }
                else{
                    System.out.println("Escriba una nota válida");
                }
            }
            bw.newLine();
        }
        } catch (Exception e){

        }
}
}
