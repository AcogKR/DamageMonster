package kr.yunah.damagemonster;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class EventListner implements Listener {

    private final Plugin plugin;

    public EventListner(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void MonsterDamage(EntityDamageByEntityEvent e) {
        int damage = (int) e.getFinalDamage();
        Entity mob = e.getEntity();
        double health = (int) ((LivingEntity) mob).getHealth();
        double Maxhealth = (int) ((LivingEntity) mob).getMaxHealth();

        if(!(e.getDamager() instanceof Player)) {return;}
        if(mob instanceof Player) { e.setCancelled(true); return; }
        int per = (int) ((health / Maxhealth) * 100);
        mob.setCustomName("§c§l[M] §f" + (int) ((LivingEntity) mob).getHealth() + "/" + (int) ((LivingEntity) mob).getMaxHealth() + "§e | " + per + "%");
        mob.setCustomNameVisible(true);

        ((Player) e.getDamager()).sendActionBar("§c-" + damage + " health");
    }
}
