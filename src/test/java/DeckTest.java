import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {
    private Deck deck;
    private Player player1;

    @Before
    public void before(){
        deck=new Deck();
        deck.shuffleDeck();
        player1=new Player("Joseph");
    }

    @Test
    public void checkDeckPopulated(){
        assertEquals(52,deck.checkDeckSize());
    }

    @Test
    public void checkCardsCanBeRemoved(){
        deck.dealCard();
        assertEquals(51,deck.checkDeckSize());
    }

    @Test
    public void checkPlayerCanGetCard(){
        player1.addToHand(deck.dealCard());
        assertEquals(1,player1.countCardsInHand());
    }
}
