package problem;

import java.util.ArrayList;

import lombok.Data;
import lombok.NonNull;
import main.Problem;

/**
 *	Discrete backpack problem.
 */
@Data
public class ProblemBackpack implements Problem<ProblemBackpack> {
	
	@NonNull protected ArrayList<Integer> values;
	@NonNull protected ArrayList<Integer> weights;
	
	@NonNull protected Integer backpackWeight;
	
	@Override
	public Type getType() {
		return Problem.Type.BackpackProblem;
	}

	@Override
	public ObjFuncType getObjFuncType() {
		return ObjFuncType.Maximize;
	}

}
