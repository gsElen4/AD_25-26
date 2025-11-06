
import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String email;
    private int tlf;
    private boolean borrado;


    public Contacto(String nombre, String email, int tlf){
        this.nombre = nombre;
        this.email = email;
        this.tlf = tlf;
        this.borrado= false;
       
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
     public boolean isBorrado(){
        return borrado;
    }
    public void setBorrado(boolean borrado) {
      this.borrado = borrado;
    }     

     @Override
    public String toString() {
        if (borrado) {
            return "(BORRADO) Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + tlf;
        } else {
            return "Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + tlf;
        }
    }
   
}
