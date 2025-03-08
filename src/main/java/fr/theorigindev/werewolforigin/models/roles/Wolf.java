package fr.theorigindev.werewolforigin.models.roles;

import fr.theorigindev.werewolforigin.models.game.GameState;
import fr.theorigindev.werewolforigin.models.game.Player;
import fr.theorigindev.werewolforigin.models.interfaces.Role;

public class Wolf implements Role {

    @Override
    public String getName() {
        return "Loup Garou";
    }

    @Override
    public void performAction(GameState state, Player player) {
        Player victim = state.getRandomAliveVillager();
        victim.kill();
    }
}
