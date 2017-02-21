package main;

/**
 *	Data object. Models a solution (which may be in progress) and its characteristics.
 */
public interface Solution<T> {

	/**
	 * State of a solution.
	 */
	public enum State {
		InProgress,	// Half-built; it does not meet the problem's criteria for now.
		Failed,		// This "solution" fails to meet the problem's criteria.
		Complete	// Meets the problem's criteria, though it may not be optimal.
	}
}
