package test.g49707.skyjo.model;

import g49707.skyjo.model.Card;
import g49707.skyjo.model.Player;
import g49707.skyjo.model.Value;
import g49707.skyjo.model.VisibilityCard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void getScorePlayer() {
        Player player = new Player();
        player.adCard(new Card(Value.TEN, VisibilityCard.NOTHIDE));
        player.adCard(new Card(Value.TWELVE, VisibilityCard.HIDDEN));
        player.scorePlayer();
        int expResult = 10;
        int result = player.getScorePlayer();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void getHandPlayer() {
        Player player = new Player();
        assertNotNull(player.getHandPlayer());
    }

    @org.junit.jupiter.api.Test
    void adCard() {
        Player player = new Player();
        player.adCard(new Card(Value.ACE, VisibilityCard.HIDDEN));
        assertEquals(1, player.getHandPlayer().size());
    }

    @org.junit.jupiter.api.Test
    void getHandSize() {
        Player player = new Player();
        player.adCard(new Card(Value.ACE, VisibilityCard.HIDDEN));
        player.adCard(new Card(Value.ACE, VisibilityCard.HIDDEN));
        player.adCard(new Card(Value.ACE, VisibilityCard.HIDDEN));
        assertEquals(3, player.getHandSize());
    }

    @org.junit.jupiter.api.Test
    void scorePlayer() {
        Player player = new Player();
        player.adCard(new Card(Value.TEN, VisibilityCard.NOTHIDE));
        player.adCard(new Card(Value.TWELVE, VisibilityCard.HIDDEN));
        player.adCard(new Card(Value.EIGHT, VisibilityCard.NOTHIDE));
        player.scorePlayer();
        int expResult = 18;
        int result = player.getScorePlayer();
        assertEquals(expResult, result);

    }

    @org.junit.jupiter.api.Test
    void getCard() {
        Player player = new Player();
        player.adCard(new Card(Value.TEN, VisibilityCard.NOTHIDE));
        player.adCard(new Card(Value.TWELVE, VisibilityCard.HIDDEN));
        player.adCard(new Card(Value.EIGHT, VisibilityCard.NOTHIDE));
        player.scorePlayer();
        Card expResult = new Card(Value.TWELVE, VisibilityCard.HIDDEN);
        Card result = player.getCard(1);
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void setCardVisibility() {
        Player player = new Player();
        player.adCard(new Card(Value.TEN, VisibilityCard.NOTHIDE));
        player.adCard(new Card(Value.TWELVE, VisibilityCard.HIDDEN));
        player.adCard(new Card(Value.EIGHT, VisibilityCard.NOTHIDE));
        player.scorePlayer();
        VisibilityCard expResult = VisibilityCard.NOTHIDE;
        player.setCardVisibility(1);
        VisibilityCard result = player.getCard(1).getVisibility();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testEquals(){
        Player player = new Player();
        player.adCard(new Card(Value.TEN, VisibilityCard.NOTHIDE));
        player.adCard(new Card(Value.TWELVE, VisibilityCard.HIDDEN));
        player.adCard(new Card(Value.EIGHT, VisibilityCard.NOTHIDE));
        Player playerTwo = new Player();
        playerTwo.adCard(new Card(Value.TEN, VisibilityCard.NOTHIDE));
        playerTwo.adCard(new Card(Value.TWELVE, VisibilityCard.HIDDEN));
        playerTwo.adCard(new Card(Value.EIGHT, VisibilityCard.NOTHIDE));
        assertEquals(playerTwo,player);
    }

}