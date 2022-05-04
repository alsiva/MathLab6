package compMath;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Function {

    private final Expression expression;
    private final String function;

    private final Expression preciseExpression;
    private final String preciseFunction;

    public Function(String function, String preciseFunction) {

        this.function = function;
        this.preciseFunction = preciseFunction;

        this.expression = new ExpressionBuilder(function).variables("x", "y").build();
        this.preciseExpression = new ExpressionBuilder(preciseFunction).variable("x").build();
    }

    public double apply(double x, double y) {
        return expression.setVariable("x", x).setVariable("y", y).evaluate();
    }

    public double applyPreciseFunction(double x) {
        return preciseExpression.setVariable("x", x).evaluate();
    }

    @Override
    public String toString() {
        return this.function;
    }

}
