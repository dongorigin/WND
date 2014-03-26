package au.edu.unimelb.benz;

import java.util.*;

public class NimSys {
	
	private ArrayList<PlayerData> playerList;

	public NimSys() {
		playerList = new ArrayList<PlayerData>();
	}

	// test method
	public void showPlayer(int index) {
		PlayerData testPlayer = playerList.get(index);
		String[] testData = testPlayer.getData();
		System.out.print(index);
		for (int i = 0; i < 5; i ++) {
			System.out.print(" " + testData[i]);
		}
		System.out.println();
	}
	
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
		PlayerData editor = playerList.get(index);
		editor.setNames(userN, familyN, givenN);
	}
	
	public void resetStats(int index) {
		PlayerData editor = playerList.get(index);
		editor.resetNumbers();
	}
	
	// test method
	public void testNumber(int index) {
		PlayerData editor = playerList.get(index);
		editor.finish("won");
		editor.finish("lost");
	}
	
	public void resetStats() {
		for (PlayerData toReset : playerList) {
			toReset.resetNumbers();
		}
	}
	
	public String[] displayPlayer(int index) {
		PlayerData player = playerList.get(index);
		return(player.getData());
	}
	
	public int size() {
		return playerList.size();
	}
	
	public void exit() {
		
	}
}// end class

