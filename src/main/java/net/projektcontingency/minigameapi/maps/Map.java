package net.projektcontingency.minigameapi.maps;

import net.projektcontingency.minigameapi.teams.TeamColor;
import org.bukkit.Location;


public abstract class Map {
    private final java.util.Map<TeamColor, Location> spawns;
    private final int numberOfTeams;
    private final int maxPlayersOnTeam;
    private final int minPlayersOnTeam;
    private final double maxTime;
    private final String mapName;


    public Map(java.util.Map<TeamColor, Location> spawns, int numberOfTeams, int maxPlayersOnTeam, int minPlayersOnTeam, double maxTime, String mapName) {
        this.spawns = spawns;
        this.numberOfTeams = numberOfTeams;
        this.maxPlayersOnTeam = maxPlayersOnTeam;
        this.minPlayersOnTeam = minPlayersOnTeam;
        this.maxTime = maxTime;
        this.mapName = mapName;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getMaxPlayersOnTeam() {
        return maxPlayersOnTeam;
    }

    public int getMinPlayersOnTeam() {
        return minPlayersOnTeam;
    }

    public double getMaxTime() {
        return maxTime;
    }

    public String getMapName() {
        return mapName;
    }

    public java.util.Map<TeamColor, Location> getSpawns() {
        return spawns;
    }
}
