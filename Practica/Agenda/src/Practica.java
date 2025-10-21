
public class Practica {
    public static void main(String[]args){
        int Op = 0;
         Agenda agenda = new Agenda();
        switch(Op){
      
            case 1: 
                agenda.Crear();  
                break;
            case 2:
                agenda.Anhadir();  
                break;
            case 3:
                agenda.Consultar();
                break;
            case 4:
                agenda.Modificar();
                break;
            case 5: 
                agenda.Borrar();
                break;
            case 6:
                agenda.Restaurar();
                break;
            case 7: 
                agenda.Ver();
                break;
            case 8: 
                agenda.Vaciar();
            case 9:
                agenda.MasOpciones();
            default:
                System.out.println("No es un número válido");
                break;
        }
        
    
}
}
