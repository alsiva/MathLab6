package compMath;

import java.util.Map;

public class Answer {

    private final Map<Double, Double> solution;
    
    public Answer(Map<Double, Double> solution) {
        this.solution = solution;
    }

    public void showAnswer() {
        String leftAlignFormat = "| %d | %f | %f |%n";

        System.out.format("+---+----------+-----------+%n");
        System.out.format("| i | xi       | yi        |%n");
        System.out.format("+---+----------+-----------+%n");

        int i = 0;
        for (Double key : solution.keySet()) {
            System.out.format(leftAlignFormat, i, key, solution.get(key));
            i++;
        }

        System.out.format("+---+----------+-----------+%n");
    }

}
