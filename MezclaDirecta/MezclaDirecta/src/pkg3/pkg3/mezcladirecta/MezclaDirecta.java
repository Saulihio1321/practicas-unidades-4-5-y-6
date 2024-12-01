/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg3.mezcladirecta;
import java.util.Scanner;

 /**
 * 23550382
 * @author saul Alejandro Bermudez Arzaga
 * estructura de datos
 */
public class MezclaDirecta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        // Solicitar la cantidad de números
        System.out.print("¿Cuántos números deseas ingresar? ");
        int n = scanner.nextInt();

        // Crear el arreglo con el tamaño especificado por el usuario
        int[] arreglo = new int[n];

        // Solicitar al usuario los números
        System.out.println("Ingresa los números:");
        for (int i = 0; i < n; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        // Imprimir el arreglo original
        System.out.println("\nEste es tu arreglo original:");
        imprimirArreglo(arreglo);

        // Ordenar el arreglo utilizando el método Merge Sort
        mergeSort(arreglo, 0, arreglo.length - 1);

        // Imprimir el arreglo ordenado
        System.out.println("\nArreglo ordenado:");
        imprimirArreglo(arreglo);

        scanner.close();
    }

    // Método que implementa el algoritmo Merge Sort
    public static void mergeSort(int[] arreglo, int izquierda, int derecha) {
        // Caso base: si izquierda es menor que derecha, el arreglo tiene al menos dos elementos
        if (izquierda < derecha) {
            // Calcular el punto medio
            int medio = izquierda + (derecha - izquierda) / 2;

            // Ordenar la mitad izquierda
            mergeSort(arreglo, izquierda, medio);

            // Ordenar la mitad derecha
            mergeSort(arreglo, medio + 1, derecha);

            // Combinar las dos mitades ordenadas
            merge(arreglo, izquierda, medio, derecha);
        }
    }

    // Método que combina (merge) dos subarreglos ordenados
    public static void merge(int[] arreglo, int izquierda, int medio, int derecha) {
        // Tamaños de los subarreglos izquierdo y derecho
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // Arreglos temporales para almacenar los elementos
        int[] arregloIzquierda = new int[n1];
        int[] arregloDerecha = new int[n2];

        // Copiar los datos a los arreglos temporales
        for (int i = 0; i < n1; i++) {
            arregloIzquierda[i] = arreglo[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            arregloDerecha[j] = arreglo[medio + 1 + j];
        }

        // Índices para recorrer los subarreglos y el arreglo original
        int i = 0, j = 0, k = izquierda;

        // Combinar los arreglos ordenados
        while (i < n1 && j < n2) {
            if (arregloIzquierda[i] <= arregloDerecha[j]) {
                arreglo[k] = arregloIzquierda[i];
                i++;
            } else {
                arreglo[k] = arregloDerecha[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes del subarreglo izquierdo, si los hay
        while (i < n1) {
            arreglo[k] = arregloIzquierda[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes del subarreglo derecho, si los hay
        while (j < n2) {
            arreglo[k] = arregloDerecha[j];
            j++;
            k++;
        }
    }

    // Método para imprimir un arreglo
    public static void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
