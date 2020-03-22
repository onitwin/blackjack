import java.util.ArrayList;

public class Game {
  ArrayList<Player>players;
  Deck deck;

  public Game(Deck deck){ //deck class constructor
      this.players= new ArrayList<Player>();
      this.deck=deck;
  }


  public void addPlayer(Player player){
      this.players.add(player);
  }

  public int countPlayers(){
      return this.players.size();
  }

  public void startGame(){
      for (Player player:players){
              deck.shuffleDeck();
              player.addToHand(deck.dealCard());
              player.addToHand(deck.dealCard());
      }
  }

  public int checkValueOfCards(Player player){
      int total=0;
      total=+player.addValuesOfCardsInHand();
      return total;
  }

  public boolean checkVictory(Player player){
      boolean twentyOneAchieved=false;
      if (player.addValuesOfCardsInHand()==21) {
          twentyOneAchieved = true;
      }
      return twentyOneAchieved;
  }

  public boolean checkOverTwentyOne(Player player){
      boolean overTwentyOne=false;
      if (player.addValuesOfCardsInHand()> 21 ){
          overTwentyOne=true;
      }
      return overTwentyOne;
  }

  public String rundown(Player player){
      String intro=String.format("%s it is your turn", player.getName());
      System.out.println(intro);
      String playerCurrentTotal=String.format( "Your cards total %s" ,player.addValuesOfCardsInHand());
      for (Card card:player.getHand()){
          String currentCard=String.format("You have %s \n",card.cardName());
          System.out.print(currentCard);
      }
      System.out.println(playerCurrentTotal);
      return playerCurrentTotal;
  }







}
