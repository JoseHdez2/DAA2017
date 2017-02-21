package main;

/**
 *	Given a {@link Problem}, tries to create an optimal {@link Solution}.
 * @param <T> Type of the Problem.
 */
public abstract class SolverAbstract<T> {

	/**
	 *	Types of objective functions.
	 */
	public enum ObjFuncType {
		Maximize,
		Minimize,
//		NoObjectiveFunction	// TODO maybe this for the case of RAM machines...
	}
	
	/** Force all Solvers to have an intent towards the objective function. */
	abstract ObjFuncType getObjectiveFunctionType();
	
	/** */
	abstract Double evaluateSolutionToProblem(Solution<T> sol, Problem<T> prob);
}
