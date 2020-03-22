import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
   private String card;
   private Player player1;
   private Card tenOfHearts;
   private Card sixOfDiamonds;

   @Before
   public void before(){
       player1= new Player("Joseph");
       tenOfHearts=new Card(Suit.HEARTS,Rank.TEN);
       sixOfDiamonds=new Card(Suit.DIAMONDS,Rank.SIX);
   }

   @Test
    public void canGetPlayerName(){
       assertEquals("Joseph",player1.getName());//ran passing and failing tests- method successful
   }
//   @Test
//   public void canGetHand(){
//       player1.addToHand(tenOfHearts); //unsure how to get contents of array to return
//       assertEquals(tenOfHearts,player1.getHand());
//   }

   @Test
    public void canAddCardsToHand(){ //ran twice, once with extra card to fail- method successful
       player1.addToHand(tenOfHearts);
//       player1.addToHand(tenOfHearts);
       assertEquals(1,player1.countCardsInHand());
   }
   @Test
    public void canCalculateValues(){ //ran twice, once with extra card to fail test- method successful
       player1.addToHand(tenOfHearts);
       player1.addToHand(tenOfHearts);
       player1.addToHand(sixOfDiamonds);
//       player1.addToHand(tenOfHearts);
       assertEquals(26,player1.addValuesOfCardsInHand());

   }
   @Test
    public void canRemoveCardFromHand(){
       player1.addToHand(sixOfDiamonds);
//       assertEquals(1,player1.countCardsInHand());check if card was added to hand- successful so commented out
       player1.removeCard(0);
       assertEquals(0,player1.countCardsInHand());//removes requested card from hand
   }
   @Test
    public void canFindCardBySuitAndRank(){
       player1.addToHand(sixOfDiamonds);
       player1.addToHand(tenOfHearts);
//       assertEquals(2,player1.countCardsInHand());//cards successfully added to hand so comment out check
       assertEquals(true,player1.cardPresent(Suit.DIAMONDS,Rank.SIX));

   }
   @Test
    public void findCardbyIndex(){
       player1.addToHand(sixOfDiamonds);
       assertEquals("SIX of DIAMONDS", player1.showCard(0));
   }

   @Test
    public void checkIfSticking(){ //check of player has decided to stick
       assertEquals(false,player1.checkStick());
   }
   @Test
    public void checkIfStickUpdating(){
       player1.updateStick();
       assertEquals(true,player1.checkStick());
   }
}
