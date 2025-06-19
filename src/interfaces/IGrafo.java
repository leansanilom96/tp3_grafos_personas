package interfaces;

public interface IGrafo<T> {
	void agregarNodo(T valor);
    void agregarArista(T origen, T destino);
    
    public void mostrarMatrizAdyacencia();
    public void mostrarListaAdyacencia();

    void recorrerDFS(T inicio);
    void recorrerBFS(T inicio);

    int[][] getMatrizAdyacencia();

    void setDirigido(boolean dirigido);
    boolean esDirigido();
}
