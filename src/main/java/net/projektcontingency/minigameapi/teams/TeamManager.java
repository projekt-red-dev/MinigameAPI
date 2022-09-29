package net.projektcontingency.minigameapi.teams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeamManager {
    private final List<Team> teams;
    private final Class<Team> clazz;

    public TeamManager(Class<Team> team) {
        this.clazz = team;
        this.teams = new ArrayList<>();
    }

    public void addTeam(TeamColor color, net.projektcontingency.minigameapi.maps.Map map) {
        try {
            teams.add(clazz.getConstructor(color.getClass(), map.getClass()).newInstance(color, map));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
