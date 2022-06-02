package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import com.proj2.model.vehicles.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NieuweRitController implements Initializable, IControllerInfo
{
    private AbstractPerson user;

    public TableView vehiclesTable;
    public TextField numberOfKm;

    public void calculatePoints(ActionEvent actionEvent)
    {
    }

    public void backToDashboard(ActionEvent actionEvent) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) {
            stage.setScene(scene);
        }
    }

    public void setUser(AbstractPerson user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void createVehicleTable() {
        vehiclesTable = new TableView<>();
        TableColumn<User, String> column1 = new TableColumn<>("Naam");
        TableColumn<User, String> column2 = new TableColumn<>("Modifier");

        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("modifier"));

        vehiclesTable.getColumns().add(column1);
        vehiclesTable.getColumns().add(column2);

        vehiclesTable.getItems().add(new Bike());
        vehiclesTable.getItems().add(new DieselCar());
        vehiclesTable.getItems().add(new ElectricCar());
        vehiclesTable.getItems().add(new GasolineCar());
        vehiclesTable.getItems().add(new Plane());
        vehiclesTable.getItems().add(new PublicTransport());

    }
}
