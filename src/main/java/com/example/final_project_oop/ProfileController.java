package com.example.final_project_oop;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ProfileController implements Initializable {
    @FXML
    private AnchorPane ShoProfile;
    @FXML
    private Label fTel, fBirthdate,lbUserName, fName, fEmail, fU_Name;
    @FXML
    private Button btnUpdateInfo, btnDelete,btnCancel;
   @FXML
   private TextField Username;


    public void updateOnAction(MouseEvent mouseEvent) {
    }
    public void cancelOnAction(MouseEvent mouseEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    private Stage stage;
    public void deleteOnAction(Event event) throws IOException {

    }
    public void initialize(URL url, ResourceBundle resourceBundle){
        DBConnection connectNow = new DBConnection();
        Connection connectDB = connectNow.getConnection();



        try {
            String query = "SELECT * FROM account_user WHERE ID =1";
            Statement stmt = connectDB.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            String name,tel,dob,uname,em;
            if (rs.next()) {
                name = rs.getString("full_name");
                dob = rs.getString("birt_of_date");
                tel = rs.getString("phone_num");
                uname = rs.getString("username");
                em = rs.getString("email");
                lbUserName.setText(name);
                fName.setText(name);
                fBirthdate.setText(dob);
                fTel.setText(tel);
                fU_Name.setText(uname);
                fEmail.setText(em);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
