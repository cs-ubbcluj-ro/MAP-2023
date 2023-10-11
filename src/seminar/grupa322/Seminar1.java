package seminar.grupa322;

abstract class Expression {

    protected static int expressionCount = 0;

    public Expression() {
//        expressionCount += 1;
        Expression.expressionCount += 1;
    }

    public static int getExpressionCount() {
        return Expression.expressionCount;
    }

    public abstract double evaluate();

}

class Constant extends Expression {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }
}

abstract class UnaryExpression extends Expression {
    public UnaryExpression(Expression right) {
        this.right = right;
    }

    // clasa e abstracta fiindca mosteneste metoda evaluate() -- abstracta
    protected Expression right; // valoarea implicita a unei referinte este null
}

class Negate extends UnaryExpression {

    public Negate(Expression right) {
        super(right);
    }

    @Override
    public double evaluate() {
        return -right.evaluate();
    }
}

abstract class BinaryExpression extends UnaryExpression {
    protected Expression left;

    public BinaryExpression(Expression right, Expression left) {
        // apeleaza constructorul clasei de baza
        // apelul super() e primul din metoda
        super(right);
        this.left = left;
    }
}

class Adder extends BinaryExpression {
    public Adder(Expression right, Expression left) {
        super(right, left);
    }


    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class Subtractor extends BinaryExpression {
    public Subtractor(Expression right, Expression left) {
        super(right, left);
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}

public class Seminar1 {
    public static void main(String[] args) {
        // Exemplul cel mai simplu
        Expression x = new Constant(99);
        System.out.println(x.evaluate());

        Negate nope = new Negate(x);
        System.out.println(nope.evaluate());

        // Negate este un Expression, deci poate fi folosit ca parametru
        Negate yep = new Negate(nope);
        System.out.println(yep.evaluate());

        // Un exemplu mai complicat
        // -5 + (9 - 3)
        Constant five = new Constant(5);
        Negate negate = new Negate(five);

        /*
        Exemplul functioneaza ca si o implementare a sablonului de proiectare (eng. Design
        Pattern) Composite.

         */

        Constant nine = new Constant(9);
        Constant three = new Constant(3);
        Subtractor nine_three = new Subtractor(three, nine);

        Adder add = new Adder(negate, nine_three);
        System.out.println(add.evaluate());


        // Metodele statice ar trebui apelate pe baza clasei și nu a instanțelor
        System.out.println(Expression.getExpressionCount());
//        System.out.println(x.getExpressionCount());

    }
}
