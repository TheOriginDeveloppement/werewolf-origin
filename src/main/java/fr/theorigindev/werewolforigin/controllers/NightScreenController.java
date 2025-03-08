package fr.theorigindev.werewolforigin.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NightScreenController {
    @FXML
    private Label nightLabel;

    public void setNightLabel(String text) {
        if(nightLabel != null)
            nightLabel.setText(text);
    }
}