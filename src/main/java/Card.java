public class Card {
    private Suit suit;
    private Rank rank;
    private int value;


    public Card(Suit suit, Rank rank){
        this.suit=suit;
        this.rank=rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public int getValueofRankEnum(){
        return this.rank.getValue();
    }

    public String cardName(){
        return String.format("%s of %s", this.rank, this.suit);
    }

}
