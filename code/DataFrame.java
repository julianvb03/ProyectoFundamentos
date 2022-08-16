import java.util.ArrayList;

/**
 * En esta clase se guardan los datos de un DataFrame
 * 
 * Nicolás Gutiérrez y Julian Valencia
 */
public class DataFrame {
    // se guardan los datos de una fila
    ArrayList<Integer> fila;
    // se guardan los datos de las columnas
    ArrayList<String> encabezados;
    // aca se guardan las filas del dataframe
    // cada fila es un AL de enteros
    ArrayList<ArrayList<Integer>> datos;

    /**
     * Constructor.
     * param encabezados: ArrayList con los nombres
     * de las columnas
     */
    public DataFrame(ArrayList<String> encabezados) {
        this.datos = new ArrayList<>();
        this.encabezados = encabezados;
    }

    /**
     * permite agregar una fila a los datos
     * param f: arraylist con los enteros de una fila
     */
    public void agregarFila(ArrayList<Integer> f) {
        datos.add(f);
    }

    /**
     * Permite imprimir el DAtaframe
     * primero se imprimen los encabezados y luego cada fila de datos
     * 
     */
    public void imprimirDF() {
        for (String e : encabezados) {
            System.out.print(e + " ");
        }
        System.out.println();
        for (ArrayList<Integer> f : datos) {
            for (Integer i : f) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
