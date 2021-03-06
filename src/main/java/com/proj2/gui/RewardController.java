package com.proj2.gui;

import com.proj2.model.Reward;
import com.proj2.model.person.User;
import com.proj2.service.Logic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class RewardController extends MainController implements Initializable, Observer
{
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
    void buyItem(ActionEvent actionEvent) {
        Reward reward = rewardsTable.getSelectionModel().getSelectedItem();
        if (reward != null) {
            ((User) getUser()).removeReward(reward);
            backToDashboard(actionEvent);
        } else errorMessage.setText("Please select a reward before collecting it.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        pointsUser.setText(Integer.toString(((User) getUser()).getPoints()));
        Logic.get_organization().addObserver(this);
        createTable();
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update leaderboard " + getUser().getName());
        rewardsTable.refresh();
    }

    private void createTable(){
        colomnItems.setCellValueFactory(new PropertyValueFactory<Reward, String>("name"));
        colomnCost.setCellValueFactory(new PropertyValueFactory<Reward, Integer>("points"));
        rewardsTable.setItems(getRewardList());
    }

    private ObservableList<Reward> getRewardList() {
        ObservableList<Reward> list = FXCollections.observableArrayList();
        list.addAll(Logic.get_organization().getRewards());
        return list;
    }
}
