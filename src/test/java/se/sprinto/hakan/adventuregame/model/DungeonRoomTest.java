package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DungeonRoomTest {
    @Test
    public void DungeonRoomTest() {
        FakeUI ui = new FakeUI();
        DungeonRoom dungeonRoom = new DungeonRoom();
        ui.setInput("a");
        Player player = new Player.Builder()
                .setName("Kevin")
                .setHealth(1)
                .setScore(0)
                .setStrength(10)
                .build();
        dungeonRoom.enterRoom(player, ui);
        assertTrue(player.hasDefeatedEnemy(), "Bör döda monstret så länge hp över 40 ");
    }
}
