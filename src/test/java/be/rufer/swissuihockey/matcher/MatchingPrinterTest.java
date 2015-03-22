package be.rufer.swissuihockey.matcher;

import org.junit.Before;
import org.junit.Test;
import be.rufer.swissunihockey.matcher.KeyMatcher;
import be.rufer.swissunihockey.matcher.MatchingPrinter;
import be.rufer.swissunihockey.matcher.domain.League;
import be.rufer.swissunihockey.matcher.domain.MatchingResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MatchingPrinterTest {

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
        MatchingPrinter.printResult(league1, league2, matchingResult);
        assertEquals(createExpectedConsoleOutput().trim(), boas.toString().trim());
    }

    private String createExpectedConsoleOutput() {
        return new StringBuilder().append(createExpectedHeader()).
                append(System.getProperty("line.separator")).
                append("1").append(KeyMatcher.BLANKS).append("1").
                append(MatchingPrinter.TWO_TABS).append(1).
                append(System.getProperty("line.separator")).
                append("0").append(KeyMatcher.BLANKS).append("1").
                append(MatchingPrinter.TWO_TABS).append(2).toString();
    }

    @Test
    public void createHeader() {
        String header = MatchingPrinter.createHeader(league1, league2);
        assertEquals(createExpectedHeader(), header);
    }

    private String createExpectedHeader() {
        return new StringBuilder().append(LEAGUE_NAME_1).
                append(MatchingPrinter.SPACES).append(LEAGUE_NAME_2).
                append(MatchingPrinter.SPACES).append(MatchingPrinter.MATCHES).toString();
    }
}
