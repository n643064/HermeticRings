package n643064.hermetic_rings.item;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

import static n643064.hermetic_rings.HermeticRings.MODID;

public class AttributeTrinketItem extends TrinketItem implements Equipable
{
    private final Attribute attribute;
    private final String id;
    private final double value;
    private final AttributeModifier.Operation operation;
    public AttributeTrinketItem(Properties settings, Attribute attribute, double value, AttributeModifier.Operation operation)
    {
        super(settings);
        this.attribute = attribute;
        id = MODID + ":" + attribute.getDescriptionId();
        this.value = value;
        this.operation = operation;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid)
    {
        final Multimap<Attribute, AttributeModifier> map = super.getModifiers(stack, slot, entity, uuid);
        map.put(attribute, new AttributeModifier(uuid, id, value, operation));
        return map;
    }

    @Override
    public EquipmentSlot getEquipmentSlot()
    {
        return EquipmentSlot.MAINHAND;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }
}
