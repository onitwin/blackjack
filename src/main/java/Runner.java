import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Deck deck =new Deck();
        deck.shuffleDeck();
        Game game=new Game(deck);

        System.out.println("Welcome to Blackjack");
        System.out.println("How many players are their?");

        String noOfPlayers=scanner.next();
        int players=parseInt(noOfPlayers);

        for(int i = 0; i < players; i++) {
            String prompt = String.format("Player %s, please enter your name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }

        game.startGame();
        for (Player player:game.players){
            if (player.checkStick()==false){
                game.rundown(player);
                System.out.println("Would you like to stick or twist?");
                String answer=scanner.next();
                if(answer =="stick"){
                    player.updateStick();
                    String end = String.format("You are finishing with a total of %s \n", player.addValuesOfCardsInHand());
                    System.out.println(end);
                }else {
                    System.out.println("You have chosen to continue...");
                    player.addToHand(deck.dealCard());
                }
            }
        }

    }
}
