package g49707.skyjo.model;

import java.util.Objects;

/**
 * The enum Next player.
 */
public enum NextPlayer {
    /**
     * Playerone next player.
     */
    PLAYERONE("Player 1"),
    /**
     * Playertwo next player.
     */
    PLAYERTWO("Player 2");


    /**
     * The Next player.
     */
    private final String nextPlayer;


    /**
     * Instantiates a new Next player.
     *
     * @param s the string value
     */
    NextPlayer(String s) {
        this.nextPlayer = Objects.requireNonNull(s, "s ne peut etre null");
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return nextPlayer;
    }


}
