package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class CemetaryRoom implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kommer till en gravplats. Det står ett spöke framför dig.");
        Ghost ghost = new Ghost("Spöke", 40, 0, 20);

        while (player.isAlive() && ghost.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equals("a")) {
                player.attack(ghost);
                ui.showMessage("Du attackerade spöket! Spökets HP: " + ghost.getHealth());
                if (ghost.isAlive()) {
                    ghost.attack(player);
                    ui.showMessage("Spöket attackerade dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du dödade spöket!");
                    player.setDefeatedEnemy(true);
                    player.addScore(50);
                }
            } else if (choice.equals("r")) {
                ui.showMessage("Du springer därifrån!");
                break;
            }
        }

    }
}
