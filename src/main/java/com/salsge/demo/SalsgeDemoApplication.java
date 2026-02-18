package com.salsge.demo;

import com.salsge.demo.JavaFX.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SalsgeDemoApplication extends Application {

	public static void main(String[] args) {

		SpringApplication.run(SalsgeDemoApplication.class, args);

		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Home.fxml"));
			Parent root = loader.load();

			MainController mainController = loader.getController();

			Scene scene = new Scene(root);
			stage.setTitle("S.A.L.S.G.E");
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
