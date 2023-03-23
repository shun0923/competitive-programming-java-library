package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class WarshallFloyd {
	// O(V^3)
	public static final <Graph extends AbstractGraph<? extends WeightedNode, WeightedEdge>> long[][] dist(final Graph g) { return dist(g, null, null); }
	public static final <Graph extends AbstractGraph<? extends WeightedNode, WeightedEdge>> long[][] dist(final Graph g, final int[][] prv) { return dist(g, prv, null); }
	public static final <Graph extends AbstractGraph<? extends WeightedNode, WeightedEdge>> long[][] dist(final Graph g, final int[][] prv, final WeightedEdge[][] prvEdge) { return dist(g.numNode, g.directed, g.edges(), prv, prvEdge); }
	public static final long[][] dist(final int numNode, final boolean directed, final WeightedNode edges) { return dist(numNode, directed, edges, null, null); }
	public static final long[][] dist(final int numNode, final boolean directed, final WeightedNode edges, final int[][] prv) { return dist(numNode, directed, edges, prv, null); }
	public static final long[][] dist(final int numNode, final boolean directed, final WeightedNode edges, final int[][] prv, final WeightedEdge[][] prvEdge) {
		final long dist[][] = new long[numNode][numNode];
		if(prv != null) for(int[] ele : prv) Arrays.fill(ele, -1);

		for(long[] ele : dist) Arrays.fill(ele, FastIO.INF);
		for(int i = 0; i < numNode; i ++) dist[i][i] = 0;
		for(WeightedEdge e : edges) updateDist(dist, e, prv, prvEdge);
		if(!directed) for(WeightedEdge e : edges) updateDist(dist, e.reverse(), prv, prvEdge);
		for(int k = 0; k < numNode; k ++) {
			for(int i = 0; i < numNode; i ++) {
				for(int j = 0; j < numNode; j ++) {
					long updated = dist[i][k] + dist[k][j];
					if(updated < dist[i][j]) dist[i][j] = updated;
					if(prv != null) prv[i][j] = prv[k][j];
					if(prvEdge != null) prvEdge[i][j] = prvEdge[k][j];
				}
			}
		}
		return dist;
	}
	private static final void updateDist(final long[][] dist, final WeightedEdge e, final int[][] prv, final WeightedEdge[][] prvEdge) {
		if(dist[e.source][e.target] > e.cost) {
			dist[e.source][e.target] = e.cost;
			if(prv != null) prv[e.source][e.target] = e.source;
			if(prvEdge != null) prvEdge[e.source][e.target] = e;
		}
	}
}