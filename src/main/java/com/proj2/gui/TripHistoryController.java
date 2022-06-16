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

public class TripHistoryController extends MainController implements Initializable, Observer
{
    @FXML
    private TableColumn<Travel, String> colomnDate;

    @FXML
    private TableColumn<Travel, Integer> colomnPoints;

    @FXML
    private TableView<Travel> historyTable;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update"+ this);
        createTable();
    }

    private void createTable(){
        colomnDate.setCellValueFactory(new PropertyValueFactory<Travel, String>("date"));
        colomnPoints.setCellValueFactory(new PropertyValueFactory<Travel, Integer>("points"));
//        colomnDate.setSortType(TableColumn.SortType.DESCENDING);

        historyTable.setItems(getTravelList());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (getUser() instanceof User) {
            getUser().addObserver(this);
        }
        createTable();
    }

    private ObservableList<Travel> getTravelList() {
        ObservableList<Travel> list = FXCollections.observableArrayList();

        User person = (User) getUser();
        for (Travel travel : person.getTravels())
        {
            list.add(travel);
        }
        return list;
    }
}
