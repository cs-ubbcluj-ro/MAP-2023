package seminar.grupa321;

/*
    1. Sortam numerele transmise programului la linia de comanda. Daca programul e pornit fara parametri, citim numerele
    de la tastatura.
    2. Afisam numerele prime transmise programului la linia de comanda. Daca programul e pornit fara parametri, citim numerele
    de la tastatura.
    3. Facem un meniu ca sa alegem intre 1 si 2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seminar1 {

    /**
     * Citeste numere intregi de la consola pana la citirea lui 'stop'. Intrarile care nu sunt numere intregi sunt ignorate
     *
     * @return Lista de numere intregi
     */
    private static List<Integer> readConsole() {
        List<Integer> numere = new ArrayList<Integer>();
        Scanner cons = new Scanner(System.in);
        System.out.println("Introduceti numere intregi. Stop pentru oprire.");

        while (cons.hasNext()) {
            String token = cons.next();

            if ("stop".equals(token)) {
                break;
            }

            try {
                numere.add(Integer.parseInt(token));
            } catch (NumberFormatException nfe) {

            }
        }
        return numere;
    }

    private static void sort(List<Integer> numbers) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    sorted = false;
                    int aux = numbers.get(i);
                    numbers.set(i, numbers.get(i + 1));
                    numbers.set(i + 1, aux);
                }
            }
        }

    }

    private static List<Integer> transformToInt(String[] params) {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < params.length; i++) {
            try {
                numberList.add(Integer.parseInt(params[i]));
            } catch (NumberFormatException nfe) {
                // Ignoram exceptia, desi de regula nu este o idee buna :)
            }
        }

        return numberList;
    }

    public static void main(String[] args) {

        // 1. Obtinem numerele
        List<Integer> numere;
        if (args.length > 0) {
            numere = transformToInt(args);
        } else {
            numere = readConsole();
        }

        // 2. Sortam lista
        sort(numere);

        // 3. Le afisam
        for (int x : numere) {
            System.out.println(x);
        }
//        System.out.println(numere.toString());
    }
}
