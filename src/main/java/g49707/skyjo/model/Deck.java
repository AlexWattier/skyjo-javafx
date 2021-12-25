package g49707.skyjo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * The type Deck.
 * create a card list
 *
 * @author alexandre
 */
public class Deck {

    /**
     * The Deck.
     */
    private final List<Card> deck;

    /**
     * Instantiates a new Deck.
     */
    public Deck() {
        deck = new ArrayList<>();
    }

    /**
     * Instantiates a new Deck.
     *
     * @param decks the decks
     */
    public Deck(Deck decks) {
        this.deck = new ArrayList<>();
        this.deck.addAll(Objects.requireNonNull(decks.deck, "decks ne peut etre null"));
    }

    /**
     * Add all card.
     */
    public void addAllCard() {
        Value[] valeur = Value.values();
        for (int i = 0; i < 5; i++) {
            deck.add(new Card(Value.MINUS_TWO, VisibilityCard.HIDDEN));
        }
        for (int i = 0; i < 15; i++) {
            deck.add(new Card(Value.ZERO, VisibilityCard.HIDDEN));
        }
        for (int i = 0; i < 10; i++) {
            deck.add(new Card(Value.MINUS_ONE, VisibilityCard.HIDDEN));
            for (int j = 3; j < valeur.length; j++) {
                deck.add(new Card(valeur[j], VisibilityCard.HIDDEN));
            }
        }
    }

    /**
     * Shuffle.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return deck.isEmpty();

    }

    /**
     * Hit card.
     *
     * @return the card
     */
    public Card hit() {
        return deck.get(0);
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return deck.size();
    }

    /**
     * Remove.
     *
     * @param card the card
     */
    public void remove(Card card) {
        deck.remove(Objects.requireNonNull(card, "card ne peut etre null"));
    }

    /**
     * Add card.
     *
     * @param card the card
     */
    public void addCard(Card card) {
        deck.add(Objects.requireNonNull(card, "card ne peut etre null"));
    }

    /**
     * Lasthit card.
     *
     * @param lastcard the lastcard
     * @return the card
     */
    public Card lasthit(int lastcard) {
        return deck.get(lastcard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck1 = (Deck) o;
        return Objects.equals(deck, deck1.deck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deck);
    }

    @Override
    public String toString() {
        return "{deck=" + deck + '}';
    }


}
