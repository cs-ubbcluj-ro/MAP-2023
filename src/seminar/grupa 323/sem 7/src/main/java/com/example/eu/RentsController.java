package com.example.eu;

import Domain.Car;
import Domain.Rent;
import Service.CarService;
import Service.RentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class RentsController {
    @FXML
    private TextField idTextField;

    @FXML
    private DatePicker endDateDatePicker;

    @FXML
    private ListView<Rent> rentsListView;

    @FXML
    private Button addRentButton;

    @FXML
    private DatePicker startDateDatePicker;


    @FXML
    private ChoiceBox<Integer> carIdChoiceBox;

    RentService rentService;

    CarService carService;

    ObservableList<Rent> rents;

    RentsController(RentService rentService, CarService carService) {
        this.rentService = rentService;
        this.carService = carService;
    }

    public void initialize() {
        rents = FXCollections.observableArrayList(rentService.getAll());
        rentsListView.setItems(rents);

        Collection<Car> cars = carService.getAll();
        List<Integer> carIds = new ArrayList<>();
        for (Car c: cars) {
            carIds.add(c.getId());
        }
        ObservableList<Integer> carIdsObservableList = FXCollections.observableArrayList(carIds);
        carIdChoiceBox.setItems(carIdsObservableList);
    }

    @FXML
    void onAddRenBtnClicked(MouseEvent event) {
        try {
            int id = Integer.parseInt(idTextField.getText());
            int carId = carIdChoiceBox.getValue();
            Date startDate = fromLocalDateToDate(startDateDatePicker.getValue());
            Date endDate = fromLocalDateToDate(endDateDatePicker.getValue());
            rentService.add(id, carId, startDate, endDate);
            rents.setAll(rentService.getAll());
        } catch (Exception e) {
            Alert errorPopUp = new Alert(Alert.AlertType.ERROR);
            errorPopUp.setTitle("Error");
            errorPopUp.setContentText(e.getMessage());
            errorPopUp.show();
        }
    }

    private Date fromLocalDateToDate(LocalDate localDate) {
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        return Date.from(instant);
    }
}
