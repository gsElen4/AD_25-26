import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String []args) throws IOException{
       try(BufferedWriter bw = Files.newBufferedWriter(Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\archivos\\fich01.txt"),StandardCharsets.UTF_8)){
                
        bw.write("aaaañññññññaaaa");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
       } 
    
    catch(Exception e){

    }
    System.out.println("Fin del programa");
    
}
}
