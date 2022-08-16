import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * En esta clase se lee un archivo csv y guarda los valores
 * de este mismo en un objeto DataFrame para posteriormente imprimirlos.
 * 
 * @author Julian Valencia y Nicolás Gutiérrez
 *         version Mayo 2022
 */
public class CrearDF {
    ArrayList<String> encabezados;
    ArrayList<Integer> fila;
    ArrayList<Integer> columna;
    ArrayList<ArrayList<Integer>> compare = new ArrayList<>();
    ArrayList<ArrayList<Integer>> columnas = new ArrayList<>();
    int numColumnas = 0;
    int[] ids;
    int[] estaturas;
    DataFrame df;

    /**
     * este primer metodo crea un DataFrame leyendo un
     * archivio que se le pase
     */
    public void CrearDataFrame(String n)
            throws FileNotFoundException {
        File directory = new File(n);
        Scanner sc = new Scanner(directory);
        String linea = sc.nextLine();
        Scanner lineScan = new Scanner(linea);
        lineScan.useDelimiter(",");
        this.encabezados = new ArrayList<>();
        while (lineScan.hasNext()) {
            numColumnas += 1;
            this.encabezados.add(lineScan.next());
        }
        this.df = new DataFrame(encabezados);
        while (sc.hasNextLine()) {
            linea = sc.nextLine();
            lineScan = new Scanner(linea);
            lineScan.useDelimiter(",");
            fila = new ArrayList<>();
            while (lineScan.hasNextInt()) {
                fila.add(lineScan.nextInt());
            }
            df.agregarFila(fila);
            compare.add(fila);
        }
        sc.close();
        lineScan.close();
    }

    /**
     * el metodo numeroHijos usa el dataFrame hijos para buscar
     * la madre que más hijos tiene.
     */
    public void numeroHijos() {
        int ids[] = new int[compare.size()];
        int pos = 0;
        /**
         * primero se pasan los datos de numero de hijos de cada AL
         * a un arreglo estatico en caso de que no se halla leido el
         * archivo arroja el mensaje pidiendo que se asegure de leer
         * el archivo
         */
        if (compare.size() != 0) {
            for (ArrayList<Integer> f : compare) {
                ids[pos] = f.get(1);
                pos++;
            }
        } else {
            System.out.println("Asegurese de haber leido el archivo hijos");
        }
        int elemento = 0;
        int cuenta = 0;
        int cuenta2 = 0;
        int elemento2 = 0;
        if (compare.size() != 0) {

            // el siguiente ciclo for recorre los elementos del arreglo escogido
            for (int i = 0; i < ids.length; i++) {
                int elementoTemporal = ids[i];
                int cuentaTemporal = 0;
                // el siguiente ciclo for cuenta las instancias para cada elemento
                for (int j = 0; j < ids.length; j++) {
                    if (ids[j] == elementoTemporal)
                        cuentaTemporal++;
                }
                // se crea el condicional para guardar tanto la madre como la cantidad de hijos
                // que tiene
                if (cuentaTemporal > cuenta) {
                    elemento = elementoTemporal;
                    cuenta = cuentaTemporal;
                    /*
                     * el else sirve para darse cuenta cuadno hay 2 madres
                     * con el mismo numero de hijos
                     */
                } else if (cuentaTemporal == cuenta) {
                    cuenta2 = cuentaTemporal;
                    elemento2 = elementoTemporal;
                }
            }
            // este if es importante porque el programa puede
            if (cuenta2 == cuenta && elemento2 != elemento) {
                System.out.println("no existe una madre que tenga más hijos que todas las demas");
            } else {
                System.out.println("La madre con más hijos es la número: " + elemento + " Con un total de " + cuenta);
            }
        }
    }

    // metodo que imprime un DataFrame
    public void imprimir()
            throws NullPointerException {
        this.df.imprimirDF();
    }

