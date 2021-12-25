package g49707.skyjo.view;

import g49707.skyjo.model.Card;

import java.util.Objects;

/**
 * The type Color.
 *
 * @author alexandre
 */
public class Color {

    /**
     * Instantiates a new Color.
     *
     * @param colorCard the color card
     * @param card      the card
     */
    public Color(ColorCard colorCard, Card card) {
        ColorCard colorCards = Objects.requireNonNull(colorCard, "colorCard ne peut etre null");
        Card cards = Objects.requireNonNull(card, "card ne peut etre null");
        colorCards.getStyleClass().removeAll("carte_gris",
                "carte_bleu", "carte_rouge", "carte_jaune", "carte_vert");
        if (cards.value() < 0) {
            colorCards.getStyleClass().add("carte_gris");
        } else if (cards.value() == 0) {
            colorCards.getStyleClass().add("carte_bleu");
        } else if (cards.value() > 8) {
            colorCards.getStyleClass().add("carte_rouge");
        } else if (cards.value() > 4) {
            colorCards.getStyleClass().add("carte_jaune");
        } else if (cards.value() > 0) {
            colorCards.getStyleClass().add("carte_vert");
        }
    }

    /**
     * Instantiates a new Color.
     *
     * @param colorCard the color card
     */
    public Color(ColorCard colorCard) {
        ColorCard colorCards = Objects.requireNonNull(colorCard, "colorCard ne peut etre null");
        colorCards.getStyleClass().removeAll("carte_gris",
                "carte_bleu", "carte_rouge", "carte_jaune", "carte_vert");
    }
}
