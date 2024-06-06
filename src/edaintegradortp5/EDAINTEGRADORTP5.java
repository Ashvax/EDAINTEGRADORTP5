package edaintegradortp5;

import java.util.Scanner;

public class EDAINTEGRADORTP5 {
    public static void main(String[] args) {
        
     Arbol arbol = new Arbol("rey");
        boolean salir = true;
        Scanner sc = new Scanner(System.in);

        while (salir) {
            System.out.println("\n-----");
            System.out.println("Bienvenido al Reino de los Nodos");
            System.out.println("¿Qué desea realizar?");
            System.out.println("1) Agregar súbdito");
            System.out.println("2) Mostrar súbditos por niveles");
            System.out.println("3) Encontrar súbdito más lejano");
            System.out.println("4) Mostrar amigos de persona");
            System.out.println("5) Salir");
            System.out.print("Seleccione una opción: ");
            int opc = sc.nextInt();
            sc.nextLine();  

            switch (opc) {
                case 1:
                    System.out.print("Ingrese el nombre del padre: ");
                    String nombreDelPadre = sc.nextLine();
                    System.out.print("Ingrese el nombre del nuevo súbdito: ");
                    String nombre = sc.nextLine();
                    arbol.agregarSubdito(arbol.getRey(), nombreDelPadre, nombre);
                    break;
                case 2:
                    System.out.println("Súbditos por niveles:");
                    arbol.mostrarNiveles();
                    break;
                case 3:
                    Nodo lejano = arbol.encontrarMasLejano();
                    if (lejano != null) {
                        System.out.println("Súbdito más lejano: " + lejano.getNombre());
                    } else {
                        System.out.println("No se encontró ningún súbdito.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la persona: ");
                    String persona = sc.nextLine();
                    Nodo nodoPersona = arbol.buscarPersona(arbol.getRey(), persona);
                    arbol.mostrarAmigos(nodoPersona);
                    break;
                case 5:
                    System.out.println("Saliendo de la red social...");
                    salir = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        sc.close();
    }
}