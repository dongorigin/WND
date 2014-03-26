package au.edu.unimelb.benz;

import java.util.Scanner;

public class IOInterface {
	private Scanner userInput;
	private NimSys nimSystem;
	private String[] command;
	private String[] names;
	int index;
	
	public IOInterface() {
		System.out.println("Welcome to Nim");
		System.out.println();
		userInput = new Scanner(System.in);
		nimSystem = new NimSys();
		index = 0;
	}
	
	// test method
	public void displayCommand() {
		for (String toDisplay : command) {
			System.out.print(toDisplay + " ");
			System.out.println();
		}
	}
	
	public void comAddplayer() {
		System.out.println("in comAddplayer now");
		names = command[1].split(",");
		index = nimSystem.checkPosition(names[0]);
		if (index == -1) {
			nimSystem.addPlayer(names[0], names[1], names[2]);
		} else {
			System.out.println("The player already exists.");
		}
	}
	
	public void comRemoveplayer() {
		if (command.length == 2) {
			names[0] = command[1];
			index = nimSystem.checkPosition(names[0]);
			if (index != -1) {
				nimSystem.removePlayer(index);
			} else {
				System.out.println("The player does not exist.");
			}
		} else {
			System.out.println("Are you sure you want to remove all players? (y/n)");
			if (userInput.next() == "y") {
				nimSystem.removePlayer();
			}
		}
	}
	
	public void commandLine() {
		while (true) {
			System.out.print(">");
			command = userInput.next().split(" ");
			displayCommand();
			if (command[0] == "addplayer") {
				comAddplayer();
				// test
				System.out.println("add player succeed");
			} else if (command[0] == "removeplayer") {
				comRemoveplayer();
			}
		}// end loop
	}// end method
	
}
