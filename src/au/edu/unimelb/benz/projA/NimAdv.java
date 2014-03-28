package au.edu.unimelb.benz.projA;
/* Nim.java
 * This is an OO style Nim game all in one class
 * Designed and written by Benz
 * 24/3/2014
 */

import java.util.Scanner;

public class NimAdv {

	private Scanner userInput;
	
	public NimAdv() {
		userInput = new Scanner(System.in);
	}
	
	/* gameStart() method displays a welcome language 
	 * and takes an initial number of stones from user's input
	 * it returns the number
	 */
	public int gameStart() {
		int initialNum = 0;
		
		System.out.println("Welcome to Nim");
		System.out.println();
		System.out.println("Please enter initial number of stones:");
		
		initialNum = userInput.nextInt();
		System.out.println();
		return initialNum;
	}
	
	/* stonesRemove() method removes stones as user's input
	 * it takes the initial number of stones
	 */
	public void stonesRemove(int leftStones) {
		while (gameFinish(leftStones)) {
			System.out.print(leftStones + " stones left:");
			displayStars(leftStones);
			
			System.out.println("Remove how many?");
			leftStones = leftStones - userInput.nextInt();
			System.out.println();
		} //end loop
	} //end method
	
	/* gameFinish() method determines whether the game is over or not
	 * if there are stones left, then game continues, returns true
	 * if there is none left, the game is over, display "Game Over"
	 * return false
	 */
	public boolean gameFinish(int num) {
		if (num == 0) {
			userInput.close();
			System.out.println("Game Over");
			return false;
		} else{
			return true;
		} //end if
	} //end method
	
	/* displayStars() method displays stars as the number it takes
	 * stonesRemove() gives the number
	 */
	public void displayStars(int num) {
		for (int i = num; i > 0; i--) {
			System.out.print(" *");
		}
		
		System.out.println();
	}
	
	/* main() method starts the game by invoking gameStart()
	 * when everything finishes, main() ends the program
	 */
	public static void main(String[] args) {
		int numOfStones = 0;
		
		NimAdv nimGame = new NimAdv();
		numOfStones = nimGame.gameStart();
		nimGame.stonesRemove(numOfStones);
		System.exit(0);
	}
}
