package fr.theorigindev.werewolforigin.controllers;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class StartScreenController {
    @FXML
    private Label startLabel;

    @FXML
    private ListView<String> playerList;

    @FXML
    private Button startButton;

    public void setStartLabel(String text) {
        startLabel.setText(text);
    }

    public void setPlayerRoles(List<String> roles) {
        playerList.setItems(FXCollections.observableArrayList(roles));
    }

    public Button getStartButton() {
        return startButton;
    }
}