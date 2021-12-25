package g49707.skyjo.view;

import g49707.skyjo.controller.Controller;
import g49707.skyjo.model.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.Objects;


/**
 * The type H box board.
 *
 * @author alexandre
 */
public class HBoxBoard extends HBox {

    /**
     * The Grid player one.
     */
    private final GridPlayer gridPlayerOne;
    /**
     * The Grid player two.
     */
    private final GridPlayer gridPlayerTwo;
    /**
     * The Grid center.
     */
    private final GridCenter gridCenter;
    /**
     * The Img player one.
     */
    private final Image imgPlayerOne;
    /**
     * The Img player two.
     */
    private final Image imgPlayerTwo;

    /**
     * The Filter player 2.
     */
    private EventHandler<MouseEvent> filterPlayer2;
    /**
     * The Filter player 1.
     */
    private EventHandler<MouseEvent> filterPlayer1;
    /**
     * The Filter deck.
     */
    private  EventHandler<MouseEvent> filterDeck;

    /**
     * Instantiates a new H box board.
     *
     * @param games      the games
     * @param controller the controller
     */
    public HBoxBoard(Model games, Controller controller) {
        Model game = Objects.requireNonNull(games, "game ne peut etre null");
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");
        setFillHeight(false);
        EventHandler<MouseEvent> eventHandler = e -> game.notifyObserver();
        addEventHandler(MouseEvent.DRAG_DETECTED,eventHandler);
        Player playerOne = game.getPlayerOne();
        Player playerTwo = game.getPlayerTwo();
        imgPlayerOne = new Image("cardr.png");
        gridPlayerOne = new GridPlayer(playerOne, "joueur 1", imgPlayerOne,this,controllers);
        getChildren().add(gridPlayerOne);
        gridCenter = new GridCenter(game,this);
        getChildren().add(gridCenter);
        imgPlayerTwo = new Image("cardb.png");
        gridPlayerTwo = new GridPlayer(playerTwo, "joueur 2", imgPlayerTwo,this,controllers);
        getChildren().add(gridPlayerTwo);
    }

    /**
     * Sets score.
     *
     * @param game the game
     */
    public void setScore(Model game) {
        Model games =  Objects.requireNonNull(game, "games ne peut etre null");
        Player playerOne = games.getPlayerOne();
        Player playerTwo = games.getPlayerTwo();
        gridPlayerOne.setScore(playerOne.getScorePlayer());
        gridPlayerTwo.setScore(playerTwo.getScorePlayer());
    }

    /**
     * Sets grid player.
     *
     * @param game       the game
     * @param controller the controller
     */
    public void setGridPlayer(Model game,Controller controller) {
        Model games = Objects.requireNonNull(game, "games ne peut etre null");
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");
        Player playerOne = games.getPlayerOne();
        Player playerTwo = games.getPlayerTwo();
        gridPlayerOne.setCards(gridPlayerOne,playerOne,"Player 1", imgPlayerOne, controllers);
        gridPlayerTwo.setCards(gridPlayerTwo,playerTwo, "Player 2",imgPlayerTwo, controllers);
    }

    /**
     * Sets deck dis.
     *
     * @param game the game
     */
    public void setDeckDis(Model game) {
        Model games = Objects.requireNonNull(game, "games ne peut etre null");
        Deck deck = games.getDeck();
        Card discard = games.lastDiscardCard();
        gridCenter.setDeckDis(games, deck, discard);
    }

    /**
     * Sets filter player 2.
     */
    public void setFilterPlayer2() {
        filterPlayer2 = Event::consume;
        gridPlayerTwo.addEventFilter(MouseEvent.ANY, filterPlayer2);
    }

    /**
     * Sets filter player one.
     */
    public void setFilterPlayerOne() {
        filterPlayer1 = Event::consume;
        gridPlayerOne.addEventFilter(MouseEvent.ANY, filterPlayer1);
    }

    /**
     * Del filter player 2.
     */
    public void delFilterPlayer2() {
        gridPlayerTwo.removeEventFilter(MouseEvent.ANY, filterPlayer2);
    }

    /**
     * Del filter player one.
     */
    public void delFilterPlayerOne(){
        gridPlayerOne.removeEventFilter(MouseEvent.ANY, filterPlayer1);
    }

    /**
     * Gets deck.
     */
    public void getDeck() {
        filterDeck =  Event::consume;
        gridCenter.addgetDeck(filterDeck);
    }

    /**
     * Del filter deck.
     */
    public void delFilterDeck(){
        gridCenter.removeFilterDeck(filterDeck);
    }

}
