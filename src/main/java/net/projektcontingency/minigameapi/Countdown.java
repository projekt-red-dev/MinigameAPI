package net.projektcontingency.minigameapi;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;
import java.util.function.Consumer;

public class Countdown {

    private List<Player> players;
    private BukkitTask run;

    public Countdown(int time, List<Player> players, Runnable runnable) {
        this.players = players;

        run = new BukkitRunnable() {
            private int t = time;

            @Override
            public void run() {
                t--;
                if (t <= 0) {
                    for (Player p : players) {
                        p.sendTitle(ChatColor.GREEN + "GO", "");
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
                        p.playSound(p.getLocation(), Sound.EVENT_RAID_HORN, 1f, 1f);
                    }
                    runnable.run();
                    this.cancel();
                    return;
                }

                ChatColor color = (t < 11) ? ChatColor.RED : ChatColor.AQUA;
                for (Player p : players) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.YELLOW + "Starting in " + color + t + ChatColor.YELLOW + "..."));
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1f, 1f);
                }
            }
        }.runTaskTimerAsynchronously(MinigameAPI.getInstance(), 0L, 20L);
    }

    public void cancel() {
        this.run.cancel();

        for (Player p : this.players) {
            p.sendTitle("", "");
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
        }
    }
}
