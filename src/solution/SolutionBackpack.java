package solution;

import java.util.ArrayList;

import lombok.Data;
import main.Solution;
import problem.ProblemBackpack;

@Data
public class SolutionBackpack extends Solution<ProblemBackpack>{
	
	/** Elements included in the backpack. */
	ArrayList<Integer> includedElements;
	
	public SolutionBackpack(){
		super();
		includedElements = new ArrayList<>();
	}
	
	public SolutionBackpack clone(){
		SolutionBackpack clone = new SolutionBackpack();
		clone.getIncludedElements().addAll(this.includedElements);
		return clone;
	}
	
//	public int compareTo(SolutionBackpack s){
//		return super.compareTo(s);
//	}
}
