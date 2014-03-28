package au.edu.unimelb.benz.proja;
/* Nim.java
 * This is a Nim game all in one class
 * Designed and written by Benz
 * 20/3/2014
 */

import java.util.Scanner;

public class Nim {

	/* The main method: It first prints out a welcome message 
	 * and asks for the total number of stones. 
	 * Then it repeatedly displays the remaining stones 
	 * and asks the player to remove some stones until there is no stone left. 
	 * Finally, it prints the "Game over" message.
	 * Comment above are directly copied from the lecture side.
	*/

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		//welcome message
		System.out.println("Welcome to Nim");
		System.out.println();
		
		int numberOfStones = 0;
		
		//initialize number of stones
		System.out.println("Please enter initial number of stones:");
		numberOfStones = userInput.nextInt();
		System.out.println("");
		
		boolean isLeft = true;
		
		//let user remove stones
		while (isLeft) {
			//print the number
			System.out.print(numberOfStones + " stones left:" );
			//print the "*" as stones
			for (int i = numberOfStones; i > 0; i--) {
				System.out.print(" *");
			}
			System.out.println();
			//get user's input number
			System.out.println("Remove how many?");
			numberOfStones = numberOfStones - userInput.nextInt();
			System.out.println();
			
			if (numberOfStones == 0) {
				isLeft = false;
			}//end if
		}//end loop
		
		//the end of the Nim game
		userInput.close();
		System.out.println("Game Over");
	}//end main
}//end class
