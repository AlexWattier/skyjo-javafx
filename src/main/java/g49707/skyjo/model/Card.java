package g49707.skyjo.model;


import java.util.Objects;

/**
 * The type Card.
 *
 * @author alexandre Card class that initializes a card with a color and a value
 */
public class Card {

    /**
     * The Value.
     */
    private final Value value;
    /**
     * The Visibility.
     */
    private VisibilityCard visibility;

    /**
     * Instantiates a new Card.
     *
     * @param value      the value
     * @param visibility the visibility
     */
    public Card(Value value, VisibilityCard visibility) {
        this.visibility = Objects.requireNonNull(visibility, "visibility ne peut etre null");
        this.value = Objects.requireNonNull(value, "value ne peut etre null");

    }


    /**
     * Instantiates a new Card.
     *
     * @param card the card
     */
    public Card(Card card) {
        this(card.getValue(), card.getVisibility());
    }


    /**
     * Gets value.
     *
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    /**
     * Value int.
     *
     * @return the int
     */
    public int value() {
        return value.getValue();
    }

    /**
     * Gets visibility.
     *
     * @return the visibility
     */
    public VisibilityCard getVisibility() {
        return visibility;
    }

    /**
     * Sets visibility.
     *
     * @param visibility the visibility
     */
    public void setVisibility(VisibilityCard visibility) {
        this.visibility = Objects.requireNonNull(visibility, "visibility ne peut etre null");
    }

    /**
     * Is hidden boolean.
     *
     * @return the boolean
     */
    public boolean isHidden() {
        return visibility.equals(VisibilityCard.HIDDEN);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && visibility == card.visibility;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, visibility);
    }

    @Override
    public String toString() {
        return "{" + value + "," + visibility + "}";
    }

}
