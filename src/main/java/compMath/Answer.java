package compMath;

import java.util.Map;

public class Answer {

    private final Map<Double, Double> solution;
    private final Map<Double, Double> preciseSolution;
    
    public Answer(Map<Double, Double> solution, Map<Double, Double> preciseSolution) {
        this.solution = solution;
        this.preciseSolution = preciseSolution;
    }

    public void showAnswer() {
        String leftAlignFormat = "| %d | %f | %f | %f |%n";

        System.out.format("+---+----------+-----------+-----------+%n");
        System.out.format("| i | xi       | yi        | yPrec     +%n");
        System.out.format("+---+----------+-----------+-----------+%n");

        int i = 0;
        for (Double key : solution.keySet()) {
            System.out.format(leftAlignFormat, i, key, solution.get(key), preciseSolution.get(key));
            i++;
        }

        System.out.format("+---+----------+-----------+-----------+%n");
    }

}
