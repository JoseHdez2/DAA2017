package main;

import lombok.Data;

/**
 *	Data object. Models a solution (which may be in progress) and its characteristics.
 */
@Data
public abstract class Solution<P> {
	
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
	
	public int compareTo(Solution<P> s){
		if(value < s.getValue()) return -1;
		if(value > s.getValue()) return 1;
		else return 0;
	}
}
