package solver;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import main.Problem;
import main.Solution;
import main.SolverAbstract;
import problem.ProblemBackpack;
import solution.SolutionBackpack;

public class SolverBackpack extends SolverAbstract<SolutionBackpack,ProblemBackpack> {

	/** (values / weights) */
	@Setter @Getter protected ArrayList<Float> ratios;
	
	@Override
	public void evaluateSolutionToProblem(SolutionBackpack sol, ProblemBackpack prob) {
		Float backpackValue = 0f;
		for(Integer i : sol.getIncludedElements()){
			backpackValue += prob.getValues().get(i);
		}
		sol.setValue(backpackValue);
	}

	@Override
	public Solution<ProblemBackpack> solve(Problem<ProblemBackpack> p, main.SolverAbstract.SolvingMethod method) {
		// TODO Auto-generated method stub
		return null;
	}

}
