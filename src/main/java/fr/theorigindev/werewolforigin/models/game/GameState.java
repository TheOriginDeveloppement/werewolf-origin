package fr.theorigindev.werewolforigin.models.game;

import fr.theorigindev.werewolforigin.models.roles.Villager;
import fr.theorigindev.werewolforigin.models.roles.Wolf;

import java.util.List;
import java.util.Random;

public class GameState {
    private List<Player> players;
    private boolean isDay;
    private int turn;
    private static GameState instance;

    public int getTurn() {
        return turn;
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;

    }

    public boolean isDay() {
        return isDay;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }

    public Player getRandomAliveVillager() {
        List<Player> villagers = getAlivePlayers().stream()
                .filter(p -> p.getRole() instanceof Villager).toList();
        return villagers.isEmpty() ? null : villagers.get(new Random().nextInt(villagers.size()));
    }

    public List<Player> getAlivePlayers() {
        return players.stream().filter(Player::isAlive).toList();
    }

    public boolean isGameOver() {
        int aliveVillagers = (int) getAlivePlayers().stream().filter(p -> p.getRole() instanceof Villager).count();
        int aliveWerewolves = (int) getAlivePlayers().stream().filter(p -> p.getRole() instanceof Wolf).count();
        return aliveVillagers == 0 || aliveWerewolves == 0;
    }

    public void nextPhase() {
        isDay = !isDay;
        if (isDay) turn++;
    }

}
