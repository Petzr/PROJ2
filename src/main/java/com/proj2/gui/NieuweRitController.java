package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import com.proj2.model.vehicles.*;
import com.proj2.model.abstraction.AbstractVehicle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    public TableView<AbstractVehicle> vehiclesTable;
    @FXML
    public TableColumn<AbstractVehicle, Class> colomnVehicle;
    @FXML
    public TableColumn<AbstractVehicle, Integer> colomnModifier;
    @FXML
    private Label errorMessage;
    public TextField numberOfKm;

    public void calculatePoints(ActionEvent actionEvent)
    {
        AbstractVehicle vehicle = vehiclesTable.getSelectionModel().getSelectedItem();

        if (vehicle != null) {
            if (user instanceof User) {
                if (isNumeric(numberOfKm.getText())) {
                    ((User) user).newTravel(
                            vehicle,
                            Integer.parseInt(numberOfKm.getText())
                    );
                    backToDashboard(actionEvent);
                } else errorMessage.setText("Incorrect number of kilometers.");
            }
        } else errorMessage.setText("Please select a vehicle before calculating points.");
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
        createVehicleTable();
    }

    private void createVehicleTable() {

        colomnVehicle.setCellValueFactory(new PropertyValueFactory<>("name"));
        colomnModifier.setCellValueFactory(new PropertyValueFactory<>("modifier"));

        vehiclesTable.setItems(FXCollections.observableArrayList(
                new Bicycle(),
                new DieselCar(),
                new ElectricCar(),
                new GasolineCar(),
                new Plane(),
                new PublicTransport()
        ));
    }

    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
