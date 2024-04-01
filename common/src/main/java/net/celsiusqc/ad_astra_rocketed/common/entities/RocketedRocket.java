package net.celsiusqc.ad_astra_rocketed.common.entities;

import net.celsiusqc.ad_astra_rocketed.common.registry.ModEntityTypes;
import net.celsiusqc.ad_astra_rocketed.common.registry.ModFluidTags;
import net.celsiusqc.ad_astra_rocketed.common.registry.ModItems;
import earth.terrarium.adastra.common.entities.vehicles.Rocket;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import java.util.Map;

public class RocketedRocket extends Rocket {
    private static final RocketProperties TIER_5_PROPERTIES = new RocketProperties(5, ModItems.TIER_5_ROCKET.get(), 1.7f, ModFluidTags.TIER_5_ROCKET_FUEL);
    private static final RocketProperties TIER_6_PROPERTIES = new RocketProperties(6, ModItems.TIER_6_ROCKET.get(), 1.7f, ModFluidTags.TIER_6_ROCKET_FUEL);
    private static final RocketProperties TIER_7_PROPERTIES = new RocketProperties(7, ModItems.TIER_7_ROCKET.get(), 1.7f, ModFluidTags.TIER_7_ROCKET_FUEL);

    public static final Map<EntityType<?>, RocketProperties> COSMIC_ROCKET_PROPERTIES = Map.of(
            ModEntityTypes.TIER_5_ROCKET.get(), TIER_5_PROPERTIES,
            ModEntityTypes.TIER_6_ROCKET.get(), TIER_6_PROPERTIES,
            ModEntityTypes.TIER_7_ROCKET.get(), TIER_7_PROPERTIES);

    public RocketedRocket(EntityType<?> type, Level level) {
        super(type, level, COSMIC_ROCKET_PROPERTIES.get(type));
    }
}
