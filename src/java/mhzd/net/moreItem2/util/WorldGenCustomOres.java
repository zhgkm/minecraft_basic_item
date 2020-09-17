package mhzd.net.moreItem2.util;

import java.util.Random;

import mhzd.net.moreItem2.init.ModBlock;
import mhzd.net.moreItem2.init.ModItem;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator
{
	private WorldGenerator water_stone;
	private WorldGenerator wind_stone;
	private WorldGenerator fire_stone;
	
	public WorldGenCustomOres() 
	{
		water_stone = new WorldGenMinable(ModBlock.WATER_STONE_ORE.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.STONE));
		wind_stone = new WorldGenMinable(ModBlock.WIND_STONE_ORE.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.STONE));
		fire_stone = new WorldGenMinable(ModBlock.FIRE_STONE_ORE.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.STONE));

	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case -1:			
			break;
		case 0:
			runGenerator(water_stone, world, random, chunkX, chunkZ, 20, 0, 40);
			runGenerator(wind_stone, world, random, chunkX, chunkZ, 20, 0, 40);
			runGenerator(fire_stone, world, random, chunkX, chunkZ, 20, 0, 40);
			break;
		case 1:
			break;
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}
}
