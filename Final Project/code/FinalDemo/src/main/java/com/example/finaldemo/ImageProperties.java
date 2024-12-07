package com.example.finaldemo;

/**
 * Model class to represent image properties
 * Demonstrates encapsulation and information hiding
 */
public class ImageProperties {
    // Private fields for encapsulation
    private String fileName;
    private String filePath;
    private String createdDate;
    private int width;
    private int height;
    private long fileSize;


    // Constructor
    public ImageProperties(
            String fileName,
            String filePath,
            String createTime,
            int width,
            int height,
            long fileSize
    ) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.createdDate = createTime;
        this.width = width;
        this.height = height;
        this.fileSize = fileSize;
    }

    // Getters with appropriate encapsulation
    public String getFileName() { return fileName; }
    public String getFilePath() { return filePath; }
    public String getCreatedDate() { return createdDate; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    // Optional: Method to get formatted file size
    public String getFormattedFileSize() {
        return String.format("%.2f KB", fileSize / 1024.0);
    }
}