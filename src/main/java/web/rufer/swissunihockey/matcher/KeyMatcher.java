package web.rufer.swissunihockey.matcher;

import web.rufer.swissunihockey.matcher.domain.MatchingResult;
import web.rufer.swissunihockey.matcher.domain.Team;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class KeyMatcher {

    public MatchingResult findMatchesForTwoTeams(Team team1, Team team2) {
        MatchingResult result = new MatchingResult();
        for (int i = 0; i < team1.getNbrOfTeamsInLeague(); i++) {
            for (int j = 0; j < team2.getNbrOfTeamsInLeague(); j++) {
                int matchesPerCombination = 0;
                Map<LocalDate, List<Integer>> mapOfTeam1 = team1.getTeamKeysWithHomeGamePerDate();
                Map<LocalDate, List<Integer>> mapOfTeam2 = team2.getTeamKeysWithHomeGamePerDate();

                for (LocalDate date : mapOfTeam1.keySet()) {
                    if (mapOfTeam1.containsKey(date)) {
                        if (mapOfTeam1.get(date) != null && mapOfTeam2.get(date) != null) {
                            if (mapOfTeam1.get(date).contains(i) && mapOfTeam2.get(date).contains(j)) {
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
