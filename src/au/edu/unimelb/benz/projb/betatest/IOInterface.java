package au.edu.unimelb.benz.projb.betatest;

import java.util.*;

public class IOInterface {
	
	public static Scanner userInput;
	private PlayerCenter playerCenter;
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
		playerCenter = new PlayerCenter();
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
		index = playerCenter.checkPosition(names[0]);
		if (index == -1) {
			playerCenter.addPlayer(names[0], names[1], names[2]);
		} else {
			System.out.println("The player already exists.");
		}
		System.out.println();
	}
	
	private void comRemoveplayer() {
		if (command.length == 2) {
			names[0] = command[1];
			index = playerCenter.checkPosition(names[0]);
			if (index != -1) {
				playerCenter.removePlayer(index);
			} else {
				System.out.println("The player does not exist.");
			}
		} else {
			System.out.println("Are you sure you want to remove all players? (y/n)");
			if (userInput.nextLine().equals("y")) {
				playerCenter.removePlayer();
			}
		}
		System.out.println();
	}
	
	private void comEditplayer() {
		names = command[1].split(",");
		index = playerCenter.checkPosition(names[0]);
		if (index != -1) {
			playerCenter.editPlayer(index, names[0], names[1], names[2]);
		} else {
			System.out.println("The player does not exist.");
		}
		System.out.println();
	}
	
	private void comResetstats() {
		if (command.length == 2) {
			names[0] = command[1];
			index = playerCenter.checkPosition(names[0]);
			if (index != -1) {
				playerCenter.resetStats(index);
			} else {
				System.out.println("The player does not exist.");
			}
		} else {
			System.out.println("Are you sure you want to reset all player statistics? (y/n)");
			if (userInput.nextLine().equals("y")) {
				playerCenter.resetStats();
			}
		}
		System.out.println();
	}
	
	private void comDisplayplayer() {
		if (command.length == 2) {
			String username = command[1];
			index = playerCenter.checkPosition(username);
			if (index != -1) {
				showPlayer(playerCenter.getPlayerData(index));
			}else {
				System.out.println("The player does not exist.");
			}
		} else {
			int[] displayIndex = playerCenter.displayAll();
			for (int i = 0; i < displayIndex.length; i ++) {
				showPlayer(playerCenter.getPlayerData(displayIndex[i]));
			}
		}
		System.out.println();
	}
	
	private void comRankings() {
		int[] rankingIndex = playerCenter.rank();
		String[] rankData = new String[5];
		int index = 0;
		int playedNum = 0;
		String rate = null;
		for (int i = 0; i < Math.min(10, rankingIndex.length); i ++) {
			index = rankingIndex[i];
			rankData = playerCenter.getPlayerData(index);
			rate = playerCenter.getRate(index);
			playedNum = Integer.parseInt(rankData[4]);
			if (playedNum < 10) {
				rankData[3] = "0" + rankData[3];
			}
			System.out.printf("%-5s| %-3sgames | %s %s%n", rate, rankData[3], rankData[2], rankData[1]);
		}
		System.out.println();
	}
	
	
	private void comStartgame() {
		String[] parameters = new String[4];
		int playerOneIndex = 0;
		int playerTwoIndex = 0;
		parameters = command[1].split(",");
		playerOneIndex = playerCenter.checkPosition(parameters[2]);
		playerTwoIndex = playerCenter.checkPosition(parameters[3]);
		if ((playerOneIndex != -1) && (playerTwoIndex != -1)) {
			String result = null;
			int initialStones = Integer.parseInt(parameters[0]);
			int upperBound = Integer.parseInt(parameters[1]);
			NimGame game = new NimGame(initialStones, upperBound, playerCenter.getPlayerData(playerOneIndex), playerCenter.getPlayerData(playerTwoIndex));
			result = game.gameLauncher();
			if (result.equals("first player wins")) {
				playerCenter.playerWin(playerOneIndex);
				playerCenter.playerLose(playerTwoIndex);
			} else if (result.equals("second player wins")) {
				playerCenter.playerLose(playerOneIndex);
				playerCenter.playerWin(playerTwoIndex);
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
