package solution;

import java.util.ArrayList;

import lombok.Data;
import main.Solution;
import problem.ProblemBackpack;

@Data
public class SolutionBackpack extends Solution<ProblemBackpack>{
	
	public SolutionBackpack(){
		includedElements = new ArrayList<>();
	}
	
	/** Elements included in the backpack. */
	ArrayList<Integer> includedElements;
}
