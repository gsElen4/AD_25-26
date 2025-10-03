import java.util.Scanner;

public class EjerciciosString {
public static void main(String[] args) throws Exception {

Scanner teclado = new Scanner(System.in);

String cadena; 

System.out.print("Dame una cadena: ");
cadena = teclado.nextLine();
/* a 
  System.out.println(cadena.toLowerCase());   
    
*/
/*b. Decir si en la cadena aparece el carácter ‘x’.
        System.out.print("Introduce una cadena: ");
        cadena = teclado.nextLine();
        */

/*c. Decir si la cadena tiene más de 10 posiciones.*/

/*d. Decir si la cadena contiene el carácter ‘x’ a partir de la cuarta posición.*/
/*e. Crear una cadena formada por las 5 primeras posiciones de la cadena.*/
/*f. Crear una cadena formada por las 5 últimas posiciones de la cadena.
        if (cadena.length()>5){
            String fin = cadena.substring(cadena.length()-5);
            System.out.println(fin);

        }
        else{
            System.out.println(cadena);
        }
        */
/*g. Decir si la cadena es igual a la cadena “hola”.
     if (cadena.equals("hola")){
        System.out.println("El igual a hola");
     }
     else{
        System.out.println("No es igual a hola");
     }
     */
/*h. Convertir la cadena de entrada a una variable de tipo int, suponiendo que dicha cadena
es un número, esto es, contiene solo dígitos decimales (del 0 a 9)

Integer numero;

try{
numero = Integer.parseInt(cadena);
System.out.print(numero);
}
catch ( NumberFormatException exception){
    System.out.println("La cadena no es un entero");
}
catch(Exception e){
    System.out.println("Ha ocurrido otro tipo de error");
    System.out.println(e.getMessage());
}


/*i. Convertir la cadena de entrada a una variable de tipo int, suponiendo que dicha cadena
es un número hexadecimal, esto es, contiene solo dígitos decimales (del 0 a 9) y letras de
la A a F.
int decimal = Integer.parseInt(cadena,16);
System.out.println(decimal);
String valoresHex = "0123456789ABCDEF";
decimal = 0;

for(char c : cadena.toCharArray()){
    int valor = valoresHex.indexOf(c);
    decimal = valor*16 + valor;
}
    System.out.println(decimal);

/*j. Si se encuentra con en su interior con “prueva” sustituir por “prueba”.
String cadena2 = cadena.replace("prueva", "prueba");
    System.out.print(cadena);
    
/*k. Decir si la primera posición de la cadena es igual a la última.
    Character primera = cadena.charAt(0);
    char ultima = cadena.charAt(cadena.length());

    if(primera.equals(ultima)){
        System.out.println("El primero es igual al ultimo");
    }
    else{
        System.out.println("El primero no es igual al ultimo");
    }
/*l. Decir cuántos dígitos numéricos hay en la cadena.*/
        int n=0;
        for (char c : cadena.toCharArray()){
            if(Character.isDigit(c)){
                n++;
            }
        }
        System.out.println("Hay " + n + " digitos numéricos");
//Otra solucion
int contador= 0;
for ( int i = 0;i <cadena.length();i++){
    char letra = cadena.charAt(i);
    if(Character.isDigit(letra)){
        contador++;
    }
}
System.out.println("En la cadena hay "+ contador + " digitos.");

/*m. Decir si la cadena es un palíndromo (se lee igual hacia adelante como hacia atrás)*/
boolean esPalindromo=true;
for (int i=0, j=cadena.length()-1; i<j ;i++,j--){
    if(cadena.charAt(i) !=cadena.charAt(j)){
        esPalindromo = false;
        break;
    }

}	
System.out.println("Es palindromo: "+ esPalindromo);


//Otra opcion
esPalindromo = true;
for(int i= 0; i<cadena.length()/2; i++){
    if(cadena.charAt(i) !=cadena.charAt(cadena.length()-1-i)){
    esPalindromo = false;
    break;
    }
}
System.out.println("Es palindromo: "+ esPalindromo);


/*n. Crear una cadena que sea igual a la introducida, pero con la primera y última posiciones
intercambiadas. Ejemplo: si introducen: “abcde”, obtendría “ebcda”.*/
char ultimo = cadena.charAt(cadena.length()-1);
char primero = cadena.charAt(0);

    String cadena2 = cadena.substring(1,cadena.length()-1);
    cadena2 = ultimo + cadena2 + primero;

    System.out.println(cadena2);
}
}
