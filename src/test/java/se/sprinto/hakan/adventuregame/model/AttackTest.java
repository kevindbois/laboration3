package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackTest {

    @Test
    public void TestAttack() {
        Giant giant = new Giant("Jätte", 100, 0,20);
        Player player = new Player.Builder()
                .setName("KEVIN")
                .setHealth(1000)
                .setScore(0)
                .setStrength(40)
                .build();
        player.attack(giant);
        assertEquals(60, giant.getHealth(), "Borde ha minsat med 40");
    }
}
