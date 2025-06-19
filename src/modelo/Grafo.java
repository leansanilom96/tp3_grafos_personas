package modelo;

import interfaces.IGrafo;
import interfaces.INodoGrafo;
import java.util.*;

public class Grafo<T> implements IGrafo<T> {
    private Map<T, INodoGrafo<T>> nodos;
    private boolean dirigido;

    public Grafo() {
        this.nodos = new HashMap<>();
        this.dirigido = true;
    }

    @Override
    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    @Override
    public boolean esDirigido() {
        return dirigido;
    }

    @Override
    public void agregarNodo(T valor) {
        if (!nodos.containsKey(valor)) {
            nodos.put(valor, new NodoGrafo<>(valor));
        }
    }
    @Override
    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            INodoGrafo<T> nodoOrigen = nodos.get(origen);
            INodoGrafo<T> nodoDestino = nodos.get(destino);

            nodoOrigen.agregarVecino(nodoDestino);

            if (!dirigido) {
                nodoDestino.agregarVecino(nodoOrigen);
            }
        }
    }
    
    @Override
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");

        // Obtener lista ordenada de nodos (por toString o ID si Persona)
        List<T> claves = new ArrayList<>(nodos.keySet());
        Collections.sort(claves, Comparator.comparing(T::toString));

        // Encabezado
        System.out.print("    ");
        for (T col : claves) {
            System.out.print(col.toString() + " ");
        }
        System.out.println();

        // Filas
        for (T fila : claves) {
            System.out.print(fila.toString() + ": ");
            INodoGrafo<T> nodoFila = nodos.get(fila);
            for (T col : claves) {
                INodoGrafo<T> nodoCol = nodos.get(col);
                System.out.print(nodoFila.getVecinos().contains(nodoCol) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
    
    @Override
    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");

        for (Map.Entry<T, INodoGrafo<T>> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey().toString() + ": ");
            List<INodoGrafo<T>> vecinos = entrada.getValue().getVecinos();

            for (INodoGrafo<T> vecino : vecinos) {
                System.out.print(vecino.getValor().toString() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void recorrerDFS(T inicio) {
        if (!nodos.containsKey(inicio)) return; // precondición

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(INodoGrafo<T> actual, Set<T> visitados) {
        T valorActual = actual.getValor();
        visitados.add(valorActual);
        System.out.print(valorActual.toString() + " ");

        List<INodoGrafo<T>> vecinos = actual.getVecinos();
        for (int i = vecinos.size() - 1; i >= 0; i--) {
            INodoGrafo<T> vecino = vecinos.get(i);
            T valorVecino = vecino.getValor();
            if (!visitados.contains(valorVecino)) {
                dfsRec(vecino, visitados);
            }
        }
    }

    
    @Override
    public void recorrerBFS(T inicio) {
        if (!nodos.containsKey(inicio)) return; // precondición

        Set<T> visitados = new HashSet<>();
        Queue<INodoGrafo<T>> cola = new LinkedList<>();

        INodoGrafo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            INodoGrafo<T> actual = cola.poll();
            System.out.print(actual.getValor().toString() + " ");

            for (INodoGrafo<T> vecino : actual.getVecinos()) {
                T valorVecino = vecino.getValor();
                if (!visitados.contains(valorVecino)) {
                    visitados.add(valorVecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}

 