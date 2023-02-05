package net.projektcontingency.minigameapi;

import net.projektcontingency.minigameapi.teams.Team;
import net.projektcontingency.minigameapi.teams.TeamColor;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class Minigame extends JavaPlugin {

    protected final ArrayList<Player> players;
    protected Status status;
    protected Countdown countdown;

    public Minigame(List<TeamColor> colors) {
        this.players = new ArrayList<>();
        this.status = Status.QUEUING;
    }

    abstract public int getMaxPlayers();

    abstract public int getMinPlayers();

    public boolean isAtMax() {
        return players.size() == this.getMaxPlayers();
    }

    public boolean isAtMin() {
        return players.size() >= this.getMinPlayers();
    }

    public void addPlayer(Player player) {
        if (isAtMax()) return;

        this.players.add(player);

        for (Player p : this.players) {
            ChatColor ps = (isAtMin()) ? ChatColor.GREEN : ChatColor.RED;
            p.sendMessage(player.getDisplayName() + ChatColor.YELLOW + " just joined the game! " + ps + "(" + this.players.size() + "/" + this.getMaxPlayers() + ")");
        }



        if (isAtMin())
            this.countdown = new Countdown(15, this::start, this::onCountdownTick);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);

        if (this.status != Status.STARTING || this.isAtMin())
            return;

        this.status = Status.QUEUING;
        this.countdown.cancel();
    }

    abstract void start();

    abstract void onCountdownTick(int time);

    abstract void end(Team winner);
}
