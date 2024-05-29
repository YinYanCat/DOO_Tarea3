package Vistas;

import Vistas.Ventana;

/** El main en donde se realiza el programa
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Main {
    public static void main(String[] args) throws Exception {

        Ventana ventana = new Ventana();

        System.out.println("1100%1000: "+(1000%1000));
        System.out.println("900%1000: "+(1000%2000));
        System.out.println("600%500: "+(500%400));
        System.out.println("400%500: "+(500%700));
        System.out.println("200%100: "+(100%200));

    }
}
