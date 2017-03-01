package main;

/**
 *	Data object. Models a problem and its requirements.
 */
public interface Problem<T> {

	/**
	 *	Types of problems this program can handle.
	 */
	public enum Type {
		AssignmentProblem,
		BackpackProblem,
		MaximumMeanDispersion,
		MaximumDiversity,
		TravelingSalesmanProblem
	}
	
	/**
	 *	Types of objective functions.
	 */
	public enum ObjFuncType {
		Maximize,
		Minimize,
//		NoObjectiveFunction	// TODO maybe this for the case of RAM machines...
	}
	
	/** Force every Problem to be of a type. */
	abstract Type getType();
	
	/** Force every Problem to tell you what they want to do. */
	abstract ObjFuncType getObjFuncType();
}
