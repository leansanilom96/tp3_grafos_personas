package test;

import interfaces.IGrafo;
import modelo.Grafo;
import modelo.Persona;

public class testMostrarListaAdyacencia {

	public static void main(String[] args) {
		System.out.println("\n--- Test: mostrarListaAdyacencia ---");
        IGrafo<Persona> grafo = new Grafo<>();
        Persona p1 = new Persona(39529732, "Leanadro molinas");
        Persona p2 = new Persona(56666566, "cascio Juan");
        Persona p3 = new Persona(54656566, "ramiro perez galeano");

        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);
        grafo.agregarArista(p1, p2);
        grafo.agregarArista(p2, p3);

        grafo.mostrarListaAdyacencia();

	}

}
