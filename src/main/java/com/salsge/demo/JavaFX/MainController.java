package com.salsge.demo.JavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainController {

    @Autowired
    private ApplicationContext applicationContext;

    @FXML
    public void loadEmployeesView(ActionEvent event) throws IOException {
        openFxmlView("/views/Employees.fxml", "Employees");
    }

    public void loadPayrollView() throws IOException {
        openFxmlView("/views/Home.fxml", "Employees");
    }

    public void loadNovedadesView() throws IOException {
        openFxmlView("/views/Novedades.fxml", "Employees");
    }

    public void loadConceptosView() throws IOException {
        openFxmlView("/views/Concepto.fxml", "Conceptos");
    }

    public void loadCategoriasView() throws IOException {
        openFxmlView("/views/Categorias.fxml", "Categorias");
    }

    public void openFxmlView(String path, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getResource(path)));
        loader.setControllerFactory(applicationContext::getBean);
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();

    }

}
