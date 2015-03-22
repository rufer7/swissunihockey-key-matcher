package be.rufer.swissunihockey.matcher.domain;

import org.junit.Test;
import be.rufer.swissunihockey.matcher.domain.League;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class LeagueTest {

    private static final String LEAGUE_NAME = "sampleLeague";
    private static final int nbrOfTeamsInLeague = 4;
    private Map<LocalDate, List<Integer>> emptyKeysPerDateMap = new HashMap<>();
    private List<Integer> gameScheduleKey = Arrays.asList(1);
    private LocalDate sampleDate = LocalDate.of(2015, 1, 1);

    @Test
    public void constructLeagueSetsCorrectNameAndMap() {
        League league = new League(LEAGUE_NAME, nbrOfTeamsInLeague, emptyKeysPerDateMap);
        assertEquals(LEAGUE_NAME, league.getName());
        assertEquals(Collections.emptyMap(), league.getKeysWithHomeGamePerDate());
    }

    @Test
    public void addingEntryToKeysWithHomeGamePerDatePutsEntryToMap() {
        League league = new League(LEAGUE_NAME, nbrOfTeamsInLeague, emptyKeysPerDateMap);
        league.addKeysWithHomeGameForDate(sampleDate, gameScheduleKey);
        Map<LocalDate, List<Integer>> expectedMap = new HashMap<>();
        expectedMap.put(sampleDate, gameScheduleKey);
        assertEquals(expectedMap, league.getKeysWithHomeGamePerDate());
    }
}
