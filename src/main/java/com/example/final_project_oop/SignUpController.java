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
    public TextField Username;
    @FXML
    private ChoiceBox<String> Sex;
    private String [] gen = {"Male","Female"};
    @FXML
    private TextField date_of_birth;
    @FXML
    private TextField phone;

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
        String F = date_of_birth.getText();
        String G = phone.getText();

        if (A.isEmpty() || B.isEmpty() || C.isEmpty() || D.isEmpty() || E.isEmpty()||F.isEmpty()||G.isEmpty()) {
            createdMessage.setText("Please kindly complete all Fields");
        }else{
            if (D.length() >= 6) {

                if (password.getText().equals(confirm_pass.getText())) {
                    Stage stage = (Stage) cancel_button.getScene().getWindow();
                    stage.close();
                    registerUser();
                    intoHomePage();
                    confirmPassMessage.setText("");
                } else {
                    confirmPassMessage.setText("Password doesn't match ");
                }
            } else {
                createdMessage.setText("Password must be 6 or more character");
            }
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
        String birth_of_date = date_of_birth.getText();
        String phone_n = phone.getText();

        String insertFields = "INSERT INTO account_user(full_name,birt_of_date,gender,username,email,phone_num,pass) values ('";
        String insertValue = full_name + "','" +birth_of_date+ "','" + gender + "','"  + username + "','" + email + "','" + phone_n+"','"+ pass + "')";
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
    public void intoHomePage(){
        try{
            Parent root= FXMLLoader.load(getClass().getResource("healthManage.fxml"));
            Stage homeStage = new Stage();
            homeStage.initStyle(StageStyle.UNDECORATED);
            homeStage.setScene(new Scene(root,750,670));
            homeStage.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}
