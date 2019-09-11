// los datos ingresaran al programa usando la entrada estandar
// y los resultados seran impresos en la salida estandar
// por ejemplo:

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }
    }
}
