package com.salsge.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SalsgeDemoApplication extends Application {

	public static void main(String[] args) {

		SpringApplication.run(SalsgeDemoApplication.class, args);

		launch(args);

	}

	private ConfigurableApplicationContext applicationContext;

	@Override
	public void init() {
		applicationContext = SpringApplication.run(SalsgeDemoApplication.class);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Home.fxml"));

		loader.setControllerFactory(applicationContext::getBean);

		Parent root = loader.load();
		stage.setScene(new Scene(root));
		stage.setTitle("S.A.L.S.G.E");
		stage.show();
	}

	@Override
	public void stop() {
		applicationContext.close();
	}

}
