package Modelos;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

/** Un deposito que almacena objetos de tipo genérico <T> en una lista
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Deposito<T extends Visible> extends JPanel {

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

    /** Método que entrega el objeto guardado en la posición index
     * @return un objeto generico almacenado en Deposito */
    public T checkContenido(int index) {
        if(contenido.size() == 0){
            return null;
        } else {
            return contenido.get(index);
        }
    }

    /** Método para extender un deposito al final del deposito actual
     * @param depoExtend Deposito que va a extender el deposito actual */
    public void extend(Deposito<T> depoExtend) {
        T obj;
        while(true) {
            obj = depoExtend.getContenido();
            if(obj == null)
                break;
            this.addContenido(obj);
        }
    }

    /** Metodo que devuelve la cantidad de objetos en Deposito
     * @return int con la cantidad de objetos */
    public int getCantidadContenido() {
        return contenido.size();
    }

    /** Método para vaciar el Deposito */
    public void vaciarDeposito() {
        contenido.clear();
    }

    /** Método para dibujar en un componente de Swing los objetos almacenados en el Deposito */
    public void paintComponent(Graphics g,Component observer){
        for(int j=0;j<getCantidadContenido();j++){
            contenido.get(j).paintComponent(g,observer);
        }
    }
}