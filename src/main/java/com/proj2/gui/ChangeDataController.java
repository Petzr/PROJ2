package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import com.proj2.service.PasswordHash;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangeDataController implements Initializable, IControllerInfo
{
    private AbstractPerson user;
    @FXML
    private Label changeMessage;
    @FXML
    private TextField newName;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField oldPassword;
    @FXML
    private Label regLabel;

    @FXML
    private TextField pictureTextfield;

    @FXML
    private ImageView profilePicture;

    URL url;

    {
        try
        {
            url = new URL("https://pngset.com/images/katie-notopoulos-katienotopoulos-i-write-about-tech-round-profile-image-placeholder-text-number-symbol-word-transparent-png-201415.png");
        } catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void backToDashboard(ActionEvent event) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene;
        if (user instanceof Admin) scene = IControllerInfo.createNewScene(user, "/com/proj2/admin-dashboard.fxml", new AdminDashboardController());
        else scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    public void downloadNewImage() throws IOException
    {
        // Downloading image from URL
        InputStream inputStream = url.openStream();
        FileOutputStream fileOutputStream = new FileOutputStream("profilePicture.jpg");
        int b = 0;
        while ((b = inputStream.read()) != -1)
        {
            fileOutputStream.write(b);
        }
        fileOutputStream.close();
        inputStream.close();
    }

    public void refactorImage()
    {
        // Moving and deleting file
        File file = new File("profilePicture.jpg");
        // renaming the file and moving it to a new location
        if (file.renameTo
                (new File("src/main/resources/profilePicture.jpg")))
        {
            // if file copied successfully then delete the original file
            file.delete();
            System.out.println("File moved successfully");
        } else
        {
            System.out.println("Failed to move the file");
        }
        user.setImage(new Image("profilePicture.jpg"));
    }

    public void setProfilePicture() throws IOException
    {
        if (!pictureTextfield.getText().equals(""))
        {
            URL url = new URL(pictureTextfield.getText());
            setUrl(url);
            downloadNewImage();
            refactorImage();
            this.profilePicture.setImage(user.getImage());
        }
    }

    @FXML
    void changeData(ActionEvent event) throws IOException
    {
        if (user.comparePassword(oldPassword.getText()))
        {
            setProfilePicture();
            if (!newName.getText().equals("") && !newPassword.getText().equals("")) {
                user.setName(newName.getText());
                user.setPassword(newPassword.getText());
                backToDashboard(event);
            } else if (!newName.getText().equals("") && newPassword.getText().equals("")) {
                user.setName(newName.getText());
                backToDashboard(event);
            } else if (newName.getText().equals("") && !newPassword.getText().equals("")) {
                user.setPassword(newPassword.getText());
                backToDashboard(event);
            } else changeMessage.setText("Please fill in a new name and / or new password.");
        } else changeMessage.setText("Please enter the correct old password.");
    }

    @Override
    public void setUser(AbstractPerson user) { this.user = user; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void setUrl(URL url)
    {
        this.url = url;
    }
}
