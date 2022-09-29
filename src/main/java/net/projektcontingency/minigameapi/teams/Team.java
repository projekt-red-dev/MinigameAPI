package net.projektcontingency.minigameapi.teams;

import net.projektcontingency.minigameapi.maps.Map;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Team {
    protected final List<Player> players;
    protected final TeamColor color;
    protected final Map map;

    public Team(TeamColor color, Map map) {
        this.players = new ArrayList<>();
        this.color = color;
        this.map = map;
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public TeamColor getColor() {
        return color;
    }
}
