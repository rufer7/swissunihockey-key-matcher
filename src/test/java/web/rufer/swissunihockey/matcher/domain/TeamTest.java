package web.rufer.swissunihockey.matcher.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class TeamTest {

    private static final String TEAM_NAME = "myTeam";
    private static final int nbrOfTeamsInLeague = 4;
    private Map<LocalDate, List<Integer>> emptyMap = new HashMap();
    private List<Integer> gameScheduleKey = Arrays.asList(1);
    private LocalDate sampleDate = LocalDate.of(2015, 1, 1);

    @Test
    public void constructTeamSetsCorrectNameAndMap() {
        Team team = new Team(TEAM_NAME, nbrOfTeamsInLeague, emptyMap);
        assertEquals(TEAM_NAME, team.getName());
        assertEquals(Collections.emptyMap(), team.getTeamKeysWithHomeGamePerDate());
    }

    @Test
    public void addingEntryToTeamKeysWithHomeGamePerDatePutsEntryToMap() {
        Team team = new Team(TEAM_NAME, nbrOfTeamsInLeague, emptyMap);
        team.addTeamKeysWithHomeGameForDate(sampleDate, gameScheduleKey);
        Map<LocalDate, List<Integer>> expectedMap = new HashMap();
        expectedMap.put(sampleDate, gameScheduleKey);
        assertEquals(expectedMap, team.getTeamKeysWithHomeGamePerDate());
    }
}
