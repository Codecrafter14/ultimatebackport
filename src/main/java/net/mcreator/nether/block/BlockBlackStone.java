
package net.mcreator.nether.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.Block;

import net.mcreator.nether.world.WorldNetherNew;
import net.mcreator.nether.creativetab.TabNetherupdateBlocks;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Random;

@ElementsNetherMod.ModElement.Tag
public class BlockBlackStone extends ElementsNetherMod.ModElement {
	@GameRegistry.ObjectHolder("nether:black_stone")
	public static final Block block = null;
	public BlockBlackStone(ElementsNetherMod instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("black_stone"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("nether:black_stone", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == WorldNetherNew.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		for (int i = 0; i < 10; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(64) + 0;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 16, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					if (blockAt.getBlock() == Blocks.NETHERRACK.getDefaultState().getBlock())
						blockCriteria = true;
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}
	public static class BlockCustom extends Block {
		public static final PropertyDirection FACING = BlockDirectional.FACING;
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("black_stone");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 1);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabNetherupdateBlocks.tab);
			this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH));
		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{FACING});
		}

		@Override
		public IBlockState withRotation(IBlockState state, Rotation rot) {
			if (rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
				if ((EnumFacing) state.getValue(FACING) == EnumFacing.WEST || (EnumFacing) state.getValue(FACING) == EnumFacing.EAST) {
					return state.withProperty(FACING, EnumFacing.UP);
				} else if ((EnumFacing) state.getValue(FACING) == EnumFacing.UP || (EnumFacing) state.getValue(FACING) == EnumFacing.DOWN) {
					return state.withProperty(FACING, EnumFacing.WEST);
				}
			}
			return state;
		}

		@Override
		public IBlockState getStateFromMeta(int meta) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			return ((EnumFacing) state.getValue(FACING)).getIndex();
		}

		@Override
		public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
				EntityLivingBase placer) {
			if (facing == EnumFacing.WEST || facing == EnumFacing.EAST)
				facing = EnumFacing.UP;
			else if (facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH)
				facing = EnumFacing.EAST;
			else
				facing = EnumFacing.SOUTH;
			return this.getDefaultState().withProperty(FACING, facing);
		}
	}
}
