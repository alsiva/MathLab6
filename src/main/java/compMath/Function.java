package compMath;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Function {

    private final Expression expression;
    private final String function;

    public Function(String expr) {
        this.function = expr;
        this.expression = new ExpressionBuilder(expr).variables("x", "y").build();
    }

    public double apply(double x, double y) {
        return expression.setVariable("x", x).setVariable("y", y).evaluate();
    }

    @Override
    public String toString() {
        return this.function;
    }

}
