package net.projektcontingency.minigameapi.lobby;

import org.bukkit.entity.Player;

import java.util.List;

public class ItemManager {
    private List<Player> players;

    public ItemManager(List<Player> players) {
        this.players = players;
    }

    public void updateItems() {
        for (Player p : players) {
            // check if player has items
        }
    }

    public void giveItems(Player p) {

    }
}
