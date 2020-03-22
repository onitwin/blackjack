import java.util.ArrayList;

public class Player { //add and cards (no need for remove), count cards in hand, count value of cards in hand
    private String name;
    private ArrayList<Card>hand;
    private Boolean stick;


    public Player(String name){
        this.name=name;
        this.hand=new ArrayList<Card>();
        this.stick=false;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void addToHand(Card card){
        this.hand.add(card);
    }

    public int countCardsInHand(){
        return this.hand.size();
    }


    public int addValuesOfCardsInHand(){ //loops through array list and adds value of cards to a total to return
        int cumulativeValue=0;
        for(Card card: hand){
            cumulativeValue +=card.getValueofRankEnum();
        }
        return cumulativeValue;
    }
    public void removeCard(int index){
        hand.remove(index);
    }

    public boolean cardPresent(Suit suit,Rank rank){
        boolean present=false;
        for (Card card:hand){
            if(card.getSuit()==suit){ //suit is private so need to access using method
                if(card.getRank()==rank){//rank is private so need to access using method
                    present=true;
                }
            }
        }
        return present;
    }
    public String showCard(int index){
        return this.hand.get(index).cardName();
    }

    public boolean checkStick(){
        return this.stick;
    }

    public void updateStick(){
        this.stick=true;
    }


//    public int fetchIndex(Player player,Card card){
//        for (card:player.hand){
//            if(card.getSuit()==Suit suit){
//                if(card.getRank()==rank){
//                   return hand.indexOf(card);
//                }
//            }else{
//                return 00000;
//            }
//        }return 00000000;
//    }
}
