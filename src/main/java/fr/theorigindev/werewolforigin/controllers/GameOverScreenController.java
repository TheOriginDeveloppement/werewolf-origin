package fr.theorigindev.werewolforigin.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameOverScreenController {
    @FXML
    private Label gameOverLabel;

    public void setGameOverLabel(String text) {
        if(gameOverLabel != null)
            gameOverLabel.setText(text);
    }
}