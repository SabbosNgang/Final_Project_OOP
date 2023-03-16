package com.example.final_project_oop;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
//Leang Menghangg
public class SignUpController implements Initializable {

    @FXML
    private Hyperlink back;

    @FXML
    private ImageView brandingImageView;

    @FXML
    private Button cancel_button;

    @FXML
    private Label confirmPassMessage;

    @FXML
    private PasswordField confirm_pass;

    @FXML
    private Label createdMessage;

    @FXML
    private TextField Email;

    @FXML
    private TextField fullName;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private TextField Username;
    @FXML
    private ChoiceBox<String> Sex;
    private String [] gen = {"Male","Female"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Sex.getItems().addAll(gen);
    }
    public void cancelButtonOnAction(Event event){
        Stage stage = (Stage) cancel_button.getScene().getWindow();
        stage.close();
    }
    public void registerOnAction(){
        String A = fullName.getText();
        String B = Username.getText();
        String C = Email.getText();
        String D = password.getText();
        String E = confirm_pass.getText();

        if(D.length()>=6) {

            if (password.getText().equals(confirm_pass.getText())) {

                if (A.isEmpty() || B.isEmpty() || C.isEmpty() || D.isEmpty() || E.isEmpty()) {
                    createdMessage.setText("Please kindly complete all Fields");
                } else {
                    Stage stage = (Stage) cancel_button.getScene().getWindow();
                    stage.close();
                    registerUser();
                }
                confirmPassMessage.setText("");
            } else {
                confirmPassMessage.setText("Password doesn't match ");
            }
        }else{
            createdMessage.setText("Password must be 6 or more character");
        }

    }
    public void backOnAction(Event event){
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        backToLogin();

    }
    public void registerUser() {
        DBConnection connectNow = new DBConnection();
        Connection connectDB = connectNow.getConnection();
        String full_name = fullName.getText();
        String gender = Sex.getValue();
        String email = Email.getText();
        String username = Username.getText();
        String pass = password.getText();

        String insertFields = "INSERT INTO account_user(full_name,gender,username,email,pass) values ('";
        String insertValue = full_name + "','" + gender + "','" + username + "','" + email + "','" + pass + "')";
        String insertToRegister = insertFields + insertValue;
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void backToLogin(){
        try{
            Parent root= FXMLLoader.load(getClass().getResource("Log_In.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(root,700,500));
            homeStage.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }



}
