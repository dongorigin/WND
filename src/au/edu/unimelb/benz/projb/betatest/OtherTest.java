package au.edu.unimelb.benz.projb.betatest;

import java.util.ArrayList;
import java.util.Collections;

public class OtherTest {

	public static void main(String[] args) {
		ArrayList<Integer> testSort = new ArrayList<Integer>();
		testSort.add(0);
		testSort.add(100);
		testSort.add(66);
		
		Collections.sort(testSort);
		
		for (int toDisplay : testSort) {
			System.out.print(toDisplay + " ");
		}
		System.out.println();
	}
}
