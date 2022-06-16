package com.proj2.gui;

import com.proj2.model.Reward;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class AdminRewardController extends MainController implements Initializable, Observer
{
    @FXML
    private TableColumn<Reward, Integer> colomnCost;
    @FXML
    private TableColumn<Reward, String> colomnItems;
    @FXML
    private TableView<Reward> rewardsTable;
    @FXML
    private TextField pointsTextfield;
    @FXML
    private TextField rewardTextfield;
    @FXML
    private Label errorMessage;

    @FXML
    void addReward(ActionEvent event) {
        if (!rewardTextfield.getText().equals("") && !pointsTextfield.getText().equals("")) {
            if (isNumeric(pointsTextfield.getText())) {
                ((Admin) getUser()).addReward(
                        rewardTextfield.getText(),
                        Integer.parseInt(pointsTextfield.getText())
                );
                createTable();
                rewardTextfield.setText("");
                pointsTextfield.setText("");
            } else errorMessage.setText("Incorrect number of kilometers.");
        }
    }
    @FXML
    void deleteReward(ActionEvent actionEvent) {
        Reward reward = rewardsTable.getSelectionModel().getSelectedItem();
        if (reward != null) {
            ((Admin) getUser()).removeReward(reward);
            createTable();
        } else if (!rewardTextfield.getText().equals("")) {
            reward = Logic.get_organization().getReward(rewardTextfield.getText());
            if (reward != null) {
                ((Admin) getUser()).removeReward(reward);
                createTable();
                rewardTextfield.setText("");
            } else errorMessage.setText("Please enter the name of an existing reward.");
        } else errorMessage.setText("Please select a reward before collecting it.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
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
        colomnCost.setSortType(TableColumn.SortType.DESCENDING);

        rewardsTable.setItems(getRewardList());
    }

    private ObservableList<Reward> getRewardList() {
        ObservableList<Reward> list = FXCollections.observableArrayList();
        list.addAll(Logic.get_organization().getRewards());
        return list;
    }

    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
