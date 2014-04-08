package au.edu.unimelb.benz.projb.alphatest;

import java.util.*;

public class IOInterface {
	
	public static Scanner userInput;
	private NimSys nimSystem;
	private String[] command;
	private String[] names;
	int index;
	
	static {
		userInput = new Scanner(System.in);
	}
	
	public IOInterface() {
		System.out.println("Welcome to Nim");
		System.out.println();
		command = new String[2];
		names = new String[3];
		nimSystem = new NimSys();
		index = 0;
	}
	
	// test method
	/*private void displayCommand() {
		System.out.println("command: " + command[0]);
		System.out.println("names: " + command[1]);
	}
	*/
	
	private void showPlayer(String[] playerData) {
		System.out.print(playerData[0] + ",");
		System.out.print(playerData[2] + ",");
		System.out.print(playerData[1] + ",");
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
			System.out.println("The player does not exist.");
		}
		System.out.println();
	}
	
	private void comResetstats() {
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
			int[] displayIndex = nimSystem.displayAll();
			for (int i = 0; i < displayIndex.length; i ++) {
				showPlayer(nimSystem.getPlayerData(displayIndex[i]));
			}
		}
		System.out.println();
	}
	
	private void comRankings() {
		int[] rankingIndex = nimSystem.rank();
		String[] rankData = new String[5];
		int index = 0;
		int playedNum = 0;
		String rate = null;
		for (int i = 0; i < Math.min(10, rankingIndex.length); i ++) {
			index = rankingIndex[i];
			rankData = nimSystem.getPlayerData(index);
			rate = nimSystem.getRate(index);
			playedNum = Integer.parseInt(rankData[4]);
			if (playedNum < 10) {
				rankData[4] = "0" + rankData[4];
			}
			System.out.printf("%-5s| %-3sgames | %s %s%n", rate, rankData[4], rankData[2], rankData[1]);
		}
		System.out.println();
	}
	
	
	private void comStartgame() {
		String[] parameters = new String[4];
		int playerOneIndex = 0;
		int playerTwoIndex = 0;
		parameters = command[1].split(",");
		playerOneIndex = nimSystem.checkPosition(parameters[2]);
		playerTwoIndex = nimSystem.checkPosition(parameters[3]);
		if ((playerOneIndex != -1) && (playerTwoIndex != -1)) {
			String result = null;
			int initialStones = Integer.parseInt(parameters[0]);
			int upperBound = Integer.parseInt(parameters[1]);
			NimGame game = new NimGame(initialStones, upperBound, nimSystem.getPlayerData(playerOneIndex), nimSystem.getPlayerData(playerTwoIndex));
			result = game.gameLauncher();
			if (result.equals("first player wins")) {
				nimSystem.playerWin(playerOneIndex);
				nimSystem.playerLose(playerTwoIndex);
			} else if (result.equals("second player wins")) {
				nimSystem.playerLose(playerOneIndex);
				nimSystem.playerWin(playerTwoIndex);
			}
		} else {
			System.out.println("One of the players does not exist.");
		}
		System.out.println();
	}
	
	private void comExit() {
		userInput.close();
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
			} else if (command[0].equals("resetstats")) {
				comResetstats();
			} else if (command[0].equals("displayplayer")) {
				comDisplayplayer();
			} else if (command[0].equals("rankings")) {
				comRankings();
			} else if (command[0].equals("startgame")) {
				comStartgame();
			} else if (command[0].equals("exit")) {
				comExit();
			} else {
				System.out.println();
			}
		}// end loop
	}// end method
	
}
