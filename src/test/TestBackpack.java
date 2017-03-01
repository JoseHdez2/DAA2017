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
	static SolutionBackpack expectedSol;
	
	@BeforeClass
	public static void setup(){
		prob = new ProblemBackpack();
		prob.setBackpackWeight(15);
		Integer[] values = {10, 10, 12, 18};
		Integer[] weights = {2, 4, 6, 9};
		prob.setValues(new ArrayList<Integer>(Arrays.asList(values)));
		prob.setWeigths(new ArrayList<Integer>(Arrays.asList(weights)));
		
		Integer[] optimalSolution = {3, 1, 0};
		expectedSol = new SolutionBackpack();
		expectedSol.getIncludedElements().addAll(Arrays.asList(optimalSolution));
	}
	
	@Test
	public void theTest(){
		
		SolverBackpack solver = new SolverBackpack();
		SolutionBackpack sol = solver.solve(prob, SolvingMethod.DynamicProgramming);
		
		System.out.println("Solution:" + sol);
		Assert.assertEquals(sol, expectedSol);
	}
}
