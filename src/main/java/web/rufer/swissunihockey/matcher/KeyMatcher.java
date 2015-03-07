package web.rufer.swissunihockey.matcher;

import web.rufer.swissunihockey.matcher.domain.League;
import web.rufer.swissunihockey.matcher.domain.MatchingResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class KeyMatcher {

    public static final String BLANKS = "       ";

    public MatchingResult findMatchesForTwoLeagues(League league1, League league2) {
        MatchingResult result = new MatchingResult();
        for (int i = 0; i < league1.getNbrOfTeamsInLeague(); i++) {
            for (int j = 0; j < league2.getNbrOfTeamsInLeague(); j++) {
                result.setMatchForCombination(i + BLANKS + j, calculateMatchesPerCombination(league1, league2, i, j));
            }
        }
        return result;
    }

    private int calculateMatchesPerCombination(League league1, League league2, int indexLeague1, int indexLeague2) {
        int matchesPerCombination = 0;
        Map<LocalDate, List<Integer>> keysPerDateForLeague1 = league1.getKeysWithHomeGamePerDate();
        Map<LocalDate, List<Integer>> keysPerDateForLeague2 = league2.getKeysWithHomeGamePerDate();

        for (LocalDate date : keysPerDateForLeague1.keySet()) {
            if (dateExistsInBothLeagues(date, keysPerDateForLeague1, keysPerDateForLeague2)) {
                if (keysPerDateForLeague1.get(date).contains(indexLeague1) && keysPerDateForLeague2.get(date).contains(indexLeague2)) {
                    matchesPerCombination++;
                }
            }
        }
        return matchesPerCombination;
    }

    private boolean dateExistsInBothLeagues(LocalDate date, Map<LocalDate, List<Integer>> keysPerDateForLeague1, Map<LocalDate, List<Integer>> keysPerDateForLeague2) {
        return keysPerDateForLeague1.get(date) != null && keysPerDateForLeague2.get(date) != null;
    }
}
