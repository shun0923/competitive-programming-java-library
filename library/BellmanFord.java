package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.RestorePath;

final class BellmanFord {
	private static int prv[];
	private static WeightedEdge prvEdge[];

	// O(VE)
	public static final long[] dist(WeightedGraph g, int start) { return dist(g, start, false); }
	public static final long[] dist(WeightedGraph g, int start, boolean memoize) { return dist(g.numNode, g.edges(), start, memoize); }
	public static final long[] dist(int numNode, WeightedNode edges, int start) { return dist(numNode, edges, start, false); }
	public static final long[] dist(int numNode, WeightedNode edges, int start, boolean memoize) {
		SimpleUtil.rangeCheck(start, numNode);
		long dist[] = new long[numNode];
		prv = new int[numNode];
		prvEdge = new WeightedEdge[numNode];

		Arrays.fill(dist, SimpleUtil.INF);
		dist[start] = 0;
		for(int i = 0; i < numNode - 1; i ++) {
			for(WeightedEdge e : edges) {
				long updated = dist[e.source] + e.cost;
				if(!SimpleUtil.isPlusINF(dist[e.source]) && dist[e.target] > updated) {
					dist[e.target] = updated;
					prv[e.target] = e.source;
					prvEdge[e.target] = e;
				}
			}
		}
		for(int i = 0; i < numNode; i ++) {
			for(WeightedEdge e : edges) {
				if(!SimpleUtil.isPlusINF(dist[e.source]) && dist[e.target] > dist[e.source] + e.cost) {
					dist[e.target] = - SimpleUtil.INF;
				}
			}
		}
		return dist;
	}

	public static final int[] path(final int start, final int goal) { return RestorePath.path(prv, start, goal); }
	public static final WeightedEdge[] pathEdge(final int start, final int goal) { return RestorePath.pathEdge(prv, prvEdge, start, goal); }
}