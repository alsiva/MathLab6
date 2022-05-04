package compMath;

import java.util.HashMap;
import java.util.Map;

public class RungeKutta {

    public Answer solve(double a, double b, Function function, double y0) {

        double h = 0.1;
        double y = y0;


        Map<Double, Double> solution = new HashMap<>();


        for (double x = a; x <= b; x += h) {

            solution.put(x, y);

            double k1 = h * function.apply(x, y);
            double k2 = h * function.apply(x + h/2, y + k1/2);
            double k3 = h * function.apply(x + h/2, y + k2/2);
            double k4 = h * function.apply(x + h, y + k3);

            y = y + (1.0 / 6.0) * (k1 + k2 + k3 + k4);

        }

        return new Answer(solution);

    }
}
