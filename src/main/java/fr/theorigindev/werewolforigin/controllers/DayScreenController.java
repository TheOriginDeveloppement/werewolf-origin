package fr.theorigindev.werewolforigin.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DayScreenController {
    @FXML
    private Label dayLabel;

    public void setDayLabel(String text) {
        if(dayLabel != null)
            dayLabel.setText(text);
    }
}
