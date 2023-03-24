package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class WeightedBfs {
	// O(V)
	public static final long[] dist(final AbstractGraph<? extends WeightedNode, WeightedEdge> g, final int start) { return dist(g, start, null, null); }
	public static final long[] dist(final AbstractGraph<? extends WeightedNode, WeightedEdge> g, final int start, final int[] prv) { return dist(g, start, prv, null); }
	public static final long[] dist(final AbstractGraph<? extends WeightedNode, WeightedEdge> g, final int start, final int[] prv, final WeightedEdge[] prvEdge) { return dist(g.nodes(), start, prv, prvEdge); }
	public static final long[] dist(final WeightedNode[] nodes, final int start) { return dist(nodes, start, null, null); }
	public static final long[] dist(final WeightedNode[] nodes, final int start, final int[] prv) { return dist(nodes, start, prv, null); }
	public static final long[] dist(final WeightedNode[] nodes, final int start, final int[] prv, final WeightedEdge[] prvEdge) {
		int numNode = nodes.length;
		long dist[] = new long[numNode];
		Arrays.fill(dist, -1);
		boolean visited[] = new boolean[numNode];
		int dq[] = new int[numNode];
		int ptr = 0;
		int size = 0;
		if(prv != null) Arrays.fill(prv, -1);

		dq[size ++] = start;
		dist[start] = 0;
		visited[start] = true;
		while(ptr != size) {
			int crt = dq[ptr ++];
			for(WeightedEdge e : nodes[crt]) {
				if(!visited[e.target]) {
					dist[e.target] = dist[e.source] + e.cost;
					visited[e.target] = true;
					dq[size ++] = e.target;
					if(prv != null) prv[e.target] = e.source;
					if(prvEdge != null) prvEdge[e.target] = e;
				}
			}
		}
		return dist;
	}
}