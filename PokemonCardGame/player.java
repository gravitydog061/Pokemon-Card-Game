
/**
 * Players are given all necessary things fo this game to run.
 *
 * @author Zach Zimmerman
 * @version 1.24.18
 */
public class player
{
    //base 100 health
    int health = 100;
    deck d = new deck();
    private String name;
    //hardcoded as a temp user choice
    private String choice = "attack";
    //says when it's a player's turn
    boolean turn = false;
    //gives player's pokemon names
    public void setName(String t){
        name = t;
        System.out.println(name); //test code?
    }

    public void attack(String n){
        //random damage
        int damage = (int) (Math.random() * 15 + 15); //+ 15 is needed to keep damage from being 0. range = 15 to 30.
        health = health -= damage; //subtracts damage amount from health
        System.out.println(health);
        turn = false; //ends turn
        //attack a specific pokemon
    }

    public void defend(){
        //player becomes "invinsible" for the next player's turn. Ex) P1 defends, P2 cannot attack P1 but P3 can
        //Cannot be use twice in a row. If used twice print p.name + " defended but it failed." and end turn
        turn = false; //ends turn
    }

    public void turn(){
        //choose what to do; attack, defend, item?
        if(choice == "attack"){
            //choose who to attack
            this.attack(d.pokemon[0]); //place holder name convert to user input
        }
        else if (choice == "defend"){
            this.defend();
        }
        else if (choice == "item"){
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
