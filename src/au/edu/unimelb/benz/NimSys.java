package au.edu.unimelb.benz;

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
		playerList.get(index).win();
	}
	
	public void playerLose(int index) {
		playerList.get(index).lose();
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
	
	public void rank() {
		Collections.sort(playerList);
	}
	
	public String getRate(int index) {
		String rate = playerList.get(index).getRate() + "%";
		return rate;
	}
	
	public void exit() {
		
	}
}// end class

