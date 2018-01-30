
/**
 * Players are given all necessary things fo this game to run.
 *
 * @author Zach Zimmerman, Chris Hicks, Christian Rodriguez
 * @version 1.24.18
 */
public class player extends game
{
    //base 100 health
    int health = 100;
    deck d = new deck();
    scanner user = new scanner();
    String name;
    //hardcoded as a temp user choice
    private String choice;
    int damage;
    //says when it's a player's turn
    //boolean turn = false;
    private int margin = 0;
    //gives player's pokemon names
    //setName() creates the name for the player when called and displays the intial
    //health of the pokemon
    public void setName(String n){
        name = n;
        System.out.println(name + " " + health + " health ");
    }
    //Method that handles the attacking of the pokemon
    public void attack(){
        //random damage
        damage = (int) (Math.random() * 15 + 15); //+ 15 is needed to keep damage from being 0.
        //The if statement handles who gets the damage. When the variable currentPlayer
        //is zero, that means that player one is attacking player two. Since the damage is randomized
        //from the above command, the amount of damage dealt has a range of 15 to 30. The same is applied
        //if player two is attacking player one. The embedded if statements is detecting when their respective
        //health is at zero so the battle can end. The print line prints at the end of each turn to update the
        //health of each respective pokemon.
        if (currentPlayer == 0){
            p2Health = p2Health - damage;
            if(p2Health < 0){
                p2Health = 0;
                health = p2Health;
            }
            System.out.println(name + "'s health is now " + p2Health + ".");
        }
        else{
            p1Health = p1Health - damage;
            if(p1Health < 0){
                p1Health = 0;
                health = p1Health;
            }
            System.out.println(name + "'s health is now " + p1Health + ".");
        }
    }
    //Method for handling the turns.
    public void turn(){
        //choose what to do; attack, defend, item?
        choice = user.getString();
        //The choice is where the user input gets held. It checks the words against attack,
        //item, and debug. The attack route calls the attack method native to this class, and to the player
        //object. Debug shows the damage before the round and after the round. Item increases the health
        //of the pokemon; to heal them. The health is increased by 20 hit points. If the pokemon is at 100 health, the
        //pokemon will not gain any health. If the pokemon's healt is anywhere between 80 and 99, the health will automatically
        //go up to 100, if the item choice is chosen. This applies to both player one and player two.
        if(choice.equals("attack")){
            attack();
        }
        else if(choice.equals("debug")){
            if(currentPlayer == 0){
                System.out.print("---Debug Menu---\nName: " + p1Name + "\nHealth: " + health + "\np1Health: " + p1Health + "\np2Health: " + p2Health + "\nDamage last Turn: " + damage + "\n");
            }
            else{
                System.out.print("---Debug Menu---\nName: " + p2Name + "\nHealth: " + health + "\np1Health: " + p1Health + "\np2Health: " + p2Health + "\nDamage last Turn: " + damage + "\n");
            }
        }
        else if (choice.equals("item")){
            System.out.println("You used a potion.");
            if(currentPlayer == 0){
                health = p1Health;
                if (health == 100){
                    System.out.println("The potion had no effect. You are already at max health.");
                }
                else if (health > 80){
                    //heals up to 100
                    margin = 100 - health;
                    health = health += margin; 
                    p1Health = health;
                    System.out.println(p1Name + "'s health is now " + health + ".");
                }
                else{
                    health += 20; //heals 20 health
                    p1Health = health;
                    System.out.println(p1Name + "'s health is now " + health + ".");
                }
            }
            else{
                health = p2Health;
                if (health == 100){
                    System.out.println("The potion had no effect. You are already at max health.");
                }
                else if (health > 80){
                    //heals up to 100
                    margin = 100 - health;
                    health = health += margin; 
                    p2Health = health;
                    System.out.println(p2Name + "'s health is now  at " + health + ".");
                }
                else{
                    health += 20; //heals 20 health
                    p2Health = health;
                    System.out.println(p2Name + "'s health is now  at " + health + ".");
                }   
            }
        }
    }
}
