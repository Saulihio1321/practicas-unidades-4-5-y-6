package ejemploburbuja1;

import java.util.*;

/**
 * 23550382
 * @author saul Alejandro Bermudez Arzaga
 * estructura de datos
 */
public class EjemploBurbuja1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        
        System.out.println("Ingresa números para agregar a la lista. Escribe 'salir' para finalizar:");

        // Captura de datos
        while (true) {
            System.out.print("Número: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("salir")) {
                break;
            }
            
            try {
                int numero = Integer.parseInt(input);
                lista.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido o 'salir' para terminar.");
            }
        }

        // Validar que haya al menos un elemento para ordenar
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía. No hay nada que ordenar.");
        } else {
            // Ordenamiento burbuja
            bubbleSort(lista);

            // Impresión de la lista ordenada
            System.out.println("\nLista ordenada: " + lista);
        }
        scanner.close();
    }

    // Método de ordenamiento burbuja
    public static void bubbleSort(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            boolean intercambioRealizado = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    // Intercambio
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                    intercambioRealizado = true;
                }
            }
            // Si no hubo intercambios en una pasada, la lista ya está ordenada
            if (!intercambioRealizado) {
                break;
            }
        }
    }
    
}
