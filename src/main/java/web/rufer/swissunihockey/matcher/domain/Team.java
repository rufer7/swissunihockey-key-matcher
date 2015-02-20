package web.rufer.swissunihockey.matcher.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Team {

    private String name;
    private int nbrOfTeamsInLeague;
    private Map<LocalDate, List<Integer>> teamKeysWithHomeGamePerDate;

    /**
     * Constructor for a team
     *
     * @param name name of the team
     * @param nbrOfTeamsInLeague number of teams in league
     * @param homeGameKeysPerDate map with game schedule home game keys per date
     */
    public Team(String name, int nbrOfTeamsInLeague, Map<LocalDate, List<Integer>> homeGameKeysPerDate) {
        this.name = name;
        this.nbrOfTeamsInLeague = nbrOfTeamsInLeague;
        this.teamKeysWithHomeGamePerDate = homeGameKeysPerDate;
    }

    public void addTeamKeysWithHomeGameForDate(LocalDate date, List<Integer> keys) {
        this.teamKeysWithHomeGamePerDate.put(date, keys);
    }

    public String getName() {
        return name;
    }

    public int getNbrOfTeamsInLeague() {
        return nbrOfTeamsInLeague;
    }

    public Map<LocalDate, List<Integer>> getTeamKeysWithHomeGamePerDate() {
        return teamKeysWithHomeGamePerDate;
    }
}
