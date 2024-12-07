package com.example.finaldemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main JavaFX application for Image Management Tool
 */
public class ImageManagementApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the main FXML layout
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main_view.fxml"));
            Parent root = loader.load();

            // Add styles to the Scene
            Scene scene = new Scene(root, 600, 400);
            String css = getClass().getResource("styles.css").toExternalForm();
            scene.getStylesheets().add(css);

            // Set up the primary stage
            primaryStage.setTitle("Image Management Tool");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // Log and show error dialog
            showErrorDialog("Failed to load application", e);
        }
    }

    // Show error dialog to user
    private void showErrorDialog(String message, Exception e) {
        // Implementation of error dialog
        e.printStackTrace();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
