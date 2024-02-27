/*Hoja de Trabajo #1
Kevin Villagrán, Carlos Alburez, Marinés García, Nery Molina
CLASE TEST
 */

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class CalculatorTest {

    ICalculator calcu = new Calculator();
    @Test
    /**
     * Test para suma: Funciona
     */
    public void testAdd() {
        int n1 = 3;
        int n2 = 4;
        assertEquals(7, calcu.add(n1, n2),0);
    }

    @Test
    /**
     * Test para división: Funciona
     */
    public void testDivision() throws Exception {
        int n1 = 4;
        int n2 = 2;
        assertEquals(2, calcu.division(n1, n2),0);
    }

    @Test
    /**
     * Test para multiplicación: Funciona
     */
    public void testMultiplication() {
        int n1 = 6;
        int n2 = 3;
        assertEquals(18, calcu.multiplication(n1, n2),0);
    }

    @Test
    /**
     * Test para Read: Funciona
     * @throws Exception  si hay error en la lectura
     */
    public void testRead() throws Exception {
        ArrayList<String> readArray = new ArrayList<String>();
        assertEquals("Algo", calcu.read("Algo").get(0));
    }

    @Test
    /**
     * Test para residuo: Funciona
     * @throws Exception  Si no se puede escribir el archivo
     */
    public void testResidue() throws Exception {
        int n1 = 15;
        int n2 = 4;
        assertEquals(3, calcu.residue(n1, n2),0);
    }

    @Test
    /**
     * Test para Solve: Funciona
     * @throws Exception  Si falla la escritura del archivo
     */
    public void testSolve() throws Exception {
        String line = "1 2 + 4 * 3 +";
        ArrayList<String> readArray = new ArrayList<>(Arrays.asList(line.split(" ")));
        assertEquals(15, calcu.solve(readArray));
    }

    @Test
    /**
     * Test para restar: Funciona
     */
    public void testSubstraction() {
        int n1 = 3;
        int n2 = 4;
        assertEquals(-1, calcu.substraction(n1, n2),0);
    }
    
}
