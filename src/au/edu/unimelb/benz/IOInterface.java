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
		System.out.println("command: " + command[0]);
		System.out.println("parameters: " + command[1]);
	}
	
	public void comAddplayer() {
		// test
		System.out.println("in comAddplayer now");
		names = command[1].split(",");
		index = nimSystem.checkPosition(names[0]);
		// test
		System.out.println(nimSystem.checkPosition(names[0]));
		System.out.println(names[0]);
		System.out.println(index);
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
			if (userInput.nextLine().equals("y")) {
				nimSystem.removePlayer();
			}
		}
	}
	
	public void commandLine() {
		while (true) {
			System.out.print(">");
			command = userInput.nextLine().split(" ");
			// test
			displayCommand();
			//System.out.println(command[0].equals("addplayer"));
			if (command[0].equals("addplayer")) {
				// test
				//System.out.println("addplayer received");
				comAddplayer();
				// test
				//System.out.println("add player succeed");
			} else if (command[0].equals("removeplayer")) {
				// test
				System.out.println("received");
				
				comRemoveplayer();
				// test
				System.out.println("succeed");
				
			}
		}// end loop
	}// end method
	
}
