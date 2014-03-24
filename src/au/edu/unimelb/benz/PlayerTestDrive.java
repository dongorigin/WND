package au.edu.unimelb.benz;

public class PlayerTestDrive {

	public static void main(String[] args) {
		String[] playerDetail = new String[5];
		Player playerA = new Player();
		
		playerDetail = playerA.getPlayer();
		for (int i = 0; i < 5; i++) {
			System.out.print(playerDetail[i] + " ");
		}
		
		int played = 12;
		int won = 5;
		String[] playerNames = new String[3];
		playerNames[0] = "benjamin";
		playerNames[1] = "Chibin";
		playerNames[2] = "Zhang";
		playerA.setPlayer(playerNames);
		playerA.setGames(played, won);
		
		playerDetail = playerA.getPlayer();
		for (int i = 0; i < 5; i++) {
			System.out.print(playerDetail[i] + " ");
		}
	}
}
