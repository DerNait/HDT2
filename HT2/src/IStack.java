/*Hoja de Trabajo #1
Kevin Villagrán, Carlos Alburez, Marinés García, Nery Molina
INTERPHASE
 */

public interface IStack<T>{

    /**
     * Devuelve la cantidad de elementos
     * @return un entero que devuelve la cantidad de elementos
     */
    int count();


    /**
     * Este elemento nos indica si la pila está vacia o no
     * @return  verdadero si está vacia y falso de lo contrario
     */
    boolean isEmpty();

    /**
     * @param value  es el valor del nuevo elemento a insertar en la pila
     */
    void push(T value);

    /**
     * @return  El ultimo elemento de la pila
     * Elimina el ultimo elemento de la pila, si esta vacía lanza una excepción.
     */
    T pop();

    /**
     * @return  El tope de la pila (el último elemento) sin eliminarlo. Si la pila está vacía, devuelve null.
     */
    T peek();

}