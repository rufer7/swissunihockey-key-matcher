package web.rufer.swissunihockey.matcher;

import org.junit.Before;
import org.junit.Test;
import web.rufer.swissunihockey.matcher.domain.MatchingResult;
import web.rufer.swissunihockey.matcher.domain.League;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class KeyMatcherTest {

    private static final String LEAGUE_NAME_1 = "league1";
    private static final String LEAGUE_NAME_2 = "league2";
    private static final int nbrOfTeamsInLeague1 = 3;
    private static final int nbrOfTeamsInLeague2 = 2;
    private Map<LocalDate, List<Integer>> keysPerDateMapLeague1 = new HashMap();
    private Map<LocalDate, List<Integer>> keysPerDateMapLeague2 = new HashMap();
    private LocalDate matchingDate = LocalDate.of(2015, 1, 1);
    private LocalDate matchingDate2 = LocalDate.of(2015, 1, 2);
    private LocalDate matchingDate3 = LocalDate.of(2015, 1, 3);
    private List<Integer> gameScheduleKeysLeague1 = Arrays.asList(0, 1, 2);
    private List<Integer> gameScheduleKeysLeague2 = Arrays.asList(1);
    private List<Integer> secondGameScheduleKeysLeague1 = Arrays.asList(1);
    private List<Integer> secondGameScheduleKeysLeague2 = Arrays.asList(0, 1);

    private KeyMatcher keyMatcher;

    @Before
    public void init() {
        keyMatcher = new KeyMatcher();
    }

    @Test
    public void findMatchesForTwoLeaguesAndOneEqualDateFindsExpectedMatches() {
        keysPerDateMapLeague1.put(matchingDate, gameScheduleKeysLeague1);
        keysPerDateMapLeague2.put(matchingDate, gameScheduleKeysLeague2);
        League league1 = new League(LEAGUE_NAME_1, nbrOfTeamsInLeague1, keysPerDateMapLeague1);
        League league2 = new League(LEAGUE_NAME_2, nbrOfTeamsInLeague2, keysPerDateMapLeague2);
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoLeagues(league1, league2);
        assertEquals(createExpectedMatchingResultForTwoLeaguesAndOneEqualDate().getMatchesPerCombination(), matchingResult.getMatchesPerCombination());
    }

    private MatchingResult createExpectedMatchingResultForTwoLeaguesAndOneEqualDate() {
        MatchingResult matchingResult = new MatchingResult();
        matchingResult.setMatchForCombination("0" + KeyMatcher.BLANKS + "0", 0);
        matchingResult.setMatchForCombination("0" + KeyMatcher.BLANKS + "1", 1);
        matchingResult.setMatchForCombination("1" + KeyMatcher.BLANKS + "0", 0);
        matchingResult.setMatchForCombination("1" + KeyMatcher.BLANKS + "1", 1);
        matchingResult.setMatchForCombination("2" + KeyMatcher.BLANKS + "0", 0);
        matchingResult.setMatchForCombination("2" + KeyMatcher.BLANKS + "1", 1);
        return matchingResult;
    }

    @Test
    public void findMatchesForTwoLeaguesAndTwoDatesEqualFindsExpectedMatches() {
        keysPerDateMapLeague1.put(matchingDate, gameScheduleKeysLeague1);
        keysPerDateMapLeague1.put(matchingDate2, secondGameScheduleKeysLeague1);
        keysPerDateMapLeague2.put(matchingDate, gameScheduleKeysLeague2);
        keysPerDateMapLeague2.put(matchingDate2, secondGameScheduleKeysLeague2);
        League league1 = new League(LEAGUE_NAME_1, nbrOfTeamsInLeague1, keysPerDateMapLeague1);
        League league2 = new League(LEAGUE_NAME_2, nbrOfTeamsInLeague2, keysPerDateMapLeague2);
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoLeagues(league1, league2);
        assertEquals(createExpectedMatchingResultForTwoLeaguesAndTwoEqualDates().getMatchesPerCombination(), matchingResult.getMatchesPerCombination());
    }

    private MatchingResult createExpectedMatchingResultForTwoLeaguesAndTwoEqualDates() {
        MatchingResult matchingResult = new MatchingResult();
        matchingResult.setMatchForCombination("0" + KeyMatcher.BLANKS + "0", 0);
        matchingResult.setMatchForCombination("0" + KeyMatcher.BLANKS + "1", 1);
        matchingResult.setMatchForCombination("1" + KeyMatcher.BLANKS + "0", 1);
        matchingResult.setMatchForCombination("1" + KeyMatcher.BLANKS + "1", 2);
        matchingResult.setMatchForCombination("2" + KeyMatcher.BLANKS + "0", 0);
        matchingResult.setMatchForCombination("2" + KeyMatcher.BLANKS + "1", 1);
        return matchingResult;
    }

    @Test
    public void findMatchesForTwoLeaguesAndDifferentDatesFindsExpectedMatches() {
        keysPerDateMapLeague1.put(matchingDate, gameScheduleKeysLeague1);
        keysPerDateMapLeague1.put(matchingDate2, secondGameScheduleKeysLeague1);
        keysPerDateMapLeague2.put(matchingDate, gameScheduleKeysLeague2);
        keysPerDateMapLeague2.put(matchingDate2, secondGameScheduleKeysLeague2);
        keysPerDateMapLeague2.put(matchingDate3, secondGameScheduleKeysLeague2);
        League league1 = new League(LEAGUE_NAME_1, nbrOfTeamsInLeague1, keysPerDateMapLeague1);
        League league2 = new League(LEAGUE_NAME_2, nbrOfTeamsInLeague2, keysPerDateMapLeague2);
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoLeagues(league1, league2);
        assertEquals(createExpectedMatchingResultForTwoLeaguesAndTwoEqualDates().getMatchesPerCombination(), matchingResult.getMatchesPerCombination());
    }
}
