package main;

/**
 *	Given a {@link Problem}, tries to create an optimal {@link Solution}.
 * @param <T> Type of the Problem.
 */
public abstract class SolverAbstract<T> {
	
	/** Assess the validity and optimality of a solution for a certain problem. */
	public abstract void evaluateSolutionToProblem(Solution<T> sol, T prob);
}
