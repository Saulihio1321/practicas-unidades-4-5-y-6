/*
 * 23550382
 * @author saul Alejandro Bermudez Arzaga
 * estructura de datos
 */
package radix;

import java.util.Scanner;

public class Radix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el tamaño del arreglo:");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Error: El tamaño del arreglo debe ser mayor a 0.");
            return;
        }

        int[] array = new int[size];
        System.out.println("Ingrese los elementos del arreglo, uno por uno:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        Radix radixSorter = new Radix();
        radixSorter.radixSort(array);

        System.out.println("Arreglo ordenado de menor a mayor:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println(); // Salto de línea adicional al final.
    }

    private void radixSort(int[] array) {
        int max = getMax(array); // Encuentra el valor máximo para determinar el número de dígitos.

        // Ordenar utilizando cada dígito, desde el menos significativo al más significativo.
        for (int exponent = 1; max / exponent > 0; exponent *= 10) {
            countingSort(array, exponent);
        }
    }

    private void countingSort(int[] array, int exponent) {
        int size = array.length;
        int[] output = new int[size]; // Array temporal para almacenar los resultados ordenados.
        int[] count = new int[10]; // Cuenta los dígitos (0-9).

        // Contar ocurrencias de los dígitos.
        for (int i = 0; i < size; i++) {
            int digit = (array[i] / exponent) % 10;
            count[digit]++;
        }

        // Transformar `count` para que contenga las posiciones reales de los dígitos.
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo ordenado.
        for (int i = size - 1; i >= 0; i--) {
            int digit = (array[i] / exponent) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copiar el arreglo ordenado de vuelta al original.
        System.arraycopy(output, 0, array, 0, size);
    }

    private int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
