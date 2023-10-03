package lecture.lecture1;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Salut lume!");
        System.out.println("Avem " + args.length + " parametri in linia de comanda");

        int result = 0;

        for (int i = 0; i < args.length; i++) {
//            System.out.print(args[i]);
            try {
                result += Integer.parseInt(args[i]);
            } catch (NumberFormatException nfe) {
                System.out.println("parametru nu e intreg: " + args[i]);
            }
        }

        System.out.println("Suma parametrilor: " + result);

    }

}
