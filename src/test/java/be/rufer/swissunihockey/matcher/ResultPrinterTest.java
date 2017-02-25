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
    private static final String LINE_SEPARATOR = "line.separator";
    private static final String LEAGUE_NAME_1 = "league1";
    private static final String LEAGUE_NAME_2 = "league2";
    private static final int nbrOfTeamsInLeague = 4;
    private Map<LocalDate, List<Integer>> keysPerDateMapLeague = new HashMap<>();
    private MatchingResult matchingResult = new MatchingResult();

    @Before
    public void init() {
        league1 = new League(LEAGUE_NAME_1, nbrOfTeamsInLeague, keysPerDateMapLeague);
        league2 = new League(LEAGUE_NAME_2, nbrOfTeamsInLeague, keysPerDateMapLeague);
        matchingResult.setMatchForCombination("1" + Constants.TAB + "1", 1);
        matchingResult.setMatchForCombination("0" + Constants.TAB + "1", 2);
    }

    @Test
    public void printResultPrintsExpectedResultToConsole() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        ResultPrinter.print(league1, league2, matchingResult);
        assertEquals(createExpectedConsoleOutput().trim(), outputStream.toString().trim());
    }

    private String createExpectedConsoleOutput() {
        return new StringBuilder()
                .append(createExpectedHeader())
                .append(System.getProperty(LINE_SEPARATOR))
                .append("0")
                .append(Constants.TAB)
                .append("1")
                .append(Constants.TAB)
                .append(Constants.TAB)
                .append(2)
                .append(System.getProperty(LINE_SEPARATOR))
                .append("1")
                .append(Constants.TAB)
                .append("1")
                .append(Constants.TAB)
                .append(Constants.TAB)
                .append(1)
                .toString();
    }

    @Test
    public void createHeader() {
        String header = ResultPrinter.createHeader(league1, league2);
        assertEquals(createExpectedHeader(), header);
    }

    private String createExpectedHeader() {
        return new StringBuilder()
                .append(LEAGUE_NAME_1)
                .append(Constants.TAB)
                .append(LEAGUE_NAME_2)
                .append(Constants.TAB)
                .append(ResultPrinter.MATCHES)
                .toString();
    }
}
