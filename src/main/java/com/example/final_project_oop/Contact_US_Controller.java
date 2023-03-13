package com.example.final_project_oop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class Contact_US_Controller {
    @FXML
    private Label lbName,lbNumber,lbEmail,lbAddress,lbMessages, SubmitMessage;
    @FXML
    private TextArea taName,taNumber,taEmail,taAddress,taMessages;
    @FXML
    private Button btnSubmit, btnClose;

    public void SubmitOnAction(ActionEvent actionEvent) throws IOException {
        contactUser();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) btnSubmit.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Contact US");
        stage.setScene(scene);
        stage.show();
    }

    public void CloseOnAction(ActionEvent Event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    public void contactUser(){
        DBConnection connectNow = new DBConnection();
        Connection connectDB = connectNow.getConnection();
        String name= taName.getText();
        String number = taNumber.getText();
        String email = taEmail.getText();
        String address = taAddress.getText();
        String message = taMessages.getText();
        String insertFields = "INSERT INTO contact_us(Name, Phone_Number, Email, Address, Message) VALUES ('";
        String insertValue = name + "','" + number + "','" + email + "','" + address + "','" + message + "')";
        String insertToContactUs = insertFields + insertValue;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToContactUs);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
