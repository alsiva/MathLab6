module edu.ifmo.math {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;

    opens compMath to javafx.fxml;
    exports compMath;
}
