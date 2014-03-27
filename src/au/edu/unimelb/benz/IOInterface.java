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
		command = new String[2];
		names = new String[3];
		userInput = new Scanner(System.in);
		nimSystem = new NimSys();
		index = 0;
	}
	
	// test method
	/*private void displayCommand() {
		System.out.println("command: " + command[0]);
		System.out.println("parameters: " + command[1]);
	}
	*/
	
	private void showPlayer(String[] playerData) {
		for (int i = 0; i < 3; i ++) {
			System.out.print(playerData[i] + ",");
		}
		System.out.print(playerData[3] + " games,");
		System.out.print(playerData[4] + " wins");
		System.out.println();
	}
	
	private void comAddplayer() {
		names = command[1].split(",");
		index = nimSystem.checkPosition(names[0]);
		if (index == -1) {
			nimSystem.addPlayer(names[0], names[1], names[2]);
		} else {
			System.out.println("The player already exists.");
		}
		System.out.println();
	}
	
	private void comRemoveplayer() {
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
		System.out.println();
	}
	
	private void comEditplayer() {
		names = command[1].split(",");
		index = nimSystem.checkPosition(names[0]);
		if (index != -1) {
			nimSystem.editPlayer(index, names[0], names[1], names[2]);
		} else {
			System.out.println("The player does not exists.");
		}
		System.out.println();
	}
	
	private void comResetstates() {
		if (command.length == 2) {
			names[0] = command[1];
			index = nimSystem.checkPosition(names[0]);
			if (index != -1) {
				nimSystem.resetStats(index);
			} else {
				System.out.println("The player does not exist.");
			}
		} else {
			System.out.println("Are you sure you want to reset all player statistics? (y/n)");
			if (userInput.nextLine().equals("y")) {
				nimSystem.resetStats();
			}
		}
		System.out.println();
	}
	
	private void comDisplayplayer() {
		if (command.length == 2) {
			String username = command[1];
			index = nimSystem.checkPosition(username);
			if (index != -1) {
				showPlayer(nimSystem.getPlayerData(index));
			}else {
				System.out.println("The player does not exist.");
			}
		} else {
			for (int i = 0; i < nimSystem.getSize(); i ++) {
				showPlayer(nimSystem.getPlayerData(i));
			}
		}
		System.out.println();
	}
	
	private void comRankings() {
		nimSystem.rank();
		String[] rankData = new String[5];
		int size = nimSystem.getSize();
		int playedNum = 0;
		String rate = null;
		for (int i = 1; i <= Math.min(10, size); i ++) {
			rankData = nimSystem.getPlayerData((size - i));
			rate = nimSystem.getRate((size - i));
			playedNum = Integer.parseInt(rankData[4]);
			if (playedNum < 10) {
				rankData[4] = "0" + rankData[4];
			}
			System.out.printf("%-5s| %-3sgames | %s %s%n", rate, rankData[4], rankData[2], rankData[1]);
		}
		System.out.println();
	}
	
	private void comStartgame() {
		
	}
	
	private void comExit() {
		System.out.println();
		System.exit(0);
	}
	
	public void commandLine() {
		while (true) {
			System.out.print(">");
			command = userInput.nextLine().split(" ");
			//String junk = userInput.next();
			if (command[0].equals("addplayer")) {
				comAddplayer();
			} else if (command[0].equals("removeplayer")) {
				comRemoveplayer();
			} else if (command[0].equals("editplayer")) {
				comEditplayer();
			} else if (command[0].equals("resetstates")) {
				comResetstates();
			} else if (command[0].equals("displayplayer")) {
				comDisplayplayer();
			} else if (command[0].equals("rankings")) {
				comRankings();
			} else if (command[0].equals("startgame")) {
				comStartgame();
			} else if (command[0].equals("exit")) {
				comExit();
			}
		}// end loop
	}// end method
	
}
