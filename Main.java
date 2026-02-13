import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--------------------------");
            System.out.println("   MENÚ DE OPERACIONES");
            System.out.println("--------------------------");
            System.out.println("1. Invertir una cadena usando una pila");
            System.out.println("2. Comprobar sintaxis de apertura y cierre");
            System.out.println("3. Ordenar vector de nümeros");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Por favor ingresa un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.println("\nIngresa una cadena:");
                    String cadena = scanner.nextLine();
                    System.out.println(invierteCadena(cadena));
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.println("Ingresa la cadena de aperturas y cierres:");
                    String aperturas = scanner.nextLine();
                    System.out.println("El resultado de la revision ha sido: "+revisarSintaxis(aperturas));
                    break;

                case 3:


                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 10);

        scanner.close();
    }

    public static String invierteCadena(String cadena) {
       String cadenaInvertida = "";
       Pila<Character> pila = new Pila<>(cadena.length());

       for(int i=0; i<cadena.length(); i++) {
           pila.push(cadena.charAt(i));
       }
       while(!pila.pilaVacia()) {
           cadenaInvertida += pila.pop().toString();
       }

        return cadenaInvertida;
    }

    public static boolean revisarSintaxis(String cadena) {
        Pila<Character> p = new Pila<>(cadena.length());

        for (int i = 0; i < cadena.length(); i++) {
            char actual = cadena.charAt(i);

            if (actual == '{' || actual == '[' || actual == '(') {
                p.push(actual);
            }
            else if (actual == '}' || actual == ']' || actual == ')') {

                if (p.pilaVacia()) {
                    System.out.println("Error, hay in símbolo de cierre " + actual + "' sin apertura.");
                    return false;
                }

                char apertura = p.pop();

                if (!esPar(apertura, actual)) {
                    System.out.println("Error, n hay concordancia entre " + apertura + "' y '" + actual + "'.");
                    return false;
                }
            }
        }

        if (!p.pilaVacia()) {
            System.out.println("Error, quedaron elementos abiertos sin cerrar.");
            return false;
        }

        return true;
    }

    // Método para verificar los pares y no sobrecargar tanto el
    // metodo de revisar sintaxis.
    private static boolean esPar(char abre, char cierre) {
        return (abre == '(' && cierre == ')') ||
                (abre == '[' && cierre == ']') ||
                (abre == '{' && cierre == '}');
    }

    public Pila<Integer> ordenarVector(int[] vector) {
        Pila<Integer> pilaOrdenada = new Pila<>(vector.length);

        Pila<Integer> pilaAux = new Pila<>(vector.length);

        for (int num : vector) {
            pilaAux.push(num);
        }

        while (!pilaAux.pilaVacia()) {
            int temp = pilaAux.pop();

            while (!pilaOrdenada.pilaVacia()) {
                int topeOrdenado = pilaOrdenada.pop();

                if (topeOrdenado > temp) {
                    pilaAux.push(topeOrdenado);
                } else {
                    pilaOrdenada.push(topeOrdenado);
                    break;
                }
            }

            pilaOrdenada.push(temp);
        }

        return pilaOrdenada;
    }
}