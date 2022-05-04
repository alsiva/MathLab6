module edu.ifmo.math {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;

    opens compMath to javafx.fxml;
    exports compMath;
    exports compMath.Math;
    opens compMath.Math to javafx.fxml;
    exports compMath.Methods;
    opens compMath.Methods to javafx.fxml;
}
