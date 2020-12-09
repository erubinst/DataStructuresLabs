//Esme Rubinstein
import java.util.Random;
import java.util.Scanner;
public class HiLo {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Random rnd = new Random();
	int target = rnd.nextInt(1000)+1;
	int userGuess = -1;
	int count = 0;
	Scanner input = new Scanner(System.in);
	System.out.print("Enter your integer guess between 1 and 1000: ");
	while ( input.hasNextLine() ) {         // keep looping for each guess, use 'break' to exit

	        String line = input.nextLine();     // Read the next line of input from the user

	        Scanner s2 = new Scanner(line);     // s2 will let me break 'line' apart

	        if  ( s2.hasNextInt() ) {           // check to see if s2 would next see an integer number
	            // Yay! do something with this
	            userGuess = s2.nextInt();
	          
	            // read in that number
	        } else {
	            System.out.print("Illegal guess.  Enter your integer guess between 1 and 1000: ");
	            continue;
	            // jump back to the top of the while loop
	           
	        }
	        count +=1;
	        if (userGuess > target) {
	            System.out.println("Too high!");
	            System.out.print("Enter your integer guess between 1 and 1000: ");
	            continue;
	        }
	        if (userGuess < target) {
	            System.out.println("Too low!");
	            System.out.println("Enter your integer guess between 1 and 1000: ");
	            continue;
	        }
	        else {
	            System.out.println("Yay you got it!");
	            break;
	        }
	        
	            
	        /* probably more here! This is just an example, you know? */

    }
	System.out.printf("You got it in %d tries. \n", count);

    }
}