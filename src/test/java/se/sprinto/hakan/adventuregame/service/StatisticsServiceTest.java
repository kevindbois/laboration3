package se.sprinto.hakan.adventuregame.service;

import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.dao.FakeFileStatisticsDao;
import se.sprinto.hakan.adventuregame.model.Statistics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsServiceTest {


    @Test
    void getSortedStatistics_HighToLow() {
        FakeFileStatisticsDao fakeDao = new FakeFileStatisticsDao();
        StatisticsService service = new StatisticsService(fakeDao);


        List<Statistics> sortedList = service.getSortedStatistics();

        assertEquals("Kevin", sortedList.get(0).getPlayerName(), "BORDE VARA KEVIN(100)");
        assertEquals("Håkan", sortedList.get(1).getPlayerName(), "BORDE VARA HÅKAN(40)");
        assertEquals("Joel", sortedList.get(2).getPlayerName(), "BORDE VARA JOEL(30)");
    }
}
