package com.example.final_project_oop;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Management_Controller {
    @FXML
    private Button btn1, btn2, btn3, btn4, btn5;
    @FXML
    private BorderPane borderPane;

    @FXML
    private void onBookClick(ActionEvent event){

    }
    @FXML
    private void onDrugClick(ActionEvent event){

    }
    @FXML
    private void onCalenderClick(ActionEvent event){

    }

    public void onHomeClick(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Management.class.getResource("home.fxml"));
        borderPane.getChildren().remove(borderPane.getCenter()); ////remove existing fxml from center.
        borderPane.setCenter(fxmlLoader.load());
    }


    public void onBookClick(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Management.class.getResource("book.fxml"));
        borderPane.getChildren().remove(borderPane.getCenter()); ////remove existing fxml from center.
        borderPane.setCenter(fxmlLoader.load());
    }

    public void onDrugClick(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Management.class.getResource("pharmacy.fxml"));
        borderPane.getChildren().remove(borderPane.getCenter()); ////remove existing fxml from center.
        borderPane.setCenter(fxmlLoader.load());
    }

    public void onCalenderClick(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Management.class.getResource("calender.fxml"));
        borderPane.getChildren().remove(borderPane.getCenter()); ////remove existing fxml from center.
        borderPane.setCenter(fxmlLoader.load());
    }

    public void onProfileClick(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Management.class.getResource("profile.fxml"));
        borderPane.getChildren().remove(borderPane.getCenter()); ////remove existing fxml from center.
        borderPane.setCenter(fxmlLoader.load());
    }

    private Stage stage;
    public void onLogOutClick(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Calendar.class.getResource("Log_In.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}