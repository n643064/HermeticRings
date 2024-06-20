package n643064.hermetic_rings.item;

import dev.emi.trinkets.api.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class HermeticRingItem extends TrinketItem implements Equipable
{
    private final MobEffect effect;
    public HermeticRingItem(Properties properties, MobEffect effect)
    {
        super(properties);
        this.effect = effect;
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity)
    {
        if (!entity.level().isClientSide) this.update(entity);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity)
    {
        if (!entity.level().isClientSide) this.update(entity);
    }

    private void update(LivingEntity entity)
    {
        int amp = 0;
        Optional<TrinketComponent> o = TrinketsApi.getTrinketComponent(entity);
        if (o.isPresent())
        {
            amp = o.get().getEquipped(this).size();
        }
        if (amp >= 1)
        {
            entity.forceAddEffect(new MobEffectInstance(effect, -1, amp - 1), null);
        } else
        {
            entity.removeEffect(effect);
        }
    }

    @Override
    public EquipmentSlot getEquipmentSlot()
    {
        return EquipmentSlot.MAINHAND;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ENCHANTMENT_TABLE_USE;
    }
}
