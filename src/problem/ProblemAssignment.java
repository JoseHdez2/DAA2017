package problem;

import main.Problem;

public class ProblemAssignment implements Problem<ProblemAssignment>{

	@Override
	public main.Problem.Type getType() {
		return Problem.Type.AssignmentProblem;
	}

	@Override
	public main.Problem.ObjFuncType getObjFuncType() {
		return null;
	}

}
