import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cadena: ");
        String cadena = sc.nextLine();
//Apartado a
        if(cadena.matches("\\d{4} ?[A-Z]{3}")){//Apartado A
            System.out.println("La cadena es una matricula");
        }
        
        if(cadena.matches("[0 1]+")){//Apartado B
            System.out.println("La cadena es un binario");
        }

        if(cadena.matches("[0-9A-Fa-f]{5,8}")){
            System.out.println("La cadena es un hexadecimal");
        }
        if(cadena.matches("\\d{4}-\\d{2}-\\d{1,2}")){
            System.out.println("La cadena es una fecha");
        }
        if(cadena.matches("\\d{4}-\\d{1,2}-\\d{1,2}")){
            System.out.println("La cadena es una fecha con el mes en dos o un dígito");
        }
        if(cadena.matches("^@[A-Za-z0-9-_]{2,15}")){
            System.out.println("La cadena es un nombre de usuario");
        }

        }


        


/*
[^@]+                       cualquier carácter que no sea @ una o más veces seguido de
 \.                         un punto seguido de
[a-zA-Z]{2,}                dos o más letras minúsculas o mayúsculas
 \w                         una palabra (estaría delimitada por espacios en blanco, punto, coma, etc)
 \d \s                      un dígito, un espacio en blanco
 [abc]                      o ‘a’ o ‘b’ o ‘c’ (un solo carácter).
 [^abc]                     ni ‘a’ ni ‘b’ ni ‘c’.
 [a-g]                      un carácter entre ‘a’ y ‘g’.
 [A-Dh-k]                   un carácter entre ‘A’ y ‘D’ o bien entre ‘h’ y ‘k’.
 \. \* \\                   caracteres especiales: el punto, el asterisco y la barra.
 a* a+ a?                   *: cero o más veces, +: una o más veces, ?: cero o una vez.
 a{5} a{5,8} a{5, }         {5} cinco veces exactas, {5,8}entre 5 y 8, {5,}5 ó mas.
 ab | cd                    o bien ‘ab’ o bien ‘cd’ 
*/
    }

