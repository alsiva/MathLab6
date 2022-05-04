package compMath;

import compMath.Math.DotStorage;
import compMath.Methods.Answer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;

public class Graph extends Application implements Runnable {

    private static List<Answer> answers;
    private static DotStorage dotStorage;
    private static DotStorage preciseSolution;

    public void setData(List<Answer> answers, DotStorage dotStorage, DotStorage preciseSolution) {
        Graph.answers = answers;
        Graph.dotStorage = dotStorage;
        Graph.preciseSolution = preciseSolution;
    }

    @Override
    public void run() {
        launch();
    }

    @FXML
    public LineChart<Number, Number> lineChart;

    @Override
    public void start(Stage stage) throws Exception {
        lineChart = new LineChart<>(
            new NumberAxis(-dotStorage.getMaxAbs() - 0.25, dotStorage.getMaxAbs() + 0.25, 1),
            new NumberAxis(-dotStorage.getMaxAbs() - 0.25, dotStorage.getMaxAbs() + 0.25, 1)
        );
        lineChart.setCreateSymbols(true);
        Scene scene = new Scene(lineChart, 900, 600);

        for (Answer answer: answers) {
            drawDots(answer.getSolution(), answer.getName());
        }

        drawDots(preciseSolution, "Precise solution");

        stage.setScene(scene);
        stage.show();
    }

    private void drawDots(DotStorage dotStorage, String name) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        series.setName(name);
        for (int i = 0; i < dotStorage.size(); i++) {
            double x = dotStorage.getDot(i).getX();
            double y = dotStorage.getDot(i).getY();
            series.getData().add(new XYChart.Data<Number, Number>(x, y));
        }

        lineChart.getData().add(series);
    }
}
