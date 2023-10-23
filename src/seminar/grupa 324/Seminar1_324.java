public class Seminar1_324 {
    static abstract class Expresie {
        abstract double evalueaza();
    }

    static class Constanta extends Expresie {
        private double valoare;

        Constanta(double valoare) {
            this.valoare = valoare;
        }

        @Override
        double evalueaza() {
            return valoare;
        }
    }

    static class ExpresieUnara extends Expresie {
        protected Expresie expresie;

        ExpresieUnara(Expresie e) {
            this.expresie = e;
        }

        @Override
        double evalueaza() {
            return expresie.evalueaza();
        }
    }

    static class Negare extends ExpresieUnara {
        Negare(Expresie expresie) {
            super(expresie);
        }

        @Override
        double evalueaza() {
            return -expresie.evalueaza();
        }
    }

    abstract static class ExpresieBinara extends Expresie {
        protected Expresie expresieStanga, expresieDreapta;

        ExpresieBinara(Expresie expresieStanga, Expresie expresieDreapta)
        {
            this.expresieStanga = expresieStanga;
            this.expresieDreapta = expresieDreapta;
        }
    }

    static class Adaugare extends ExpresieBinara {
        Adaugare(Expresie expresieStanga, Expresie expresieDreapta) {
            super(expresieStanga, expresieDreapta);
        }

        @Override
        double evalueaza() {
            return expresieStanga.evalueaza() + expresieDreapta.evalueaza();
        }
    }

    static class Scadere extends ExpresieBinara {
        Scadere(Expresie expresieStanga, Expresie expresieDreapta) {
            super(expresieStanga, expresieDreapta);
        }

        @Override
        double evalueaza() {
            return expresieStanga.evalueaza() - expresieDreapta.evalueaza();
        }
    }

    public static void main(String[] args) {
        Expresie e1 = new Constanta(2);
        System.out.println(e1.evalueaza());

        Expresie unara1 = new ExpresieUnara(e1);
        System.out.println(unara1.evalueaza());

        Negare negare1 = new Negare(unara1);
        System.out.println(negare1.evalueaza());
        Negare negare2 = new Negare(negare1);
        System.out.println(negare2.evalueaza());

        // 3 + 4
        Constanta trei = new Constanta(3);
        Constanta patru = new Constanta(4);
        Adaugare a1 = new Adaugare(trei, patru);
        System.out.println(a1.evalueaza());

        // 10 - (3 + 4)
        Constanta zece = new Constanta(10);
        Scadere s1 = new Scadere(zece, a1);
        System.out.println(s1.evalueaza());
    }
}
