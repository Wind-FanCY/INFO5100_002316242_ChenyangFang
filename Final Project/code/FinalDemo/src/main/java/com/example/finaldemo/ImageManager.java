package com.example.finaldemo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 * Singleton service for managing image-related operations
 */
public class ImageManager {
    // Singleton instance
    private static ImageManager instance;

    // List to store uploaded images
    private List<ImageProperties> uploadedImages;

    // Private constructor to prevent direct instantiation
    private ImageManager() {
        uploadedImages = new ArrayList<>();
    }

    // Singleton getInstance method
    public static synchronized ImageManager getInstance() {
        if (instance == null) {
            instance = new ImageManager();
        }
        return instance;
    }

    /**
     * Upload images from file
     * 'files': List of image files to upload
     * return List of ImageProperties for uploaded images
     */
    public List<ImageProperties> uploadImages(List<File> files) {
        List<ImageProperties> newImages = new ArrayList<>();

        for (File file : files) {
            try {
                BufferedImage bufferedImage = ImageIO.read(file);

                if (bufferedImage == null) {
                    throw new IOException("Unable to read image file");
                }

                // Get file path
                Path filePath = file.toPath();

                // Get file properties
                BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
                Instant creationTime = attributes.creationTime().toInstant();

                // Convert to local time
                LocalDateTime localDateTime = LocalDateTime.ofInstant(creationTime, ZoneId.systemDefault());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                ImageProperties imageProps = new ImageProperties(
                        file.getName(),
                        file.getAbsolutePath(),
                        localDateTime.format(formatter),
                        bufferedImage.getWidth(),
                        bufferedImage.getHeight(),
                        file.length()
                );

                uploadedImages.add(imageProps);
                newImages.add(imageProps);
            } catch (IOException e) {
                // Log error, could notify user through UI
                e.printStackTrace();
            }
        }

        return newImages;
    }

    /**
     * Convert images to specified format
     * 'images': List of images to convert
     * 'targetFormat': Target image format
     * 'outputDirectory': Directory to save converted images
     * return List of converted image files
     */
    public List<File> convertImages(
            List<ImageProperties> images,
            String targetFormat,
            File outputDirectory
    ) throws Exception {
        DefaultImageConverter instance = new DefaultImageConverter();
        return instance.convert(images, targetFormat, outputDirectory);

    }
}
