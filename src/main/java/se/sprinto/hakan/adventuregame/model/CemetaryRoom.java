package se.sprinto.hakan.adventuregame.model;

import se.sprinto.hakan.adventuregame.view.UI;

public class CemetaryRoom implements Room {
    private boolean isDone = false;
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kommer till en gravplats. Det står ett spöke framför dig.");
        Ghost ghost = new Ghost("Spöke", 40, 0, 20);

        while (player.isAlive() && ghost.isAlive() && !isDone) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)etirera?");
            if (choice.equals("a")) {
                player.attack(ghost);
                ui.showMessage("Du attackerade spöket!");
                if (ghost.isAlive()) {
                    System.out.print("Spökets HP:" + ghost.getHealth());
                    ghost.attack(player);
                    ui.showMessage("Spöket attackerade dig! Ditt HP: " + player.getHealth());
                } else {
                    ui.showMessage("Du dödade spöket!");
                    player.setDefeatedEnemy(true);
                    player.addScore(50);
                    ui.showMessage("Spöket tappade sin kristall...");
                    choice = ui.getInput("Vill du öka ditt HP eller din STR?");
                    if (choice.equalsIgnoreCase("hp")) {
                        player.setHealth(player.getHealth() + 50);
                        System.out.println("Ditt HP är nu: " + player.getHealth());
                        isDone = true;
                    } else if (choice.equalsIgnoreCase("str")) {
                        player.setStrength(player.getStrength() + 50);
                        System.out.println("Din styrka ökades! Den är nu: " + player.getStrength());
                        isDone = true;
                    }
                }
            } else if (choice.equals("r")) {
                ui.showMessage("Du springer därifrån!");
                isDone = false;
                break;
            }
        }

    }
}
