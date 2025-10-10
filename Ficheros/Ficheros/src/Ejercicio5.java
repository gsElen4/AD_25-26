
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio5 {
    public static int[] analizarFichero(String rutaFichero) {
        File archivo  = new File(rutaFichero);
        if(!archivo.exists()){
            return null;
        }
        int numCaracteres = 0;
        int numLineas = 0;
        int numPalabras = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea =br.readLine()) != null){
                numLineas++;
                numCaracteres += linea.length();

                String [] palabras = linea.trim().split("\\s+");
                if (!linea.trim().isEmpty()){
                    numPalabras += palabras.length;
                }
            }
        } catch (IOException e){
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        return  new int[] {
            numCaracteres, numLineas, numPalabras
        };
     
    }
    public static void main(String[] args) {
        String ruta = "D:\\ElenaGonzalez\\AD\\Ficheros\\archivos\\fich02.txt";
        
        int[]resultado = analizarFichero(ruta);

        if(resultado == null){
            System.out.println("El fichero no existe");
        }else{
            System.out.println("Número de caracteres: " + resultado[0]);
            System.out.println("Número de lineas: " + resultado[1]);
            System.out.println("Número de palabras: " + resultado[2]);
        }
    }
}
