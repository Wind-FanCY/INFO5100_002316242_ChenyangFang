package com.example.finaldemo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Strategy pattern
 * Interface for image conversion
 */
public interface ImageConverter {
    /**
     * Convert images to a specific format
     * 'images': List of input image files
     * 'targetFormat': Target format for conversion
     * 'outputDirectory': Directory to save converted images
     * return List of converted image files
     * throws Exception If conversion fails
     */

    List<File> convert(
            List<ImageProperties> images,
            String targetFormat,
            File outputDirectory
    ) throws Exception;
}

// Concrete implementation
class DefaultImageConverter implements ImageConverter {
    @Override
    public List<File> convert(
            List<ImageProperties> images,
            String targetFormat,
            File outputDirectory
    ) throws Exception {
        // Implementation details for conversion
        if (images == null) {
            throw new Exception("Image data is null. Cannot apply converting.");
        }
        List<File> convertedFiles = new ArrayList<>();

        for (ImageProperties image : images) {
            try {
                File inputFile = new File(image.getFilePath());
                BufferedImage bufferedImage = ImageIO.read(inputFile);

                String fileName = image.getFileName();
                String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
                File outputFile = new File(
                        outputDirectory,
                        baseName + "_converted." + targetFormat.toLowerCase()
                );

                ImageIO.write(bufferedImage, targetFormat, outputFile);
                convertedFiles.add(outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return convertedFiles;
    }
}
