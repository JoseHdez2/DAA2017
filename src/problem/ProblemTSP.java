package problem;

import main.Problem;

public class ProblemTSP implements Problem<ProblemTSP> {

	@Override
	public ObjFuncType getObjFuncType() {
		return ObjFuncType.Minimize;
	}
	
	@Override
	public Type getType() {
		return Problem.Type.TravelingSalesmanProblem;
	}
}
