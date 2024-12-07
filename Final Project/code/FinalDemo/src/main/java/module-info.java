module com.example.finaldemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.finaldemo to javafx.fxml;
    exports com.example.finaldemo;
}
