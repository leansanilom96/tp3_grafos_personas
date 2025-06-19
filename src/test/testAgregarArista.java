package test;

import interfaces.IGrafo;
import modelo.Grafo;
import modelo.Persona;

public class testAgregarArista {

	public static void main(String[] args) {
		System.out.println("\n--- Test: agregarArista ---");
        IGrafo<Persona> grafo = new Grafo<>();
        Persona p1 = new Persona(39529732, "Leandro molinas");
        Persona p2 = new Persona(56565655, "cascio Juan");
        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarArista(p1, p2);

        grafo.mostrarListaAdyacencia(); // Leandro -> Juan

	}

}
