package main;

import lombok.Getter;
import lombok.Setter;

public class Tester {
	/** Millisecond precision timer. */
	private static class Timer {
		enum Status {
			Blank,
			Ongoing,
			Stopped,
		}
		Status status = Status.Blank;
		private Long started;
		private Long stopped;
		@Getter @Setter Long timeElapsed;
		
		public void start(){
			if(status != Status.Blank) return;
			started = System.currentTimeMillis();
		}
		
		public void stop(){
			if(status != Status.Ongoing) return;
			stopped = System.currentTimeMillis();
			setTimeElapsed(stopped - started);
		}
		
		public void reset(){
			if(status != Status.Stopped) return;
			status = Status.Blank;
		}
	}
	
	Timer timer = new Timer();
	Long solveTime = 0l;
	
	Problem prob;
	Solution sol;
	SolverAbstract<Solution,Problem> solver;
	SolverAbstract.SolvingMethod solvingMethod;
	
	public void solve(){
		timer.start();
		solver.solve(prob, solvingMethod);
		timer.stop();
		solveTime = timer.getTimeElapsed();
	}
}
