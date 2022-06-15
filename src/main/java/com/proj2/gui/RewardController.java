package com.proj2.gui;

import com.proj2.model.Reward;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import javafx.collections.FXCollections;
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
import java.util.ResourceBundle;

public class RewardController implements Initializable, IControllerInfo
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
    void backToDashboard(ActionEvent event) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    @FXML
    void buyItem(ActionEvent event) {
        Reward reward = (Reward) rewardsTable.getSelectionModel().getSelectedItems();




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
        createRewardTable();
    }

    private void createRewardTable() {

        colomnItems.setCellValueFactory(new PropertyValueFactory<>("name"));
        colomnCost.setCellValueFactory(new PropertyValueFactory<>("points"));

        rewardsTable.setItems(FXCollections.observableArrayList(
                new Reward("Playstation 69", 420)



        ));
    }
}
