package fr.theorigindev.werewolforigin.models.game;

import fr.theorigindev.werewolforigin.models.roles.Villager;
import fr.theorigindev.werewolforigin.models.roles.Wolf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoleAssigner {
    public List<Player> assignRoles(int playerCount, int werewolfCount) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerCount - werewolfCount; i++) {
            players.add(new Player("Joueur " + (i + 1), new Villager()));
        }
        for (int i = 0; i < werewolfCount; i++) {
            players.add(new Player("Joueur " + (playerCount - werewolfCount + i + 1), new Wolf()));
        }
        Collections.shuffle(players);
        return players;
    }
}
