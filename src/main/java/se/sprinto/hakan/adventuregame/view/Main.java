package se.sprinto.hakan.adventuregame.view;
import se.sprinto.hakan.adventuregame.dao.FileStatisticsDao;
import se.sprinto.hakan.adventuregame.dao.StatisticsDao;
import se.sprinto.hakan.adventuregame.model.Player;
import se.sprinto.hakan.adventuregame.model.StartRoom;
import se.sprinto.hakan.adventuregame.model.Statistics;
import se.sprinto.hakan.adventuregame.service.StatisticsService;
import se.sprinto.hakan.adventuregame.util.AppInfo;

public class Main {

    public static void main(String[] args) {
        UI ui = new ScannerUI();
        AppInfo appInfo = AppInfo.getInstance();
        ui.showMessage("Välkommen till Äventyrsspelet!");
        ui.showMessage("Version " + appInfo.getVersion() + " av " + appInfo.getAuthor());
        String name = ui.getInput("Ange ditt namn:");
        Player player = new Player.Builder()
                .setName(name)
                .setHealth(100)
                .setScore(0)
                .setStrength(10)
                .build();


        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

