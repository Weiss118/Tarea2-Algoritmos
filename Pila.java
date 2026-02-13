public class Pila <T>{

    private T[] pila;
    private int tope;

    public Pila(int tamano) {
        pila = (T[]) new Object[tamano];
        tope = -1;
    }

    public Pila() {
        pila = (T[]) new Object[10];
        tope = -1;
    }

    public void push(T dato) {
            if(pilaLlena()) {
                System.out.println("Desbordamiento");
        } else {
                tope++;
                pila[tope] = dato;
            }
    }

    public T pop() {
        T dato = null;
        if(pilaVacia()) {
            System.out.println("Subdesbordamiento");
        } else {
            dato = pila[tope];
            tope--;
        }
        return dato;
    }

    public boolean pilaVacia() {
        return tope == -1;
    }

    public boolean pilaLlena() {
        return pila.length - 1 == tope;
    }

    public int getTamaño() {
        return pila.length;
    }
}
