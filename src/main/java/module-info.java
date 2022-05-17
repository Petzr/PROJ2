module com.proj2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proj2 to javafx.fxml;
    exports com.proj2;
    exports com.proj2.gui;
    opens com.proj2.gui to javafx.fxml;
}