package g49707.skyjo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The type Player.
 *
 * @author alexandre
 */
public class Player {

    /**
     * The Score player.
     */
    private int scorePlayer;
    /**
     * The Hand player.
     */
    private final List<Card> handPlayer;

    /**
     * Instantiates a new Player.
     */
    public Player() {
        this.handPlayer = new ArrayList<>();
        this.scorePlayer = 0;
    }

    /**
     * Gets score player.
     *
     * @return the score player
     */
    public int getScorePlayer() {
        return scorePlayer;
    }

    /**
     * Gets hand player.
     *
     * @return the hand player
     */
    public List<Card> getHandPlayer() {
        return handPlayer;
    }

    /**
     * Ad card.
     *
     * @param cards the cards
     */
    public void adCard(Card cards) {
        Card card = Objects.requireNonNull(cards, "cards ne peut etre null");
        handPlayer.add(card);
    }

    /**
     * Score player.
     */
    public void scorePlayer() {
        scorePlayer = 0;
        for (Card card : handPlayer) {
            if (card.getVisibility() == VisibilityCard.NOTHIDE) {
                scorePlayer = scorePlayer + card.value();
            }
        }
    }

    /**
     * Card visibility.
     *
     * @param random the random
     */
    public void cardVisibility(List<Integer> random) {
        List<Integer> randoms = Objects.requireNonNull(random, "random ne peut etre null");
        Card card = handPlayer.get(randoms.get(0));
        card.setVisibility(VisibilityCard.NOTHIDE);
    }


    /**
     * Gets card.
     *
     * @param index the index
     * @return the card
     */
    public Card getCard(int index) {
        return handPlayer.get(index);
    }

    /**
     * Gets hand size.
     *
     * @return the hand size
     */
    public int getHandSize() {
        return handPlayer.size();
    }

    /**
     * Hit card player.
     */
    public void hitCardPlayer() {
        List<Integer> random = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            random.add(i);
        }
        Collections.shuffle(random);
        for (int i = 0; i < 2; i++) {
            cardVisibility(random);
            random.remove(0);
        }
    }

    /**
     * Sets card visibility.
     *
     * @param nbCard the nb card
     */
    public void setCardVisibility(int nbCard) {
        getCard(nbCard).setVisibility(VisibilityCard.NOTHIDE);
    }


    /**
     * Beats boolean.
     *
     * @param player the player
     * @return the boolean
     */
    public boolean beats(Player player) {
        return scorePlayer > player.getScorePlayer();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return scorePlayer == player.scorePlayer && handPlayer.equals(player.handPlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scorePlayer, handPlayer);
    }
}