
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
    static int numOfPlayers = 3;
    //Simple "coin toss" to decide who goes first
    static int playerTurn = (int)(Math.random() * numOfPlayers);

    public static void play(){
        d.shuffle(d.pokemon);
        player p1 = new player();
        player p2 = new player();
        player p3 = new player();
        //give players pokemon
        System.out.println("---Pokemon Names---");//seperation code
        p1.setName(d.pokemon[0]);
        p2.setName(d.pokemon[1]);
        p3.setName(d.pokemon[2]);
        //Game is active until one player's health = 0
        while (p1.health >= 0 || p2.health >= 0 || p3.health >= 0){
            //tells program who's turn it is
            if (playerTurn == 0){ 
                p1.turn = true;
            }
            else if (playerTurn == 1){
                p2.turn = true;
            }
            else{
                p3.turn = true;
            }

            while (p1.turn){
                System.out.print("Player 1, would you like to attack, defend, or use item? ");
                p1.turn();
                playerTurn = 1;
                p2.turn = true;
                break;
            }

            while (p2.turn){
                System.out.print("Player 2, would you like to attack, defend, or use item? ");
                p2.turn();
                p2.turn = false;
                p3.turn = true;
                break;
            }

            while (p3.turn){
                System.out.print("Player 3, would you like to attack, defend, or use item? ");
                p3.turn();
                p3.turn = false;
                p1.turn = true;
                break;
            }
        }
    }
}
