package web.rufer.swissunihockey.matcher;

import web.rufer.swissunihockey.matcher.domain.MatchingResult;
import web.rufer.swissunihockey.matcher.domain.League;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class KeyMatcher {

    public MatchingResult findMatchesForTwoLeagues(League league1, League league2) {
        MatchingResult result = new MatchingResult();
        for (int i = 0; i < league1.getNbrOfTeamsInLeague(); i++) {
            for (int j = 0; j < league2.getNbrOfTeamsInLeague(); j++) {
                int matchesPerCombination = 0;
                Map<LocalDate, List<Integer>> keysPerDateForLeague1 = league1.getKeysWithHomeGamePerDate();
                Map<LocalDate, List<Integer>> keysPerDateForLeague2 = league2.getKeysWithHomeGamePerDate();

                for (LocalDate date : keysPerDateForLeague1.keySet()) {
                    if (keysPerDateForLeague1.containsKey(date)) {
                        if (keysPerDateForLeague1.get(date) != null && keysPerDateForLeague2.get(date) != null) {
                            if (keysPerDateForLeague1.get(date).contains(i) && keysPerDateForLeague2.get(date).contains(j)) {
                                matchesPerCombination++;
                            }
                        }
                    }
                }
                result.setMatchForCombination(i + " " + j, matchesPerCombination);
            }
        }
        return result;
    }
}
