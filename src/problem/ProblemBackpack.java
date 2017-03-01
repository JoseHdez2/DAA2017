package problem;

import main.Problem;

public class ProblemBackpack implements Problem {

	@Override
	public Type getType() {
		return Problem.Type.BackpackProblem;
	}

	@Override
	public ObjFuncType getObjFuncType() {
		return ObjFuncType.Maximize;
	}

}
