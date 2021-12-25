package g49707.skyjo.model;

import g49707.skyjo.observateurObserver.Observable;

/**
 * The interface Model.
 *
 * @author alexandre
 */
public interface Model extends Observable {

    /**
     * Refresh the score player.
     */
    void refreshScore();

    /**
     * Gets deck.
     *
     * @return the deck
     */
    Deck getDeck();

    /**
     * Gets player one.
     *
     * @return the player one
     */
    Player getPlayerOne();

    /**
     * Gets player two.
     *
     * @return the player two
     */
    Player getPlayerTwo();


    /**
     * Last Discard card card.
     *
     * @return the card
     */
    Card lastDiscardCard();

    /**
     * Deck hit card.
     *
     * @return the card
     */
    Card deckHit();


    /**
     * Gets tour player.
     *
     * @return the tour player
     */
    NextPlayer getTourPlayer();

    /**
     * Change card.
     *
     * @param player the player
     * @param nbCard the nb card
     */
    void changeCard(Player player, int nbCard);

    /**
     * Gets click deck.
     */
    void setClickDeck();

    /**
     * Gets deck click.
     *
     * @return the deck click
     */
    boolean getDeckClick();

    /**
     * Gets click Discard.
     */
    void setClickDiscard();

    /**
     * Get Discard click boolean.
     *
     * @return the boolean
     */
    boolean getDiscardClick();

    /**
     * Deck to Discard.
     */
    void deckToDiscard();

    /**
     * Gets Discard to deck.
     *
     * @return the Discard to deck
     */
    boolean getDiscardToDeck();

    /**
     * Sets deck to Discard.
     *
     * @param discardToDeck the deck go to Discard
     */
    void setDiscardToDeck(boolean discardToDeck);

    /**
     * End tour.
     */
    void endTour();

    /**
     * End game level status.
     *
     * @return the level status
     */
    LevelStatus endGame();

    /**
     * Deck empty boolean.
     *
     * @return the boolean
     */
    boolean deckEmpty();


    /**
     * Gets tour value.
     *
     * @return the tour value
     */
    String getTourValue();

    /**
     * Is deck block boolean.
     *
     * @return the boolean
     */
    boolean isDeckBlock();


    /**
     * Sets deck block.
     *
     */
    void setDeckBlock() ;


}
