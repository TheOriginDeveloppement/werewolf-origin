package fr.theorigindev.werewolforigin;

import fr.theorigindev.werewolforigin.controllers.GameLoop;
import fr.theorigindev.werewolforigin.views.GameView;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) {
        GameView view = new GameView(primaryStage);
        new GameLoop(view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
