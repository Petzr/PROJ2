package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.vehicles.AbstractVehicle;
import com.proj2.model.vehicles.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    private TableView<AbstractVehicle> vehiclesTable;

    @FXML
    private TableColumn<AbstractVehicle, Double> colomnModifier;

    @FXML
    private TableColumn<AbstractVehicle, String> colomnVehicle;

    ObservableList<AbstractVehicle> list = FXCollections.observableArrayList(
            new Bike(),
            new DieselCar(),
            new ElectricCar(),
            new GasolineCar(),
            new Plane(),
            new PublicTransport()
    );

    @FXML
    private TextField numberOfKm;

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
        if (scene != null) stage.setScene(scene);
    }

    public void setUser(AbstractPerson user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colomnModifier.setCellValueFactory(new PropertyValueFactory<AbstractVehicle, Double>("modifier"));
        colomnVehicle.setCellValueFactory(new PropertyValueFactory<AbstractVehicle, String>("name"));
//
        vehiclesTable.setItems(list);
    }
}
