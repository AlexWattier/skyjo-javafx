package test.g49707.skyjo.model;

import g49707.skyjo.model.*;

import static org.junit.jupiter.api.Assertions.*;


class GameTest {

    @org.junit.jupiter.api.Test
    void testgetDeck() {
        Game gameTest = new Game();
        assertNotNull(gameTest.getDeck());
    }

    @org.junit.jupiter.api.Test
    void testlastDiscardCard() {
        Game gameTest = new Game();
        assertNotNull(gameTest.lastDiscardCard());
    }

    @org.junit.jupiter.api.Test
    void testendTour() {
        Game game = new Game();
        if (!game.getTourValue().equals(NextPlayer.PLAYERONE.getValue())){
            game.endTour();
        }
        NextPlayer expResult = NextPlayer.PLAYERTWO;
        game.endTour();
        NextPlayer result = game.getTourPlayer();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testendTour2() {
        Game game = new Game();
        if (!game.getTourValue().equals(NextPlayer.PLAYERONE.getValue())){
            game.endTour();
        }
        String expResult = NextPlayer.PLAYERONE.getValue();
        String result = game.getTourPlayer().getValue();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testdeckHit() {
        Game gameTest = new Game();
        assertNotNull(gameTest.deckHit());
    }

    @org.junit.jupiter.api.Test
    void testdeckEmpty() {
        Game gameTest = new Game();
        assertFalse(gameTest.deckEmpty());
        Deck Deck = new Deck();
        assertTrue(Deck.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testgetTourValue() {
        Game game = new Game();
        if (!game.getTourValue().equals(NextPlayer.PLAYERONE.getValue())){
            game.endTour();
        }
        String exResult = NextPlayer.PLAYERONE.getValue();
        String result = game.getTourValue();
        assertEquals(exResult, result);
    }

    @org.junit.jupiter.api.Test
    void testgetTourValue2() {
        Game game = new Game();
        if (!game.getTourValue().equals(NextPlayer.PLAYERONE.getValue())){
            game.endTour();
        }
        game.endTour();
        String exResult = NextPlayer.PLAYERONE.getValue();
        game.endTour();
        String result = game.getTourPlayer().getValue();
        assertEquals(exResult, result);
    }

    @org.junit.jupiter.api.Test
    void testchangeCard() {
        Game gameTest = new Game();
        assertThrows(NullPointerException.class,
                () -> gameTest.changeCard(null, 0));
    }

    @org.junit.jupiter.api.Test
    void testsetClickDeck() {
        Game gametestsetClickDeck = new Game();
        gametestsetClickDeck.setClickDeck();
        boolean result = gametestsetClickDeck.getDeckClick();
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void getPlayerTwo(){
        Game game = new Game();
        assertNotNull(game.getPlayerTwo());
    }

    @org.junit.jupiter.api.Test
    void getPlayerOne(){
        Game game = new Game();
        assertNotNull(game.getPlayerOne());
    }
    @org.junit.jupiter.api.Test
    void changeCardDeckToPlayer(){
        Game game = new Game();
        game.setClickDeck();
        Card expResult = game.getPlayerOne().getCard(0);
        game.changeCard(game.getPlayerOne(),0);
        Card result = game.lastDiscardCard();
        assertEquals(expResult,result);
    }

    @org.junit.jupiter.api.Test
    void changeCardDiscardToPlayer(){
        Game game = new Game();
        game.setClickDiscard();
        Card expResult = game.getPlayerOne().getCard(0);
        game.changeCard(game.getPlayerOne(),0);
        Card result = game.lastDiscardCard();
        assertEquals(expResult,result);
    }

    @org.junit.jupiter.api.Test
    void getDiscardClick(){
        Game game = new Game();
        boolean result = game.getDiscardClick();
        assertFalse(result);
        game.setClickDiscard();
        result = game.getDiscardClick();
        assertTrue(result);

    }

    @org.junit.jupiter.api.Test
    void deckToDiscard(){
        Game game = new Game();
        game.setClickDeck();
        Card expResult = game.deckHit();
        game.deckToDiscard();
        Card result = game.lastDiscardCard();
        assertEquals(expResult,result);
    }

    @org.junit.jupiter.api.Test
    void deckDoNotToDiscard(){
        Game game = new Game();
        Card expResult = game.deckHit();
        game.deckToDiscard();
        Card result = game.deckHit();
        assertEquals(expResult,result);
    }

    @org.junit.jupiter.api.Test
    void deckDoNotToDiscard2(){
        Game game = new Game();
        Card expResult = game.deckHit();
        game.setClickDiscard();
        game.deckToDiscard();
        Card result = game.deckHit();
        assertEquals(expResult,result);
    }

    @org.junit.jupiter.api.Test
    void NotendGame() {
        Game game = new Game();
        LevelStatus expResult = LevelStatus.IN_PROGRESS;
        LevelStatus result = game.endGame();
        assertEquals(expResult,result);
    }
    @org.junit.jupiter.api.Test
    void winendGame() {
        Game game = new Game();
        for (int i = 0 ; i< game.getPlayerOne().getHandSize();i++ ){
            game.getPlayerOne().getCard(i).setVisibility(VisibilityCard.NOTHIDE);
        }
        LevelStatus result;
        game.endGame();
        if (!game.getPlayerOne().beats(game.getPlayerTwo())){
            result = LevelStatus.WIN;
        }else if (game.getPlayerOne().beats(game.getPlayerTwo())){
            result = LevelStatus.FAIL;
        }else{
            result = LevelStatus.IN_PROGRESS;
        }
        LevelStatus expResult = game.endGame();
        assertEquals(expResult,result);
    }

    @org.junit.jupiter.api.Test
    void getDiscardToDeckTrue(){
        Game game = new Game();
        game.setClickDeck();
        game.deckToDiscard();
        boolean result = game.getDiscardToDeck();
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void getDiscardToDeckFalse(){
        Game game = new Game();
        game.deckToDiscard();
        boolean result = game.getDiscardToDeck();
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void getDiscardToDeckFalse2(){
        Game game = new Game();
        game.setClickDiscard();
        game.deckToDiscard();
        boolean result = game.getDiscardToDeck();
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void setDiscardToDeckTrue(){
        Game game = new Game();
        game.setClickDeck();
        game.setDiscardToDeck(true);
        boolean result = game.getDiscardToDeck();
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void setDiscardToDeckFalse(){
        Game game = new Game();
        game.setClickDeck();
        game.deckToDiscard();
        game.setDiscardToDeck(false);
        boolean result = game.getDiscardToDeck();
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void setDiscardToDeckFalse2(){
        Game game = new Game();
        game.setDiscardToDeck(false);
        boolean result = game.getDiscardToDeck();
        assertFalse(result);
    }




}