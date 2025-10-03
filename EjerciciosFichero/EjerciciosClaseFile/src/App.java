import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws IOException {

    System.out.println("Ejercicio 1");
    System.out.println("=================");
        File fich = new File (".\\FicheroPrueba.txt");
        System.out.println("Existe: " + fich.exists());
        System.out.println("Directorio: " + fich.isDirectory());
        System.out.println("Fichero: " + fich.isFile());
        System.out.println("Ruta absoluta: " + fich.getAbsolutePath());
       System.out.println("Ruta canonica: " + fich.getCanonicalPath());
        System.out.println("Tamaño: " + fich.length());
        System.out.println("=================");
     System.out.println();
     System.out.println("=================");
     System.out.println("Ejercicio 2");
     
            if(fich.canRead()){
                System.out.println("El fichero tiene permisos de lectura");
            }
            else{
                System.out.println("El fichero no tiene permisos de lectura");
            }
            if(fich.canWrite()){
                System.out.println("El fichero tiene permisos de escritura");
            }
            else{
                System.out.println("El fichero no tiene permisos de escritura");
            }
            if(fich.canExecute()){
                System.out.println("El fichero tiene permisos de ejecución");
            }
            else{
                System.out.println("El fichero no tiene permisos de ejecución");
            }
            System.out.println();
            System.out.println("=================");
            System.out.println("Ejercicio 3");
            
         File dir = new File("D:\\ElenaGonzalez\\AD\\EjerciciosFichero\\EjerciciosClaseFile\\probas")  ;
         File subdir = new File ("D:\\ElenaGonzalez\\AD\\EjerciciosFichero\\EjerciciosClaseFile\\probas\\subcarpeta");
        
        if(subdir.mkdirs()) {
        System.out.println("Directorio y Subdirectorio creado");   

      }else
        System.out.println("Subdirectorio ya existe o no se puede crear");
      System.out.println("=================");
     System.out.println();
     System.out.println("=================");
     System.out.println("Ejercicio 4");
    
        Scanner teclado = new Scanner(System.in);
        String res;
        File fichval= new File ("D:\\ElenaGonzalez\\AD\\EjerciciosFichero\\EjerciciosClaseFile\\probas\\datos.txt");
        

        if(fichval.createNewFile()){
                System.out.println("El fichero vacío ha sido creado");
                System.out.println("Quieres borrar el fichero datos.txt: ");
                res = teclado.nextLine();

                if(res.equals("si")){
                    fichval.delete();
                    System.out.println("El fichero datos.txt ha sido eliminado");
                }
                else{
                    System.out.println("El fichero datos.txt no se eliminará");
                }
        }
        else {
            System.out.println("El fichero vacío datos.txt ya existe o no se ha podido crear");
        }

        System.out.println("=================");
        System.out.println();
     System.out.println("=================");
     System.out.println("Ejercicio 5"); 
     String ruta;
        System.out.println("Escribe una ruta");
        ruta = teclado.nextLine();

        File carpeta = new File(ruta);

        String[]nombres = carpeta.list();
        File[]rutas = carpeta.listFiles();

        for(String nombre : nombres){
            System.out.println("- " + nombre);
        }

        System.out.println("-----------");
        for(File ruta2 : rutas){
            System.out.println("- " + ruta2.getAbsolutePath());
        }
        System.out.println("Solo archivos: -------------------");
        for(File ruta2: rutas){
            if(ruta2.isFile())
                System.out.println("- " + ruta2.getAbsolutePath());
                }
     System.out.println("=================");
     

     System.out.println();
     System.out.println("=================");
    System.out.println("Ejercicio 6");

    String directorio;
    System.out.println("Dame un directorio: ");
    directorio = teclado.nextLine();

    for(File ruta2 : rutas){
        if(ruta2.isFile()){
            if(ruta2.getAbsolutePath().endsWith(".txt")){
                System.out.println(ruta2.getAbsolutePath());
            }
        }
    }


    System.out.println("=================");
    System.out.println();
     System.out.println("=================");
    System.out.println("Ejercicio 7");

        File fichvalOR= new File("D:\\ElenaGonzalez\\AD\\EjerciciosFichero\\EjerciciosClaseFile\\probas\\datos.txt");
        File fichvalNU = new File("D:\\ElenaGonzalez\\AD\\EjerciciosFichero\\EjerciciosClaseFile\\probas\\copia.txt");
        if (fichvalOR.exists()){
            System.out.println("El nombre del fichero datos.txt se cambiará a copia.txt");
            fichvalOR.renameTo(fichvalNU);
        }
    System.out.println("=================");
    System.out.println();
    System.out.println("=================");
    System.out.println("Ejercicio 8");

        File datos = null;
        System.out.println(datos.lastModified());

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(datos.lastModified());
        System.out.println(c.getTime());

    System.out.println("=================");

    
    }

    
    public static void recursivofichero(File dir, int level){

     recursivofichero(dir,0);
    System.out.println();
    System.out.println("=================");
    System.out.println("Ejercicio 9");
    if(dir.isDirectory()){
        File[] lista = dir.listFiles();
        for(File file : lista){
            System.out.print(file.getAbsoluteFile());

            if(dir.isDirectory()){
                recursivofichero(file, level +1);
            }
        }
    }
        
    System.out.println("=================");
        
    }

    }