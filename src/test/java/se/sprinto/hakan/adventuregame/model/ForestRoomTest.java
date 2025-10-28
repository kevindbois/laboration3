package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.model.ForestRoom;
import se.sprinto.hakan.adventuregame.model.Player;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForestRoomTest {


    @Test
    public void TestForestRoom() {
        FakeUI ui = new FakeUI();
        ForestRoom forestRoom = new ForestRoom();
        ui.setInput("ja");
        Player player = new Player.Builder()
                .setName("KevinTEST")
                .setHealth(100)
                .setScore(0)
                .setStrength(10)
                .build();
        forestRoom.enterRoom(player, ui);
        assertTrue(player.hasFoundKey());


    }
}
