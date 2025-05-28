package net.rocketstrong.waterframescctcompat.blocks.peripherals;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import me.srrapero720.waterframes.common.block.entity.DisplayTile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
//import team.creative.littleframes.common.block.BECreativePictureFrame;

public class PeripheralProvider implements IPeripheralProvider{

    @Override
    public LazyOptional<IPeripheral> getPeripheral(Level level, BlockPos blockPos, Direction direction) {
        if (level.getBlockEntity(blockPos) instanceof DisplayTile) {
            IPeripheral displayTilePeripheral = new DisplayTilePeripheral(blockPos, level);
            if (displayTilePeripheral != null) {
                return LazyOptional.of(() -> displayTilePeripheral);
            }
        }
        return LazyOptional.empty();
    }
}
