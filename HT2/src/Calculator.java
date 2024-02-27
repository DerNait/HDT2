/*Hoja de Trabajo #1
Kevin Villagrán, Carlos Alburez, Marinés García, Nery Molina
CLASE
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Calculator implements ICalculator{

    @Override

    /**
     * @param  n1 The first number to be added upon  by the calculator
     * @param  n2 The second number which will be used in conjunction with n1
     * @return An integer value representing the addition of n1 and n2
     */
    public int add(int n1, int n2) {
        // Method add
        return n1 + n2;
    }

    @Override
    /**
     * @param  n1 The first number to be substracted upon  by the calculator
     * @param  n2 The second number which will be used in conjunction with n1
     * @return An integer value representing the substraction of n1 and n2
     */
    public int substraction(int n1, int n2) {
        //Method sub
        return n1 - n2;
    }

    @Override
    /**
     * @param  n1 The first number to be multiplied upon  by the calculator
     * @param  n2 The second number which will be used in conjunction with n1
     * @return An integer value representing the multiplication of n1 and n2
     */
    public int multiplication(int n1, int n2) {
        //Method mult
        return n1 * n2;
    }

    @Override
    /**
     * @param  n1 The first number to be divided upon  by the calculator
     * @param  n2 The second number which will be used in conjunction with n1
     * @return  A double value representing the division of n1 and n2.
     * If n2 is equal to zero an error message will appear.
     */
    public int division(int n1, int n2) throws ArithmeticException{
        // Method div
        if(n2 == 0)
        throw new ArithmeticException("Divido cero");
        return n1/n2;
    }

    @Override
    /**
     * @param  n1 The first number to be divided upon by the calculator
     * @param  n2 The second number which will be used in conjunction with n1
     * @return  A float that represents the result of the modulo operation between n1 and n2.
     *          If n2 is zero an ArithmeticException will be thrown.
     */
    public int residue(int n1, int n2) throws ArithmeticException{
        // Method residue
        if(n2==0)
        throw new ArithmeticException("Residuo cero");
        return n1 % n2;
        
    }

    @Override
    /**
     * @return  An integer representing the value of the variable
     */
    public ArrayList<String> read(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        br.close();
        return lines;
    }

    @Override
    /**
     * @return  Returns a string representation of this object.
     */
    public int solve(ArrayList<String> elements) throws IllegalArgumentException {
        IStack<Integer> stack = new StackWithVector<>(50);
        int operandCount = 0;
        int operatorCount = 0;

        for (String element : elements) {
            if (element.matches("-?\\d+")) { // Verifica si el elemento es un número
                stack.push(Integer.parseInt(element));
                operandCount++;
            } else {
                operatorCount++;

                if(element.matches("[a-zA-Z]+"))
                    throw new IllegalArgumentException("Caracteres no numericos/operadores, entrada no valida");

                if (operandCount - operatorCount < 1) {
                    throw new IllegalArgumentException("Más operadores que números disponibles en la expresión");
                }

                int operandB = stack.pop();
                int operandA = stack.pop();

                switch (element) {
                    case "+":
                        stack.push(add(operandA, operandB));
                        break;
                    case "-":
                        stack.push(substraction(operandA, operandB));
                        break;
                    case "*":
                        stack.push(multiplication(operandA, operandB));
                        break;
                    case "/":
                        stack.push(division(operandA, operandB));
                        break;
                    case "%":
                        stack.push(residue(operandA, operandB));
                        break;
                }
            }
        }

        if (operandCount - operatorCount != 1) {
            throw new IllegalArgumentException("Desbalance entre números y operadores en la expresión");
        }

        return stack.peek();
    }
}
