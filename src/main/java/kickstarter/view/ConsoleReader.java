package kickstarter.view;

import java.util.Scanner;

public class ConsoleReader implements Reader{
	
	public String readUserInput() {
		String result;
		Scanner scanner = new Scanner(System.in);
		result = scanner.next();
		//scanner.close();
		return result;
	}

}
