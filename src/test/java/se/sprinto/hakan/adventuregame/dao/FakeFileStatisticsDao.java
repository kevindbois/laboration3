package se.sprinto.hakan.adventuregame.dao;

import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticsDao implements StatisticsDao {
    @Override
    public void save(Statistics stat) {

    }

    @Override
    public List<Statistics> loadAll() {
        return new ArrayList<>(List.of(
                new Statistics("Håkan", 40),
                new Statistics("Kevin", 100),
                new Statistics("Joel", 30)

        ));
    }
}
