package cn.benz;

public class MyEx extends Exception {

	static void doRisky(String t) throws MyEx {
		System.out.print("h");
		
		if ("yes".equals(t)) {
			System.out.print("a");
		} else {
			System.out.print("r");
			throw new MyEx();
		}
	}
	
	public static void main(String[] args) {
		String test = args[0];
		System.out.print("t");
		try {
			doRisky(test);
		} catch (MyEx e) {
			System.out.print("o");
		} finally {
			System.out.print("w");
		}
		System.out.print("s");
	}
}
