package compMath.Methods;

import compMath.Math.Dot;
import compMath.Math.DotStorage;
import compMath.Math.Function;


public class AdamsMethod implements Method {

    public Answer solve(double a, double b, Function function, double y0, double h) {


        int n = (int)((b - a) / h);
        double b0 = Math.min(b, a + 3 * h);

        Answer rungeKuttaAnswer = new RungeKutta().solve(a, b0, function, y0, h);
        DotStorage dots = rungeKuttaAnswer.getSolution();
        DotStorage preciseSolution = rungeKuttaAnswer.getPreciseSolution();



        for (int i = 4; i <= n; i++) {

            //Solution
            double df = function.apply(dots.getDot(i - 1).getX(), dots.getDot(i - 1).getY())
                - function.apply(dots.getDot(i-2).getX(), dots.getDot(i-2).getY());

            double d2f = function.apply(dots.getDot(i-1).getX(), dots.getDot(i-1).getY())
                -2 * function.apply(dots.getDot(i-2).getX(), dots.getDot(i-2).getY())
                + function.apply(dots.getDot(i-3).getX(), dots.getDot(i-3).getY());

            double d3f = function.apply(dots.getDot(i-1).getX(), dots.getDot(i-1).getY())
                -3 * function.apply(dots.getDot(i-2).getX(), dots.getDot(i-2).getY())
                +3 * function.apply(dots.getDot(i-3).getX(), dots.getDot(i-3).getY())
                -function.apply(dots.getDot(i-4).getX(), dots.getDot(i-4).getY());

            dots.addDot(new Dot(
                dots.getDot(i-1).getX() + h,
                dots.getDot(i-1).getY()
                + h * function.apply(dots.getDot(i-1).getX(), dots.getDot(i-1).getY())
                + (Math.pow(h, 2) * df / 2 + 5 * Math.pow(h, 3) * d2f / 12 + 3 * Math.pow(h, 4) * d3f / 8)
            ));

            //PreciseSolution
            preciseSolution.addDot(new Dot(
                dots.getDot(i-1).getX() + h,
                function.applyPreciseFunction(dots.getDot(i-1).getX() + h)
            ));
        }


        return new Answer(dots, preciseSolution, "Метод Адама");
    }
}
