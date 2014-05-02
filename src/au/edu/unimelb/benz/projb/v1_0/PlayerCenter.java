package au.edu.unimelb.benz.projb.v1_0;

import java.util.*;

/**
 * This class dealing with all the operations about a list that
 * stores all the players.
 * 
 * @author Tonny
 * @version v1.0, 1/5/2014
 * @see PlayerData
 */
public class PlayerCenter {
	
	private ArrayList<PlayerData> playerList;

	/**
	 * The sole constructor.
	 */
	public PlayerCenter() {
		playerList = new ArrayList<PlayerData>();
	}

	// test method
	/*
		public void showPlayer(int index) {
		String[] testData = playerList.get(index).getData();
		System.out.print(index);
		for (String toDisplay : testData) {
			System.out.print(" " + toDisplay);
		}
		System.out.println();
	}
	*/
	
	/**
	 * This method check a position of a player's date 
	 * in the array list by the username.
	 * 
	 * @param userN a username to allocate the position. 
	 * @return 		position if the username matches one player's.
	 *				-1 if there is no match.
	 */
	public int checkPosition(String userN) {
		int position = 0;
		for (PlayerData toCheck : playerList) {
			if (toCheck.getUsername().equals(userN)) {
				return position;
			}
			position ++;
		}
		return -1;
	}
	
	/**
	 * This method add a new player to the list.
	 * 
	 * @param userN a username.
	 * @param familyN a family name.
	 * @param givenN a given name.
	 */
	public void addPlayer(String userN, String familyN, String givenN) {
		PlayerData newPlayer = new PlayerData(userN, familyN, givenN);
		playerList.add(newPlayer);
	}

	/**
	 * This method remove a player from a certain position of the list.
	 * 
	 * @param index the position of a player.
	 */
	public void removePlayer(int index) {
			playerList.remove(index);
	}

	/**
	 * This method removes all the player data.
	 */
	public void removePlayer() {
		playerList.clear();
	}

	/**
	 * This method edit the three names of a certain player in the list 
	 * by invoking {@link PlayerData#setNames(String, String, String)}.
	 * 
	 * @param index the position of a player.
	 * @param userN a username.
	 * @param familyN a family name.
	 * @param givenN a given name.
	 */
	public void editPlayer(int index, String userN, String familyN, String givenN) {
		playerList.get(index).setNames(userN, familyN, givenN);
	}
	
	/**
	 * This method reset the two numbers of a certain player by invoking
	 * {@link PlayerData#resetNumbers()}.
	 * 
	 * @param index the position of a player
	 */
	public void resetStats(int index) {
		playerList.get(index).resetNumbers();
	}
	
	/**
	 * This method changes the two numbers when a player win a game
	 * by invoking {@link PlayerData#editNumbers(int, int)}.
	 * 
	 * @param index the position of a player.
	 */
	public void playerWin(int index) {
		playerList.get(index).editNumbers(1, 1);
	}
	
	/**
	 * This method changes the two numbers when a player lose a game
	 * by invoking {@link PlayerData#editNumbers(int, int)}.
	 * 
	 * @param index the position of a player.
	 */
	public void playerLose(int index) {
		playerList.get(index).editNumbers(1, 0);
	}
	
	/**
	 * This method reset the two numbers of all players to 0
	 * by invoking {@link PlayerData#resetNumbers()}.
	 */
	public void resetStats() {
		for (PlayerData toReset : playerList) {
			toReset.resetNumbers();
		}
	}
	
	/**
	 * This method gives the data of a certain player to other class
	 * by invoking {@link PlayerData#getData()}.
	 * 
	 * @param index the position of a player.
	 * @return 		a string array of a player's data.
	 */
	public String[] getPlayerData(int index) {
		return playerList.get(index).getData();
	}
	
	/**
	 * This method returns the size of the list.
	 * @return 		the size of the list.
	 */
	public int getSize() {
		return playerList.size();
	}
	
	/**
	 * This method ranks all players in the list, stores and returns
	 * each player's ranking in an integer array.
	 * Merging is implemented by {@link Collections#sort(List)}.
	 * 
	 * @return 		an integer array with the ranking positions of all the
	 * 				players.
	 * @see PlayerData#compareTo(PlayerData)
	 */
	public int[] rank() {
		@SuppressWarnings("unchecked")
		ArrayList<PlayerData> toMerge = (ArrayList<PlayerData>)playerList.clone();
		Collections.sort(toMerge);
		int size = Math.min(10, toMerge.size());
		int[] rankingIndex = new int[size];
		for (int i = 0; i < size; i ++) {
			rankingIndex[i] = playerList.indexOf(toMerge.get(i));
		}
		
		return rankingIndex;
	}
	
	/**
	 * This method returns the rate of a certain player in format.
	 * 
	 * @param index the position of a player.
	 * @return		a string that stores the formatted rate.
	 */
	public String getRate(int index) {
		String rate = playerList.get(index).getRate() + "%";
		return rate;
	}
	
	/**
	 * This class is the comparator of the username.
	 * 
	 * @author Tonny
	 */
	class UsernameCompare implements Comparator<PlayerData> {
		public int compare(PlayerData one, PlayerData two) {
			return one.getUsername().compareTo(two.getUsername());
		}
	}
	
	/**
	 * This method merge a copy of the player list by username.
	 * 
	 * @return		an integer array stores the position of each player.
	 * @see UsernameCompare
	 */
	public int[] displayAll() {
		@SuppressWarnings("unchecked")
		ArrayList<PlayerData> toMerge = (ArrayList<PlayerData>)playerList.clone();
		UsernameCompare usernameCompare = new UsernameCompare();
		Collections.sort(toMerge, usernameCompare);
		int size = toMerge.size();
		int[] displayIndex = new int[size];
		for (int i = 0; i < size; i ++) {
			displayIndex[i] = playerList.indexOf(toMerge.get(i));
		}
		
		return displayIndex;
	}
}// end class

