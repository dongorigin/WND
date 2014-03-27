package au.edu.unimelb.benz;

public class NimSysTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//System.out.println("15/21 = " + 15.0 / 21.0);
		//System.out.println("15%21 = " + 15.0 % 21.0);
		
		
		NimSys testSys = new NimSys();
		testSys.addPlayer("bond", "bond", "bond");
		testSys.addPlayer("ben", "ben", "ben");
		// bond 
		testSys.playerWin(0);
		//testSys.playerLose(0);
		//testSys.playerLose(0);
		
		// ben
		testSys.playerLose(1);
		//testSys.playerWin(1);
		//testSys.playerWin(1);
		//testSys.checkPosition("bond");
		//testSys.showPlayer(0);
		//testSys.showPlayer(1);
		
		
		
		
		
		/*// test addPlayer()
		System.out.println("addPlayer");
		System.out.println(testGame.addPlayer("benjamin", "Zhang", "Chibin"));
		testGame.showPlayer(0);
		System.out.println(testGame.addPlayer("benjamin", "Zhang", "Chibin"));
		testGame.showPlayer(0);
		System.out.println(testGame.addPlayer("lskywalker", "Skywalker", "Luke"));
		testGame.showPlayer(0);
		testGame.showPlayer(1);
		System.out.println();
		
		// test removePlayer(username)
		System.out.println("removePlayer(username)");
		System.out.println(testGame.removePlayer("lskywalker"));
		testGame.showPlayer(0);
		System.out.println(testGame.removePlayer("nobody"));
		System.out.println();
		
		// test removePlayer()
		System.out.println("removePlayer()");
		System.out.println(testGame.removePlayer());
		System.out.println();
		
		// test editPlayer(S,S,S)
		System.out.println("editPlayer");
		testGame.editPlayer(0, "lskywalker", "Skywalker", "Luke");
		testGame.showPlayer(0);
		System.out.println();
		
		// test won lose
		System.out.println("test win lose");
		testGame.testNumber(0);
		testGame.showPlayer(0);
		System.out.println();
		
		// test resetState(S)
		System.out.println("test resetStates(s)");
		System.out.println(testGame.resetStats("lskywalker"));
		testGame.showPlayer(0);
		System.out.println();
		
		// test resetStats()
		System.out.println("test resetState()");
		testGame.testNumber(0);
		testGame.showPlayer(0);
		testGame.resetStats();
		testGame.showPlayer(0);*/
			
		
	}
}
