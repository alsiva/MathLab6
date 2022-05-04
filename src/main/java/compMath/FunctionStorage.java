package compMath;

import java.util.Arrays;
import java.util.List;

public class FunctionStorage {

    private static final List<Function> FUNCTIONS = Arrays.asList(
        new Function("y+(1+x)*(y^2)"),
        new Function("(x^2)-(2*y)")
    );

    public static void writeFunctionsChoice() {
        System.out.println("Choose the function from 1 to " + FUNCTIONS.size());

        for (int i = 0; i < FUNCTIONS.size(); i++) {
            System.out.println("[" + (i+1) + "]: " + FUNCTIONS.get(i).toString());
        }
    }

    public static Function chooseFunction(int index) {
        return FUNCTIONS.get(index);
    }
}