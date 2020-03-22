import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;


    public Deck(){
        this.deck= new ArrayList<Card>();

        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                Card card = new Card(suit, rank);
                this.deck.add(card);
            }
        }

    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }

    public int checkDeckSize(){
        return this.deck.size();
    }

    public Card dealCard(){ //Card class is the expected return result so must be declared
        return this.deck.remove(0);
    }


}
