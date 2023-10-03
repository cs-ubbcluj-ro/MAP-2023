package lecture.lecture1;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("Salut lume!");
        System.out.println("Avem " + args.length + " parametri in linia de comanda");

        String results = "";

        for (int i = 0; i < args.length; i++) {
//            System.out.print(args[i]);
            results += args[i];
        }

        System.out.println("Concatenarea parametrilor: " + results);

    }

}
