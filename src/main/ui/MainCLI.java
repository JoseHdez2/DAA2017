package main.ui;

import main.Main;
import main.Problem;
import main.Problem.Type;

/**
 *	Command-Line Interface version of the program.
 */
public class MainCLI extends Main {

	public static void main(String[] args) {
		Main main = new MainCLI();
		System.out.println(Problem.Type.MaximumMeanDispersion.toString());
	}
	
	@Override
	protected Type promptMenuProblem() {
		System.out.println("Choose problem type:");
		return null;
	}
}
