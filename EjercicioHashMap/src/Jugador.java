public class Jugador {
    private String nombre;
    private Double salario;
    private Integer edad;


public Jugador(String nombre, double salario, int edad) {
        this.nombre = nombre;

        if(salario< 0){
            this.salario = 0.0;
        }
        else{
            this.salario = salario;
        }
        if(edad <0 || edad > 100){
            edad = 18;
            System.out.println("La edad de " + nombre + "se ha cambiado a los 18 años.");
        }
        else{
             this.edad = edad;
       }
    }

    public Jugador(){
        nombre ="Jugador vacio";
        salario = 0.0;
        edad = 18;
    }

    public String getNombre(){
        return nombre;
    }

    public Double getSalario(){
        return salario;
    }

    public Integer getEdad(){
        return edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

     public void setSalario(Double salario){
        this.salario = salario;
    }
    public void setEdad(Integer edad){
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugador [Nombre=" + nombre + ", Salario=" + salario + ", Edad=" + edad + "]";
    }

    
   
    
    }

/*Realizar un programa que tenga un HashMap que almacene una plantilla de jugadores de un
equipo, cuya clave es el nombre de cada jugador. De cada uno de ellos, además del nombre,
tendremos su salario y su edad. La plantilla tiene un máximo de 25 jugadores. El programa dispondrá
de menú que permita: añadir jugador, eliminar jugador, lista jugadores con su salario y que tenga
también opción que permita introducir un salario y muestre lo datos de los jugadores que tiene un
salario parecido al introducido (por “parecido” entendemos que el salario del jugador esté en un
rango de 6000 euros arriba o abajo respecto al introducido).*/