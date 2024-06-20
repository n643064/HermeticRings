package n643064.hermetic_rings;

import n643064.hermetic_rings.item.AttributeTrinketItem;
import n643064.hermetic_rings.item.HermeticRingItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;

public class HermeticRings implements ModInitializer
{
    public static final String MODID = "hermetic_rings";

    public static final Item BINDING_AGENT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON));
    public static final Item TIDE_REAGENT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.RARE));
    public static final Item VIGOR_REAGENT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.RARE));
    public static final Item WIND_REAGENT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.UNCOMMON));
    public static final Item VOID_REAGENT = new Item(new FabricItemSettings().maxCount(64).rarity(Rarity.EPIC));

    public static final Item IRON_RING = new AttributeTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON), Attributes.ARMOR_TOUGHNESS, 0.5, AttributeModifier.Operation.ADDITION);
    public static final Item GOLDEN_RING = new AttributeTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON), Attributes.LUCK, 0.2, AttributeModifier.Operation.ADDITION);
    public static final Item OBSIDIAN_RING = new AttributeTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON), Attributes.ARMOR_TOUGHNESS, 2, AttributeModifier.Operation.ADDITION);

    public static final Item SPEED_RING = new HermeticRingItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), MobEffects.MOVEMENT_SPEED);
    public static final Item REGEN_RING = new HermeticRingItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC), MobEffects.REGENERATION);
    public static final Item WATER_BREATHING_RING = new HermeticRingItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), MobEffects.WATER_BREATHING);

    public static final Item IRON_BRACELET = new AttributeTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.COMMON), Attributes.ARMOR, 1, AttributeModifier.Operation.ADDITION);
    public static final Item GOLDEN_BRACELET = new AttributeTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON), Attributes.LUCK, 0.2, AttributeModifier.Operation.ADDITION);
    public static final Item OBSIDIAN_BRACELET = new AttributeTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON), Attributes.ARMOR, 4, AttributeModifier.Operation.ADDITION);

    public static final Item DOLPHINS_GRACE_BRACELET = new HermeticRingItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), MobEffects.DOLPHINS_GRACE);
    public static final Item HEALTH_BRACELET = new AttributeTrinketItem(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC), Attributes.MAX_HEALTH, 2, AttributeModifier.Operation.ADDITION);
    public static final Item SLOW_FALLING_BRACELET = new HermeticRingItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), MobEffects.SLOW_FALLING);


    public static final CreativeModeTab ITEMS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(HermeticRings.VOID_REAGENT))
            .displayItems((itemDisplayParameters, output) ->
            {
                output.accept(IRON_RING);
                output.accept(GOLDEN_RING);
                output.accept(OBSIDIAN_RING);

                output.accept(SPEED_RING);
                output.accept(REGEN_RING);
                output.accept(WATER_BREATHING_RING);

                output.accept(IRON_BRACELET);
                output.accept(GOLDEN_BRACELET);
                output.accept(OBSIDIAN_BRACELET);

                output.accept(SLOW_FALLING_BRACELET);
                output.accept(HEALTH_BRACELET);
                output.accept(DOLPHINS_GRACE_BRACELET);

                output.accept(BINDING_AGENT);
                output.accept(TIDE_REAGENT);
                output.accept(VIGOR_REAGENT);
                output.accept(WIND_REAGENT);
                output.accept(VOID_REAGENT);
            })
            .title(Component.literal("Hermetic Rings")).build();

    @Override
    public void onInitialize()
    {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "iron_ring"), IRON_RING);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "obsidian_ring"), OBSIDIAN_RING);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "golden_ring"), GOLDEN_RING);

        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "speed_ring"), SPEED_RING);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "regen_ring"), REGEN_RING);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "water_breathing_ring"), WATER_BREATHING_RING);

        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "iron_bracelet"), IRON_BRACELET);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "obsidian_bracelet"), OBSIDIAN_BRACELET);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "golden_bracelet"), GOLDEN_BRACELET);

        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "slow_falling_bracelet"), SLOW_FALLING_BRACELET);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "health_bracelet"), HEALTH_BRACELET);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "dolphins_grace_bracelet"), DOLPHINS_GRACE_BRACELET);


        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "binding_agent"), BINDING_AGENT);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "wind_reagent"), WIND_REAGENT);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "vigor_reagent"), VIGOR_REAGENT);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "tide_reagent"), TIDE_REAGENT);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MODID, "void_reagent"), VOID_REAGENT);

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MODID, "items"), ITEMS);
    }
}
