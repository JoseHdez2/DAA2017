package main;

import lombok.Data;

/**
 *	Data object. Models a solution (which may be in progress) and its characteristics.
 */
@Data
public abstract class Solution<P> implements Comparable<Solution<P>>{
	
	/**
	 * State of a solution.
	 */
	public enum State {
		InProgress,	// Half-built; it does not meet the problem's criteria for now.
		Failed,		// This "solution" fails to meet the problem's criteria.
		Complete	// Meets the problem's criteria, though it may not be optimal.
	}
	
	protected State state;
	protected float value;
	/** Added heuristic value. */
	protected float heuristic = 0f;
	
	/** "f value": Total value for heuristic comparison. Probably wrong name. */
	public float fValue(){
		return value + heuristic;
	}
	
	public int compareTo(Solution<P> s){
		if(value < s.fValue()) return -1;
		if(value > s.fValue()) return 1;
		else return 0;
	}
}
