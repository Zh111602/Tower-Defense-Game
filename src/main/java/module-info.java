module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires testfx.junit;
    requires testfx.core;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}