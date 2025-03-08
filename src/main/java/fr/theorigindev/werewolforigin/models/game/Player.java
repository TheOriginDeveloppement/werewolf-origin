package fr.theorigindev.werewolforigin.models.game;

import fr.theorigindev.werewolforigin.models.interfaces.Role;

public class Player {
    private String name;
    private Role role;
    private boolean isAlive;

    public Player(String name, Role role){
        this.name = name;
        this.role = role;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public void kill() {
        isAlive = false;
    }
}
