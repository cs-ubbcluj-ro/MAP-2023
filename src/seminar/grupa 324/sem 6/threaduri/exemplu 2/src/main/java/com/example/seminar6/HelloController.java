package com.example.seminar6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    @FXML
    public TextField txtNumbers;

    public ObservableList<String> listData = FXCollections.observableList(new ArrayList<>());

    @FXML
    public Button btnCalculate;
    @FXML
    public ListView<String> lstMessages;
    @FXML
    public TextField txtThreads;

    @FXML
    public void initialize() {
        lstMessages.setItems(listData);
    }

    public void btnCalculateClicked(ActionEvent actionEvent) throws InterruptedException {

        int numbers = 0;
        try {
            numbers = Integer.parseInt(txtNumbers.getText());
        } catch (NumberFormatException nfe) {
            Alert hello = new Alert(Alert.AlertType.ERROR, "Enter a valid, positive integer");
            hello.show();
            return;
        }


//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


//        Thread -- modeleaza un fir de executie
//          Runnable -- are o metoda run si o pot folosi intr-un Thread

        int threads = Integer.parseInt(txtThreads.getText());
        int finalNumbers = numbers;
        int[] numberArray = Util.generate(finalNumbers);

        Thread[] threadArray = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            int finalI = i;
            threadArray[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int total = Util.countPrimes(numberArray, finalI, threadArray.length);
                }
            });
        }
        long t1 = System.currentTimeMillis();

        for (var t : threadArray) {
            t.start();
        }

        for (var t : threadArray) {
            t.join();
        }
        long timeDelta = System.currentTimeMillis() - t1;
        listData.add("time = " + timeDelta + " miliseconds.");




    }
}