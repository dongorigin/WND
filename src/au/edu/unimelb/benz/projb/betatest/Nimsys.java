package au.edu.unimelb.benz.projb.betatest;

/**
 * This is the import of the Nim system.
 * 
 * @author Tonny
 * @version v1.0, 1/5/2014
 */
public class Nimsys {

	/**
	 * The main method create a new object of the IOInterface class.
	 * 
	 * @param arges nothing.
	 * @see IOInterface
	 */
	public static void main(String[] arges) {
		IOInterface nimStart = new IOInterface();
		nimStart.commandLine();
	}
}
