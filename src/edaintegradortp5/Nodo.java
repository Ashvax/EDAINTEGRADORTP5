package edaintegradortp5;
import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private String nombre;
    private List<Nodo> amigos;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.amigos = new ArrayList<>();
    }
    
    public void insertarAmigos(Nodo amigo){
       this.amigos.add(amigo);
    }
    
    public List<Nodo> getAmigos() {
       return amigos;
    }
   
    public String getNombre() {
       return nombre;
    }
}