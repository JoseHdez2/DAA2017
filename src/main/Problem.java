package main;

public interface Problem<T> {

	/**
	 *	Types of problems this program can handle.
	 */
	public enum Type {
		MaximumMeanDispersion,
		MaximumDiversity
	}
}
