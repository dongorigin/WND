
package au.edu.unimelb.benz.projb.v1_0;

import java.util.*;

/**
 * This class deals with all the operations about inputs (the command lines) and outputs.
 * It contains a static scanner that is used in both this class and the NimGame class,
 * since there should be no more than two scanners.
 * 
 * @author Tonny
 * @version v1.0, 2/5/2014
 */
public class IOInterface {
	
	public static Scanner userInput;
	private PlayerCenter playerCenter;
	private String[] command;
	private String[] names;
	int index;
	
	static {
		userInput = new Scanner(System.in);
	}
	
	/**
	 * This is the sole constructor. Besides the initialization, it also
	 * prints out a welcome message.
	 */
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
	
	/**
	 * This method prints out all of a player's data.
	 * @param playerData the player data. Slightly change the order
	 * 					 to meet the format.
	 * @see PlayerData#getData()
	 */
	private void showPlayer(String[] playerData) {
		System.out.print(playerData[0] + ",");
		System.out.print(playerData[2] + ",");
		System.out.print(playerData[1] + ",");
		System.out.print(playerData[3] + " games,");
		System.out.print(playerData[4] + " wins");
		System.out.println();
	}
	
	/**
	 * This method first check if there is a player with the same username
	 * by invoking {@link PlayerCenter#checkPosition(String)}; if there isn't,
	 * invokes {@link PlayerCenter#addPlayer(String, String, String)} to add a new player.
	 * If there is, prints out an error.
	 */
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
	
	/**
	 * This method removes player(s). If the command line is with parameters, 
	 * invokes {@link PlayerCenter#checkPosition(String)} to find out the index,
	 * then invokes {@link PlayerCenter#removePlayer(int)} to remove the player;
	 * if the command is without parameters, then invokes {@link PlayerCenter#removePlayer()}
	 * to remove all players after acknowledging the user.
	 */
	private void comRemoveplayer() {
		// if the command has parameters
		if (command.length == 2) {
			names[0] = command[1];
			index = playerCenter.checkPosition(names[0]);
			// check valid player
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
	
	/**
	 * This method edits an existing player's family name and given name.
	 * First invokes {@link PlayerCenter#checkPosition(String)} to check the
	 * index, then invokes {@link PlayerCenter#editPlayer(int, String, String, String)}
	 * to edit the names if there is an existing player with the same user; If there is not, print
	 * out an error.
	 */
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
	
	/**
	 * This method rest player(s)' played number and won number.
	 * If the command line is with parameters, the method invokes 
	 * {@link PlayerCenter#checkPosition(String)} to check the
	 * index, then invokes {@link PlayerCenter#resetStats(int)}
	 * to reset the player's numbers if there is an existing player with the same username;
	 * if all the username is not same to the parameter, print out an error;
	 * if the command line is without parameters, then reset all players' numbers
	 * by invoking {@link PlayerCenter#resetStats()} after acknowledging the user.
	 */
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
	
	/**
	 * This method display player(s). If the command line is without parameters,
	 * then the method display the list of players by invoking {@link PlayerCenter#displayAll()};
	 * if the command line is with parameters, the method check for the player with the same username
	 * by invoking {@link PlayerCenter#checkPosition(String)}; if there is not, print out an error;
	 * if there is, display it.
	 */
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
			// display all players
			for (int i = 0; i < displayIndex.length; i ++) {
				showPlayer(playerCenter.getPlayerData(displayIndex[i]));
			}
		}
		System.out.println();
	}
	
	/**
	 * This method shows the ranking of the players in the list. By invoking
	 * {@link PlayerCenter#rank()} to get the order and displays the list in that
	 * order, in certain format.
	 */
	private void comRankings() {
		int[] rankingIndex = playerCenter.rank();
		String[] rankData = new String[5];
		int index = 0;
		int playedNum = 0;
		String rate = null;
		// check boundaries
		for (int i = 0; i < Math.min(10, rankingIndex.length); i ++) {
			index = rankingIndex[i];
			rankData = playerCenter.getPlayerData(index);
			rate = playerCenter.getRate(index);
			playedNum = Integer.parseInt(rankData[4]);
			// format
			if (playedNum < 10) {
				rankData[3] = "0" + rankData[3];
			}
			System.out.printf("%-5s| %-3sgames | %s %s%n", rate, rankData[3], rankData[2], rankData[1]);
		}
		System.out.println();
	}
	
	
	/**
	 * This method start a Nim game, and alter the players' data by the result of the game.
	 * It check the user's input by invoking {@link PlayerCenter#checkPosition(String)}, if it
	 * is valid, then start a game by create a new object of the NimGame class. At last, it changes
	 * the players' data by invoking {@link PlayerCenter#playerWin(int)} and {@link PlayerCenter#playerLose(int)}.
	 * 
	 * @see NimGame
	 */
	private void comStartgame() {
		String[] parameters = new String[4];
		int playerOneIndex = 0;
		int playerTwoIndex = 0;
		parameters = command[1].split(",");
		playerOneIndex = playerCenter.checkPosition(parameters[2]);
		playerTwoIndex = playerCenter.checkPosition(parameters[3]);
		// start game
		if ((playerOneIndex != -1) && (playerTwoIndex != -1)) {
			String result = null;
			int initialStones = Integer.parseInt(parameters[0]);
			int upperBound = Integer.parseInt(parameters[1]);
			NimGame game = new NimGame(initialStones, upperBound, playerCenter.getPlayerData(playerOneIndex), playerCenter.getPlayerData(playerTwoIndex));
			result = game.gameLauncher();
			// set players' data
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
	
	/**
	 * This method takes the user's input command line and runs it.
	 * The command lines are:
	 * <li><code>addplayer</code>
	 * <li><code>removeplayer</code>
	 * <li><code>editplayer</code>
	 * <li><code>resetstats</code>
	 * <li><code>displayplayer</code>
	 * <li><code>rankings</code>
	 * <li><code>startgame</code>
	 * <li><code>exit</code>
	 */
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
