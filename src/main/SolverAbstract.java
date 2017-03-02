package main;

/**
 *	Given a {@link Problem}, tries to create an optimal {@link Solution}.
 * @param <P> Type of the Problem.
 */
public abstract class SolverAbstract<S,P> {
	
	public enum SolvingMethod{
		BranchAndBound,
		BruteForce,
		DynamicProgramming,
		GRASP,
		GreedyAlgorithm,
		VNS,
	}
	
	/** Assess the validity and optimality of a solution for a certain problem. */
	public abstract void evaluateSolutionToProblem(S sol, P prob);
	
	public abstract void evaluateHeuristicToProblem(S sol, P prob);
	
	public abstract S solve(P p, SolvingMethod method);
}
