package com.example.eu;

import Domain.Car;
import Repository.DuplicateEntityException;
import Repository.IRepository;
import Repository.MemoryRepository;
import Service.CarService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    TextField idTextField = new TextField();
    TextField modelTextField = new TextField();

    @Override
    public void start(Stage stage) throws IOException {
        IRepository<Car> carRepo = new MemoryRepository<>();
        CarService carService = new CarService(carRepo);
        try {
            carService.add(1, "BMW");
            carService.add(2, "Opel");
            carService.add(3, "Ford");
        } catch (DuplicateEntityException e) {
            throw new RuntimeException(e);
        }

        VBox mainVerticalBox = new VBox();
        mainVerticalBox.setPadding(new Insets(10));

        ObservableList<Car> cars = FXCollections.observableArrayList(carService.getAll());
        ListView<Car> listView = new ListView<Car>(cars);
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Car car = listView.getSelectionModel().getSelectedItem();
                idTextField.setText(Integer.toString(car.getId()));
                modelTextField.setText(car.getModel());
            }
        });
        mainVerticalBox.getChildren().add(listView);

        GridPane carsGridPane = new GridPane();

        Label idLabel = new Label();
        idLabel.setText("Id: ");
        idLabel.setPadding(new Insets(10, 5, 10, 0));

        Label modelLabel = new Label();
        modelLabel.setText("Model:");
        modelLabel.setPadding(new Insets(10, 5, 10, 0));

        carsGridPane.add(idLabel, 0, 0);
        carsGridPane.add(idTextField, 1 , 0);
        carsGridPane.add(modelLabel, 0, 1);
        carsGridPane.add(modelTextField, 1, 1);
        mainVerticalBox.getChildren().add(carsGridPane);

        HBox buttonsHorizontalBox = new HBox();
        mainVerticalBox.getChildren().add(buttonsHorizontalBox);

        Button addButton = new Button("Add car");
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    int id = Integer.parseInt(idTextField.getText());
                    String model = modelTextField.getText();
                    carService.add(id, model);
                    cars.setAll(carService.getAll());
                } catch (Exception e) {
                    Alert errorPopUp = new Alert(Alert.AlertType.ERROR);
                    errorPopUp.setTitle("Error");
                    errorPopUp.setContentText(e.getMessage());
                    errorPopUp.show();
                }
            }
        });
        buttonsHorizontalBox.getChildren().add(addButton);

        Button updateButton = new Button("Update car");
        updateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    int id = Integer.parseInt(idTextField.getText());
                    String model = modelTextField.getText();
                    carService.update(id, model);
                    cars.setAll(carService.getAll());
                } catch (Exception e) {
                    Alert errorPopUp = new Alert(Alert.AlertType.ERROR);
                    errorPopUp.setTitle("Error");
                    errorPopUp.setContentText(e.getMessage());
                    errorPopUp.show();
                }
            }
        });
        buttonsHorizontalBox.getChildren().add(updateButton);

        Button deleteButton = new Button("Delete car");
        deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    int id = Integer.parseInt(idTextField.getText());
                    carService.remove(id);
                    cars.setAll(carService.getAll());
                } catch (Exception e) {
                    Alert errorPopUp = new Alert(Alert.AlertType.ERROR);
                    errorPopUp.setTitle("Error");
                    errorPopUp.setContentText(e.getMessage());
                    errorPopUp.show();
                }
            }
        });
        buttonsHorizontalBox.getChildren().add(deleteButton);

        Scene scene = new Scene(mainVerticalBox, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}