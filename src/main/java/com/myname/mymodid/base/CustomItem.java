package com.myname.mymodid.base;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;

public class CustomItem extends ItemBlock {
    public CustomItem(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }
}
