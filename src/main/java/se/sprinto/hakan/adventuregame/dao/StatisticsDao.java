package se.sprinto.hakan.adventuregame.dao;

import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.List;

public interface StatisticsDao {
    void save(Statistics stat);

    List<Statistics> loadAll();
}

