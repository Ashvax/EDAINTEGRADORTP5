package edaintegradortp5;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Arbol {
    private Nodo rey;
    
    public Arbol(String nombre) {
        this.rey = new Nodo(nombre);
    }

    public Nodo getRey() {
        return rey;
    }

    // Agregar Subdito
    public void agregarSubdito(Nodo actual, String nombreDelPadre, String nombre) {
        if (actual == null) {
            System.out.println("El árbol está vacío.");
            return;
        }
        if (actual.getNombre().equals(nombreDelPadre)) {
            actual.insertarAmigos(new Nodo(nombre));
            System.out.println("Se agregó con éxito.");
            return;
        }
        for (Nodo amigo : actual.getAmigos()) {
            agregarSubdito(amigo, nombreDelPadre, nombre);
        }
    }

    // Mostrar Subditos del Rey
    public void mostrarNiveles() {
        if (rey == null) {
            return;
        }
        List<Nodo> nivelActual = new ArrayList<>();
        nivelActual.add(rey);
        int nivel = 0;
        while (!nivelActual.isEmpty()) {
            List<Nodo> proximoNivel = new ArrayList<>();
            System.out.print("Nivel: "+nivel +" - ");
            for (Nodo actual : nivelActual) {
                
                System.out.print(actual.getNombre() + " ");   
                for (Nodo amigo : actual.getAmigos()) {
                    proximoNivel.add(amigo);
                }
            }
            System.out.println("");
            nivelActual = proximoNivel;
            nivel++;
        }
    }

    // Encontrar al Subdito Más Lejano del Rey
    public Nodo encontrarMasLejano() {
        if (rey == null) {
            return null;
        }
        Nodo masLejano = null;
        int nivel = 0;
        List<Nodo> nivelActual = new ArrayList<>();
        nivelActual.add(rey);
        int nivelMax = 0;
        int pasos = -1;
        while (!nivelActual.isEmpty()) {
            List<Nodo> proximoNivel = new ArrayList<>();
            for (Nodo actual : nivelActual) {
                if (nivel > nivelMax) {
                    nivelMax = nivel;
                    masLejano = actual;
                }
                for (Nodo amigo : actual.getAmigos()) {
                    proximoNivel.add(amigo);
                }
            }
            nivelActual = proximoNivel;
            nivel++;
            pasos++;
        }
        System.out.println("Pasos Desde El Rey Hasta El Subdito Mas Lejano: "+pasos);
        return masLejano;
    }

    public Nodo buscarPersona(Nodo actual, String nombre) {
        if (actual == null) {
            return null;
        }
        if (actual.getNombre().equals(nombre)) {
            return actual;
        }
        for (Nodo amigo : actual.getAmigos()) {
            Nodo resultado = buscarPersona(amigo, nombre);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    public void mostrarAmigos(Nodo persona) {
        if (persona == null) {
            return;
        }
        List<Nodo> amigos = persona.getAmigos();
        if (amigos.isEmpty()) {
            System.out.println(persona.getNombre() + " no tiene amigos.");
        } else {
            System.out.println(persona.getNombre() + " tiene los siguientes amigos:");
            for (Nodo amigo : amigos) {
                System.out.println(amigo.getNombre());
            }
        }
    }
}