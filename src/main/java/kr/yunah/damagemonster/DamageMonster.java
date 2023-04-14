package kr.yunah.damagemonster;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class DamageMonster extends JavaPlugin {

    private Plugin plugin;

    @Override
    public void onEnable() {
        EventListner listeners = new EventListner(plugin);
        Bukkit.getPluginManager().registerEvents(listeners, this);
        getLogger().info("§a Start DamageMob System");
    }

    @Override
    public void onDisable() {
        getLogger().info("§c Stop DamageMob System");
    }



}
