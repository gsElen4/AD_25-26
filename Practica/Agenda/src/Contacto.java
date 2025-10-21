
import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String email;
    private int tlf;


    public Contacto(String nombre, String email, int tlf){
        this.nombre = nombre;
        this.email = email;
        this.tlf = tlf;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
     public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

     public int getTlf(){
        return tlf;
    }

    public void setTlf(int tlf){
        this.tlf = tlf;
    
    }
       

}
