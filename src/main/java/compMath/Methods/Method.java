package compMath.Methods;

import compMath.Math.Function;

public interface Method {

    Answer solve(double a, double b, Function function, double y0);
}
