package me.stutiguias.mcmmorankup;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public final class Effects {

    public static void abilityLevelUpCelebration(Player player, String skill) {
        fireworkParticleShower(player, Color.BLUE);
    }

    public static void playGreaterImpactEffect(LivingEntity livingEntity) {
        Location location = livingEntity.getEyeLocation();
        livingEntity.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 0.0F, false, false);
    }

    public static void playAbilityEnabledEffect(Player player) {
        fireworkParticleShower(player, Color.GREEN);
    }

    public static void playAbilityDisabledEffect(Player player) {
        fireworkParticleShower(player, Color.RED);
    }

    private static void fireworkParticleShower(Player player, Color color) {
        Location location = player.getLocation();
        location.setY(location.getY() - 1.0D);
        location.setPitch(-90.0F);

        Firework firework = (Firework) player.getWorld().spawnEntity(location, EntityType.FIREWORK);
        FireworkMeta fireworkMeta = firework.getFireworkMeta();
        FireworkEffect effect = FireworkEffect.builder().flicker(false).withColor(color).with(FireworkEffect.Type.STAR).trail(true).build();
        fireworkMeta.addEffect(effect);
        fireworkMeta.addEffect(effect);
        fireworkMeta.setPower(0);
        firework.setFireworkMeta(fireworkMeta);
    }

    public static void playDodgeEffect(Player player) {
        Location location = player.getEyeLocation();
        World world = player.getWorld();

        world.playEffect(location, Effect.SMOKE, BlockFace.SOUTH_EAST);
        world.playEffect(location, Effect.SMOKE, BlockFace.SOUTH);
        world.playEffect(location, Effect.SMOKE, BlockFace.SOUTH_WEST);
        world.playEffect(location, Effect.SMOKE, BlockFace.EAST);
        world.playEffect(location, Effect.SMOKE, BlockFace.SELF);
        world.playEffect(location, Effect.SMOKE, BlockFace.WEST);
        world.playEffect(location, Effect.SMOKE, BlockFace.NORTH_EAST);
        world.playEffect(location, Effect.SMOKE, BlockFace.NORTH);
        world.playEffect(location, Effect.SMOKE, BlockFace.NORTH_WEST);
    }
}