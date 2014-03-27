package cn.dong.projb;

import java.util.Scanner;

public class Nim {
	private Scanner mScanner;
	private int stonesNum;
	private int upperBound;
	private Player playerA;
	private Player playerB;

	public Nim(Scanner scanner, int stonesNum, int upperBound, Player playerA, Player playerB) {
		this.mScanner = scanner;
		this.stonesNum = stonesNum;
		this.upperBound = upperBound;
		this.playerA = playerA;
		this.playerB = playerB;
	}

	public void startGame() {
		System.out.println("Game Playing...");
	}
}
