package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class SewerRoom implements Room {
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du har gått ner till kloaken. Du ser en liten råtta.");
        Rat rat = new Rat("Råtta", 10, 0, 1);

        while (rat.isAlive() && player.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(rat);
                ui.showMessage("Du attackerade råttan");
                if (rat.isAlive()) {
                    rat.attack(player);
                    ui.showMessage("Råttan attackerade dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du dödade råttan! ");
                    player.setDefeatedEnemy(true);
                    player.addScore(5);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer iväg!");
                break;
            }


        }
    }
}
