package g49707.skyjo.model;

/**
 * Enum for value of Card
 *
 * @author alexandre
 */
public enum Value {
    /**
     * Minus two value.
     */
    MINUS_TWO(-2),
    /**
     * Minus one value.
     */
    MINUS_ONE(-1),
    /**
     * Zero value.
     */
    ZERO(0),
    /**
     * Ace value.
     */
    ACE(1),
    /**
     * Two value.
     */
    TWO(2),
    /**
     * Three value.
     */
    THREE(3),
    /**
     * Four value.
     */
    FOUR(4),
    /**
     * Five value.
     */
    FIVE(5),
    /**
     * Six value.
     */
    SIX(6),
    /**
     * Seven value.
     */
    SEVEN(7),
    /**
     * Eight value.
     */
    EIGHT(8),
    /**
     * Nine value.
     */
    NINE(9),
    /**
     * Ten value.
     */
    TEN(10),
    /**
     * Eleven value.
     */
    ELEVEN(11),
    /**
     * Twelve value.
     */
    TWELVE(12);
    private final int value;

    /**
     * Constructor for value
     *
     * @param value set value
     */
    Value(int value) {
        this.value = value;
    }

    /**
     * Getter of the value
     *
     * @return value value
     */
    public int getValue() {
        return value;
    }
}
