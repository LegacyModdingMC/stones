package com.myname.mymodid.blocks;

import com.myname.mymodid.base.CustomBlock;
import com.myname.mymodid.base.CustomItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.HashMap;

public class CustomStone{
    static HashMap<Integer, String> subblocks = new HashMap<>();
    public enum Stones {
        BRICKS,
        CHISELED;

        Stones() {
            subblocks.put(this.ordinal(), this.name());
        }
    }

    public static void register(){
        Stones.values();
        CustomBlock block = new CustomBlock("custom_block", Material.rock, subblocks);
        //ItemBlock item = new CustomItem(block);
        //block.setDrop(item);
        //GameRegistry.registerItem(item, block.name);
        GameRegistry.registerBlock(block, block.name);
    }
}

