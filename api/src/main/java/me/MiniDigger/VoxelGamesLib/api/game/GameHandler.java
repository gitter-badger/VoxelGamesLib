package me.MiniDigger.VoxelGamesLib.api.game;

import java.util.ArrayList;
import java.util.List;

import me.MiniDigger.VoxelGamesLib.api.handler.Handler;

/**
 * Handles all {@link Game} instances and all {@link GameMode}s.
 */
public class GameHandler implements Handler {

    private List<Game> games = new ArrayList<>();
    private List<GameMode> modes = new ArrayList<>();

    @Override
    public void start() {
        // TODO Auto-generated method stub

    }

    @Override
    public void stop() {
        games.forEach(Game::stop);
        games.clear();
    }

    /**
     * Registers a new {@link GameMode}. Fails silently if that {@link GameMode} is already
     * registered.
     * 
     * @param mode the new mode to be registered
     */
    public void registerGameMode(GameMode mode) {
        if (!modes.contains(mode)) {
            modes.add(mode);
        }
    }

    /**
     * Starts a new {@link Game} instance of that {@link GameMode}.
     * 
     * @param mode the {@link GameMode} that should be started.
     * @return the started {@link Game}
     * @throws GameModeNotAvailableException if that {@link GameMode} is not registered on this
     *         server
     * @throws GameStartException if something goes wrong while starting
     */
    public Game startGame(GameMode mode) {
        if (!modes.contains(mode)) {
            throw new GameModeNotAvailableException(mode);
        }

        try {
            Game game = mode.getGameClass().newInstance();
            games.add(game);
            // TODO register tickable here
            return game;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new GameStartException(mode, e);
        }
    }
}
