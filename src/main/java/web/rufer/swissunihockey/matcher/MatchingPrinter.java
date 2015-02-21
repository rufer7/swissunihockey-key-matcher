package web.rufer.swissunihockey.matcher;

import web.rufer.swissunihockey.matcher.domain.League;
import web.rufer.swissunihockey.matcher.domain.MatchingResult;

public class MatchingPrinter {

    public static final String MATCHES = "Matches";
    public static final String SPACES = "  ";
    public static final String TWO_TABS = "     ";

    /**
     * Prints result to console
     *
     * @param league1 league 1 (it's keys appear in the first column)
     * @param league2 league 2 (it's keys appear in the second column)
     * @param matchingResult the result of matches (3rd column)
     */
    public static void printResult(League league1, League league2, MatchingResult matchingResult) {
        System.out.println(createHeader(league1, league2));

        for (String combination : matchingResult.getMatchesPerCombination().keySet()) {
            System.out.println(combination + TWO_TABS + matchingResult.getMatchesPerCombination().get(combination));
        }
    }

    /**
     * Creates the header for the console output in the format
     * '{name of league1}   {name of league 2}  {matches}
     *
     * @param league1 league 1
     * @param league2 league 2
     * @return the header as string
     */
    static String createHeader(League league1, League league2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(league1.getName());
        stringBuilder.append(SPACES);
        stringBuilder.append(league2.getName());
        stringBuilder.append(SPACES);
        stringBuilder.append(MATCHES);
        return stringBuilder.toString();
    }
}
