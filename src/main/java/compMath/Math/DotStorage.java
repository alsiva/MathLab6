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

}
