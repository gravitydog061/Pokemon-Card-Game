
/**
 * Write a description of class deck here.
 *
 * @author Zach Zimmerman
 * @version 1.24.18
 */
import java.util.ArrayList;

public class deck
{
    //pokenon array
    String [] pokemon = {"Eevee", "Growlithe", "Cyndaquil",
            "Natu", "Ralts", "Torchic", "Riolu", "Piplup", "Zorua", "Seawaddle",
            "Honedge", "Bunnelby", "Rockruff","Jangmo'o"};
    //int index = random.nextInt(pokemon.length);

    public void shuffle(String [] pokemon){
        //shuffles pokemon into an ArrayList
        for (int i = 0; i < pokemon.length; i++){
            int r = (int)(Math.random() * (pokemon.length - 1));   
            String temp = pokemon[r];
            pokemon[r] = pokemon[i];
            pokemon[i] = temp;
        }

        for (int i = 0; i < pokemon.length; i++){
            System.out.println(pokemon[i]);
        }
        //debug code
        //System.out.print(shuffledPokemon.get(0));
        //System.out.print(shuffledPokemon.size());
    }

    //debug method
    /**public static void main(){
        deck d = new deck();
        d.shuffle(d.pokemon);
    }**/

}
