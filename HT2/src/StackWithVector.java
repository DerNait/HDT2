/*Hoja de Trabajo #1
Kevin Villagrán, Carlos Alburez, Marinés García, Nery Molina
MAIN VECTOR
 */

import java.util.EmptyStackException;
import java.util.Vector;

public class StackWithVector<T> implements IStack<T> {

    private int index;
    Vector<T> internalVector;

    /**
     * @param qty
     */
    public StackWithVector(int qty){
        index = 0;
        internalVector = new Vector<T>(qty);
    }

    @Override
    /**
     * @return  entero con cantidad de elementos en pila
     */
    public int count() {
        return internalVector.size();
    }

    @Override
    /**
     * @return  verdadero si está vacia y falso de lo contrario
     */
    public boolean isEmpty() {
        return internalVector.isEmpty();
    }

    @Override
    /**
     * @param  value a insertar en la pila
     */
    public void push(T value) {
        
            internalVector.add(value);
        
    }

    @Override
    /**
     * @return   the top element of the stack (extract it), or throws an EmptyStackException if the stack is empty
     */
    public T pop() {
        if (internalVector.size() > 0) {
            T tempValue = internalVector.remove(internalVector.size() - 1);
            return tempValue;
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    /**
     * @return  the top element of the stack (just view it), or throws an EmptyStackException if the stack is empty
     */
    public T peek() {
        T tempValue = null;
        if (internalVector.size() > 0){
            tempValue = internalVector.get(internalVector.size() - 1);
        }
        return tempValue;
    }
    
}
