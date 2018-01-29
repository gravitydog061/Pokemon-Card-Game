
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
    static int currentPlayer = (int)(Math.random() * numOfPlayers);
    static int p1Health;
    static int p2Health;
    static String temp;
    static String p1Name;
    static String p2Name;
    public static void play(){
        d.shuffle(d.pokemon);
        player p1 = new player();
        player p2 = new player();
        p1Health = p1.health;
        p2Health = p2.health;
        //give players pokemon
        System.out.println("---Pokemon Names---");//seperation code
        System.out.print("Player 1: ");
        p1.setName(d.pokemon[0]);
        System.out.print("Player 2: ");
        p2.setName(d.pokemon[1]);
        System.out.print("\n");
        temp = p1.name;
        p1.name = p2.name;
        p2.name = temp;
        p1Name = p2.name;
        p2Name = p1.name;
        boolean gameInProgress = true;
        //Game is active until one player's health = 0
        while (gameInProgress){
            while (currentPlayer == 0){
                System.out.print("Player 1, would you like to attack or use item? ");
                temp = p1.name;
                p1.turn();
                p2.health = p2Health;
                currentPlayer = 1;
                break;
            }
            if(p2Health <= 0){
                gameInProgress = false;
                System.out.println("Player 2's pokemon has 0 health remaining. Player 1 wins!");
                break;
            }
            while (currentPlayer == 1){
                System.out.print("Player 2, would you like to attack or use item? ");
                temp = p2.name;
                p2.turn();
                p1.health = p1Health;
                currentPlayer = 0;
                break;
            }
            if(p1Health <= 0){
                gameInProgress = false;
                System.out.println("Player 1's pokemon has 0 health remaining. Player 2 wins!");
                break;
            }
            
        }
    }

}
