package au.edu.unimelb.benz.projc.v0_1;

import java.util.*;
import java.io.*;

/**
 * This class stores all players' data.
 * 
 * @author Tonny
 *
 */
public class NimPlayerCenter {

	private ArrayList<NimPlayer> playerList;
	
	public NimPlayerCenter() {
		playerList = new ArrayList<NimPlayer>();
	}

	/**
	 * This method check a position of a player's date 
	 * in the array list by the user name.
	 * 
	 * @param userN a user name to allocate the position. 
	 * @return 		position. if the user name matches one player's.
	 *				-1 if there is no match.
	 */
	public int checkPosition(String userN) {
		int position = 0;
		for (NimPlayer toCheck : playerList) {
			if (toCheck.getUserName().equals(userN)) {
				return position;
			}
			position ++;
		}
		return -1;
	}
	
	
	/**
	 * This method add a new human player to the player list.
	 * 
	 * @param userName	a user name.
	 * @param givenName	a given name.
	 * @param familyName	a family name.
	 */
	public void addPlayer(String userName, String givenName, String familyName) {
		playerList.add(new NimHumanPlayer(userName, givenName, familyName));
	}
	
	/**
	 * This method add a new AI player to the player list.
	 * 
	 * @param userName	a user name.
	 * @param givenName	a given name.
	 * @param familyName	a family name.
	 */
	public void addAIPlayer(String userName, String givenName, String familyName) {
		playerList.add(new NimAIPlayer(userName, givenName, familyName));
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
	 * @param userName a username.
	 * @param givenName a family name.
	 * @param familyName a given name.
	 */
	public void editPlayer(int index, String userName, String givenName, String familyName) {
		playerList.get(index).setUserName(userName);
		playerList.get(index).setGivenName(givenName);
		playerList.get(index).setFamilyName(familyName);
	}
	
	/**
	 * This method changes the two numbers when a player win a game
	 * by invoking {@link NimPlayer#setNumbers(int, int)}.
	 * 
	 * @param index the position of a player.
	 */
	public void gameResult(int index, boolean gameWon) {
		if (gameWon) {
			playerList.get(index).setNumbers(1, 1);
		} else {
			playerList.get(index).setNumbers(1, 0);
		}
	}
	
	/**
	 * This method reset the two numbers of a players to 0
	 * by invoking {@link NimPlayer#setNumbers(int, int)}.
	 */
	public void resetStats(int index) {
		playerList.get(index).setNumbers(0, 0);
	}
	
	public void resetStats() {
		for (NimPlayer toReset : playerList) {
			toReset.setNumbers(0, 0);
		}
	}
	
	/**
	 * This method returns the size of the list.
	 * @return 		the size of the list.
	 */
	public int getSize() {
		return playerList.size();
	}
	
	/**
	 * This method returns a player.
	 * 
	 * @param index	the index of a player.
	 * @return		an player object.
	 */
	public NimPlayer getPlayer(int index) {
		return playerList.get(index);
	}
	
	/**
	 * This method ranks all players in the list, stores and returns
	 * each player's ranking in an integer array.
	 * The comparator is {@link RateCompare}.
	 * 
	 * @return 		an integer array with the ranking positions of all the
	 * 				players.
	 * @see RateCompare#compare(NimPlayer, NimPlayer)
	 */
	public int[] rank() {
		@SuppressWarnings("unchecked")
		ArrayList<NimPlayer> toMerge = (ArrayList<NimPlayer>)playerList.clone();
		RateCompare rateComparator = new RateCompare();
		Collections.sort(toMerge, rateComparator);
		int size = Math.min(10, toMerge.size());
		int[] rankingIndex = new int[size];
		for (int i = 0; i < size; i ++) {
			rankingIndex[i] = playerList.indexOf(toMerge.get(i));
		}
		
		return rankingIndex;
	}
	
	/**
	 * This class is the comparator of the ranking.
	 * 
	 * @author Tonny
	 */
	class RateCompare implements Comparator<NimPlayer> {
		public int compare(NimPlayer one, NimPlayer two) {
			Integer first = one.getRate();
			Integer second = two.getRate();
			int firstResult = first.compareTo(second);
			int finalResult = 0;
			if (firstResult == 0) {
				finalResult = one.compareTo(two);
			} else {
				finalResult = -firstResult;
			}
			return finalResult;
		}
	}
	
	/**
	 * This method merge a copy of the player list by username.
	 * 
	 * @return		an integer array stores the position of each player.
	 * @see NimPlayer#compareTo(NimPlayer)
	 */
	public int[] displayAll() {
		@SuppressWarnings("unchecked")
		ArrayList<NimPlayer> toMerge = (ArrayList<NimPlayer>)playerList.clone();
		Collections.sort(toMerge);
		int size = toMerge.size();
		int[] displayIndex = new int[size];
		for (int i = 0; i < size; i ++) {
			displayIndex[i] = playerList.indexOf(toMerge.get(i));
		}
		
		return displayIndex;
	}
	
	/**
	 * This method stores player data to a file.
	 */
	public void saveData() {
		try{
			ObjectOutputStream playerDataSaver = new ObjectOutputStream(new FileOutputStream("players.dat"));
			playerDataSaver.writeObject(playerList);
			playerDataSaver.close();
		} catch(FileNotFoundException e) {
			System.out.println("File creation failed.");
		} catch(IOException e) {
			System.out.println("Writing file failed.");
		}
	}
	
	/**
	 * This method reads data from a file.
	 */
	@SuppressWarnings("unchecked")
	public void readData() {
		try {
			ObjectInputStream playerDataReader = new ObjectInputStream(new FileInputStream("players.dat"));
			playerList = (ArrayList<NimPlayer>)playerDataReader.readObject();
			playerDataReader.close();
		} catch(Exception e) {
			saveData();
		}
	}
	
	
	
}
