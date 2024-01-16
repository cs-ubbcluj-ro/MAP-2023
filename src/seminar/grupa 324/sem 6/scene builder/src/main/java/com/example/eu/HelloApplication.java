package com.example.eu;

import Domain.Car;
import Repository.DuplicateEntityException;
import Repository.GeneralTextFileRepository;
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
    @Override
    public void start(Stage stage) throws IOException {
        IRepository<Car> carRepository = new GeneralTextFileRepository<>("cars.txt","Domain.Car");
//        IRepository<Car> carRepository = new MemoryRepository<>();
        CarService carService = new CarService(carRepository);
//        try {
//            carService.add(1, "BMW");
//            carService.add(2, "Dacia");
//            carService.add(3, "Opel");
//        } catch (DuplicateEntityException e) {
//            throw new RuntimeException(e);
//        }

        VBox mainVerticalBox = new VBox();
        mainVerticalBox.setPadding(new Insets(10));

        ListView<Car> carsListView = new ListView<>();
        ObservableList<Car> cars = FXCollections.observableArrayList (carService.getAll());
        carsListView.setItems(cars);
        mainVerticalBox.getChildren().add(carsListView);

        GridPane carsGridPane = new GridPane();
        carsGridPane.setPadding(new Insets(10,0,0,0));
        Label idLabel = new Label("Id");
        idLabel.setPadding(new Insets(0,10,0,0));
        TextField carIdTextField = new TextField();
        Label modelLabel = new Label("Model");
        modelLabel.setPadding(new Insets(0,10,0,0));
        TextField carModelTextField = new TextField();
        carsGridPane.add(idLabel,0,0);
        carsGridPane.add(carIdTextField,1,0);
        carsGridPane.add(modelLabel,0,1);
        carsGridPane.add(carModelTextField,1,1);
        mainVerticalBox.getChildren().add(carsGridPane);

        HBox carsActionsHorizontalBox = new HBox();
        carsActionsHorizontalBox.setPadding(new Insets(10,0,0,0));
        Button addCarButton = new Button("Add");
        Button updateCarButton = new Button("Update");
        Button deleteCarButton = new Button("Delete");
        carsActionsHorizontalBox.getChildren().add(addCarButton);
        carsActionsHorizontalBox.getChildren().add(updateCarButton);
        carsActionsHorizontalBox.getChildren().add(deleteCarButton);
        mainVerticalBox.getChildren().add(carsActionsHorizontalBox);

        addCarButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    int id = Integer.parseInt(carIdTextField.getText());
                    String model = carModelTextField.getText();
                    carService.add(id, model);
                    cars.setAll(carService.getAll());
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText(e.getMessage());
                    alert.show();
                }
            }
        });

        carsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Car car = carsListView.getSelectionModel().getSelectedItem();
                if (car != null) {
                    carIdTextField.setText(Integer.toString(car.getId()));
                    carModelTextField.setText(car.getModel());
                }
            }
        });

        updateCarButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    int id = Integer.parseInt(carIdTextField.getText());
                    String model = carModelTextField.getText();
                    carService.update(id, model);
                    cars.setAll(carService.getAll());
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText(e.getMessage());
                    alert.show();
                }
            }
        });

        deleteCarButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    int id = Integer.parseInt(carIdTextField.getText());
                    carService.delete(id);
                    cars.setAll(carService.getAll());
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText(e.getMessage());
                    alert.show();
                }
            }
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        HelloController hc = new HelloController(carService);
        loader.setController(hc);

        Scene scene = new Scene(loader.load(), 320, 400);
        stage.setTitle("Cars application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}