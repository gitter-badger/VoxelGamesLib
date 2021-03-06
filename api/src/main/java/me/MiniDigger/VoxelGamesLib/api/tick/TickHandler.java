package me.MiniDigger.VoxelGamesLib.api.tick;

import java.util.ArrayList;
import java.util.List;

import me.MiniDigger.VoxelGamesLib.api.feature.Feature;
import me.MiniDigger.VoxelGamesLib.api.handler.Handler;
import me.MiniDigger.VoxelGamesLib.api.phase.Phase;

/**
 * The TickHandler handles the ticking of all Tickables on the server. However not every Tickable is
 * registered here. {@link Phase}s and {@link Feature}s receive their ticks from the {@link Game}
 * instance<br>
 * Every server mod has it's own implementation of the TickHandler
 */
public abstract class TickHandler implements Handler {

    private List<Tickable> tickables = new ArrayList<>();

    /**
     * Called when the underlaying server mod calls a tick. Causes all {@link Tickable}s to tick
     */
    public void tick() {
        tickables.forEach(Tickable::tick);
    }

    /**
     * Stops every {@link Tickable} from ticking and does some cleanup
     */
    @Override
    public void stop() {
        tickables.forEach(Tickable::stop);
        tickables.clear();
    }

    /**
     * Registers a new {@link Tickable}. Calls the {@link Tickable#start()} method.
     * 
     * @param tickable the new {@link Tickable} that should now receive server ticks
     */
    public void registerTickable(Tickable tickable) {
        tickables.add(tickable);
        tickable.start();
    }
}
