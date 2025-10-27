package se.sprinto.hakan.adventuregame.dao;

import se.sprinto.hakan.adventuregame.model.Statistics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStatisticsDao implements StatisticsDao {

    private final File file = new File("statistics.txt");

    @Override
    public void save(Statistics stat) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(stat.getPlayerName() + ";" + stat.getScore());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Statistics> loadAll() {
        List<Statistics> stats = new ArrayList<>();
        if (!file.exists()) return stats;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                stats.add(new Statistics(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stats;
    }
}

