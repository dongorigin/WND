package au.edu.unimelb.benz.projb.alphatest;

import java.util.*;

public class NimSys {
	
	private ArrayList<PlayerData> playerList;

	public NimSys() {
		playerList = new ArrayList<PlayerData>();
	}

	// test method
	/*public void showPlayer(int index) {
		String[] testData = playerList.get(index).getData();
		System.out.print(index);
		for (String toDisplay : testData) {
			System.out.print(" " + toDisplay);
		}
		System.out.println();
	}
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
	
	public void addPlayer(String userN, String familyN, String givenN) {
		PlayerData newPlayer = new PlayerData(userN, familyN, givenN);
		playerList.add(newPlayer);
	}

	public void removePlayer(int index) {
			playerList.remove(index);
	}

	public void removePlayer() {
		playerList.clear();
	}

	public void editPlayer(int index, String userN, String familyN, String givenN) {
		playerList.get(index).setNames(userN, familyN, givenN);
	}
	
	public void resetStats(int index) {
		playerList.get(index).resetNumbers();
	}
	
	public void playerWin(int index) {
		playerList.get(index).editNumbers(1, 1);
	}
	
	public void playerLose(int index) {
		playerList.get(index).editNumbers(1, 0);
	}
	
	public void resetStats() {
		for (PlayerData toReset : playerList) {
			toReset.resetNumbers();
		}
	}
	
	public String[] getPlayerData(int index) {
		return playerList.get(index).getData();
	}
	
	public int getSize() {
		return playerList.size();
	}
	
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
	
	public String getRate(int index) {
		String rate = playerList.get(index).getRate() + "%";
		return rate;
	}
	
	class UsernameCompare implements Comparator<PlayerData> {
		public int compare(PlayerData one, PlayerData two) {
			return one.getUsername().compareTo(two.getUsername());
		}
	}
	
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

