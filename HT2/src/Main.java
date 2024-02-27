/*Hoja de Trabajo #1
Kevin Villagrán, Carlos Alburez, Marinés García, Nery Molina
MAIN
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        ICalculator calculator = new Calculator(); //Crea nuevo objeto de la clase Calculator

        try {
            ArrayList<String> lines = calculator.read("datos.txt"); // Lectura del archivo "datos.txt" y almacenamiento en una lista

            for (String line : lines) {
                System.out.println("Expresion: " + line);
                ArrayList<String> elements = new ArrayList<>(Arrays.asList(line.split(" "))); //Escribe  las operaciones en una lista
                int result = calculator.solve(elements); //Llama al método Solve con los elementos del Array
                System.out.println("Resultado: " + result); //Da el resultado de la operación dada
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
