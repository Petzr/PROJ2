package com.proj2.gui;

import com.proj2.model.Travel;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import com.proj2.model.person.User;
import com.proj2.service.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class TripHistoryController implements Initializable, IControllerInfo, Observer
{

    private AbstractPerson user;

    @FXML
    private TableColumn<Travel, SimpleDateFormat> colomnDate;

    @FXML
    private TableColumn<Travel, Integer> colomnPoints;

    @FXML
    private TableView<Travel> historyTable;

    public void backToDashboard(ActionEvent actionEvent) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    @Override
    public void setUser(AbstractPerson user) { this.user = user; }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update"+ this);
        createTable();
    }

    private void createTable(){
        colomnPoints.setCellValueFactory(new PropertyValueFactory<Travel, Integer>("points"));
        colomnDate.setCellValueFactory(new PropertyValueFactory<Travel, SimpleDateFormat>("date"));
        colomnDate.setSortType(TableColumn.SortType.DESCENDING);

        historyTable.setItems(getUserList());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (user instanceof User) {
            user.addObserver(this);
        }
        createTable();
    }

    private ObservableList<Travel> getUserList() {
        ObservableList<Travel> list = FXCollections.observableArrayList();

        User person = (User) user;
        for (Travel travel : person.getTravels())
        {
            list.add(travel);
        }

        return list;

    }
}
