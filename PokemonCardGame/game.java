
/**
 * Write a description of class game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class game
{
    player p1 = new player();
    player p2 = new player();
    static deck d = new deck();
    //Determines number of players
    static int numOfPlayers = 2;
    //Simple "coin toss" to decide who goes first
    static int playerTurn = (int)(Math.random() * numOfPlayers);

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
            if (playerTurn == 1){ 
                p1.turn = true;
            }
            else{
                p2.turn = true;
            }
            
            while (p1.turn){
                p1.turn();
                p2.turn = true;
                break;
            }

            /**while (p2Turn){
                p2.turn();
                p2Turn = false;
                p1Turn = true;
                break;
            }**/
        }
    }

}
