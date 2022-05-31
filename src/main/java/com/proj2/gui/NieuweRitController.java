package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class NieuweRitController implements Initializable, IControllerInfo
{
    private AbstractPerson user;

    public TableView vehiclesTable;
    public TextField numberOfKm;

    public void calculatePoints(ActionEvent actionEvent)
    {
    }

    public void setUser(AbstractPerson user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
