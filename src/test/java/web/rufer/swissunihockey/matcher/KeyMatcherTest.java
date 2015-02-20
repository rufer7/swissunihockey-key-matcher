package web.rufer.swissunihockey.matcher;

import org.junit.Before;
import org.junit.Test;
import web.rufer.swissunihockey.matcher.domain.MatchingResult;
import web.rufer.swissunihockey.matcher.domain.Team;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class KeyMatcherTest {

    private static final String TEAM_NAME_1 = "team1";
    private static final String TEAM_NAME_2 = "team2";
    private static final int nbrOfTeamsInLeague1 = 3;
    private static final int nbrOfTeamsInLeague2 = 2;
    private Map<LocalDate, List<Integer>> keyMapTeam1 = new HashMap();
    private Map<LocalDate, List<Integer>> keyMapTeam2 = new HashMap();
    private LocalDate matchingDate = LocalDate.of(2015, 1, 1);
    private LocalDate matchingDate2 = LocalDate.of(2015, 1, 2);
    private List<Integer> gameScheduleKeysTeam1 = Arrays.asList(0, 1, 2);
    private List<Integer> gameScheduleKeysTeam2 = Arrays.asList(1);
    private List<Integer> secondGameScheduleKeysTeam1 = Arrays.asList(1);
    private List<Integer> secondGameScheduleKeysTeam2 = Arrays.asList(0, 1);

    private KeyMatcher keyMatcher;

    @Before
    public void init() {
        keyMatcher = new KeyMatcher();
    }

    @Test
    public void findMatchesForTwoTeamsAndOneDateFindsExpectedMatches() {
        keyMapTeam1.put(matchingDate, gameScheduleKeysTeam1);
        keyMapTeam2.put(matchingDate, gameScheduleKeysTeam2);
        Team team1 = new Team(TEAM_NAME_1, nbrOfTeamsInLeague1, keyMapTeam1);
        Team team2 = new Team(TEAM_NAME_2, nbrOfTeamsInLeague2, keyMapTeam2);
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoTeams(team1, team2);
        assertEquals(createExpectedMatchingResultForTwoTeamsAndOneDate().getMatchesPerCombination(), matchingResult.getMatchesPerCombination());
    }

    private MatchingResult createExpectedMatchingResultForTwoTeamsAndOneDate() {
        MatchingResult matchingResult = new MatchingResult();
        matchingResult.setMatchForCombination("0 0", 0);
        matchingResult.setMatchForCombination("0 1", 1);
        matchingResult.setMatchForCombination("1 0", 0);
        matchingResult.setMatchForCombination("1 1", 1);
        matchingResult.setMatchForCombination("2 0", 0);
        matchingResult.setMatchForCombination("2 1", 1);
        return matchingResult;
    }

    @Test
    public void findMatchesForTwoTeamsAndTwoDatesFindsExpectedMatches() {
        keyMapTeam1.put(matchingDate, gameScheduleKeysTeam1);
        keyMapTeam1.put(matchingDate2, secondGameScheduleKeysTeam1);
        keyMapTeam2.put(matchingDate, gameScheduleKeysTeam2);
        keyMapTeam2.put(matchingDate2, secondGameScheduleKeysTeam2);
        Team team1 = new Team(TEAM_NAME_1, nbrOfTeamsInLeague1, keyMapTeam1);
        Team team2 = new Team(TEAM_NAME_2, nbrOfTeamsInLeague2, keyMapTeam2);
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoTeams(team1, team2);
        assertEquals(createExpectedMatchingResultForTwoTeamsAndTwoDates().getMatchesPerCombination(), matchingResult.getMatchesPerCombination());
    }

    private MatchingResult createExpectedMatchingResultForTwoTeamsAndTwoDates() {
        MatchingResult matchingResult = new MatchingResult();
        matchingResult.setMatchForCombination("0 0", 0);
        matchingResult.setMatchForCombination("0 1", 1);
        matchingResult.setMatchForCombination("1 0", 1);
        matchingResult.setMatchForCombination("1 1", 2);
        matchingResult.setMatchForCombination("2 0", 0);
        matchingResult.setMatchForCombination("2 1", 1);
        return matchingResult;
    }
}
