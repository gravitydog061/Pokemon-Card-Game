
/**
 * Players are given all necessary things fo this game to run.
 *
 * @author Zach Zimmerman
 * @version 1.24.18
 */
public class player
{
    int health = 100;
    deck d = new deck();
    private String name;
    private String choice = "attack";
    private String player;
    public void setName(String t){
        name = t;
        System.out.println(name);
    }

    public void attack(String n){
        //random damage
        int damage = (int) (Math.random() * 15 + 15); //+ 15 is needed to keep damage from being 0. range = 15 to 30.
        health = health -= damage;
        System.out.println(health);
        //attack a specific pokemon
    }

    public void defend(){
        //player becomes "invinsible" for the next player's turn. Ex) P1 defends, P2 cannot attack P1 but P3 can
        //Cannot be use twice in a row. If used twice print p.name + " defended but it failed." and end turn
        
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
                health += 20;
            }
            else if (health > 80){
                int margin = 100 - health;
                health = health += margin;
            }
            else{
                System.out.println("The potion had no effect. You are already at max health.");
            }
        }
    }
}
