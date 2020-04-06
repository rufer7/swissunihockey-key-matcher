/*
 * Copyright (C) 2015 Marc Rufer (m.rufer@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.rufer.swissunihockey.matcher;

import org.junit.Before;
import org.junit.Test;
import be.rufer.swissunihockey.matcher.KeyMatcher;
import be.rufer.swissunihockey.matcher.domain.MatchingResult;
import be.rufer.swissunihockey.matcher.domain.League;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class KeyMatcherTest {

    private static final String LEAGUE_NAME_1 = "league1";
    private static final String LEAGUE_NAME_2 = "league2";
    private static final int nbrOfTeamsInLeague1 = 4;
    private static final int nbrOfTeamsInLeague2 = 2;
    private Map<LocalDate, List<Integer>> keysPerDateMapLeague1 = new HashMap<>();
    private Map<LocalDate, List<Integer>> keysPerDateMapLeague2 = new HashMap<>();
    private LocalDate matchingDate1 = LocalDate.of(2015, 1, 1);
    private LocalDate matchingDate2 = LocalDate.of(2015, 1, 8);
    private LocalDate matchingDate3 = LocalDate.of(2015, 1, 15);
    private List<Integer> gameScheduleKeysLeague1 = Arrays.asList(1, 2);
    private List<Integer> gameScheduleKeysLeague2 = Collections.singletonList(1);
    private List<Integer> secondGameScheduleKeysLeague1 = Arrays.asList(2, 3);
    private List<Integer> secondGameScheduleKeysLeague2 = Collections.singletonList(1);

    private KeyMatcher keyMatcher;

    @Before
    public void init() {
        keyMatcher = new KeyMatcher();
    }

    @Test
    public void findMatchesForTwoLeaguesAndOneEqualDateFindsExpectedMatches() {
        keysPerDateMapLeague1.put(matchingDate1, gameScheduleKeysLeague1);
        keysPerDateMapLeague2.put(matchingDate1, gameScheduleKeysLeague2);
        League league1 = new League(LEAGUE_NAME_1, nbrOfTeamsInLeague1, keysPerDateMapLeague1);
        League league2 = new League(LEAGUE_NAME_2, nbrOfTeamsInLeague2, keysPerDateMapLeague2);
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoLeagues(league1, league2);
        assertEquals(createExpectedMatchingResultForTwoLeaguesAndOneEqualDate().getMatchesPerCombination(), matchingResult.getMatchesPerCombination());
    }

    private MatchingResult createExpectedMatchingResultForTwoLeaguesAndOneEqualDate() {
        MatchingResult matchingResult = new MatchingResult();
        matchingResult.setMatchForCombination("1" + Constants.TAB + "1", 1);
        matchingResult.setMatchForCombination("1" + Constants.TAB + "2", 0);
        matchingResult.setMatchForCombination("2" + Constants.TAB + "1", 1);
        matchingResult.setMatchForCombination("2" + Constants.TAB + "2", 0);
        matchingResult.setMatchForCombination("3" + Constants.TAB + "1", 0);
        matchingResult.setMatchForCombination("3" + Constants.TAB + "2", 0);
        matchingResult.setMatchForCombination("4" + Constants.TAB + "1", 0);
        matchingResult.setMatchForCombination("4" + Constants.TAB + "2", 0);
        return matchingResult;
    }

    @Test
    public void findMatchesForTwoLeaguesAndTwoDatesEqualFindsExpectedMatches() {
        keysPerDateMapLeague1.put(matchingDate1, gameScheduleKeysLeague1);
        keysPerDateMapLeague1.put(matchingDate2, secondGameScheduleKeysLeague1);
        keysPerDateMapLeague2.put(matchingDate1, gameScheduleKeysLeague2);
        keysPerDateMapLeague2.put(matchingDate2, secondGameScheduleKeysLeague2);
        League league1 = new League(LEAGUE_NAME_1, nbrOfTeamsInLeague1, keysPerDateMapLeague1);
        League league2 = new League(LEAGUE_NAME_2, nbrOfTeamsInLeague2, keysPerDateMapLeague2);
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoLeagues(league1, league2);
        assertEquals(createExpectedMatchingResultForTwoLeaguesAndTwoEqualDates().getMatchesPerCombination(), matchingResult.getMatchesPerCombination());
    }

    private MatchingResult createExpectedMatchingResultForTwoLeaguesAndTwoEqualDates() {
        MatchingResult matchingResult = new MatchingResult();
        matchingResult.setMatchForCombination("1" + Constants.TAB + "1", 1);
        matchingResult.setMatchForCombination("1" + Constants.TAB + "2", 0);
        matchingResult.setMatchForCombination("2" + Constants.TAB + "1", 2);
        matchingResult.setMatchForCombination("2" + Constants.TAB + "2", 0);
        matchingResult.setMatchForCombination("3" + Constants.TAB + "1", 1);
        matchingResult.setMatchForCombination("3" + Constants.TAB + "2", 0);
        matchingResult.setMatchForCombination("4" + Constants.TAB + "1", 0);
        matchingResult.setMatchForCombination("4" + Constants.TAB + "2", 0);
        return matchingResult;
    }

    @Test
    public void findMatchesForTwoLeaguesAndDifferentDatesFindsExpectedMatches() {
        keysPerDateMapLeague1.put(matchingDate1, gameScheduleKeysLeague1);
        keysPerDateMapLeague1.put(matchingDate2, secondGameScheduleKeysLeague1);
        keysPerDateMapLeague2.put(matchingDate1, gameScheduleKeysLeague2);
        keysPerDateMapLeague2.put(matchingDate2, secondGameScheduleKeysLeague2);
        keysPerDateMapLeague2.put(matchingDate3, secondGameScheduleKeysLeague2);
        League league1 = new League(LEAGUE_NAME_1, nbrOfTeamsInLeague1, keysPerDateMapLeague1);
        League league2 = new League(LEAGUE_NAME_2, nbrOfTeamsInLeague2, keysPerDateMapLeague2);
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoLeagues(league1, league2);
        assertEquals(createExpectedMatchingResultForTwoLeaguesAndTwoEqualDates().getMatchesPerCombination(), matchingResult.getMatchesPerCombination());
    }
}
