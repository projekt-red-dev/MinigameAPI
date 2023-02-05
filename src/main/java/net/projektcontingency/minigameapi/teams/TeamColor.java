package net.projektcontingency.minigameapi.teams;

import net.projektcontingency.titanium.items.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum TeamColor {
    WHITE(ChatColor.WHITE, new ItemConstructor(Material.WHITE_CONCRETE)
            .setName(ChatColor.GOLD + "White Team")),
    LIGHT_GRAY(ChatColor.GRAY, new ItemConstructor(Material.LIGHT_GRAY_CONCRETE)
            .setName(ChatColor.GOLD + "Light Gray Team")),
    GRAY(ChatColor.DARK_GRAY, new ItemConstructor(Material.GRAY_CONCRETE)
            .setName(ChatColor.GOLD + "Gray Team")),
    RED(ChatColor.RED, new ItemConstructor(Material.RED_CONCRETE)
            .setName(ChatColor.GOLD + "Red Team")),
    YELLOW(ChatColor.YELLOW, new ItemConstructor(Material.YELLOW_CONCRETE)
            .setName(ChatColor.GOLD + "Yellow Team")),
    GREEN(ChatColor.GREEN, new ItemConstructor(Material.GREEN_CONCRETE)
            .setName(ChatColor.GOLD + "Green Team")),
    AQUA(ChatColor.AQUA, new ItemConstructor(Material.CYAN_CONCRETE)
            .setName(ChatColor.GOLD + "Aqua Team")),
    BLUE(ChatColor.BLUE, new ItemConstructor(Material.BLUE_CONCRETE)
            .setName(ChatColor.GOLD + "Blue Team")),
    PURPLE(ChatColor.DARK_PURPLE, new ItemConstructor(Material.PURPLE_CONCRETE)
            .setName(ChatColor.GOLD + "Purple Team")),
    PINK(ChatColor.LIGHT_PURPLE, new ItemConstructor(Material.PINK_CONCRETE)
            .setName(ChatColor.GOLD + "Pink Team"));

    private final ChatColor color;
    private final ItemStack item;

    TeamColor(ChatColor chatColor, ItemStack item) {
        this.color = chatColor;
        this.item  = item;
    }

    public ItemStack getItem() {
        return item;
    }

    public ChatColor getColor() {
        return color;
    }
}
