
/**
 * Players are given all necessary things fo this game to run.
 *
 * @author Zach Zimmerman
 * @version 1.24.18
 */
public class player extends game
{
    player p1;
    player p2;
    //base 100 health
    int health = 100;
    deck d = new deck();
    scanner user = new scanner();
    private String name;
    //hardcoded as a temp user choice
    private String choice;
    //says when it's a player's turn
    boolean turn = false;
    private int margin = 0;
    //gives player's pokemon names
    public void setName(String t){
        name = t;
        System.out.println(name + " " + health + " health "); //test code?
    }

    public void attack(){
        //random damage
        int damage = (int) (Math.random() * 15 + 15); //+ 15 is needed to keep damage from being 0. range = 15 to 30.
        if (currentPlayer == 0){
            p2.health = p2.health - damage;
            System.out.println(p2.name + "'s health is at " + p2.health + ".");
        }
        else{
            p1.health = p1.health - damage;
            System.out.println(p1.name + "'s health is at " + p1.health + ".");
        }

        turn = false;
    }

    public void turn(){
        //choose what to do; attack, defend, item?
        choice = user.getString();
        if(choice.equals("attack")){
            this.attack();
        }
        else if (choice.equals("item")){
            System.out.println("You used a potion.");
            turn = false;
            if (health == 100){
                System.out.println("The potion had no effect. You are already at max health.");
                turn = false; //ends turn
            }
            else if (health > 80){
                //heals up to 100
                margin = 100 - health;
                health = health + margin; 
                System.out.println(health);
                turn = false; //ends turn
            }
            else{
                health += 20; //heals 20 health
                System.out.println(health);
                turn = false; //ends turn
            }
        }
    }
}
