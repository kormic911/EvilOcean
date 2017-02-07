package net.flawedlogic.EvilOcean.util;

import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandom;

public class ItemWithMeta extends WeightedRandom.Item {
    public final Item item;
    public final int meta;

    public ItemWithMeta(Item item) {
        this(item, 0, 1);
    }

    public ItemWithMeta(Item item, int meta) {
        this(item, meta, 1);
    }

    public ItemWithMeta(Item item, int meta, int weight) {
        super(weight);
        this.item = item;
        this.meta = meta;
    }

}
