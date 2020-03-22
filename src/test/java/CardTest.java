import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {
    Card card;

    @Before
    public void before(){
        card= new Card (Suit.SPADES,Rank.KING);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.SPADES,card.getSuit());//test passes
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.KING,card.getRank());//test passes- changed source to QUEEN and failed so working correctly
    }

    @Test
    public void canGetRankValue(){
        assertEquals(10,card.getValueofRankEnum()); // test passes- changed source to SIX and failed so working correctly
    }
    @Test
    public void canGetName(){
        assertEquals("KING of SPADES",card.cardName() );
    }
}

