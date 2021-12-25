package g49707.skyjo.view;

import g49707.skyjo.controller.Controller;
import g49707.skyjo.model.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * The type Color card.
 *
 * @author alexandre
 */
public class ColorCard extends Button {


    /**
     * The Heigth card.
     */
    private double heigthCard  = 80;
    /**
     * The Width card.
     */
    private double widthCard = 50;
    /**
     * The Image.
     */
    private ImageViewCard image;

    /**
     * Instantiates a new Color card.
     *
     * @param player     the player
     * @param card       the card
     * @param img        the img
     * @param click      the click
     * @param nbCard     the nb card
     * @param heigthCard the heigth card
     * @param widthCard  the width card
     * @param controller the controller
     */
    public ColorCard(Player player, Card card, Image img, boolean click, int nbCard,
                     double heigthCard,double widthCard, Controller controller) {
        Player players =Objects.requireNonNull(player, "player ne peut etre null");
        Card cards = Objects.requireNonNull(card, "card ne peut etre null");
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");
        createCardHand(players,cards,img,click,nbCard,heigthCard,widthCard,controllers);
    }

    /**
     * Instantiates a new Color card.
     *
     * @param game    the game
     * @param deckHit the deck hit
     * @param img     the img
     */
    public ColorCard(Model game, Card deckHit, Image img) {
        Card deckHits = Objects.requireNonNull(deckHit, "deckHit ne peut etre null");
        Model games = Objects.requireNonNull(game, "game ne peut etre null");
        createCard(games, deckHits, img);
    }

    /**
     * Create card hand.
     *
     * @param players    the players
     * @param cards      the cards
     * @param img        the img
     * @param click      the click
     * @param nbCard     the nb card
     * @param heigthCard the heigth card
     * @param widthCard  the width card
     * @param controller the controller
     */
    public void createCardHand(Player players, Card cards, Image img, boolean click,
                               int nbCard,double heigthCard,double widthCard,
                               Controller controller){
        Player player = Objects.requireNonNull(players, "player ne peut etre null");
        Card card = Objects.requireNonNull(cards, "card ne peut etre null");
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");
        setText("");
        heightProperty().addListener(this::changed2);
        widthProperty().addListener(this::changed);

        if (click) {
            image = new ImageViewCard(img);
            image.setFitWidth(widthCard);
            image.setFitHeight(heigthCard);

            setGraphic(image);
            setOnAction(valeur -> {
                action(card);
                controllers.changeCard(player, nbCard);
            });
        } else {
            setText("" + card.value());
            new Color(this, card);
            setOnAction(valeur -> {
                setOnAction(null);
                setText("" + card.value());
                setStyle(null);
                new Color(this, card);
                card.setVisibility(VisibilityCard.NOTHIDE);
                controllers.changeCard(player, nbCard);
            });
        }
    }

    /**
     * Create card.
     *
     * @param games    the games
     * @param deckHits the deck hits
     * @param img      the img
     */
    public void createCard(Model games, Card deckHits, Image img) {
        Card deckHit = Objects.requireNonNull(deckHits, "deckHit ne peut etre null");
        Model game = Objects.requireNonNull(games, "game ne peut etre null");
        heightProperty().addListener(this::changed2);
        widthProperty().addListener(this::changed);
        image = new ImageViewCard(img);
        image.setFitWidth(widthCard);
        image.setFitHeight(heigthCard);
        if (img == null) {
            setText("" + deckHit.value());
            new Color(this, deckHit);
        } else {
            setGraphic(image);
            setText("");
            new Color(this);
        }
        setOnAction(valeur -> {
            if (img == null) {
                game.setClickDiscard();
                game.deckToDiscard();
            } else {
                game.setClickDeck();
            }
            action(deckHit);
            game.notifyObserver();
        });

    }

    /**
     * Action.
     *
     * @param cards the cards
     */
    private void action(Card cards){
        Card card =Objects.requireNonNull(cards, "card ne peut etre null");
        setOnAction(null);
        setText("" + card.value());
        image.setImage(null);
        image.setFitWidth(0);
        setGraphic(image);
        setStyle(null);
        new Color(this, card);
        card.setVisibility(VisibilityCard.NOTHIDE);
    }


    /**
     * Changed.
     *
     * @param observableValue the observable value
     * @param number          the number
     * @param t1              the t 1
     */
    private void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
        if (number.doubleValue() != t1.doubleValue()) {
            this.widthCard = t1.doubleValue();
        }
    }

    /**
     * Changed 2.
     *
     * @param observableValue the observable value
     * @param number          the number
     * @param t1              the t 1
     */
    private void changed2(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
        if (number.doubleValue() != t1.doubleValue()) {
            this.heigthCard = t1.doubleValue();
        }
    }

    /**
     * Gets heigth card.
     *
     * @return the heigth card
     */
    public double getHeigthCard() {
        return heigthCard;
    }

    /**
     * Gets width card.
     *
     * @return the width card
     */
    public double getWidthCard() {
        return widthCard;
    }
}
