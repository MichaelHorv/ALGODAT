package main;

import inout.InOut;
import inout.InOutException;

public class Main {

	public static void main(String[] args) {
		try {
			String s = InOut.readString("Please enter a string:");
			InOut.printString("String was: " + s);
			
			double d = InOut.readDouble("Please enter a float number:");
			InOut.printString("Float number was: " + d);

			int i = InOut.readInt("Please enter an integer number:");
			InOut.printString("Integer number was: " + i);

			int j = InOut.readIntBetween("Please enter a number between 1 and 10:",1,10);
			InOut.printString("Integer number was: " + j);

			int x = InOut.readMenu("Please choose an entry:", 
					"Entry Bla@Entry Blo@Entry Blub@Entry Bluff@Entry Blaff");
			InOut.printString("You have choosen menu entry: " + x);

		} catch (InOutException e) {
			InOut.printString("Something went wrong with your input. Exiting.");
		}

	}

}
