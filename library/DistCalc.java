package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;

abstract class DistCalc<Edge extends AbstractEdge<Edge>> { // V=numNode, E=numEdge
	protected static final class Dist implements Comparable<Dist> {
		public int target;
		public long cost;
		public Dist(final int target, final long cost) { this.target = target; this.cost = cost; }
		@Override public final String toString() { return " - "+cost+" -> "+target; }
		@Override public final int hashCode() { return Long.hashCode(target); }
		@Override
		public final boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			Dist that = (Dist) obj;
			if(this.target != that.target) return false;
			if(this.cost != that.cost) return false;
			return true;
		}
		@Override
		public final int compareTo(final Dist that) {
			int c = Long.compare(this.cost, that.cost);
			if(c == 0) c = Integer.compare(this.target, that.target);
			return c;
		}
	}

	protected int prv[];
	protected int pass[];

	public final int[] pass(final int start, int goal) { // O(V)
		SimpleUtil.rangeCheck(start, prv.length);
		SimpleUtil.rangeCheck(goal, prv.length);
		final Deque<Integer> passList = new ArrayDeque<>();
		passList.addLast(goal);
		while(goal != start) passList.addLast(goal = prv[goal]);
		pass = new int[passList.size()];
		for(int i = 0; i < pass.length; i ++) pass[i] = passList.removeLast();
		return pass;
	}
	public abstract Edge[] passEdge(final int start, final int goal);
}
abstract class WeightedDistCalc extends DistCalc<WeightedEdge> {
	protected WeightedGraph g;
	protected long dist[];
	protected WeightedEdge prvEdge[];
	protected WeightedEdge passEdge[];

	public WeightedDistCalc(WeightedGraph g) { this.g = g; };

	public abstract long[] dist(int start);

	public final WeightedEdge[] passEdge(final int start, final int goal) {
		pass(start, goal);
		passEdge = new WeightedEdge[pass.length - 1];
		for(int i = 1; i < pass.length; i ++) passEdge[i - 1] = prvEdge[pass[i]];
		return passEdge;
	}
}