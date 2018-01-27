
/**
 * Players are given all necessary things fo this game to run.
 *
 * @author Zach Zimmerman
 * @version 1.24.18
 */
public class player
{
    static player p1 = new player();
    static player p2 = new player();
    static player p3 = new player();
    //base 100 health
    int health = 100;
    deck d = new deck();
    scanner user = new scanner();
    private String name;
    private String pkmnName;
    private String choice; //hardcoded as a temp user choice
    boolean shadow;
    int shadowCount = 1;
    //says when it's a player's turn
    boolean turn = false;
    //gives player's pokemon names
    public void setName(String t){
        name = t;
        System.out.println(name); //test code?
    }

    public void attack(){
        //random damage
        int damage = (int) (Math.random() * 15 + 15); //+ 15 is needed to keep damage from being 0. range = 15 to 30.
        if (d.pokemon[0] == pkmnName){
            if (!p1.shadow){
                p1.health = p1.health - damage; 
            }
            else{
                System.out.print("Player 1 has defended. " + name + "'s attack had no effect.");
            }
        }
        else if (d.pokemon[1] == pkmnName){
            if (!p2.shadow){
                p2.health = p2.health - damage;
            }
            else{
                System.out.print("Player 2 has defended. " + name + "'s attack had no effect.");
            }
        }   
        else{
            if (!p3.shadow){
                p3.health = p3.health - damage;
            }
            else{
                System.out.print("Player 3 has defended. " + name + "'s attack had no effect.");
            }
        }
        health = health -= damage; //subtracts damage amount from health
        System.out.println(this.name + " dealt " + damage + " damage to " +  pkmnName + " " + health);
        turn = false; //ends turn

        //attack a specific pokemon
    }

    public void defend(){
        //player becomes "invinsible" for the next player's turn. Ex) P1 defends, P2 cannot attack P1 but P3 can
        //Cannot be use twice in a row. If used twice print p.name + " defended but it failed." and end turn
        if (shadowCount != 2){
            shadow = true;
            shadowCount++;
        }
        else{
            System.out.print(name + " defended but it failed.");
            shadowCount = 1;
        }
    }

    public void turn(){
        //choose what to do; attack, defend, item?
        choice = user.getString();
        if(choice.equals("attack")){
            //choose who to attack
            System.out.print("Which pokemon would you like to attack? ");
            pkmnName = user.getString();
            this.attack(); //place holder name convert to user input
        }
        else if (choice.equals("defend")){
            this.defend();
        }
        else if (choice.equals("use item")){
            System.out.println("You used a potion.");
            if (health <= 80){
                health += 20; //heals 20 health
                System.out.println(health);
                turn = false; //ends turn
            }
            else if (health > 80){
                //heals up to 100
                int margin = 100 - health;
                health = health += margin; 
                System.out.println(health);
                turn = false; //ends turn
            }
            else{
                System.out.println("The potion had no effect. You are already at max health.");
                turn = false; //ends turn
            }
        }
    }
}
