package compMath;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RungeKutta {

    public Answer solve(double a, double b, Function function, double y0) {

        double h = 0.1;
        double y = y0;


        Map<Double, Double> solution = new TreeMap<>();
        Map<Double, Double> preciseSolution = new TreeMap<>();

        for (double x = a; x <= b + h / 4 ; x += h) {

            solution.put(x, y);
            preciseSolution.put(x, function.applyPreciseFunction(x));

            double k1 = h * function.apply(x, y);
            double k2 = h * function.apply(x + h/2, y + k1/2);
            double k3 = h * function.apply(x + h/2, y + k2/2);
            double k4 = h * function.apply(x + h, y + k3);

            y = y + (k1 + 2 * k2 + 2 * k3 + k4) / 6;

        }

        return new Answer(solution, preciseSolution);

    }
}
