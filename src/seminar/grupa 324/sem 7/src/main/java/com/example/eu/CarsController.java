package com.example.eu;

import Domain.Car;
import Service.CarService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class CarsController {

    @FXML
    private TextField idTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<Car> listView;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private TextField modelLabel;

    CarService carService;

    ObservableList<Car> cars;

    public CarsController(CarService carService) {
        this.carService = carService;
    }


    public void initialize() {
        cars = FXCollections.observableArrayList(carService.getAll());
        listView.setItems(cars);
    }

    @FXML
    void onAddBtnClicked(MouseEvent event) {
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

    @FXML
    void onListViewClicked(MouseEvent event) {
        Car car = listView.getSelectionModel().getSelectedItem();
        idTextField.setText(Integer.toString(car.getId()));
        modelTextField.setText(car.getModel());
    }

}