
/**
 * Write a description of class scanner here.
 *
 * @author Zach Zimmerman, Chris Hicks, Christian Rodriguez
 * @version 1.25.18
 */
import java.util.Scanner;
public class scanner
{
    //This method gets the user input so that it can be determined
    //what to do.
    public static String getString(){
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}