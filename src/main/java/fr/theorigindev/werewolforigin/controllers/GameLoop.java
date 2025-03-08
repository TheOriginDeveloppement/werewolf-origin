package fr.theorigindev.werewolforigin.controllers;

import fr.theorigindev.werewolforigin.models.game.GameState;
import fr.theorigindev.werewolforigin.models.game.Player;
import fr.theorigindev.werewolforigin.models.game.RoleAssigner;
import fr.theorigindev.werewolforigin.models.roles.Villager;
import fr.theorigindev.werewolforigin.models.roles.Wolf;
import fr.theorigindev.werewolforigin.views.GameView;

import javafx.application.Platform;

import java.util.Random;


public class GameLoop {
    private GameState state;
    private GameView view;

    public GameLoop(GameView view) {
        this.view = view;
        setupStartButtonListener();
    }

    private void setupStartButtonListener() {
        view.getStartController().getStartButton().setOnAction(event -> startGame(4, 1));
    }

    public void startGame(int playerCount, int werewolfCount) {
        RoleAssigner assigner = new RoleAssigner();
        state = GameState.getInstance();
        GameState.getInstance().setPlayers(assigner.assignRoles(playerCount, werewolfCount));
        view.displayRoles(state.getAlivePlayers());

        new Thread(() -> {

            while (!state.isGameOver()) {
                try {

                    if(state.getTurn() == 0)
                        Thread.sleep(2500);


                    if (state.isDay()) {
                        Platform.runLater(() -> view.showDayScreen());
                        runDayPhase();
                    } else {
                        Platform.runLater(() -> view.showNightScreen());
                        runNightPhase();
                    }
                    state.nextPhase();

                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String winner = (state.getAlivePlayers().getFirst().getRole() instanceof Villager) ? "Villageois" : "Loups";
            view.displayGameOver(winner);
        }).start();
    }

    private void runDayPhase() {
        Player eliminated = state.getAlivePlayers().get(new Random().nextInt(state.getAlivePlayers().size()));

        view.displayDayVote(eliminated);
    }

    private void runNightPhase() {
        Player wolf = state.getAlivePlayers().stream().filter(p -> p.getRole() instanceof Wolf).findFirst().orElse(null);
        if (wolf != null) {
            wolf.getRole().performAction(state, wolf);
            view.displayNightResult(state.getRandomAliveVillager());
        }
    }
}
