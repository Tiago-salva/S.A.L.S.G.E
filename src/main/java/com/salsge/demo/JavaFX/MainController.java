package com.salsge.demo.JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    public void loadEmployeesView(ActionEvent event) throws IOException {
        openFxmlView("/views/Employees.fxml", "Employees");
    }

    public void loadPayrollView() throws IOException {
        // openFxmlView("/views/Home.fxml", "Employees");
    }
    public void loadLegajosView() throws IOException {
        // openFxmlView("/views/Home.fxml", "Employees");
    }
    public void loadNovedadesView() throws IOException {
        // openFxmlView("/views/Home.fxml", "Employees");
    }

    public void openFxmlView(String path, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getResource(path)));
        Parent root = loader.load();

        Scene scene = new Scene(root, 500, 500);

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();

    }

}
