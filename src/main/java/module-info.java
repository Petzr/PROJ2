module com.proj2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proj2 to javafx.fxml;
    opens com.proj2.gui to javafx.fxml;
    opens com.proj2.model to javafx.fxml;
    opens com.proj2.model.person to javafx.fxml;
    opens com.proj2.model.vehicles to javafx.fxml;
    opens com.proj2.model.abstraction to javafx.fxml;

    exports com.proj2.gui;
    exports com.proj2.model;
    exports com.proj2.model.person;
    exports com.proj2.model.vehicles;
    exports com.proj2.model.abstraction;
}