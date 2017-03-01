package main.ui;

import java.util.Scanner;

import main.Main;
import main.Problem;
import main.Problem.Type;

/**
 *	Command-Line Interface version of the program.
 */
public class MainCLI extends Main {

	public static void main(String[] args) {
		Main main = new MainCLI();
	}
	
	@Override
	protected Type promptMenuProblem() {
		for (int i = 0; i < Problem.Type.values().length; i++){
			System.out.println(String.format("%d) %s", i, Problem.Type.values()[i]));
		}
		System.out.print("Choose problem type: ");
//		String strInt = System.console().readLine();
		Scanner scanner = new Scanner(System.in);
	    String answer = scanner.next();
		Integer i = Integer.valueOf(answer);
		menuProblem = Problem.Type.values()[i];
		System.out.println(String.format("Chose %s as problem.", menuProblem));
		return null;
	}
}
