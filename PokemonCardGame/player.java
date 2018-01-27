
/**
 * Players are given all necessary things fo this game to run.
 *
 * @author Zach Zimmerman
 * @version 1.24.18
 */
import java.util.Arrays;
public class player
{
    //references objects without wiping current data?
    player p1;
    player p2;
    player p3;
    //base 100 health
    int health = 100;
    //difference between max health and player health if current healthis greater than 80.
    int margin;
    //referencing objects
    deck d = new deck();
    scanner user = new scanner();
    //variables only known to player
    private String name;
    private String pkmnName;
    private String choice;
    private boolean shadow = false;
    int shadowCount = 1;
    //says when it's a player's turn
    boolean turn = false;
    //gives player's pokemon names
    public void setName(String t){
        name = t;
        System.out.println("Pokemon name: " + name);
    }
    //attacks player
    public void attack(){
        //random damage
        int damage = (int) (Math.random() * 15 + 15); //+ 15 is needed to keep damage from being 0. range = 15 to 30.
        //if player is not "Shadowed" then attack else print "Player is defended"
        if (Arrays.asList(d.pokemon).indexOf(pkmnName) == 0){
            if (!p1.shadow){
                p1.health = p1.health - damage;
                System.out.println(name + " dealt " + damage + " damage to " + p1.name + ".\n" + p1.name +
                    "'s health is " + p1.health);
            }
            else{
                System.out.print("Player 1 has defended. " + name + "'s attack had no effect.");
            }
        }
        else if (Arrays.asList(d.pokemon).indexOf(pkmnName) == 1){
            if (!p2.shadow){
                p2.health = p2.health - damage;
                System.out.println(name + " dealt " + damage + " damage to " + p2.name +
                    ".\n" + p2.name + "'s health is " + p2.health);
            }
            else{
                System.out.print("Player 2 has defended. " + name + "'s attack had no effect.");
            }
        }   
        else{
            if (!p3.shadow){
                p3.health = p3.health - damage;
                System.out.println(name + " dealt " + damage + " damage to " + p3.name + ".\n" 
                    + p3.name + "'s health is " + p3.health);
            }
            else{
                System.out.print("Player 3 has defended. " + name + "'s attack had no effect.");
            }
        }
        //attack a specific pokemon
        }
    //protects player for the next player's turn
    public void defend(){
        //player becomes "invinsible" for the next player's turn. Ex) P1 defends, P2 cannot attack P1 but P3 can
        //Cannot be use twice in a row. If used twice print p.name + " defended but it failed." and end turn
        if (shadowCount != 2){
            shadow = true;
            shadowCount++;
        }
        else{
            System.out.println(name + " defended but it failed.");
            shadowCount = 1;
        }
    }
    //player turn method
    public void turn(){
        //choose what to do; attack, defend, item?
        choice = user.getString();
        if(choice.equals("attack")){
            //choose who to attack
            System.out.print("Which pokemon would you like to attack? ");
            pkmnName = user.getString();
            System.out.println(pkmnName);
            attack(); //place holder name convert to user input
        }
        else if (choice.equals("defend")){
            this.defend();
        }
        else if (choice.equals("item")){
            System.out.println("You used a potion.");
            if (health > 80){
                //heals up to 100
                margin = 100 - health;
                health = health + margin;
                System.out.println(name + "'s health is now " + health);
                turn = false; //ends turn
            }
            else if (health <= 80){
                health = health += 20; //heals 20 health
                System.out.println(name + "'s health is now " + health);
                turn = false; //ends turn
            }
            else{
                System.out.println("The potion had no effect. You are already at max health.");
                turn = false; //ends turn
            }
        }
        //debug is used for checking components that rely on user choices
        else if (choice.equals("debug")){
            System.out.println("---Debug Menu---\nthis.name: " + name +"\nShadow: " + shadow + "\nshadowCount: " + shadowCount + 
                "\nPlayer Health (1,2,3): " + p1.health + " " + p2.health + " " + p3.health + "\nLast Item Use Margin: " +
                margin + "\n pkmnName: " + pkmnName + "\n---End Debug Menu---");
        }

    }
}
