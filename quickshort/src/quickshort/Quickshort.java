/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quickshort;

/**
 *23550382
 * @author saul Alejandro Bermudez Arzaga
 * estructura de datos
 */
public class Quickshort {

    /**
     * @param args the command line arguments
     */
    public static int partition(int[] array, int low, int high)  {
        // TODO code application logic here
         int pivot = array[high]; // Elegimos el último elemento como pivote
        int i = low - 1; // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (array[j] <= pivot) {
                i++;
                // Intercambiamos array[i] y array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambiamos el pivote con el elemento en i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Retornamos el índice del pivote
    }

    // Método principal de QuickSort
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Encontramos el índice del pivote
            int pivotIndex = partition(array, low, high);

            // Ordenamos los elementos antes y después del pivote
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5}; // Array a ordenar

        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // Llamamos al método QuickSort
        quickSort(array, 0, array.length - 1);

        System.out.println("\n\nArray ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
    
}
