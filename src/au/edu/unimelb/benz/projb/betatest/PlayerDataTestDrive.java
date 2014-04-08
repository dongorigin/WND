package au.edu.unimelb.benz.projb.betatest;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerDataTestDrive {

	public static void main(String[] args) {
		
		PlayerData testPlayerC = new PlayerData("c", "c", "c");
		PlayerData testPlayerA = new PlayerData("a", "a", "a");
		PlayerData testPlayerD = new PlayerData("d", "d", "d");
		PlayerData testPlayerB = new PlayerData("b", "b", "b");
		
		testPlayerC.editNumbers(3, 1);
		testPlayerA.editNumbers(3, 1);
		testPlayerD.editNumbers(3, 3);
		testPlayerB.editNumbers(3, 2);
		
		out.println("c " + testPlayerC.getRate());
		out.println("a " + testPlayerA.getRate());
		out.println("d " + testPlayerD.getRate());
		out.println("b " + testPlayerB.getRate());
		
		ArrayList<PlayerData> testPlayers = new ArrayList<PlayerData>();
		testPlayers.add(testPlayerC);
		testPlayers.add(testPlayerA);
		testPlayers.add(testPlayerD);
		testPlayers.add(testPlayerB);
		
		@SuppressWarnings("unchecked")
		ArrayList<PlayerData> testToMerge = (ArrayList<PlayerData>) testPlayers.clone();
		Collections.sort(testToMerge);
		
		out.println();
		
		
		
		/*String[] playerDetail = new String[5];
		PlayerData playerA = new PlayerData();
		
		playerDetail = playerA.getData();
		for (int i = 0; i < 5; i++) {
			System.out.print(playerDetail[i] + " ");
		}
		
		int played = 12;
		int won = 5;
		playerA.setNames("benjamin", "Zhang", "Chibin");
		//playerA.setGames(played, won);
		
		playerDetail = playerA.getData();
		for (int i = 0; i < 5; i++) {
			System.out.print(playerDetail[i] + " ");
		}*/
	}
}
