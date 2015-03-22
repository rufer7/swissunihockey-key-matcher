package be.rufer.swissunihockey.matcher.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class League {

    private String name;
    private int nbrOfTeamsInLeague;
    private Map<LocalDate, List<Integer>> keysWithHomeGamePerDate;

    /**
     * Constructor for a league
     *
     * @param name name of the league/name of the team, which plays in this league
     * @param nbrOfTeamsInLeague number of teams in league
     * @param homeGameKeysPerDate map with game schedule home game keys per date
     */
    public League(String name, int nbrOfTeamsInLeague, Map<LocalDate, List<Integer>> homeGameKeysPerDate) {
        this.name = name;
        this.nbrOfTeamsInLeague = nbrOfTeamsInLeague;
        this.keysWithHomeGamePerDate = homeGameKeysPerDate;
    }

    /**
     * Adds keys, which have home game, to the given date of the leagues map
     *
     * @param date the game schedule date
     * @param keys the keys with home game at the given date
     */
    public void addKeysWithHomeGameForDate(LocalDate date, List<Integer> keys) {
        this.keysWithHomeGamePerDate.put(date, keys);
    }

    public String getName() {
        return name;
    }

    public int getNbrOfTeamsInLeague() {
        return nbrOfTeamsInLeague;
    }

    public Map<LocalDate, List<Integer>> getKeysWithHomeGamePerDate() {
        return keysWithHomeGamePerDate;
    }
}