    /**
     * metodo que busca el hijo con menorEstatura.
     * No recibe parametros
     */
    public void menorEstatura() {
        // igual que anteriormente se pasan los datos a un arreglo estatico
        int estaturas[] = new int[compare.size()];
        int pos1 = 0;
        if (compare.size() != 0) {
            for (ArrayList<Integer> f : compare) {
                estaturas[pos1] = f.get(3);
                pos1++;
            }
        } else {
            System.out.println("Asegurese de haber leido el archivo hijos");
        }
        if (compare.size() != 0) {
            int menor = estaturas[0];
            int indice = 0;
            int menor2 = 0;
            // el ciclo itera entre los elementos del arreglo y encuentra el menor, junto
            // con su indice
            for (int i = 0; i < estaturas.length; i++) {
                if (estaturas[i] < menor) {
                    menor = estaturas[i];
                    indice = i;
                } else if (estaturas[i] == menor) {
                    menor2 = estaturas[i];
                }
            }
            indice += 1;
            if (menor2 == menor) {
                System.out.println("no hay un hijo que mida menos que todos los demas");
            } else {
                System.out.println("La Id del hijo con menor estatura es la número: " + indice + " Midiendo: " + menor);
            }
        }
    }

    public void describe() {
        if (compare.size() != 0) {
            int i = 0;
            int controler = 0;
            while (i < numColumnas) {
                columna = new ArrayList<>();
                int index = 0;
                for (ArrayList<Integer> v : compare) {
                    if (v.size() != 0) {
                        columna.add(v.get(index + controler));
                    }
                }
                columnas.add(columna);
                index++;
                i++;
                controler++;
            }
            // minimo elemento, se encarga de crear el ArrayList que contendra el valor
            // minimo de cada columna
            ArrayList<Integer> minimo = new ArrayList<>();
            if (columnas.size() != 0) {
                for (ArrayList<Integer> evaluar : columnas) {
                    int minimoE = evaluar.get(0);
                    for (int z = 0; z < evaluar.size(); z++) {
                        if (evaluar.get(z) < minimoE) {
                            minimoE = evaluar.get(z);
                        }
                    }
                    minimo.add(minimoE);
                }
                System.out.println(minimo);
            } else
                System.out.println("Error en la procedencia del archivo");
            // maximo elemento, se encarga de crear el ArrayList que contendra el valor
            // maximo de cada columna
            ArrayList<Integer> maximo = new ArrayList<>();
            if (columnas.size() != 0) {
                for (ArrayList<Integer> evaluar : columnas) {
                    int maximoE = evaluar.get(0);
                    for (int z = 0; z < evaluar.size(); z++) {
                        if (maximoE < evaluar.get(z)) {
                            maximoE = evaluar.get(z);
                        }
                    }
                    maximo.add(maximoE);
                }
                System.out.println(maximo);
            } else
                System.out.println("Error en la procedencia del archivo");
            // se encarga de crear el arrayList que contendra el valor promedio de cada
            // columna
            ArrayList<Double> promedios = new ArrayList<>();
            if (columnas.size() != 0) {
                for (ArrayList<Integer> evaluar : columnas) {
                    double suma = 0;
                    for (Integer y : evaluar) {
                        suma += y;
                    }
                    double promedio = suma / numColumnas;
                    promedios.add(promedio);
                }
                System.out.println(promedios);
            } else
                System.out.println("Error en la procedencia del archivo");
            // se encarga de crear el arrayList que contendra la desviación estandar de cada
            // columna
            ArrayList<Double> numerador = new ArrayList<>();
            if (columnas.size() != 0) {
                ArrayList<Float> medias = new ArrayList<>();
                for (ArrayList<Integer> integer : columnas) {
                    float desS = 0;
                    for (Integer integer2 : integer) {
                        desS += integer2;
                    }
                    float media = desS / numColumnas;
                    medias.add(media);
                }
                int indexNumerador = 0;
                for (ArrayList<Integer> parte1 : columnas) {
                    float absolutoNumerador = 0;
                    for (int u = 0; u < parte1.size(); u++) {
                        absolutoNumerador += Math.pow(parte1.get(u) - medias.get(indexNumerador), 2);
                    }
                    indexNumerador++;
                    double calculo = Math.sqrt(absolutoNumerador / numColumnas);
                    numerador.add(calculo);
                }

                System.out.println(numerador);
            } else {
                System.out.println("Error en la procedencia del archivo");
            }

        } else {
            System.out.println("Asegurese de haber leido el archivo correspondiente");
        }
    }
}