package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.TreasureRoom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreasureRoomTest  {


    @Test
    public void testTreasureRoom() {
        FakeUI ui = new FakeUI();
        TreasureRoom treasureRoom = new TreasureRoom();
        ui.setInput("ja");
        Player player = new Player.Builder()
                .setName("Kevin")
                .setHealth(100)
                .setScore(0)
                .setStrength(10)
                .setFoundKey(true)
                .build();

        treasureRoom.enterRoom(player, ui);
        assertTrue(player.hasOpenedChest(), "Spelaren bör ha öppnat kisten");
        assertEquals(100, player.getScore(), "Spelaren bör ha 100 i score");
    }



}
