package interfaces;

import java.util.List;

public interface INodoGrafo<T> {
    T getValor();
    void setValor(T valor); 
    void agregarVecino(INodoGrafo<T> vecino);
    List<INodoGrafo<T>> getVecinos();
   
}