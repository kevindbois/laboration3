package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class DungeonRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går ner i en kall fängelsehåla. En vätte står i vägen!");
        Enemy goblin = new Enemy("Vätte", 20, 0, 5);

        while (player.isAlive() && goblin.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(goblin);
                ui.showMessage("Du attackerar vätten! Vättens HP: " + goblin.getHealth());
                if (goblin.isAlive()) {
                    goblin.attack(player);
                    ui.showMessage("Vätten attackerar dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade vätten!");
                    player.setDefeatedEnemy(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }
    }
}

