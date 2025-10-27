package se.sprinto.hakan.adventuregame.model;

public abstract class AbstractCharacter {
    private String name;
    private int health;
    private int score;
    private int strength;

    public AbstractCharacter(String name, int health, int score, int strength) {
        this.name = name;
        this.health = health;
        this.score = score;
        this.strength = strength;
    }

    public abstract void attack(AbstractCharacter target);

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public int getScore() {
        return score;
    }

    public void addScore(int amount) {
        this.score += amount;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isAlive() {
        return health > 0;
    }
}

