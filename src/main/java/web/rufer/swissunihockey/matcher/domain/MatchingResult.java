package web.rufer.swissunihockey.matcher.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchingResult {

    Map<String, Integer> matchesPerCombination;

    public MatchingResult() {
        this.matchesPerCombination = new HashMap<String, Integer>();
    }

    /**
     * Set the amount of matches for a given combination
     *
     * @param combination the key combination i.e. 0 1 (first digit for league1, second for league 2)
     * @param amountOfMatches amount of matches for the given combination
     */
    public void setMatchForCombination(String combination, Integer amountOfMatches) {
        this.matchesPerCombination.put(combination, amountOfMatches);
    }

    public Map<String, Integer> getMatchesPerCombination() {
        return matchesPerCombination;
    }
}
