package net.projektcontingency.minigameapi;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.function.Consumer;

public class Countdown {
    private final BukkitTask run;

    public Countdown(int time, Runnable endOfCountdown, Consumer<Integer> onTick) {

        run = new BukkitRunnable() {
            private int t = time;

            @Override
            public void run() {
                t--;
                if (t <= 0) {
// TODO              for (Player p : players) {
//                        p.sendTitle(ChatColor.GREEN + "GO", "");
//                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
//                        p.playSound(p.getLocation(), Sound.EVENT_RAID_HORN, 1f, 1f);
//                    }
                    endOfCountdown.run();
                    this.cancel();
                    return;
                }

// TODO           ChatColor color = (t < 11) ? ChatColor.RED : ChatColor.AQUA;
//                for (Player p : players) {
//                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.YELLOW + "Starting in " + color + t + ChatColor.YELLOW + "..."));
//                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1f, 1f);
//                }
                onTick.accept(t);
            }
        }.runTaskTimerAsynchronously(MinigameAPI.getInstance(), 0L, 20L);
    }

    public void cancel() {
        this.run.cancel();

//TODO    for (Player p : this.players) {
//            p.sendTitle("", "");
//            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(""));
//        }
    }
}
