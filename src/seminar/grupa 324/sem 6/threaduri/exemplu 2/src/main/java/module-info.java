module com.example.seminar {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires javafx.graphics;

    opens com.example.seminar6 to javafx.fxml;
    exports com.example.seminar6;
}