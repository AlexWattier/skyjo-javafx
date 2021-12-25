package test.g49707.skyjo.model;

import g49707.skyjo.model.Card;
import g49707.skyjo.model.Deck;
import g49707.skyjo.model.Value;
import g49707.skyjo.model.VisibilityCard;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Deck test.
 */
class DeckTest {

    /**
     * The Deck.
     */
    private Deck deck;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        this.deck = new Deck();
        this.deck.addAllCard();
    }

    /**
     * Test deck copy.
     */
    @org.junit.jupiter.api.Test
    public void testDeckCopy(){
        Deck newDeck = new Deck(this.deck);

        assertEquals(deck, newDeck);
    }

    /**
     * Testadd all card.
     */
    @org.junit.jupiter.api.Test
    void testaddAllCard() {
        Deck resultDeck = new Deck();
        resultDeck.addAllCard();
        int result = resultDeck.size();
        assertNotNull(resultDeck);
        assertEquals(150,result);

    }

    /**
     * Testis empty.
     */
    @org.junit.jupiter.api.Test
    void testisEmpty() {
        Deck resultDeck = new Deck();
        assertTrue(resultDeck.isEmpty());
        resultDeck.addAllCard();
        assertFalse(resultDeck.isEmpty());
        assertNotNull(resultDeck);

    }

    /**
     * Testhit.
     */
    @org.junit.jupiter.api.Test
    void testhit() {
        Card result = this.deck.hit();
        Card exResult = new Card(Value.MINUS_TWO, VisibilityCard.HIDDEN);
        assertEquals(exResult,result);
    }

    /**
     * Testsize.
     */
    @org.junit.jupiter.api.Test
    void testsize() {
        Deck resultDeck = new Deck();
        resultDeck.addAllCard();
        int result = resultDeck.size();
        assertEquals(150,result);
    }

    /**
     * Testremove.
     */
    @org.junit.jupiter.api.Test
    void testremove() {
        Deck resultDeck = new Deck();
        resultDeck.addAllCard();
        Card cardResult = resultDeck.hit();
        resultDeck.remove(cardResult);
        Card exResult = new Card(Value.MINUS_TWO, VisibilityCard.HIDDEN);
        assertEquals(exResult,cardResult);
        assertThrows(NullPointerException.class ,
                ()-> resultDeck.remove(null));
    }

    /**
     * Testadd card.
     */
    @org.junit.jupiter.api.Test
    void testaddCard() {
        Deck resultDeck = new Deck();
        resultDeck.addAllCard();
        Card cardResult = resultDeck.hit();
        resultDeck.addCard(cardResult);
        Card result = this.deck.lasthit(this.deck.size()-1);
        Card exResult = new Card(Value.TWELVE, VisibilityCard.HIDDEN);
        assertEquals(exResult,result);
        assertThrows(NullPointerException.class ,
                ()-> resultDeck.remove(null));
    }

    /**
     * Testlasthit.
     */
    @org.junit.jupiter.api.Test
    void testlasthit() {
        Card cardResult = this.deck.lasthit(this.deck.size()-1);
        Card exResult = new Card(Value.TWELVE,VisibilityCard.HIDDEN);
        assertEquals(exResult,cardResult);
    }

    /**
     * Test to string.
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        String result = this.deck.toString();
        assertNotNull(result);
    }




}