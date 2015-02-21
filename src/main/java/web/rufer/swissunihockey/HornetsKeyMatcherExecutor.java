package web.rufer.swissunihockey;

import web.rufer.swissunihockey.matcher.KeyMatcher;
import web.rufer.swissunihockey.matcher.MatchingPrinter;
import web.rufer.swissunihockey.matcher.domain.MatchingResult;
import web.rufer.swissunihockey.matcher.domain.League;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HornetsKeyMatcherExecutor {

    private static final String U_21C = "U21C";
    private static final String HERREN_1LGF = "H1L GF";
    private static final int NBR_OF_TEAMS_IN_U21C = 8;
    private static final int NBR_OF_TEAMS_IN_H1LGF = 10;

    public static void main(String[] args) {
        calculateAndPrintHornetsMatches();
    }

    private static void calculateAndPrintHornetsMatches() {
        League league1GF = createLeague1GF();
        League leagueU21C = createLeagueU21C();

        KeyMatcher keyMatcher = new KeyMatcher();
        MatchingResult matchingResult = keyMatcher.findMatchesForTwoLeagues(league1GF, leagueU21C);
        MatchingPrinter.printResult(league1GF, leagueU21C, matchingResult);
    }

    private static League createLeagueU21C() {
        // U21
        Map<LocalDate, List<Integer>> u21cMap = new HashMap();
        u21cMap.put(LocalDate.of(2015, 9, 26), Arrays.asList(0, 1, 2, 3));
        u21cMap.put(LocalDate.of(2015, 10, 03), Arrays.asList(7, 5, 4, 6));
        u21cMap.put(LocalDate.of(2015, 10, 17), Arrays.asList(1, 2, 0, 3));
        u21cMap.put(LocalDate.of(2015, 10, 24), Arrays.asList(5, 3, 4, 0));
        u21cMap.put(LocalDate.of(2015, 11, 14), Arrays.asList(4, 6, 2, 7));
        u21cMap.put(LocalDate.of(2015, 11, 21), Arrays.asList(5, 3, 1, 6));
        u21cMap.put(LocalDate.of(2015, 12, 5), Arrays.asList(0, 2, 7, 4));
        u21cMap.put(LocalDate.of(2015, 12, 12), Arrays.asList(4, 5, 6, 7));
        u21cMap.put(LocalDate.of(2016, 1, 9), Arrays.asList(2, 0, 1, 3));
        u21cMap.put(LocalDate.of(2016, 1, 16), Arrays.asList(6, 4, 7, 5));
        u21cMap.put(LocalDate.of(2016, 1, 23), Arrays.asList(2, 1, 7, 6));
        u21cMap.put(LocalDate.of(2016, 2, 13), Arrays.asList(3, 5, 0, 1));
        u21cMap.put(LocalDate.of(2016, 2, 20), Arrays.asList(7, 0, 2, 4));
        u21cMap.put(LocalDate.of(2016, 2, 27), Arrays.asList(1, 3, 6, 5));

        return new League(U_21C, NBR_OF_TEAMS_IN_U21C, u21cMap);
    }

    private static League createLeague1GF() {
        // Herren 1
        Map<LocalDate, List<Integer>> herren1LGF = new HashMap();
        herren1LGF.put(LocalDate.of(2015, 9, 19), Arrays.asList(0, 1, 2, 3, 4));
        herren1LGF.put(LocalDate.of(2015, 9, 26), Arrays.asList(8, 7, 5, 6, 9));
        herren1LGF.put(LocalDate.of(2015, 10, 3), Arrays.asList(2, 1, 3, 4, 9));
        herren1LGF.put(LocalDate.of(2015, 10, 10), Arrays.asList(6, 0, 7, 5, 1));
        herren1LGF.put(LocalDate.of(2015, 10, 17), Arrays.asList(8, 3, 9, 4, 2));
        herren1LGF.put(LocalDate.of(2015, 10, 24), Arrays.asList(0, 5, 2, 1, 6));
        herren1LGF.put(LocalDate.of(2015, 10, 25), Arrays.asList(9, 4, 3, 7, 8));
        herren1LGF.put(LocalDate.of(2015, 11, 14), Arrays.asList(3, 2, 0, 5, 1));
        herren1LGF.put(LocalDate.of(2015, 11, 15), Arrays.asList(7, 6, 9, 4, 8));
        herren1LGF.put(LocalDate.of(2015, 11, 21), Arrays.asList(5, 6, 7, 8, 9));
        herren1LGF.put(LocalDate.of(2015, 11, 28), Arrays.asList(4, 3, 1, 2, 0));
        herren1LGF.put(LocalDate.of(2015, 12, 5), Arrays.asList(5, 0, 6, 7, 8));
        herren1LGF.put(LocalDate.of(2015, 12, 12), Arrays.asList(4, 8, 9, 3, 2));
        herren1LGF.put(LocalDate.of(2015, 12, 19), Arrays.asList(7, 1, 6, 5, 0));
        herren1LGF.put(LocalDate.of(2016, 1, 9), Arrays.asList(7, 9, 3, 4, 8));
        herren1LGF.put(LocalDate.of(2016, 1, 16), Arrays.asList(1, 2, 0, 6, 5));
        herren1LGF.put(LocalDate.of(2016, 1, 23), Arrays.asList(4, 9, 6, 7, 8));
        herren1LGF.put(LocalDate.of(2016, 1, 24), Arrays.asList(1, 5, 3, 0, 2));

        return new League(HERREN_1LGF, NBR_OF_TEAMS_IN_H1LGF, herren1LGF);
    }
}
