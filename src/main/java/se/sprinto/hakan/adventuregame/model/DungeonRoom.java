package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class DungeonRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner i en kall fängelsehåla. En jätte står i vägen!");
        Giant giant = new Giant("Vätte", 20, 0, 5);

        while (player.isAlive() && giant.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(giant);
                ui.showMessage("Du attackerar jätten! Jättens HP: " + giant.getHealth());
                if (giant.isAlive()) {
                    giant.attack(player);
                    ui.showMessage("Jätten attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade jätten!");
                    player.setDefeatedEnemy(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
    }
}

