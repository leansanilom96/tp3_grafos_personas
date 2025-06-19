package test;

import interfaces.IGrafo;
import modelo.Grafo;
import modelo.Persona;

public class testAgregarNodo {

	public static void main(String[] args) {
		System.out.println("\n--- Test: agregarNodo ---");
        IGrafo<Persona> grafo = new Grafo<>();
        Persona p1 = new Persona(39529732, "Leandro molinas");

        grafo.agregarNodo(p1);
        grafo.mostrarListaAdyacencia(); // debe mostrar a la persona sola sin vecinos
	}

}
