package main;

/**
 *	Given a {@link Problem}, tries to create an optimal {@link Solution}.
 * @param <P> Type of the Problem.
 */
public abstract class SolverAbstract<S,P> {
	
	public enum SolvingMethod{
		BruteForce,
	}
	
	/** Assess the validity and optimality of a solution for a certain problem. */
	public abstract void evaluateSolutionToProblem(S sol, P prob);
	
	public abstract Solution<P> solve(Problem<P> p, SolvingMethod method);
}
