
/**
 * Write a description of class game here.
 *
 * @author Zach Zimmerman, Chris Hicks, Christian Rodriguez
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
        d.shuffle(d.pokemon); //This calls the method to shuffle the deck in the deck class.
        //This initializes both player one and player two
        player p1 = new player();
        player p2 = new player();
        //This sets p_health to p1.health and p2.health, which is 100
        p1Health = p1.health;
        p2Health = p2.health;
        //give players pokemon
        System.out.println("---Pokemon Names---");//seperation code
        //This gives an output for which one is player one and player two
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
        //Game is active until one player's health = 0. This is the main while loop
        //for the game to stay in progress until one pokemon is rendered unfit to battle.
        while (gameInProgress){
            while (currentPlayer == 0){
                //This while loop is used for the turn for player one. This calls the turn()
                //method for what player one wants to do. At the end of the turn,
                //currentPlayer is set to 1 for player two's turn to commence.
                System.out.print("Player 1, would you like to attack or use item? ");
                temp = p1.name;
                p1.turn();
                p2.health = p2Health;
                currentPlayer = 1;
                break;
            }
            if(p2Health <= 0){
                //This if statement checks if player two's health is at zero. If player two's
                //health is at zero, the game ends with a statement notifying the players that
                //the game has ended. The if statement breaks so that the game can end.
                gameInProgress = false;
                System.out.println("Player 2's pokemon has 0 health remaining. Player 1 wins!");
                break;
            }
            while (currentPlayer == 1){
                //This while loop is used for the turn for player two. This calls the turn()
                //method for what player two wants to do. At the end of the turn,
                //currentPlayer is set to 0 for player one's turn to commence.
                System.out.print("Player 2, would you like to attack or use item? ");
                temp = p2.name;
                p2.turn();
                p1.health = p1Health;
                currentPlayer = 0;
                break;
            }
            if(p1Health <= 0){
                //This if statement checks if player one's health is at zero. If player one's
                //health is at zero, the game ends with a statement notifying the players that
                //the game has ended. The if statement breaks so that the game can end.
                gameInProgress = false;
                System.out.println("Player 1's pokemon has 0 health remaining. Player 2 wins!");
                break;
            }
            
        }
    }

}
