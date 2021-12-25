package g49707.skyjo.model;

import g49707.skyjo.observateurObserver.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Game.
 *
 * @author alexandre
 */
public class Game implements Model {
    /**
     * The Observers.
     */
    private final List<Observer> observers;
    /**
     * The Deck.
     */
    private final Deck deck;
    /**
     * The discard deck.
     */
    private Deck discardDeck;
    /**
     * The Player one.
     */
    private final Player playerOne;
    /**
     * The Player two.
     */
    private final Player playerTwo;
    /**
     * The Tour player.
     */
    private NextPlayer tourPlayer;
    /**
     * The Click deck.
     */
    private boolean clickDeck;
    /**
     * The Click discard.
     */
    private boolean clickDiscard;

    /**
     * The Discard to deck.
     */
    private boolean discardToDeck;

    /**
     * The Deck block.
     */
    private boolean deckBlock ;

    /**
     * Constructor of Game
     */
    public Game() {
        this.deck = new Deck();
        deck.addAllCard();
        this.discardDeck = new Deck();
        this.playerOne = new Player();
        this.playerTwo = new Player();
        this.observers = new ArrayList<>();
        this.tourPlayer = NextPlayer.PLAYERONE;
        this.clickDeck = false;
        this.clickDiscard = false;
        this.discardToDeck = false;
        this.deckBlock = false;
        initGame();

    }

    /**
     * Is deck block boolean.
     *
     * @return the boolean
     */
    public boolean isDeckBlock() {
        return deckBlock;
    }

    /**
     * Sets deck block.
     *
     */
    public void setDeckBlock() {
        this.deckBlock = true;
    }

    /**
     * Refresh the score player.
     */
    public void refreshScore() {
        playerOne.scorePlayer();
        playerTwo.scorePlayer();
    }

    /**
     * Last Discard card card.
     *
     * @return the card
     */
    public Card lastDiscardCard() {
        int last = discardDeck.size() - 1;
        return discardDeck.lasthit(last);
    }

    /**
     * Deck hit card.
     *
     * @return the card
     */
    public Card deckHit() {
        return deck.hit();
    }

    /**
     * Gets tour player.
     *
     * @return the tour player
     */
    public NextPlayer getTourPlayer() {
        return tourPlayer;
    }

    /**
     * Gets tour value.
     *
     * @return the tour value
     */
    public String getTourValue() {
        return tourPlayer.getValue();
    }

    /**
     * Change card.
     *
     * @param players the player
     * @param nbCard  the nb card
     */
    public void changeCard(Player players, int nbCard) {
        Player player = Objects.requireNonNull(players, "player ne peut etre null");
        if (clickDeck) {
            Card cardTemp = deck.hit();
            deck.remove(cardTemp);
            showCard(player, nbCard);
            discardDeck.addCard(player.getCard(nbCard));
            player.getHandPlayer().set(nbCard, cardTemp);
            showCard(player, nbCard);
            clickDeck = false;
        } else if (clickDiscard) {
            Card cardTemp = discardDeck.lasthit(discardDeck.size() - 1);
            discardDeck.remove(cardTemp);
            showCard(player, nbCard);
            discardDeck.addCard(player.getCard(nbCard));
            player.getHandPlayer().set(nbCard, cardTemp);
            showCard(player, nbCard);
            clickDiscard = false;
        }
        endTour();
    }

    /**
     * Gets click deck.
     */
    public void setClickDeck() {
        this.clickDeck = !clickDeck;
    }

    /**
     * Gets deck click.
     *
     * @return the deck click
     */
    public boolean getDeckClick() {
        return clickDeck;
    }

    /**
     * Get Discard click boolean.
     *
     * @return the boolean
     */
    public boolean getDiscardClick() {
        return clickDiscard;
    }


    /**
     * Gets click Discard.
     */
    public void setClickDiscard() {
        this.clickDiscard = !clickDiscard;
    }

    /**
     * Deck to Discard.
     */
    public void deckToDiscard() {
        if (clickDeck) {
            Card cardTemp = deck.hit();
            deck.remove(cardTemp);
            discardDeck.addCard(cardTemp);
            clickDeck = false;
            clickDiscard = false;
            this.discardToDeck = true;
        }
    }

    /**
     * End tour.
     */
    public void endTour() {
        playerTour();
        deckBlock =false;
        notifyObserver();
    }

    /**
     * End game level status.
     *
     * @return the level status
     */
    public LevelStatus endGame() {
        if (endPlayer(playerOne) || endPlayer(playerTwo)) {
            returnAllCard(playerOne);
            returnAllCard(playerTwo);
            refreshScore();
            return winner();
        }
        return LevelStatus.IN_PROGRESS;
    }

