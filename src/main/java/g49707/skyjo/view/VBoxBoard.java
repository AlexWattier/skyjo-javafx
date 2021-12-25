package g49707.skyjo.view;

import g49707.skyjo.controller.Controller;
import g49707.skyjo.model.Game;
import g49707.skyjo.model.Model;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.util.Objects;

/**
 * The type V box board.
 *
 * @author alexandre
 */
public class VBoxBoard extends VBox {

    /**
     * The H box board.
     */
    private final HBoxBoard hBoxBoard;
    /**
     * The Tour player.
     */
    private final PlayerTour tourPlayer;

    private final Label labelDeckBlock;

    /**
     * Instantiates a new V box board.
     *
     * @param games      the games
     * @param controller the controller
     */
    public VBoxBoard(Model games, Controller controller) {
        Model game = Objects.requireNonNull(games, "game ne peut etre null");
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");
        setAlignment(Pos.CENTER);
        hBoxBoard = new HBoxBoard(game, controllers);
        hBoxBoard.prefHeightProperty().bind(this.heightProperty());
        hBoxBoard.prefWidthProperty().bind(this.widthProperty());
        getChildren().add(hBoxBoard);
        tourPlayer = new PlayerTour();
        tourPlayer.prefWidthProperty().bind(this.widthProperty().divide(2));
        Button blockDeckButton = new Button("block Deck");
        blockDeckButton.setOnAction(actionEvent -> game.setDeckBlock());
        labelDeckBlock = new Label("le deck n'est pas bloquer");
        getChildren().add(labelDeckBlock);
        getChildren().add(blockDeckButton);
        getChildren().add(tourPlayer);
    }

    /**
     * Sets score player.
     *
     * @param game the game
     */
    public void setScorePlayer(Model game) {
        Model games = Objects.requireNonNull(game, "games ne peut etre null");
        hBoxBoard.setScore(games);
    }

    /**
     * Sets tour player.
     *
     * @param players the players
     */
    public void setTourPlayer(String players) {
        String player = Objects.requireNonNull(players, "player ne peut etre null");
        tourPlayer.setText(player);
    }

    /**
     * Sets grid player.
     *
     * @param game       the game
     * @param controller the controller
     */
    public void setGridPlayer(Model game, Controller controller) {
        Model games = Objects.requireNonNull(game, "games ne peut etre null");
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");
        hBoxBoard.setGridPlayer(games, controllers);
    }

    /**
     * Sets deck dis.
     *
     * @param game the game
     */
    public void setDeckDis(Model game) {
        Model games = Objects.requireNonNull(game, "games ne peut etre null");
        hBoxBoard.setDeckDis(games);
    }


    /**
     * Sets filter player 2.
     */
    public void setFilterPlayer2() {
        hBoxBoard.setFilterPlayer2();
    }

    /**
     * Sets filter player one.
     */
    public void setFilterPlayerOne() {
        hBoxBoard.setFilterPlayerOne();
    }

    /**
     * Del filter player 2.
     */
    public void delFilterPlayer2() {
        hBoxBoard.delFilterPlayer2();
    }

    /**
     * Del filter player one.
     */
    public void delFilterPlayerOne() {
        hBoxBoard.delFilterPlayerOne();
    }

    /**
     * Gets deck.
     */
    public void getDeck() {

        hBoxBoard.getDeck();
    }

    /**
     * Del filter deck.
     */
    public void delFilterDeck() {
        hBoxBoard.delFilterDeck();
    }


    public void setLabelDeck(Model game) {
        if (game.isDeckBlock()) {
            labelDeckBlock.setText("le deck a été bloquer");
        } else {
            labelDeckBlock.setText("le deck n' est pas bloquer");
        }
    }

    }
