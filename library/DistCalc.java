package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;

interface DistCalc<Edge extends AbstractEdge<Edge>> {  } // V=numNode, E=numEdge
abstract class RestorableDistCalc<Edge extends AbstractEdge<Edge>> implements DistCalc<Edge> {
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
abstract class WeightedDistCalc implements DistCalc<WeightedEdge> {
	protected WeightedGraph g;
	public WeightedDistCalc(WeightedGraph g) { this.g = g; };
}
abstract class WeightedRestorableDistCalc extends RestorableDistCalc<WeightedEdge> {
	protected WeightedGraph g;
	protected WeightedEdge prvEdge[];
	protected WeightedEdge passEdge[];

	public WeightedRestorableDistCalc(WeightedGraph g) { this.g = g; };

	public final WeightedEdge[] passEdge(final int start, final int goal) {
		pass(start, goal);
		passEdge = new WeightedEdge[pass.length - 1];
		for(int i = 1; i < pass.length; i ++) passEdge[i - 1] = prvEdge[pass[i]];
		return passEdge;
	}
}