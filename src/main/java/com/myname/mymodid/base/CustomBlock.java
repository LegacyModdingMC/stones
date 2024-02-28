package com.myname.mymodid.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomBlock extends Block {
    public String name;
    Item item;
    HashMap<Integer, String> subblocks;
    protected IIcon[] icons;

    public CustomBlock(String name, Material material, HashMap subblocks) {
        super(material);
        this.name = name;
        this.subblocks = subblocks;
        icons = new IIcon[subblocks.size()];
    }

    @Override
    public String getUnlocalizedName() {
        return "stones:"+name;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta <= this.icons.length)
            return this.icons[meta];
        else
            return this.icons[0];
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int i = 0; i < this.subblocks.size(); ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    public void setDrop(Item item){
        this.item = item;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        ItemStack itemStack = new ItemStack(this, 1, meta);
        drops.add(itemStack);
        return drops;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        for (int i = 0; i < this.icons.length; ++i) {
            this.icons[i] = icon.registerIcon("stones:"+name+"_"+this.subblocks.get(i));
        }
    }
}
