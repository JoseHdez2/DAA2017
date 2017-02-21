package main;

public abstract class Main {

	/** The problem type that the user will choose to work with. */
	public static Problem.Type menuProblem = Problem.Type.MaximumDiversity;
	
	protected Main(){
		// Set menu problem since the rest of the program depends on it.
		menuProblem = setMenuProblem();
	}
	
	/** Prompt the user one way or another to choose the type of problem to work with.*/
	protected abstract Problem.Type setMenuProblem();
}
