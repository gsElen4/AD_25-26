
public class App {
    public static void main(String[] args) throws Exception {
/* 
       Scanner teclado = new Scanner(System.in);
        System.out.println("Ejercicio 1");
        System.out.println("=============");
        int x;
try{
        System.out.print("Dame número A: ");
        int a=teclado.nextInt();
        System.out.print("Dame número B: ");
        int b=teclado.nextInt();

        x = a/b;
        

}
catch ( InputMismatchException e){
    x = 0;
}
 catch ( ArithmeticException e){
    x = 0;
 }
System.out.println("El resultado: " + x);
    

    System.out.println("Ejercicio 2");
    System.out.println("=============");

   double [] array = new double[7];
   for (int i = 0; i < array.length; i++) {
    array[i] = Math.random()*40;   
    System.out.println("Temperatura dia "+ i + ": " + array[i]);
   }

   System.out.print("Introduce numero 1: ");
   int c = teclado.nextInt();
   System.out.print("Introduce numero 2: ");
   int d = teclado.nextInt();
   
   if(c > d){
        int aux = c;
        c = d;
        d = aux;
   }
   double suma =0; 
   double media;
   
   try{
    for (int i = c; i<=d; i++){
        suma+= array[i];
    }
     media = suma/(d-c+1);
}
catch ( ArrayIndexOutOfBoundsException e){
        System.out.println("Numeros incorrectos");
        media = 0;
} 
    System.out.println("media: " + media);

    System.out.println("Ejercicio 3");
    System.out.println("=============");
    leerEntero(8,1);
    
   
    }
    public static Integer  leerEntero(int max, int min){
        Scanner teclado = new Scanner(System.in);
   
        while(true){
            try {
                System.out.println("Dame un entero: ");
                int  f = teclado.nextInt();  
                if(f>=min && f<=max){
                teclado.close();
                return f;       
            } 
            else{
                System.out.println("El número no está entre mínimo y máximo");
            } 
        
        
        } catch (InputMismatchException e) {
            System.out.println("No has introducido un entero");
            teclado.close();
            }
        
        }   
    */
    }
    public static void CorreoElectronico(String email) throws EmailInvalidoException{
       
        
        int caracteres= email.length();   
        if(caracteres<5){
            throw new EmailInvalidoException();
        }
        if(!email.contains("@")){
            throw new EmailInvalidoException();
        }
        int posicion = email.indexOf("@");
        String substring = email.substring(posicion);
        if(!substring.contains(".")){
            throw new EmailInvalidoException();    
            }
            return;
        }

}


