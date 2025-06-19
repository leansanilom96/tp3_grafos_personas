package modelo;

import interfaces.INodoGrafo;
import java.util.ArrayList;
import java.util.List;

public class NodoGrafo<T> implements INodoGrafo<T> {
    private T dato;
    private List<INodoGrafo<T>> vecinos;

    public NodoGrafo(T dato) {
        this.dato = dato;
        this.vecinos = new ArrayList<>();
    }

    @Override
    public T getValor() {
        return dato;
    }

    
    @Override
    public void setValor(T dato) {
        this.dato = dato;
    }

    @Override
    public void agregarVecino(INodoGrafo<T> vecino) {
        if (!vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }

    @Override
    public List<INodoGrafo<T>> getVecinos() {
        return vecinos;
    }
    
}