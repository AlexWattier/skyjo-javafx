package test.g49707.skyjo.model;

import g49707.skyjo.model.Card;
import g49707.skyjo.model.Value;
import g49707.skyjo.model.VisibilityCard;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Card test.
 */
class CardTest {

    /**
     * The Card.
     */
    private Card card;
    /**
     * The Value.
     */
    private Value value;
    /**
     * The Visibility.
     */
    private VisibilityCard visibility;


    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        this.value = Value.ZERO;
        this.visibility = VisibilityCard.HIDDEN;
        this.card = new Card(this.value, this.visibility);
    }

    /**
     * Test card.
     */
    @org.junit.jupiter.api.Test
    public void testCard() {
        assertThrows(NullPointerException.class,
                () -> new Card(null, this.visibility));
    }

    /**
     * Test card copy.
     */
    @org.junit.jupiter.api.Test
    public void testCardCopy() {
        Card newCard = new Card(this.card);
        Value expResult = this.card.getValue();
        VisibilityCard expResultVis = this.card.getVisibility();
        Value result = newCard.getValue();
        VisibilityCard resultVis = newCard.getVisibility();
        assertEquals(expResult, result);
        assertEquals(expResultVis, resultVis);
    }

    /**
     * Test card copy 2.
     */
    @org.junit.jupiter.api.Test
    public void testCardCopy2() {
        Card newCard = new Card(this.card);
        VisibilityCard expResultVis = this.card.getVisibility();
        VisibilityCard resultVis = newCard.getVisibility();
        assertEquals(expResultVis, resultVis);
    }

    /**
     * Test card copy 3.
     */
    @org.junit.jupiter.api.Test
    public void testCardCopy3() {
        Card newCard = new Card(this.card);
        Value expResult = this.card.getValue();
        Value result = newCard.getValue();
        assertEquals(expResult, result);
    }


    /**
     * Testget value.
     */
    @org.junit.jupiter.api.Test
    void testgetValue() {
        Value expResult = Value.ZERO;
        Value result = card.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Testvalue.
     */
    @org.junit.jupiter.api.Test
    void testvalue() {
        int expResult = Value.ZERO.getValue();
        int result = this.card.value();
        assertEquals(expResult, result);
    }

    /**
     * Testget visibility.
     */
    @org.junit.jupiter.api.Test
    void testgetVisibility() {
        VisibilityCard expResult = VisibilityCard.HIDDEN;
        VisibilityCard result = card.getVisibility();
        assertEquals(expResult, result);
    }

    /**
     * Testset visibility.
     */
    @org.junit.jupiter.api.Test
    void testsetVisibility() {
        VisibilityCard expResult = VisibilityCard.NOTHIDE;
        card.setVisibility(VisibilityCard.NOTHIDE);
        VisibilityCard result = card.getVisibility();
        assertEquals(expResult, result);
    }

    /**
     * Test to string.
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        String expResult = "{" + Value.ZERO + "," + VisibilityCard.HIDDEN + "}";
        String result = card.toString();
        assertEquals(expResult, result);

    }

    /**
     * Is hidden.
     */
    @org.junit.jupiter.api.Test
    void isHidden() {
        boolean result = card.isHidden();
        assertTrue(result);
    }

    /**
     * Test hash code.
     */
    /*
    @org.junit.jupiter.api.Test
    void testHashCode() {
        Card resultDeck = new Card(Value.ZERO, VisibilityCard.HIDDEN);
        int result = resultDeck.hashCode();
        boolean isPositif = result>0 ;
        assertTrue(isPositif);
    }

     */
}