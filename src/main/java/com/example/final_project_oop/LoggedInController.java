package com.example.final_project_oop;

import javafx.event.ActionEvent;
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
//Leang Menghangg
public class LoggedInController implements Initializable {
    @FXML
    private Button cancel_button;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField Password;

    @FXML
    private Hyperlink Register;

    @FXML
    public TextField Username_or_Email;

    @FXML
    private Hyperlink forgot_Password;

    @FXML
    private Label LoginMessage;

    @FXML
    private ImageView brandingImageView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }
    public void registerOnAction(Event event){
        Stage stage = (Stage) cancel_button.getScene().getWindow();
        stage.close();
        createAccountForm();
    }
    public void cancelButtonOnAction(Event event){
        Stage stage = (Stage) cancel_button.getScene().getWindow();
        stage.close();;
    }


    public void loginButtonOnAction(ActionEvent event){

        String username = Username_or_Email.getText();
        String password = Password.getText();

        if (username.isEmpty() || password.isEmpty()) {
            LoginMessage.setText("Please enter username and password.");
            return;
        }
        DBConnection databaseConnection = new DBConnection();
        Connection connection = databaseConnection.getConnection();

        String sql = "SELECT * FROM account_user WHERE username='" + username + "' AND pass='" + password + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                Stage stage = (Stage) cancel_button.getScene().getWindow();
                stage.close();;
                LoginMessage.setText("Logged In Success!!");
                intoHomePage();
            } else {
                LoginMessage.setText("Invalid username or password. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LoginMessage.setText("Login failed. Please try again.");
        }


    }

    public void createAccountForm(){
        try{
            Parent root= FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root,700,500));
            registerStage.show();

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
