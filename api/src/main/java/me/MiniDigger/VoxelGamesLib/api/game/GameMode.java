package me.MiniDigger.VoxelGamesLib.api.game;

/**
 * A {@link GameMode} is a identifier for the type of a {@link Game}.
 */
public class GameMode {

    private String name;
    private Class<Game> gameClass;

    /**
     * Constructs a new {@link GameMode}
     * 
     * @param name the name of this {@link GameMode}
     * @param gameClass the class that implements this {@link GameMode}
     */
    public GameMode(String name, Class<Game> gameClass) {
        this.name = name;
        this.gameClass = gameClass;
    }

    /**
     * @return the name of this {@link GameMode}
     */
    public String getName() {
        return name;
    }

    /**
     * @return the class that implements this {@link GameMode}
     */
    public Class<Game> getGameClass() {
        return gameClass;
    }
}
