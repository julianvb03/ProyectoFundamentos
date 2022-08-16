import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

/**
 * esta clase ses el menu de interaccion con el usuario
 * se hace un switch con las opciones dentro de un do while
 * para que el programa no se acabe después de escoger solo 1 opcion
 * cada opcion llama a un metodo de crearDF que hace lo que el
 * usuario le pida.
 */
public class Principal {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int option;
        boolean controler = true;
        CrearDF madres = new CrearDF();
        CrearDF hijos = new CrearDF();
        do {
            System.out.println("0. Finalizar programa");
            System.out.println("1. Leer archivo de madres");
            System.out.println("2. Imprimir archivo de madres");
            System.out.println("3. Leer archivo de hijos");
            System.out.println("4. Imprimir archivo de hijos");
            System.out.println("5. Buscar madre con mayor número de hijos");
            System.out.println("6. Buscar hijo con menor estatura");
            System.out.println("7. Aplica el metodo describe al archivo de hijos");
            System.out.println("8. Aplica el metodo describe al archivo de hijos madres");
            System.out.println();
            System.out.println("Por favor digite su opción");
            try {
                option = sc.nextInt();
                switch (option) {
                    case 0:
                        controler = false;
                        System.out.println("Programa finalizado");
                        break;
                    case 1:
                        try {
                            // en la instacia madres manda la dirección del archivo o su nombre dependiendo
                            // el caso, del directorio que va a leer
                            madres.CrearDataFrame("madres");
                            System.out.println("Archivo leido satisfactoriamente");
                        }
                        // catch por si no se encuentra el archivo solicitado
                        catch (FileNotFoundException error20) {
                            System.out.println("Error en la lectura de fichero");
                        }
                        System.out.println();
                        break;
                    case 2:
                        try {
                            madres.imprimir();
                            System.out.println();
                        } catch (Exception e) {
                            System.out.println("Archivo no encontrado");
                            System.out.println();
                        }

                        break;
                    case 3:
                        try {
                            // en la instacia hijos manda la dirección del archivo o su nombre dependiendo
                            // el caso, del directorio que va a leer
                            hijos.CrearDataFrame("hijos");
                            System.out.println("Archivo leido satisfactoriamente");
                        }
                        // catch por si no se encuentra el archivo solicitado
                        catch (FileNotFoundException error20) {
                            System.out.println("Error en la lectura de fichero");
                        }
                        System.out.println();
                        break;
                    case 4:
                        try {
                            hijos.imprimir();
                            System.out.println();
                        } catch (Exception e) {
                            System.out.println("Archivo no encontrado");
                            System.out.println();
                        }
                        break;
                    case 5:
                        hijos.numeroHijos();
                        System.out.println();
                        break;
                    case 6:
                        hijos.menorEstatura();
                        System.out.println();
                        break;
                    case 7:
                        hijos.describe();
                        System.out.println();
                        break;
                    case 8:
                        madres.describe();
                        System.out.println();
                        break;
                    default:
                        System.out.println("Digite un número en el rango");
                        System.out.println();
                }
            } catch (InputMismatchException error1) {
                System.out.println("Digite una opción valida");
                System.out.println();
                sc.next();
                sc.close();
            }
        } while (controler);
    }
}