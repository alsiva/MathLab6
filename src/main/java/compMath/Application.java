package compMath;

import compMath.Math.FunctionStorage;
import compMath.Methods.AdamsMethod;
import compMath.Methods.Answer;
import compMath.Methods.RungeKutta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Application {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        /*
        FunctionStorage.writeFunctionsChoice();

        int index = readIndex();

        Function function = FunctionStorage.chooseFunction(index - 1);

        double a = readDouble("Write a: ");
        double b = readDouble("Write b: ");

        */

        RungeKutta rungeKutta = new RungeKutta();
        AdamsMethod adamsMethod = new AdamsMethod();

        Answer rungeAnswer = rungeKutta.solve(1, 1.5, FunctionStorage.chooseFunction(0), -1);
        System.out.println("Runge-Kutta method");
        rungeAnswer.showAnswer();
        System.out.println("");

        Answer adamsAnswer = adamsMethod.solve(1, 1.5, FunctionStorage.chooseFunction(0), -1);
        System.out.println("Adams method");
        adamsAnswer.showAnswer();
        System.out.println("");

    }

    private static int readIndex() {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                System.err.println("Couldn't read index");
            }
        }
    }

    private static double readDouble(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Double.parseDouble(reader.readLine());
            } catch (IOException e) {
                System.err.println("Failed to read variable");
            }
        }
    }

}
