package se.sprinto.hakan.adventuregame.model;

public class Ghost extends AbstractCharacter {
    public Ghost(String name, int health, int score, int strength) {
        super(name, health, score, strength);
    }

    @Override
    public void attack(AbstractCharacter target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }
}
