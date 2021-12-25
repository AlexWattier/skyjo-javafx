package g49707.skyjo.view;

import g49707.skyjo.controller.Controller;
import g49707.skyjo.model.Card;
import g49707.skyjo.model.Player;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import java.util.List;
import java.util.Objects;

/**
 * The type Grid player.
 *
 * @author alexandre
 */
public class GridPlayer extends GridPane {

    /**
     * The Score player.
     */
    private Label scorePlayer;
    /**
     * The Carte player.
     */
    private ColorCard cartePlayer;

    /**
     * Instantiates a new Grid player.
     *
     * @param players    the players
     * @param messages   the messages
     * @param img        the img
     * @param hBoxBoards the h box boards
     * @param controller the controller
     */
    public GridPlayer(Player players, String messages, Image img,HBoxBoard hBoxBoards,Controller controller) {
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");
        Player player = Objects.requireNonNull(players, "player ne peut etre null");
        String message = Objects.requireNonNull(messages, "message ne peut etre null");
        HBoxBoard hBoxBoard = Objects.requireNonNull(hBoxBoards, "hBoxBoard ne peut etre null");
        prefHeightProperty().bind(hBoxBoard.heightProperty().divide(1.5));
        prefWidthProperty().bind(hBoxBoard.widthProperty().divide(3));
        List<Card> hand = player.getHandPlayer();
        double heigthCard = 80;
        double widthCard = 50;
        cardHand(player,message, hand, img,heigthCard,widthCard ,controllers);
    }

    /**
     * Card hand.
     *
     * @param players    the players
     * @param messages   the messages
     * @param hands      the hands
     * @param img        the img
     * @param heigthCard the heigth card
     * @param widthCard  the width card
     * @param controller the controller
     */
    public void cardHand(Player players, String messages, List<Card> hands, Image img,
                         double heigthCard,double widthCard,Controller controller) {
        Player player = Objects.requireNonNull(players, "player ne peut etre null");
        String message = Objects.requireNonNull(messages, "message ne peut etre null");
        List<Card> hand = Objects.requireNonNull(hands, "hand ne peut etre null");
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");

        Label name = new Label(message);
        add(name, 0, 0);
        Label score = new Label("score : ");
        add(score, 2, 0);
        scorePlayer = new Label("" + player.getScorePlayer());
        add(scorePlayer, 3, 0);

        int nbcard = 0;
        for (int length = 0; length < 4; length++) {
            for (int width = 0; width < 3; width++) {
                if (hand.get(nbcard).isHidden()) {
                    cartePlayer = new ColorCard(player, hand.get(nbcard), img, true,
                            nbcard, heigthCard, widthCard,controllers);
                } else {
                    cartePlayer = new ColorCard(player, hand.get(nbcard), null, false,
                            nbcard, heigthCard, widthCard,controllers);
                }
                add(cartePlayer, length, width + 1);
                nbcard++;
            }
        }
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(int score) {
        scorePlayer.setText("" + score);
    }

    /**
     * Sets cards.
     *
     * @param gridPlayers the grid players
     * @param players     the players
     * @param messages    the messages
     * @param img         the img
     * @param controller  the controller
     */
    public void setCards(GridPlayer gridPlayers,Player players,String messages ,Image img, Controller controller) {
        GridPlayer gridPlayer = Objects.requireNonNull(gridPlayers, "gridPlayer ne peut etre null");
        Player player = Objects.requireNonNull(players, "player ne peut etre null");
        String message = Objects.requireNonNull(messages, "message ne peut etre null");
        Controller controllers = Objects.requireNonNull(controller, "controller ne peut etre null");

        gridPlayer.getChildren().clear();
        List<Card> hand = player.getHandPlayer();
        cardHand(player,message, hand, img,cartePlayer.getHeigthCard(), cartePlayer.getWidthCard(), controllers);
    }

}
