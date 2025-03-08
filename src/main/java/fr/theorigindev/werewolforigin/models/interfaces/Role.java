package fr.theorigindev.werewolforigin.models.interfaces;

import fr.theorigindev.werewolforigin.models.game.GameState;
import fr.theorigindev.werewolforigin.models.game.Player;

public interface Role {

    String getName();

    void performAction(GameState gameState, Player player);
}
