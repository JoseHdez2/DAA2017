package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import main.SolverAbstract.SolvingMethod;
import problem.ProblemBackpack;
import solution.SolutionBackpack;
import solver.SolverBackpack;

public class TestBackpack {

	static ProblemBackpack prob;
	/** Solution to be expected of exhaustive algorithms (DP, B&B) */
	static SolutionBackpack optimalSol;
	
	@BeforeClass
	public static void setup(){
		prob = new ProblemBackpack();
		prob.setBackpackWeight(15);
		Integer[] values = {10, 10, 12, 18};
		Integer[] weights = {2, 4, 6, 9};
		prob.setValues(new ArrayList<Integer>(Arrays.asList(values)));
		prob.setWeights(new ArrayList<Integer>(Arrays.asList(weights)));
		
		Integer[] optSolution = {3, 1, 0};
		optimalSol = new SolutionBackpack();
		optimalSol.getIncludedElements().addAll(Arrays.asList(optSolution));
	}
	
	@Test
	public void solveByDynamicProgramming(){
		
		SolverBackpack solver = new SolverBackpack();
		SolutionBackpack sol = solver.solve(prob, SolvingMethod.DynamicProgramming);
		
		System.out.println("Solution:" + sol);
		Assert.assertEquals(optimalSol, sol);
	}
	
	@Test
	public void solveByGreedy(){
		
		SolverBackpack solver = new SolverBackpack();
		SolutionBackpack sol = solver.solve(prob, SolvingMethod.GreedyAlgorithm);
		
		Integer[] expSolution = {0, 1, 2};
		SolutionBackpack expectedSol = new SolutionBackpack();
		expectedSol.getIncludedElements().addAll(Arrays.asList(expSolution));
		
		System.out.println("Solution:" + sol);
		Assert.assertEquals(expectedSol, sol);
	}
	
	@Test
	public void solveByBranchAndBound(){
		
		SolverBackpack solver = new SolverBackpack();
		SolutionBackpack sol = solver.solve(prob, SolvingMethod.BranchAndBound);
		
		System.out.println("Solution:" + sol);
		Assert.assertEquals(optimalSol, sol);
	}
}
