public class Seminar1 {
    public static void main(String[] args)
    {
       //ex1(args);
        //ex2(args);
        //ex3_secv(args);
        //ex3_binar(args);
        //ex4(args);
        //ex5(args);
        ex6(args);
    }

    public static void ex1(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Nr. de argumente este gresit!");
            System.exit(0);
        }

        int x, y, suma;
        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);
        suma = x + y;

        System.out.println("Suma este " + suma);
    }

    public static void ex2(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Nr. de argumente este gresit!");
            System.exit(0);
        }

        int x, y;
        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);

        if (x > y)
            System.out.println("Cel mai mare nr. este " + x);
        else System.out.println("Cel mai mare nr. este " + y);
    }

    public static void ex3_secv(String[] args)
    {
        int x = Integer.parseInt(args[0]);

        Integer[] v = new Integer[args.length - 1];
        for (int i = 1; i < args.length; i++)
        {
            v[i - 1] = Integer.parseInt(args[i]);
        }

       if (cautare_secv(v, x) != -1)
       {
           System.out.println("da");
       }
       else
       {
           System.out.println("nu");
       }
    }

    public static int cautare_secv(Integer[] v, int x)
    {
        for (int i = 0; i < v.length; i++)
        {
            if (v[i] == x)
            {
                return i;
            }
        }
        return -1;
    }

    public static void ex3_binar(String[] args)
    {
        int x = Integer.parseInt(args[0]);

        Integer[] v = new Integer[args.length - 1];
        for (int i = 1; i < args.length; i++)
        {
            v[i - 1] = Integer.parseInt(args[i]);
        }

        if (cautare_binara(v, x))
        {
            System.out.println("da");
        }
        else System.out.println("nu");
    }

    public static boolean cautare_binara(Integer[] v, int x)
    {
        int mij = v.length / 2, st = 0, dr = v.length - 1;
        while (st < dr)
        {
            if (v[mij] == x)
            {
                return true;
            }
            if (v[mij] > x)
            {
                dr = mij - 1;

            }
            else
            {
                st = mij + 1;
            }
            mij = (st + dr) / 2;
        }
        return false;
    }

    public static void ex4(String[] args)
    {
        Integer[] v = new Integer[args.length];
        for (int i = 0; i < args.length; i++)
        {
            v[i] = Integer.parseInt(args[i]);
        }

        int aux;
        for (int i = 0; i < v.length - 1; i++)
        {
            for (int j = i + 1; j < v.length; j++)
            {
                if (v[i] > v[j])
                {
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }

        for (int i = 0; i < v.length; i++)
        {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static void ex5(String[] args) {
        Integer[] v = new Integer[args.length];
        for (int i = 0; i < args.length; i++) {
            v[i] = Integer.parseInt(args[i]);
        }

        int len = 1, len_max = 1, start = 0;
        for (int i = 1; i < v.length; i++)
        {
            if (v[i-1] == v[i])
            {
                len++;
            }
            else
            {
                if (len > len_max)
                {
                    len_max = len;
                    start = i - len_max;
                }
                len = 1;
            }
        }

        if (len > len_max)
        {
            len_max = len;
            start = v.length - len_max;
        }

        for (int i = start; i < start + len_max; i++)
        {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static void ex6(String[] args)
    {
        Integer[] v = new Integer[args.length];
        for (int i = 0; i < args.length; i++) {
            v[i] = Integer.parseInt(args[i]);
        }

        int len = 0, len_max = 0, start = -1;
        for (int i = 0; i < v.length; i++)
        {
            if (este_prim(v[i]))
            {
                len++;
            }
            else
            {
                if (len > len_max)
                {
                    len_max = len;
                    start = i - len_max;
                }
                len = 0;
            }
        }
        if (len > len_max)
        {
            len_max = len;
            start = v.length - len_max;
        }

        if (start == -1)
        {
            System.out.println("Nu exista o subsecventa de nr. prime");
        }
        else
        {
            for (int i = start; i < start + len_max; i++)
            {
                System.out.print(v[i] + " ");
            }
            System.out.println();
        }
    }

    public static boolean este_prim(int x)
    {
        if (x < 2)
            return false;
        if (x > 2 && x % 2 == 0)
            return false;
        for (int d = 3; d*d <= x; d+=2)
            if (x%d == 0)
                return false;
        return true;
    }
}
