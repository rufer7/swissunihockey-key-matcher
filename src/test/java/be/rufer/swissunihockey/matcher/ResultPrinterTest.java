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
import be.rufer.swissunihockey.matcher.domain.League;
import be.rufer.swissunihockey.matcher.domain.MatchingResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ResultPrinterTest {

    private League league1;
    private League league2;
    private static final String LEAGUE_NAME_1 = "league1";
    private static final String LEAGUE_NAME_2 = "league2";
    private static final int nbrOfTeamsInLeague = 4;
    private Map<LocalDate, List<Integer>> keysPerDateMapLeague1 = new HashMap<>();
    private MatchingResult matchingResult = new MatchingResult();

    @Before
    public void init() {
        league1 = new League(LEAGUE_NAME_1, nbrOfTeamsInLeague, keysPerDateMapLeague1);
        league2 = new League(LEAGUE_NAME_2, nbrOfTeamsInLeague, keysPerDateMapLeague1);
        matchingResult.setMatchForCombination("0" + KeyMatcher.BLANKS + "1", 2);
        matchingResult.setMatchForCombination("1" + KeyMatcher.BLANKS + "1", 1);
    }

    @Test
    public void printResultPrintsExpectedResultToConsole() {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(boas);
        System.setOut(ps);
        ResultPrinter.print(league1, league2, matchingResult);
        assertEquals(createExpectedConsoleOutput().trim(), boas.toString().trim());
    }

    private String createExpectedConsoleOutput() {
        return new StringBuilder().append(createExpectedHeader()).
                append(System.getProperty("line.separator")).
                append("1").append(KeyMatcher.BLANKS).append("1").
                append(ResultPrinter.TAB).append(1).
                append(System.getProperty("line.separator")).
                append("0").append(KeyMatcher.BLANKS).append("1").
                append(ResultPrinter.TAB).append(2).toString();
    }

    @Test
    public void createHeader() {
        String header = ResultPrinter.createHeader(league1, league2);
        assertEquals(createExpectedHeader(), header);
    }

    private String createExpectedHeader() {
        return new StringBuilder().append(LEAGUE_NAME_1).
                append(ResultPrinter.TAB).append(LEAGUE_NAME_2).
                append(ResultPrinter.TAB).append(ResultPrinter.MATCHES).toString();
    }
}
