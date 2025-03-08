package fr.theorigindev.werewolforigin.models.roles;

import fr.theorigindev.werewolforigin.models.game.GameState;
import fr.theorigindev.werewolforigin.models.game.Player;
import fr.theorigindev.werewolforigin.models.interfaces.Role;

public class Villager implements Role {


    @Override
    public String getName() {
        return "Villageois";
    }

    @Override
    public void performAction(GameState gameState, Player player) {

    }
}
