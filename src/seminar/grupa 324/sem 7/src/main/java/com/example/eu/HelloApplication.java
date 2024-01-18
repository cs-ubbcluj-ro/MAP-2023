package com.example.eu;

import Domain.Car;
import Domain.Rent;
import Repository.GeneralTextFileRepository;
import Repository.IRepository;
import Repository.MemoryRepository;
import Service.CarService;
import Service.RentService;
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
        IRepository<Car> carsRepo = new GeneralTextFileRepository<>("cars.txt", "Domain.Car");
        CarService carService = new CarService(carsRepo);

        IRepository<Rent> rentsRepo = new GeneralTextFileRepository<>("rents.txt", "Domain.Rent");
        RentService rentService = new RentService(rentsRepo);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        MainController hc = new MainController(carService, rentService);
        loader.setController(hc);

        Scene scene = new Scene(loader.load(), 700, 500);
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}