package com.example.finaldemo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class ImageDisplayController {
    @FXML private ListView<ImageProperties> thumbnailListView;
    @FXML private ImageView previewImageView;
    @FXML private Label fileNameLabel;
    @FXML private Label fileSizeLabel;
    @FXML private Label dimensionsLabel;
    @FXML private Label fileTimeLabel;
    @FXML private Label filePathLabel;
    @FXML private ComboBox<String> formatComboBox;

    private ImageManager imageManager;

    @FXML
    public void initialize() {
        // Initialize the controller
        imageManager = ImageManager.getInstance();

        // Populate format combo box
        formatComboBox.getItems().addAll(
                "PNG","JPG", "JPEG", "GIF", "BMP"
        );

        // Setup list view selection listener
        thumbnailListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        updateImagePreview(newSelection);
                    }
                }
        );
    }

    @FXML
    public void handleImageUpload() {
        // Open file chooser for image selection
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image Files");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp")
        );

        // Get selected files
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);

        if (selectedFiles != null && !selectedFiles.isEmpty()) {
            // Upload images and update UI
            List<ImageProperties> uploadedImages = imageManager.uploadImages(selectedFiles);
            thumbnailListView.getItems().addAll(uploadedImages);
        }
    }

    @FXML
    public void handleImageConversion() throws Exception {
        // Get selected format
        String targetFormat = formatComboBox.getValue();

        if (targetFormat == null) {
            // Show error if no format selected
            showAlert("Please select a target format");
            return;
        }

        // Get selected images
        List<ImageProperties> selectedImages = thumbnailListView.getSelectionModel().getSelectedItems();

        if (selectedImages.isEmpty()) {
            showAlert("Please select images to convert");
            return;
        }

        // Choose output directory
        File outputDirectory = chooseOutputDirectory();

        if (outputDirectory != null) {
            // Convert images
            List<File> convertedFiles = imageManager.convertImages(
                    selectedImages,
                    targetFormat,
                    outputDirectory
            );

            // Notify user of conversion
            showAlert("Converted " + convertedFiles.size() + " images to " + targetFormat);
        }
    }

    private void updateImagePreview(ImageProperties imageProperties) {
        // Update preview image
        File imageFile = new File(imageProperties.getFilePath());
        Image image = new Image(imageFile.toURI().toString());
        previewImageView.setImage(image);

        // Update image properties labels
        fileNameLabel.setText("File: " + imageProperties.getFileName());
        fileSizeLabel.setText("Size: " + imageProperties.getFormattedFileSize());
        dimensionsLabel.setText("Dimensions: " +
                imageProperties.getWidth() + " x " + imageProperties.getHeight());
        fileTimeLabel.setText("Create Time: " + imageProperties.getCreatedDate());
        filePathLabel.setText("File Path: " +  imageProperties.getFilePath());
    }

    private File chooseOutputDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Output Directory");
        return directoryChooser.showDialog(null);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Image Management Tool");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
