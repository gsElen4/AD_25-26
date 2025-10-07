import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio2 {
//Basándote en el ejercicio anterior, hay un programa en el usuario introduzca palabras o frases
//y se vayan escribiendo como líneas separadas en un fichero llamado fich02.txt. El programa finaliza
//cuando el usuario teclee “fin”. Emplea codificación UTF-8. 
    public static void main(String []args) throws IOException{
       try(BufferedWriter bw = Files.newBufferedWriter(Path.of("D:\\ElenaGonzalez\\AD\\Ficheros\\archivos\\fich02.txt"),StandardCharsets.UTF_8)){

        Scanner sc = new Scanner(System.in);
        String pal= "";

         System.out.println("Escribe una palabra o una frase");
            pal = sc.nextLine();

        while(!pal.equals("fin")){
            System.out.println("Esribe una palabra o una frase");
            pal = sc.nextLine();
            bw.write(pal);
            bw.newLine();
        }
        }
       
    
    catch(Exception e){
            e.printStackTrace();
    }
    
}
}
