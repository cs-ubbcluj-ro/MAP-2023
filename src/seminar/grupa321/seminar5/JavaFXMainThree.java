package seminar.grupa321.seminar5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

class Student {
    private final String name;
    private final int average;

    public Student(String name, int average) {
        this.name = name;
        this.average = average;
    }

    @Override
    public String toString() {
        return name + " - " + average;
    }
}

public class JavaFXMainThree extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("List application");
        HBox hLayout = new HBox();

        Student s1 = new Student("Ana", 9);
        Student s2 = new Student("John", 8);
        ObservableList<Student> studentData = FXCollections.observableArrayList(s1, s2);
        ListView<Student> studentsList = new ListView<>(studentData);

        hLayout.getChildren().add(studentsList);

        VBox vLayout = new VBox();

        GridPane gridP = new GridPane();
        Label nameLabel = new Label("Name");
        TextField nameText = new TextField();
        Text avgLabel = new Text("Average");
        TextField avgText = new TextField();
        gridP.add(nameLabel, 0, 0);
        gridP.add(nameText, 1, 0);
        gridP.add(avgLabel, 0, 1);
        gridP.add(avgText, 1, 1);
        vLayout.getChildren().add(gridP);

        Button addButton = new Button("Add");
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String name = nameText.getText();
                Integer average = Integer.parseInt(avgText.getText());
                Student s = new Student(name, average);
                studentData.add(s);
            }
        });
        vLayout.getChildren().add(addButton);

        hLayout.getChildren().add(vLayout);

        Scene scene = new Scene(hLayout, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}