package Modelos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Un deposito que almacena objetos de tipo genérico <T> en una lista
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Deposito<T> extends JPanel {

    /** Lista donde se guardan los objetos de tipo genérico */
    private ArrayList<T> contenido;

    /** Constructor donde se crea una nueva instancia de la lista de los objetos */
    public Deposito() {
        contenido = new ArrayList<>();
    }

    /** Método donde se agregan un objeto a la lista 'contenido'
     * @param objeto Objeto genérico que se agrega al final de la lista */
    public void addContenido(T objeto) {
        contenido.add(objeto);
    }

    /** Método que entrega el primer objeto de la lista, además de verificar si esta misma está vacía
     * @return un objeto genérico que se remueve de la primera posición de la lista 'contenido', si está vacía retorna null */
    public T getContenido() {
        if(contenido.size() == 0){
            return null;
        } else {
            return contenido.remove(0);
        }
    }
    public T checkContenido(int index) {
        if(contenido.size() == 0){
            return null;
        } else {
            return contenido.get(index);
        }
    }
    public void extend(Deposito<T> depoExtend) {
        T obj;
        while(true) {
            obj = depoExtend.getContenido();
            if(obj == null)
                break;
            this.addContenido(obj);
        }
    }
    public int getCantidadContenido() {
        return contenido.size();
    }

    public ArrayList<T> getList(){
        return contenido;
    }

    @Override
    public void paintComponent(Graphics g){

    }
}