
/**
 * Write a description of class game here.
 *
 * @author Zach Zimmerman
 * @version 1.26.18
 */
public class game
{
    static deck d = new deck();
    //Determines number of players
    static int numOfPlayers = 2;
    //Simple "coin toss" to decide who goes first
    static int playerTurn = (int)(Math.random() * numOfPlayers);
    static int currentPlayer;
    public static void play(){
        d.shuffle(d.pokemon);
        player p1 = new player();
        player p2 = new player();
        //give players pokemon
        System.out.println("---Pokemon Names---");//seperation code
        p1.setName(d.pokemon[0]);
        p2.setName(d.pokemon[1]);
        //Game is active until one player's health = 0
        while (p1.health >= 0 || p2.health >= 0){
            //tells program who's turn it is
            if (playerTurn == 0){ 
                p1.turn = true;
                currentPlayer = 0;
            }
            else if (playerTurn == 1){
                p2.turn = true;
                currentPlayer = 1;
            }

            while (p1.turn){
                System.out.print("Player 1, would you like to attack or use item?");
                p1.turn();
                p1.turn = false;
                p2.turn = true;
                currentPlayer = 1;
                break;
            }

            while (p2.turn){
                System.out.print("Player 2, would you like to attack or use item?");
                p2.turn();
                p2.turn = false;
                p1.turn = true;
                currentPlayer = 0;
                break;
            }

        }
    }
}
