package com.example.eu;

import Service.CarService;
import Service.RentService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button carsButton;

    @FXML
    private Button rentsButton;

    private CarService carService;

    private RentService rentService;

    public MainController(CarService carService, RentService rentService) {
        this.carService = carService;
        this.rentService = rentService;
    }

    @FXML
    void onCarsBtnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cars-view.fxml"));
        CarsController hc = new CarsController(carService);
        loader.setController(hc);

        Stage stage = new Stage();

        Scene scene = new Scene(loader.load(), 700, 500);
        stage.setTitle("Cars");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void onRentsBtnClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rents-view.fxml"));
        RentsController hc = new RentsController(rentService, carService);
        loader.setController(hc);

        Stage stage = new Stage();

        Scene scene = new Scene(loader.load(), 700, 500);
        stage.setTitle("Rents");
        stage.setScene(scene);
        stage.show();
    }
}
