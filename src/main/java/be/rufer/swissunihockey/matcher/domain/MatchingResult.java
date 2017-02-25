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
package be.rufer.swissunihockey.matcher.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchingResult {

    private Map<String, Integer> matchesPerCombination;

    public MatchingResult() {
        this.matchesPerCombination = new HashMap<>();
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
        return matchesPerCombination.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
