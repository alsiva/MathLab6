package compMath.Math;

import java.util.List;

public class DotStorage {

    private final List<Dot> DOTS;

    public DotStorage(List<Dot> DOTS) {
        this.DOTS = DOTS;
    }

    public void addDot(Dot dot) {
        DOTS.add(dot);
    }

    public int size() {
        return DOTS.size();
    }

    public Dot getDot(int index) {
        return DOTS.get(index);
    }


    public double getMaxAbs() {
        double max = -Double.MAX_VALUE;

        for (Dot dot : DOTS) {
            double absValue = Math.max(Math.abs(dot.getX()), Math.abs(dot.getY()));
            if (max < absValue) {
                max = absValue;
            }
        }

        return max;
    }

}
