package main;

public abstract class Main {

	/** The main interface should go in stages that prepare the program launch. */
	enum Stage {
		/** Setup problem type and problem parameters. */
		ProblemSetup,
		/** Setup solving method and solving parameters. */
		SolverSetup,
		/** Setup batch test parameters. */
		BatchTestSetup,
	}
	
	/** The problem type that the user will choose to work with. */
	public static Problem.Type menuProblemType = Problem.Type.MaximumDiversity;
	public static SolverAbstract.SolvingMethod menuSolvingMethodType;
	
	protected Main(){
		// Set menu problem since the rest of the program depends on it.
		menuProblemType = promptMenuProblem();
		System.out.println(String.format("Chose %s as problem type.", menuProblemType));
		menuSolvingMethodType = promptMenuSolvingMethod();
		System.out.println(String.format("Chose %s as solving method.", menuSolvingMethodType));
	}
	
	/** Prompt the user one way or another to choose the type of problem to work with.*/
	protected abstract Problem.Type promptMenuProblem();
	
	/** Prompt the user one way or another to choose the problem-solving method to use.*/
	protected abstract SolverAbstract.SolvingMethod promptMenuSolvingMethod();
}
