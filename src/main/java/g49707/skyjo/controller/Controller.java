package g49707.skyjo.controller;

import g49707.skyjo.model.*;
import g49707.skyjo.view.View;
import javafx.stage.Stage;
import java.util.Objects;

/**
 * The type Controller.
 *
 * @author alexandre
 */
public class Controller {

    /**
     * The Game.
     */
    private final Game game;
    /**
     * The Move player.
     */
    private final AIPlayerTwo movePlayer;

    private int difficulte;

    /**
     * Constructor of controller
     *
     * @param stage the stage
     */
    public Controller(Stage stage,int difficulte) {
        if (stage == null) {
            throw new IllegalArgumentException("le stage est null");
        }
        this.game = new Game();
        this.difficulte = difficulte;
        this.movePlayer = new AIPlayerTwo();
        new View(stage, game, this);
    }

    /**
     * Change card.
     *
     * @param players the player
     * @param nbCard  the nb card
     */
    public void changeCard(Player players, int nbCard) {
        Player player = Objects.requireNonNull(players, "players ne peut etre null");
        game.changeCard(player, nbCard);
        //game.notifyObserver();
    }

    /**
     * Start player two.
     *
     * @param games the games
     */
    public void startPlayerTwo(Model games) {
        Model game = Objects.requireNonNull(games, "players ne peut etre null");
        this.movePlayer.startPlayerTwo(game,this.difficulte);
    }

}

