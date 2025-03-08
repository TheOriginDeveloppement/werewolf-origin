package fr.theorigindev.werewolforigin.views;

import fr.theorigindev.werewolforigin.controllers.DayScreenController;
import fr.theorigindev.werewolforigin.controllers.GameOverScreenController;
import fr.theorigindev.werewolforigin.controllers.NightScreenController;
import fr.theorigindev.werewolforigin.controllers.StartScreenController;
import fr.theorigindev.werewolforigin.models.game.Player;
import fr.theorigindev.werewolforigin.models.roles.Villager;
import fr.theorigindev.werewolforigin.models.roles.Wolf;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GameView {
    private Stage stage;
    private StackPane root;
    private Pane startScreen;
    private Pane dayScreen;
    private Pane nightScreen;
    private Pane gameOverScreen;
    private StartScreenController startController;
    private DayScreenController dayController;
    private NightScreenController nightController;
    private GameOverScreenController gameOverController;

    public GameView(Stage stage) {
        this.stage = stage;
        setupUI();
    }

    private void setupUI() {
        root = new StackPane();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Loup-Garou Mini-Game");
        stage.setScene(scene);

        try {
            setupStartScreen();
            setupDayScreen();
            setupNightScreen();
            setupGameOverScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

        showStartScreen();
        stage.show();
    }

    private void setupStartScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/theorigindev/werewolforigin/fxml/StartScreen.fxml"));
        startScreen = loader.load();
        startController = loader.getController();
    }

    private void setupDayScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/theorigindev/werewolforigin/fxml/DayScreen.fxml"));
        dayScreen = loader.load();
        dayController = loader.getController();
    }

    private void setupNightScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/theorigindev/werewolforigin/fxml/NightScreen.fxml"));
        nightScreen = loader.load();
        nightController = loader.getController();
    }

    private void setupGameOverScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/theorigindev/werewolforigin/fxml/GameOverScreen.fxml"));
        gameOverScreen = loader.load();
        gameOverController = loader.getController();
    }

    private void showStartScreen() {
        root.getChildren().clear();
        root.getChildren().add(startScreen);
    }

    public void showDayScreen() {
        root.getChildren().clear();
        root.getChildren().add(dayScreen);
    }

    public void showNightScreen() {
        root.getChildren().clear();
        root.getChildren().add(nightScreen);
    }

    private void showGameOverScreen() {
        root.getChildren().clear();
        root.getChildren().add(gameOverScreen);
    }

    public void displayRoles(List<Player> players) {
        List<String> roleMessages = players.stream()
                .map(p -> p.getName() + ", vous êtes " + p.getRole().getName() + ".")
                .collect(Collectors.toList());
        Platform.runLater(() -> {
            startController.setStartLabel("Bienvenue au village... Voici vos rôles :");
            startController.setPlayerRoles(roleMessages);
        });
    }

    public void displayNightResult(Player killed) {
        String message = killed != null
                ? "Un hurlement résonne… " + killed.getName() + " a été retrouvé mort."
                : "Le village se réveille… Miraculeusement, personne n’est mort cette nuit.";
        Platform.runLater(() -> nightController.setNightLabel(message));
    }

    public void displayDayVote(Player eliminated) {
        String message = "Après un débat animé, le village a décidé d’exécuter " + eliminated.getName() + ".";
        Platform.runLater(() -> dayController.setDayLabel(message));
    }

    public void displayGameOver(String winner) {
        String message = "La partie est terminée… Les " + winner + " ont triomphé !";
        Platform.runLater(() -> {
            showGameOverScreen();
            gameOverController.setGameOverLabel(message);
        });
    }

    public StartScreenController getStartController() {
        return startController;
    }
}