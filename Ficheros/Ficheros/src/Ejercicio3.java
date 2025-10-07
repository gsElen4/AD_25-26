import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio3 {
public static void main(String[] args) {
    try(BufferedReader br = Files.newBufferedReader(Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\archivos\\fich02.txt"),StandardCharsets.UTF_8)){
        String linea;

        while ((linea = br.readLine()) !=null){
            System.out.println(linea.toUpperCase());
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}}
