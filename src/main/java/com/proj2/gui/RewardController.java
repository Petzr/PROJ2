package com.proj2.gui;

import com.proj2.model.Reward;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import com.proj2.service.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class RewardController implements Initializable, IControllerInfo, Observer
{
    private AbstractPerson user;
    @FXML
    private TableColumn<Reward, Integer> colomnCost;
    @FXML
    private TableColumn<Reward, String> colomnItems;
    @FXML
    private Label pointsUser;
    @FXML
    private TableView<Reward> rewardsTable;

    @FXML
    private Label errorMessage;

    @FXML
    void backToDashboard(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());
        if (scene != null) stage.setScene(scene);
    }

    @FXML
    void buyItem(ActionEvent actionEvent) {
        Reward reward = rewardsTable.getSelectionModel().getSelectedItem();
        if (reward != null) {
            ((User) user).removeReward(reward);
            backToDashboard(actionEvent);
        } else errorMessage.setText("Please select a reward before collecting it.");
    }

    @Override
    public void setUser(AbstractPerson user)
    {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        pointsUser.setText(Integer.toString(((User) user).getPoints()));
        Logic.get_organization().addObserver(this);
        createTable();
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update rewards: " + user.getName());
        rewardsTable.refresh();
    }

    private void createTable(){
        colomnItems.setCellValueFactory(new PropertyValueFactory<Reward, String>("name"));
        colomnCost.setCellValueFactory(new PropertyValueFactory<Reward, Integer>("points"));
        colomnCost.setSortType(TableColumn.SortType.DESCENDING);

        rewardsTable.setItems(getRewardList());
    }

    private ObservableList<Reward> getRewardList() {
        ObservableList<Reward> list = FXCollections.observableArrayList();
        list.addAll(Logic.get_organization().getRewards());
        return list;
    }
}
