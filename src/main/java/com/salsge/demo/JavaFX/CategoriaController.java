package com.salsge.demo.JavaFX;

import com.salsge.demo.Categorias.Categoria;
import com.salsge.demo.Categorias.CategoriaService;
import com.salsge.demo.Conceptos.Concepto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;


@Component
public class CategoriaController implements Initializable {

    @FXML private TableView<Categoria> categoriaView;
    @FXML private TableColumn<Categoria, String> categoriaNameCol;
    @FXML private TextField categoriaTextField;
    @FXML private Button categoriaBtn;

    @FXML private Text notificationText;

    @Autowired
    CategoriaService categoriaService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoriaNameCol.setCellValueFactory(new PropertyValueFactory<>("categoriaName"));
        categoriaView.setItems(FXCollections.observableArrayList(categoriaService.getAllCategorias()));

        categoriaView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                categoriaTextField.setText(newValue.getSueldo());
                notificationText.setText("");
            }
        });


    }

    @FXML
    public void updateCategoriaSueldo() {
        Categoria categoriaSelected = categoriaView.getSelectionModel().getSelectedItem();
        if(categoriaSelected == null) {
            notificationText.setText("There's not categoria selected");
        } else {
            categoriaService.editCategoria(categoriaSelected, categoriaTextField.getText());

            notificationText.setText("Actualizado con exito");

            categoriaView.setItems(FXCollections.observableArrayList(categoriaService.getAllCategorias()));
        }
    }

}










