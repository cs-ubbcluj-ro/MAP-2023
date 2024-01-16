package com.example.eu;

import Domain.Car;
import Service.CarService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class HelloController {
    CarService carService;

    ObservableList<Car> cars;

    @FXML
    private ListView<Car> carsListView;


    @FXML
    private TextField carIdTextField;

    @FXML
    private TextField carModelTextField;;

    @FXML
    private Button addCarButton;

    public HelloController(CarService carService) {
        this.carService = carService;
    }

    public void initialize() {
        cars = FXCollections.observableArrayList (carService.getAll());
        carsListView.setItems(cars);
    }

    @FXML
    void onAddCarClicked(MouseEvent event) {
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


    @FXML
    void onCarListViewClicked(MouseEvent event) {
        Car car = carsListView.getSelectionModel().getSelectedItem();
        if (car != null) {
            carIdTextField.setText(Integer.toString(car.getId()));
            carModelTextField.setText(car.getModel());
        }
    }
}