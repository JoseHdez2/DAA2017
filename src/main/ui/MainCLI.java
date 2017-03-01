package main.ui;

import java.util.Scanner;

import main.Main;
import main.Problem;
import main.Problem.Type;
import main.SolverAbstract;
import main.SolverAbstract.SolvingMethod;

/**
 *	Command-Line Interface version of the program.
 */
public class MainCLI extends Main {

	/** For asking questions. */
	protected static Scanner scanner;
	/** Temporal value used for multi-answer prompts. */
	protected static Integer choice;	
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		Main main = new MainCLI();
	}
	
	protected String ask(String question){
		System.out.print(question);
	    String answer = scanner.next();
	    return answer;
	}
	
	@Override
	protected Type promptMenuProblem() {
		for (int i = 0; i < Problem.Type.values().length; i++){
			System.out.println(String.format("%d) %s", i, Problem.Type.values()[i]));
		}
		choice = Integer.valueOf(ask("Choose problem type: "));
		return Problem.Type.values()[choice];
	}

	@Override
	protected SolvingMethod promptMenuSolvingMethod() {
		for (int i = 0; i < SolverAbstract.SolvingMethod.values().length; i++){
			System.out.println(String.format("%d) %s", i, SolverAbstract.SolvingMethod.values()[i]));
		}
		choice = Integer.valueOf(ask("Choose solving method: "));
		return SolverAbstract.SolvingMethod.values()[choice];
	}
}
