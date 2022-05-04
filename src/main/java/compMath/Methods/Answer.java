package compMath.Methods;

import compMath.Math.DotStorage;

public class Answer {

    private final DotStorage solution;
    private final DotStorage preciseSolution;
    private final String name;
    
    public Answer(DotStorage solution, DotStorage preciseSolution, String name) {
        this.solution = solution;
        this.preciseSolution = preciseSolution;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public DotStorage getSolution() {
        return this.solution;
    }

    public DotStorage getPreciseSolution() {
        return this.preciseSolution;
    }

    public void showAnswer() {
        String leftAlignFormat = "| %d | %f | %f | %f |%n";

        System.out.format("+---+----------+-----------+-----------+%n");
        System.out.format("| i | xi       | yi        | yPrec     +%n");
        System.out.format("+---+----------+-----------+-----------+%n");

        for (int i = 0; i < solution.size(); i++) {
            System.out.format(leftAlignFormat, i,
                solution.getDot(i).getX(),
                solution.getDot(i).getY(),
                preciseSolution.getDot(i).getY()
            );
        }

        System.out.format("+---+----------+-----------+-----------+%n");
    }

}