    /**
     * Return all card.
     *
     * @param player the player
     */
    private void returnAllCard(Player player) {
        Objects.requireNonNull(player, "player ne peut etre null");
        for (int i = 0; i < player.getHandSize(); i++) {
            Card card = player.getCard(i);
            if (card.isHidden()) {
                card.setVisibility(VisibilityCard.NOTHIDE);
            }
        }
    }

    /**
     * Register observer.
     * different view
     *
     * @param observer the observer
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(Objects.requireNonNull(observer, "Observer ne peut etre null"));
    }

    /**
     * call the view for all new calcul
     * Notify observer.
     */
    @Override
    public void notifyObserver() {
        notifyObserver(null);
    }

    /**
     * call the view for all new calcul
     * Notify observer.
     *
     * @param arg the arg
     */
    @Override
    public void notifyObserver(Object arg) {
        for (Observer observer : observers) {
            observer.update(this, arg);
        }
    }

    /**
     * Deck empty boolean.
     *
     * @return the boolean
     */
    public boolean deckEmpty() {
        return deck.isEmpty();
    }

    /**
     * Init game.
     */
    private void initGame() {
        startShuffle();
        giveCards();
        hitInitCard();
        refreshScore();
        giveDiscardCard();
        whoStart();
    }

    /**
     * Who start game.
     */
    private void whoStart() {
        if (playerTwo.beats(playerOne)) {
            playerTour();
        }
    }

    /**
     * shuffle the deck
     */
    private void startShuffle() {
        deck.shuffle();
    }

    /**
     * method for give 12 card on the handPlayer and the bank
     */
    private void giveCards() {
        for (int i = 0; i < 12; i++) {
            playerOne.adCard(giveOneCard());
            playerTwo.adCard(giveOneCard());
        }
    }

    /**
     * method for give 1 card on the handPlayer and the bank
     *
     * @return Card cardPick on the list
     */
    private Card giveOneCard() {
        Card cardPick = deck.hit();
        deck.remove(cardPick);
        return cardPick;
    }

    /**
     * Hit init card player.
     */
    private void hitInitCard() {
        playerOne.hitCardPlayer();
        playerTwo.hitCardPlayer();
    }

    /**
     * Give Discard card.
     */
    private void giveDiscardCard() {
        Card cd = giveOneCard();
        discardDeck.addCard(cd);
        setDiscardDeck(discardDeck);
    }

    /**
     * Setter of discard deck
     *
     * @param discardDeck the discard deck
     */
    private void setDiscardDeck(Deck discardDeck) {
        this.discardDeck = Objects.requireNonNull(discardDeck, "discardDeck ne peut etre null");
    }

    /**
     * Getter of deck
     */
    @Override
    public Deck getDeck() {
        return new Deck(this.deck);
    }

    /**
     * getter of Player one
     */
    @Override
    public Player getPlayerOne() {
        return playerOne;
    }

    /**
     * getter of Player Two
     */
    @Override
    public Player getPlayerTwo() {
        return playerTwo;
    }

    /**
     * Player tour.
     */
    private void playerTour() {
        if (this.tourPlayer.equals(NextPlayer.PLAYERONE)) {
            this.tourPlayer = NextPlayer.PLAYERTWO;
        } else if (this.tourPlayer.equals(NextPlayer.PLAYERTWO)) {
            this.tourPlayer = NextPlayer.PLAYERONE;
        }
    }

    /**
     * Show card.
     *
     * @param player the player
     * @param nbCard the nb card
     */
    private void showCard(Player player, int nbCard) {
        Player players = Objects.requireNonNull(player, "player ne peut etre null");
        players.setCardVisibility(nbCard);
    }

    /**
     * Gets Discard to deck.
     *
     * @return the Discard to deck
     */
    public boolean getDiscardToDeck() {
        return discardToDeck;
    }

    /**
     * Sets deck to Discard.
     *
     * @param discardToDeck the deck go to Discard
     */
    public void setDiscardToDeck(boolean discardToDeck) {
        this.discardToDeck = discardToDeck;
    }

    /**
     * End player boolean.
     *
     * @param player the player
     * @return the boolean
     */
    private boolean endPlayer(Player player) {
        Player players = Objects.requireNonNull(player, "player ne peut etre null");
        for (int i = 0; i < players.getHandSize(); i++) {
            if (players.getCard(i).isHidden()) {
                return false;
            }
        }
        return true;
    }

    /**
     * method for check the winner player .
     *
     * @return the level status
     */
    private LevelStatus winner() {

        if (playerOne.beats(playerTwo)) {
            return LevelStatus.FAIL;
        }
        if (playerTwo.beats(playerOne)) {
            return LevelStatus.WIN;
        }
        return LevelStatus.IN_PROGRESS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return tourPlayer == game.tourPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourPlayer);
    }
}
