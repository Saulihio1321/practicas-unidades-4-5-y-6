/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplobusquedasecuencial;

/**
 * 23550382
 * @author saul Alejandro Bermudez Arzaga
 * estructura de datos
 */
public class BusquedaSecuencial {

    public static int busquedaSecuencial(int[] arreglo, int numero) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == numero) {
                return i; 

            }
        }
        return -1; 
    }
}
