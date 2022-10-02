package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.PathRestoration;

final class WarshallFloyd {
	private static int prv[][];
	private static WeightedEdge prvEdge[][];
	// O(V^3)
	public static final long[][] dist(final WeightedGraph g) { return dist(g, false); }
	public static final long[][] dist(final WeightedGraph g, final boolean memoize) { return dist(g.numNode, g.directed, g.edges(), memoize); }
	public static final long[][] dist(final int numNode, final boolean directed, final WeightedNode edges) { return dist(numNode, directed, edges, false); }
	public static final long[][] dist(final int numNode, final boolean directed, final WeightedNode edges, final boolean memoize) {
		final long dist[][] = new long[numNode][numNode];
		if(memoize) {
			prv = new int[numNode][numNode];
			for(int[] ele : prv) Arrays.fill(ele, -1);
			prvEdge = new WeightedEdge[numNode][numNode];
		}

		for(long[] ele : dist) Arrays.fill(ele, SimpleUtil.INF);
		for(int i = 0; i < numNode; i ++) dist[i][i] = 0;
		for(WeightedEdge e : edges) updateDist(dist, e, memoize);
		if(!directed) for(WeightedEdge e : edges) updateDist(dist, e.reverse(), memoize);
		for(int k = 0; k < numNode; k ++) {
			for(int i = 0; i < numNode; i ++) {
				for(int j = 0; j < numNode; j ++) {
					long updated = dist[i][k] + dist[k][j];
					if(updated < dist[i][j]) dist[i][j] = updated;
					if(memoize) {
						prv[i][j] = prv[k][j];
						prvEdge[i][j] = prvEdge[k][j];
					}
				}
			}
		}
		return dist;
	}
	private static final void updateDist(final long[][] dist, final WeightedEdge e, final boolean memoize) {
		if(dist[e.source][e.target] > e.cost) {
			dist[e.source][e.target] = e.cost;
			if(memoize) {
				prv[e.source][e.target] = e.source;
				prvEdge[e.source][e.target] = e;
			}
		}
	}

	public static final int[] path(final int start, final int goal) { return PathRestoration.path(prv[start], start, goal); }
	public static final ArrayWeightedNode pathEdge(final int start, final int goal) { return PathRestoration.pathEdge(new ArrayWeightedNode(-1), prv[start], prvEdge[start], start, goal); }
}