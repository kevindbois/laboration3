package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.dao.FakeFileStatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsServiceTest {


    @Test
    void getSortedStatistics_shouldReturnSortedList() {
        FakeFileStatisticsDao fakeDao = new FakeFileStatisticsDao();
        StatisticsService service = new StatisticsService(fakeDao);


        List<Statistics> result = service.getSortedStatistics();

        assertEquals(40, result.get(0).getScore(), "borde resultera med 40");
        assertEquals(100, result.get(1).getScore(), "borde resultera med 100");
        assertEquals(30, result.get(2).getScore(), "Borde resultera med 30");
    }
}
