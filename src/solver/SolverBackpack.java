package solver;

import java.util.ArrayList;

import main.SolverAbstract;
import problem.ProblemBackpack;
import solution.SolutionBackpack;

public class SolverBackpack extends SolverAbstract<SolutionBackpack,ProblemBackpack> {

	public class DynamicProgrammingTable {
		protected int[][] m;
		
		public DynamicProgrammingTable(int N, int W){
			// We add one row and column to include the 
			m = new int[N+1][W+1];
		}
		
		public void set(int n, int w, int val){ m[n][w] = val; }
		public int get(int n, int w){ return m[n][w]; }
		
		@Override
		public String toString(){
			String str = "";
			for(int n = 0; n < m.length; n++){
				for(int w = 0; w < m[0].length; w++){
					str += (String.format("%3d ", dpTable.get(n, w)));
				}
				str += (String.format("%n"));
			}
			return str;
		}
	}
	
	/** (values / weights). Used in Branch and Bound. */
	private ArrayList<Float> ratios;
	/** Intermediate result table, used in Dynamic Programming. */
	private DynamicProgrammingTable dpTable;
	
	@Override
	public void evaluateSolutionToProblem(SolutionBackpack sol, ProblemBackpack prob) {
		Float backpackValue = 0f;
		for(Integer i : sol.getIncludedElements()){
			backpackValue += prob.getValues().get(i);
		}
		sol.setValue(backpackValue);
	}

	@Override
	public SolutionBackpack solve(ProblemBackpack p, SolvingMethod method) {
		if(method == SolvingMethod.DynamicProgramming) return solveByDynamicProgramming(p);
		if(method == SolvingMethod.BranchAndBound) return solveByBranchAndBound(p);
		else throw new IllegalArgumentException("Unsupported solving method");
	}
	
	private SolutionBackpack solveByDynamicProgramming(ProblemBackpack p){
		int N = p.getValues().size();
		int W = p.getBackpackWeight();
		/* Populate the table. */
		dpTable = new DynamicProgrammingTable(N, W);
		for(int n = 0; n <= N; n++){
			for(int w = 0; w <= W; w++){
				if(n == 0 || w == 0) 
					dpTable.set(n, w, 0);
				else
					// If the backpack is big enough to fit the new element...
					if(w >= p.getWeights().get(n-1))
					/*
					 * Max between previous sol for this weight (new element offers no improvement)
					 * or new solution with new element (including new element offers improvement).
					 */
					dpTable.set(n, w, Math.max(
							dpTable.get(n-1, w), 
							dpTable.get(n-1, w-p.getWeights().get(n-1)) + p.getValues().get(n-1)));
			}
		}
		
		System.out.println(dpTable);
		
		SolutionBackpack sol = new SolutionBackpack();
		/* Now, deduce the elements. */
		// Start at the rightmost bottom value.
		int n = N;
		int w = W;
		// End at the leftmost upper value (which should be a row and column of zeros).
		while(n > 0 && w > 0){
			// While the upper value stays the same, go up.
			if(n > 0) while(dpTable.get(n, w) == dpTable.get(n-1, w)) n--;
			// While the left value stays the same, go left.
			if(w > 0) while(dpTable.get(n, w) == dpTable.get(n, w-1)) w--;
			// We now have lower values up and to the left.
			// We "remove" the element from the backpack. It is in the solution.
			n--; w -= p.getWeights().get(n); sol.getIncludedElements().add(n);
		}
		return sol;
	}
	
	private SolutionBackpack solveByGreedy(ProblemBackpack p){
		int availableWeight = p.getBackpackWeight();
		int bestElem = -1;
		SolutionBackpack sol = new SolutionBackpack();
		do {
			bestElem = -1;	// dummy value meaning "no candidate yet".
			for (int i = 0; i < p.getValues().size(); i++){
				if (!sol.getIncludedElements().contains(bestElem)				// If not already in backpack,
						&& p.getValues().get(i) > p.getValues().get(bestElem) 	// and is better than current best
						&& p.getWeights().get(i) <= availableWeight){			// and can fit into backpack
					// Then add the element into the solution.
					sol.getIncludedElements().add(bestElem);
					availableWeight -= p.getWeights().get(bestElem);
				}
			}
		} while (bestElem != -1);	// Until no candidates are found (too full or no more items)
		return sol;
	}
	
	private SolutionBackpack solveByBranchAndBound(ProblemBackpack p){
		ArrayList<SolutionBackpack> sols = new ArrayList<>();
		// Get 
		SolutionBackpack bestCandidateSol = solveByGreedy(p);
		// Try
		sols.add(new SolutionBackpack());
		while(!sols.isEmpty()){
			branchOut(p, sols.get(0));
		}
	}
	
	private SolutionBackpack branchOut(ProblemBackpack p, SolutionBackpack s){
		for(int i = 0; i < p.getValues().size(); i++){
			if(){
				
			}
		}
	}
}
