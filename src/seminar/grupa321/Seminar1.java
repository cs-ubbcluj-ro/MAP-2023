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

public class Seminar1 {

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
        List<Integer> numere = transformToInt(args);
        sort(numere);

        for (int x : numere) {
            System.out.println(x);
        }
//        System.out.println(numere.toString());
    }
}
