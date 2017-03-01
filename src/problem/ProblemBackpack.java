package problem;

import java.util.ArrayList;

import lombok.Data;
import main.Problem;

@Data
public class ProblemBackpack implements Problem<ProblemBackpack> {
	
	protected ArrayList<Float> values;
	protected ArrayList<Float> weigths;
	
	@Override
	public Type getType() {
		return Problem.Type.BackpackProblem;
	}

	@Override
	public ObjFuncType getObjFuncType() {
		return ObjFuncType.Maximize;
	}

}
