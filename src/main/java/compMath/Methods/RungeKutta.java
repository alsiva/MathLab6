package compMath.Methods;

import compMath.Math.Dot;
import compMath.Math.DotStorage;
import compMath.Math.Function;
import java.util.ArrayList;
import java.util.List;


public class RungeKutta implements Method {

    public Answer solve(double a, double b, Function function, double y0, double h) {


        double y = y0;


        List<Dot> solution = new ArrayList<>();
        List<Dot> preciseSolution = new ArrayList<>();

        for (double x = a; x <= b + h / 4 ; x += h) {

            solution.add(new Dot(x, y));
            preciseSolution.add(new Dot(x, function.applyPreciseFunction(x)));

            double k1 = h * function.apply(x, y);
            double k2 = h * function.apply(x + h/2, y + k1/2);
            double k3 = h * function.apply(x + h/2, y + k2/2);
            double k4 = h * function.apply(x + h, y + k3);

            y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6;

        }

        return new Answer(new DotStorage(solution), new DotStorage(preciseSolution), "Рунге-Кутта");

    }
}
