package com.proj2.gui;

import com.proj2.model.Organization;
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
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class LeaderboardController implements Initializable, IControllerInfo, Observer
{
    private AbstractPerson user;

    public TableView<User> leaderboardTable;

    private TableColumn<User, String> usercolomn;

    private TableColumn<User, Integer> pointscolomn;

    public void backToDashboard(ActionEvent actionEvent) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene;
        if (user instanceof Admin) scene = IControllerInfo.createNewScene(user, "/com/proj2/admin-dashboard.fxml", new AdminDashboardController());
        else scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    @Override
    public void setUser(AbstractPerson user) { this.user = user; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { createTable(); }

    @Override
    public void update(Observable o, Object arg) { createTable(); }

    private void createTable(){

        usercolomn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pointscolomn.setCellValueFactory(new PropertyValueFactory<>("points"));

        pointscolomn.setSortType(TableColumn.SortType.DESCENDING);
        pointscolomn.setSortable(false);

        ObservableList<User> list = getUserList();
        leaderboardTable.setItems(list);
        leaderboardTable.getColumns().addAll(usercolomn, pointscolomn);


       /* for (AbstractPerson user : temp.getAllUsers() ) {
            leaderboardTable.getItems().add(user);
        } */
    }

    private ObservableList<User> getUserList() {
        User een = new User("bilal", "email", "123");
        User twee = new User("Peter", "email", "123");

        ObservableList<User> list = FXCollections.observableArrayList(een, twee);
        return list;

    }
}
