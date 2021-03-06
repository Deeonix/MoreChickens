package com.gendeathrow.morechickens.modHelper;

import java.util.List;

import net.minecraftforge.fml.common.Loader;

import com.setycz.chickens.ChickensRegistryItem;
import com.setycz.chickens.SpawnType;

public class DraconicEvolutionAddon extends BaseModAddon{

	public static ChickensRegistryItem draconiumChicken = null;
	public static ChickensRegistryItem draconiumAwakenedChicken = null; 
	
	public DraconicEvolutionAddon() 
	{
		super("draconicevolution", "Draconic Evolution", "textures/entity/draconic/");
		this.setStartID(90);
	}

	@Override
	public List<ChickensRegistryItem> registerChickens(List<ChickensRegistryItem> allChickens) 
	{
		draconiumChicken = addChicken(allChickens, 
				"draconiumChicken", 
				this.nextID(), 
				"DraconiumChicken.png", 
				this.getFirstOreDictionary("ingotDraconium"), 
				0x301549, 0x1a0c27, 
				SpawnType.NONE);
		
		draconiumAwakenedChicken = addChicken(allChickens, 
				"draconiumAwakenedChicken", 
				this.nextID(), 
				"DraconiumAwakenedChicken.png", 
				this.getFirstOreDictionary("nuggetDraconiumAwakened"), 
				0xcc440c, 0x9c691a, 
				SpawnType.NONE);
		
		
		return allChickens;
	}

	@Override
	public void RegisterAllParents(List<ChickensRegistryItem> allChickens) 
	{
        if(Loader.isModLoaded("tconstruct"))
        	setParents(draconiumChicken, TinkersConstructAddon.pigIronChicken, EnderChicken);
        else
        	setParents(draconiumChicken, GunpowderChicken, EnderChicken);

    	setParents(draconiumAwakenedChicken, draconiumChicken, EnderChicken);

	}

}
