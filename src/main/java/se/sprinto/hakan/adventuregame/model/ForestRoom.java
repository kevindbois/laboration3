package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class ForestRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kliver in i en mörk skog. Något glimmar i mossan...");
        String choice = ui.getInput("Vill du undersöka glittret? (ja/nej)");
        if (choice.equalsIgnoreCase("ja")) {
            ui.showMessage("Du hittar en nyckel!");
            player.setFoundKey(true);
            player.addScore(20);
        } else {
            ui.showMessage("Du ignorerar glittret och går vidare.");
        }
    }
}

