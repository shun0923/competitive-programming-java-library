package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;


final class BellmanFord {
	// O(VE)
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] dist(final Graph g, final int start) { return dist(g, start, null, null); }
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] dist(final Graph g, final int start, final int[] prv) { return dist(g, start, prv, null); }
	public static final <Graph extends AbstractGraph<Node, WeightedEdge>, Node extends WeightedNode> long[] dist(final Graph g, final int start, final int[] prv, final WeightedEdge[] prvEdge) { return dist(g.numNode, g.edges(), start, prv, prvEdge); }
	public static final long[] dist(final int numNode, final WeightedNode edges, final int start) { return dist(numNode, edges, start, null, null); }
	public static final long[] dist(final int numNode, final WeightedNode edges, final int start, final int[] prv) { return dist(numNode, edges, start, prv, null); }
	public static final long[] dist(final int numNode, final WeightedNode edges, final int start, final int[] prv, final WeightedEdge[] prvEdge) {
		FastIO.rangeCheck(start, numNode);
		long dist[] = new long[numNode];
		if(prv != null) Arrays.fill(prv, -1);

		Arrays.fill(dist, FastIO.INF);
		dist[start] = 0;
		for(int i = 0; i < numNode - 1; i ++) {
			for(WeightedEdge e : edges) {
				long updated = dist[e.source] + e.cost;
				if(!FastIO.isPlusINF(dist[e.source]) && dist[e.target] > updated) {
					dist[e.target] = updated;
					if(prv != null) prv[e.target] = e.source;
					if(prvEdge != null) prvEdge[e.target] = e;
				}
			}
		}
		for(int i = 0; i < numNode; i ++) {
			for(WeightedEdge e : edges) {
				if(!FastIO.isPlusINF(dist[e.source]) && dist[e.target] > dist[e.source] + e.cost) {
					dist[e.target] = - FastIO.INF;
				}
			}
		}
		return dist;
	}
}