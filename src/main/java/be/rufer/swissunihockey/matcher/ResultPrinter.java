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

public class ResultPrinter {

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
    public static void print(League league1, League league2, MatchingResult matchingResult) {
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
