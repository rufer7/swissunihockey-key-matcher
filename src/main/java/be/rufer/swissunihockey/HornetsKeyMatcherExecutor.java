/*
 * Copyright (C) 2016 Marc Rufer (m.rufer@gmx.ch)
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
package be.rufer.swissunihockey;

import be.rufer.swissunihockey.matcher.KeyMatcher;
import be.rufer.swissunihockey.matcher.MatchingPrinter;
import be.rufer.swissunihockey.matcher.domain.MatchingResult;
import be.rufer.swissunihockey.matcher.domain.League;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HornetsKeyMatcherExecutor {

    private static final String U_21C = "U21C";
    private static final String HERREN_1LGF = "H1L GF";
    private static final int NBR_OF_TEAMS_IN_U21C = 8;
    private static final int NBR_OF_TEAMS_IN_H1LGF = 12;

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
        Map<LocalDate, List<Integer>> u21cMap = new HashMap<>();
        // Date, Keys that play at home at this date
        u21cMap.put(LocalDate.of(2016, 9, 1), Arrays.asList(0, 1, 2, 3));
        u21cMap.put(LocalDate.of(2016, 9, 8), Arrays.asList(7, 5, 4, 6));
        u21cMap.put(LocalDate.of(2016, 10, 15), Arrays.asList(1, 2, 0, 3));
        u21cMap.put(LocalDate.of(2016, 10, 22), Arrays.asList(5, 3, 4, 0));
        u21cMap.put(LocalDate.of(2016, 11, 12), Arrays.asList(4, 6, 2, 7));
        u21cMap.put(LocalDate.of(2016, 11, 19), Arrays.asList(5, 3, 1, 6));
        u21cMap.put(LocalDate.of(2016, 11, 26), Arrays.asList(0, 2, 7, 4));
        u21cMap.put(LocalDate.of(2016, 12, 3), Arrays.asList(4, 5, 6, 7));
        u21cMap.put(LocalDate.of(2016, 12, 17), Arrays.asList(2, 0, 1, 3));
        u21cMap.put(LocalDate.of(2017, 1, 14), Arrays.asList(6, 4, 7, 5));
        u21cMap.put(LocalDate.of(2017, 1, 21), Arrays.asList(2, 1, 7, 6));
        u21cMap.put(LocalDate.of(2017, 2, 11), Arrays.asList(3, 5, 0, 1));
        u21cMap.put(LocalDate.of(2017, 2, 18), Arrays.asList(7, 0, 2, 4));
        u21cMap.put(LocalDate.of(2017, 2, 26), Arrays.asList(1, 3, 6, 5));

        return new League(U_21C, NBR_OF_TEAMS_IN_U21C, u21cMap);
    }

    private static League createLeague1GF() {
        // Herren 1
        Map<LocalDate, List<Integer>> herren1LGF = new HashMap<>();
        // Date, Keys that play at home at this date
        herren1LGF.put(LocalDate.of(2016, 9, 17), Arrays.asList(1, 3, 5, 7, 9, 11));
        herren1LGF.put(LocalDate.of(2016, 9, 24), Arrays.asList(10, 8, 6, 4, 12, 2));
        herren1LGF.put(LocalDate.of(2016, 9, 25), Arrays.asList(1, 3, 5, 7, 12, 11));
        herren1LGF.put(LocalDate.of(2016, 10, 1), Arrays.asList(10, 8, 6, 4, 9, 2));
        herren1LGF.put(LocalDate.of(2016, 10, 8), Arrays.asList(1, 3, 5, 4, 12, 11));
        herren1LGF.put(LocalDate.of(2016, 10, 15), Arrays.asList(10, 8, 1, 7, 9, 2));
        herren1LGF.put(LocalDate.of(2016, 10, 16), Arrays.asList(5, 3, 6, 4, 12, 11));
        herren1LGF.put(LocalDate.of(2016, 10, 22), Arrays.asList(10, 8, 5, 7, 9, 2));
        herren1LGF.put(LocalDate.of(2016, 10, 29), Arrays.asList(1, 10, 6, 4, 12, 11));
        herren1LGF.put(LocalDate.of(2016, 11, 12), Arrays.asList(1, 3, 5, 7, 9, 2));
        herren1LGF.put(LocalDate.of(2016, 11, 13), Arrays.asList(10, 8, 6, 4, 12, 11));
        herren1LGF.put(LocalDate.of(2016, 11, 19), Arrays.asList(2, 4, 6, 8, 10, 12));
        herren1LGF.put(LocalDate.of(2016, 11, 26), Arrays.asList(7, 5, 3, 11, 1, 9));
        herren1LGF.put(LocalDate.of(2016, 12, 3), Arrays.asList(9, 8, 10, 2, 4, 6));
        herren1LGF.put(LocalDate.of(2016, 12, 4), Arrays.asList(3, 11, 12, 1, 7, 5));
        herren1LGF.put(LocalDate.of(2016, 12, 17), Arrays.asList(7, 2, 9, 6, 8, 10));
        herren1LGF.put(LocalDate.of(2017, 1, 7), Arrays.asList(12, 4, 6, 5, 3, 11));
        herren1LGF.put(LocalDate.of(2017, 1, 8), Arrays.asList(1, 7, 8, 10, 2, 9));
        herren1LGF.put(LocalDate.of(2017, 1, 14), Arrays.asList(6, 1, 3, 11, 12, 4));
        herren1LGF.put(LocalDate.of(2017, 1, 21), Arrays.asList(3, 8, 2, 9, 7, 5));
        herren1LGF.put(LocalDate.of(2017, 1, 28), Arrays.asList(10, 11, 12, 4, 6 ,8));
        herren1LGF.put(LocalDate.of(2017, 1, 29), Arrays.asList(2, 9, 7, 5, 3, 1));

        return new League(HERREN_1LGF, NBR_OF_TEAMS_IN_H1LGF, herren1LGF);
    }
}
