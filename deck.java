
/**
 * Write a description of class deck here.
 *
 * @author Zach Zimmerman, Chris Hicks, Christian Rodriguez
 * @version 1.24.18
 */
import java.util.ArrayList;

public class deck
{
    //Pokemon string array that consist of 14 "cards"
    String [] pokemon = {"Eevee", "Growlithe", "Cyndaquil",
            "Natu", "Ralts", "Torchic", "Riolu", "Piplup", "Zorua", "Seawaddle",
            "Honedge", "Bunnelby", "Rockruff","Jangmo'o"};
    //Method for shuffling the pokemon, using the string array pokemon as a parameter
    public void shuffle(String [] pokemon){
        //shuffles pokemon
        for (int i = 0; i < pokemon.length; i++){
            //This uses the exchange method to shuffle the array. This gets the cards to be
            //shuffled by having a random string being grabbed and being placed at a random
            //spot in the array.
            int r = (int)(Math.random() * (pokemon.length - 1));   
            String temp = pokemon[r];
            pokemon[r] = pokemon[i];
            pokemon[i] = temp;
        }

        for (int i = 0; i < pokemon.length; i++){
            //This prints out the array that has been shuffled.
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
