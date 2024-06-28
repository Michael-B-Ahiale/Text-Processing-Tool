package textprocessingtool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Print classpath information
        System.out.println("Classpath:");
        String classpath = System.getProperty("java.class.path");
        String[] classpathEntries = classpath.split(File.pathSeparator);
        for (String entry : classpathEntries) {
            System.out.println(entry);
        }

        // Try to load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/textprocessingtool/view/main.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Text Processing Tool");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error loading FXML file:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}