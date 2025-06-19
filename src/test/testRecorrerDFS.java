package test;

import interfaces.IGrafo;
import modelo.Grafo;
import modelo.Persona;

public class testRecorrerDFS {

	public static void main(String[] args) {
		System.out.println("\n--- Test: recorrerDFS ---");
        IGrafo<Persona> grafo = new Grafo<>();
        Persona a = new Persona(3952739, "leandro molinas");
        Persona b = new Persona(4465665, "ramiro perez galeano");
        Persona c = new Persona(3565666, "cascio juan");
        Persona d = new Persona(6565656, "Ian del valle");

        grafo.agregarNodo(a);
        grafo.agregarNodo(b);
        grafo.agregarNodo(c);
        grafo.agregarNodo(d);
        grafo.agregarArista(a, b);
        grafo.agregarArista(b, c);
        grafo.agregarArista(a, d);

        grafo.recorrerDFS(a);
	}

}
