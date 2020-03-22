import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    Player player1;
    Player player2;
    Deck deck;
    Game game;
    Card AceOfSpades;
    Card KingOfDiamonds;
    Card AceOfClubs;
    Card AceOfDiamonds;
    Card AceOfHearts;
    Card TenOfHearts;


    @Before
    public void setup(){
        player1 = new Player("Joseph");
        player2 = new Player("Michelle");
        deck = new Deck();
        AceOfClubs= new Card(Suit.CLUBS,Rank.ACE);
        KingOfDiamonds=new Card (Suit.DIAMONDS,Rank.KING);
        AceOfDiamonds=new Card (Suit.DIAMONDS,Rank.ACE);
        AceOfSpades= new Card (Suit.SPADES,Rank.ACE);
        AceOfHearts=new Card (Suit.HEARTS,Rank.ACE);
        TenOfHearts=new Card (Suit.HEARTS,Rank.TEN);

        game = new Game(deck);
        game.addPlayer(player1);
        game.addPlayer(player2);
    }
    @Test
    public void checkNoOfPlayers(){
        assertEquals(2,game.countPlayers());
    }

    @Test
    public void canStartGame(){
        game.startGame();
        assertEquals(2,player2.countCardsInHand());
    }

    @Test
    public void checkIfPlayerhas21(){
        game.startGame();
        assertEquals(false,game.checkVictory(player1));
    }
    @Test
    public void checkIfPlayerOver21returnTrue(){
        player1.addToHand(KingOfDiamonds); //added 3 cards totalling 30 to return 'True'- over 21
        player1.addToHand(KingOfDiamonds);
        player1.addToHand(KingOfDiamonds);
        assertEquals(true,game.checkOverTwentyOne(player1));
    }

    @Test
    public void checkIfPlayerOver21ReturnFalse(){
        player1.addToHand(KingOfDiamonds); //added 2 cards to total under 21 and return false
        player1.addToHand(KingOfDiamonds);
        assertEquals(false,game.checkOverTwentyOne(player1));
    }
    @Test
    public void checkStringInterpolation(){
        player1.addToHand(KingOfDiamonds);
        player1.addToHand(KingOfDiamonds);
        assertEquals("Your cards total 20", game.rundown(player1));
    }


}
