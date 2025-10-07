import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio4 {
public static void main(String[] args) {
    

try{
        List<String> lineas = Files.readAllLines(Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\archivos\\fich02.txt"),StandardCharsets.UTF_8);
        
        for(String linea : lineas){
            System.out.println(linea.toUpperCase());
        }
        System.out.println("Leyendo con ReadString");

        String ficheroCompleto = Files.readString(Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\archivos\\fich02.txt"),StandardCharsets.UTF_8);
        System.out.println(ficheroCompleto);
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
