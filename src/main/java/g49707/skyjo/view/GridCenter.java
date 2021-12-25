package g49707.skyjo.view;

import g49707.skyjo.model.Card;
import g49707.skyjo.model.Deck;
import g49707.skyjo.model.Model;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.Objects;

/**
 * The type Grid center.
 *
 * @author alexandre
 */
public class GridCenter extends GridPane {

    /**
     * The Discard btn.
     */
    private final ColorCard discardBtn;
    /**
     * The Deck btn.
     */
    private final ColorCard deckBtn;
    /**
     * The Img deck.
     */
    private final Image imgDeck;


    /**
     * Instantiates a new Grid center.
     *
     * @param games      the games
     * @param hBoxBoards the h box boards
     */
    public GridCenter(Model games, HBoxBoard hBoxBoards) {
        Model game = Objects.requireNonNull(games, "game ne peut etre null");
        HBoxBoard hBoxBoard = Objects.requireNonNull(hBoxBoards, "hBoxBoard ne peut etre null");
        prefHeightProperty().bind(hBoxBoard.heightProperty().divide(1.5));
        prefWidthProperty().bind(hBoxBoard.widthProperty().divide(4));
        Label labelLeft = new Label("");
        add(labelLeft, 0, 0);
        Label centre = new Label("");
        add(centre, 1, 0);

        imgDeck= new Image("cardb.png");
        deckBtn = new ColorCard(game,game.deckHit(),imgDeck);
        add(deckBtn, 1, 1);
        discardBtn = new ColorCard(game,game.lastDiscardCard(),null);
        add(discardBtn, 0, 3);
    }

    /**
     * Sets deck dis.
     *
     * @param games   the games
     * @param deck    the deck
     * @param discard the discard
     */
    public void setDeckDis(Model games,Deck deck,Card discard) {
        Model game = Objects.requireNonNull(games, "games ne peut etre null");
        Deck decks = Objects.requireNonNull(deck, "deck ne peut etre null");
        Card discards = Objects.requireNonNull(discard, "discard ne peut etre null");
        deckBtn.createCard(game ,decks.hit(), imgDeck);
        discardBtn.createCard(game, discards,null);
    }

    public void addgetDeck(EventHandler<MouseEvent> filterDeck) {
        deckBtn.addEventFilter(MouseEvent.ANY, filterDeck);

    }

    public void removeFilterDeck(EventHandler<MouseEvent> filterDeck) {
        deckBtn.removeEventFilter(MouseEvent.ANY, filterDeck);
    }
}
