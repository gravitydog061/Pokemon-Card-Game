
/**
 * Players are given all necessary things fo this game to run.
 *
 * @author Zach Zimmerman
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
    public void setName(String n){
        name = n;
        System.out.println(name + " " + health + " health ");
    }

    public void attack(){
        //random damage
        damage = (int) (Math.random() * 15 + 15); //+ 15 is needed to keep damage from being 0.
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

    public void turn(){
        //choose what to do; attack, defend, item?
        choice = user.getString();
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
