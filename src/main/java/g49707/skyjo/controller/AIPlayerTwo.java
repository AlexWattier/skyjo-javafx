package g49707.skyjo.controller;

import g49707.skyjo.model.Card;
import g49707.skyjo.model.Model;
import g49707.skyjo.model.Player;
import g49707.skyjo.model.VisibilityCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Move player two.
 */
public class AIPlayerTwo {

    /**
     * Instantiates a new Move player two.
     */
    public AIPlayerTwo() {
    }

    /**
     * Start player two.
     *
     * @param games           the games
     * @param choseDifficulte the chose difficulte
     */
    public void startPlayerTwo(Model games,int choseDifficulte) {
        Player player = games.getPlayerTwo();
        int valeurDiscard = games.lastDiscardCard().value();
        if (choseDifficulte == 1) {
            easyPlayerTwo(games, player, valeurDiscard);
        }
        if (choseDifficulte == 2) {
            hardPlayerTwo(games, player, valeurDiscard);
        }
        games.endGame();
    }

    private void hardPlayerTwo(Model games, Player player, int valeurDiscard) {
        if (valeurDiscard > 2) {
            // dans le deck
            games.setClickDeck();
            int intCardDeck = games.deckHit().value();
            if (intCardDeck < 3) {
                choice(games, player);
            } else {
                games.deckToDiscard();
                returnCardPlayer(player);
                games.endTour();
            }
        } else {
            //dans la defausse
            games.setClickDiscard();
            choice(games, player);
        }
    }


    /**
     * Hard player two.
     *
     * @param games         the games
     * @param player        the player
     * @param valeurDiscard the valeur discard
     */
    private void easyPlayerTwo(Model games , Player player,int valeurDiscard){
        if (valeurDiscard > 5) {
            // dans le deck
            games.setClickDeck();
            int intCardDeck = games.deckHit().value();
            if (intCardDeck < 6) {
                choice(games, player);
            } else {
                games.deckToDiscard();
                returnCardPlayer(player);
                games.endTour();
            }
        } else {
            //dans la defausse
            games.setClickDiscard();
            choice(games, player);
        }
    }

    /**
     * Choice.
     *
     * @param games  the games
     * @param player the player
     */
    private void choice(Model games, Player player) {
        int numCard = searchCardPlayer(player);
        if (numCard == -2) {
            numCard = randomCardPlayer(player);
        }
        games.changeCard(player, numCard);
    }

    /**
     * Random card player int.
     *
     * @param playerTwo the player two
     * @return the int
     */
    private int randomCardPlayer(Player playerTwo) {
        List<Card> hand = playerTwo.getHandPlayer();
        int sizeHand = hand.size();
        List<Integer> handHidden = new ArrayList<>();
        for (int i = 0; i < sizeHand; i++) {
            if (hand.get(i).isHidden()) {
                handHidden.add(i);
            }
        }
        Collections.shuffle(handHidden);
        return handHidden.get(0);
    }

    /**
     * Return card player.
     *
     * @param playerTwo the player two
     */
    private void returnCardPlayer(Player playerTwo) {
        int numCardReturn = randomCardPlayer(playerTwo);
        playerTwo.getCard(numCardReturn).setVisibility(VisibilityCard.NOTHIDE);
    }

    /**
     * Search card player int.
     *
     * @param playerTwo the player two
     * @return the int
     */
    private int searchCardPlayer(Player playerTwo) {
        List<Card> hand = playerTwo.getHandPlayer();
        int sizeHand = hand.size();
        for (int i = 0; i < sizeHand; i++) {
            if (!hand.get(i).isHidden()) {
                if (hand.get(i).value() > 7) {
                    return i;
                }
            }
        }
        return -2;
    }

}
