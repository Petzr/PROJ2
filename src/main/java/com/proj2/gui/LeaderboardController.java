package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import com.proj2.service.Logic;
import com.proj2.model.person.User;
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
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class LeaderboardController extends MainController implements Initializable, Observer
{

    @FXML
    public TableView<User> leaderboardTable;
    @FXML
    private TableColumn<User, String> usercolomn;
    @FXML
    private TableColumn<User, Integer> pointscolomn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Logic.get_organization().addObserver(this);
        createTable();
    }

    // Observer Pattern: de leaderboard krijgt een update
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update leaderboard " + getUser().getName());
        leaderboardTable.refresh();
    }

    private void createTable(){
        usercolomn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        pointscolomn.setCellValueFactory(new PropertyValueFactory<User, Integer>("points"));
        pointscolomn.setSortType(TableColumn.SortType.DESCENDING);

        leaderboardTable.setItems(getUserList());
    }

    private ObservableList<User> getUserList() {
        ObservableList<User> list = FXCollections.observableArrayList();
        for (AbstractPerson person : Logic.get_organization().getAllUsers()) if (person instanceof User) list.add((User) person);
        return list;
    }
}
