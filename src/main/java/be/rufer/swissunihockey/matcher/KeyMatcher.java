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

import be.rufer.swissunihockey.matcher.domain.League;
import be.rufer.swissunihockey.matcher.domain.MatchingResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class KeyMatcher {

    /**
     * Finds the matches for all combinations of two given leagues
     *
     * @param league1 league 1
     * @param league2 league 2
     * @return a matching result object, which contains the amount of matches per combination
     */
    public MatchingResult findMatchesForTwoLeagues(League league1, League league2) {
        MatchingResult result = new MatchingResult();
        for (int i = 1; i <= league1.getNbrOfTeamsInLeague(); i++) {
            for (int j = 1; j <= league2.getNbrOfTeamsInLeague(); j++) {
                result.setMatchForCombination(i + Constants.TAB + j, calculateMatchesPerCombination(league1, league2, i, j));
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

    /**
     * Checks, if the given date exits in both leagues
     *
     * @param date the given date
     * @param keysPerDateForLeague1 keys per date for league 1
     * @param keysPerDateForLeague2 keys per date for league 2
     * @return true, if date exists in both leagues
     */
    private boolean dateExistsInBothLeagues(LocalDate date, Map<LocalDate, List<Integer>> keysPerDateForLeague1, Map<LocalDate, List<Integer>> keysPerDateForLeague2) {
        return keysPerDateForLeague1.get(date) != null && keysPerDateForLeague2.get(date) != null;
    }
}
