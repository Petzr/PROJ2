package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class LeaderboardController implements Initializable, IControllerInfo
{
    private AbstractPerson user;

    public TableView leaderboardTable;

    @Override
    public void setUser(AbstractPerson user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
