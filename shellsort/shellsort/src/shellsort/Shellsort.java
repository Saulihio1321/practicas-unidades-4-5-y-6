/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shellsort;

import java.util.Scanner;

/**
 * 23550382
 * @author saul Alejandro Bermudez Arzaga
 * estructura de datos
 */
public class Shellsort {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        // Solicitar números al usuario
        System.out.println("Ingresa los números que deseas ordenar, separados por espacios (por ejemplo: 34 7 23 32 5):");
        String input = scanner.nextLine();

        // Convertir los números ingresados en un arreglo de enteros
        String[] tokens = input.split(" ");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        // Mostrar el arreglo original
        System.out.println("\nArreglo original:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Ordenar el arreglo usando Shell Sort
        shellSort(arr);

        // Mostrar el arreglo ordenado
        System.out.println("\n\nArreglo ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // Implementación del método Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Iniciar con un gap (intervalo) y reducirlo en cada iteración
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                // Realizar intercambios dentro del subarreglo
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }
}


