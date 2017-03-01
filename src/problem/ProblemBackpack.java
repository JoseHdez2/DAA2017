package problem;

import java.util.ArrayList;

import lombok.Data;
import main.Problem;

/**
 *	Discrete backpack problem.
 */
@Data
public class ProblemBackpack implements Problem<ProblemBackpack> {
	
	protected ArrayList<Integer> values;
	protected ArrayList<Integer> weights;
	
	protected Integer backpackWeight;
	
	@Override
	public Type getType() {
		return Problem.Type.BackpackProblem;
	}

	@Override
	public ObjFuncType getObjFuncType() {
		return ObjFuncType.Maximize;
	}

}
