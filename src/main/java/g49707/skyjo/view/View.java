package g49707.skyjo.view;

import g49707.skyjo.controller.Controller;
import g49707.skyjo.model.*;
import g49707.skyjo.observateurObserver.Observable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * The type View.
 *
 * @author alexandre
 */
public class View implements InterfaceView {

    /**
     * The Games.
     */
    private Model games;
    /**
     * The V box board.
     */
    private final VBoxBoard vBoxBoard;

    /**
     * The Controllers.
     */
    private final Controller controllers;

    /**
     * Instantiates a new View.
     *
     * @param stages     the stages
     * @param game       the game
     * @param controller the controller
     */
    public View(Stage stages, Model game, Controller controller) {
        Stage stage = Objects.requireNonNull(stages, "stage ne peut etre null");
        this.games = Objects.requireNonNull(game, "game ne peut etre null");
        controllers = Objects.requireNonNull(controller, "controller ne peut etre null");
        stage.setTitle("49707_Skyjo");
        vBoxBoard = new VBoxBoard(games, controllers);
        Scene scene = new Scene(vBoxBoard, 1000, 600);
        scene.getStylesheets().add("Styles.css");
        stage.getIcons().add(new Image("skyjo.jpg"));
        stage.setScene(scene);
        stage.show();
        games.registerObserver(this);
        games.notifyObserver();
    }

    @Override
    public void update(Observable observable, Object arg) {
        games = (Game) Objects.requireNonNull(observable, "observable ne peut etre null");
        vBoxBoard.setFilterPlayer2();
        vBoxBoard.setFilterPlayerOne();
        vBoxBoard.getDeck();
        if (games.getDeckClick() || games.getDiscardClick()) {
            filterPlayers(games);
        }
        if (games.getDiscardToDeck()) {
            filterPlayers(games);
            games.setDiscardToDeck(false);
        }
        updateBox(games);
    }

    /**
     * Filter players.
     *
     * @param game the game
     */
    private void filterPlayers(Model game) {
        Model games = Objects.requireNonNull(game, "games ne peut etre null");
        if (games.getTourPlayer().equals(NextPlayer.PLAYERONE)) {
            vBoxBoard.setFilterPlayer2();
            vBoxBoard.delFilterPlayerOne();
        } else if (games.getTourPlayer().equals(NextPlayer.PLAYERTWO)) {
            vBoxBoard.setFilterPlayerOne();
            vBoxBoard.delFilterPlayer2();
        }
    }

    /**
     * Update box.
     *
     * @param game the game
     */
    private void updateBox(Model game) {
        Model games = Objects.requireNonNull(game, "games ne peut etre null");
        if (games.endGame().equals(LevelStatus.IN_PROGRESS)) {
            vBoxBoard.setTourPlayer(games.getTourValue() + " prenez la carte de la defausse ou piochez une nouvelle carte");
            updateVBoxBoard(games);
            vBoxBoard.setLabelDeck(games);
            if (games.isDeckBlock()){
                vBoxBoard.getDeck();
            }else{
                vBoxBoard.delFilterDeck();
            }
            if (games.getTourPlayer().equals(NextPlayer.PLAYERTWO)) {
                controllers.startPlayerTwo(games);
            }
        } else if (games.endGame().equals(LevelStatus.FAIL)) {
            vBoxBoard.setTourPlayer("Vous avez perdu");
            updateVBoxBoard(games);
        } else if (games.endGame().equals(LevelStatus.WIN)) {
            vBoxBoard.setTourPlayer("Vous avez gagner");
            updateVBoxBoard(games);
        } else if (games.deckEmpty()) {
            vBoxBoard.setTourPlayer("Le deck est vide");
        }
    }

    /**
     * Update VBoxBoard.
     *
     * @param game the game
     */
    private void updateVBoxBoard(Model game) {
        Model games = Objects.requireNonNull(game, "games ne peut etre null");
        games.refreshScore();
        vBoxBoard.setScorePlayer(games);
        vBoxBoard.setGridPlayer(games, controllers);
        if (!games.getDeckClick()) {
            vBoxBoard.setDeckDis(games);
        }
    }

}
