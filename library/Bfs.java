package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.PathRestoration;

final class Bfs {
	private static int prv[];
	private static UnweightedEdge prvEdge[];

	// O(V)
	public static final int[] dist(UnweightedGraph g, int start) { return dist(g, start, false); }
	public static final int[] dist(UnweightedGraph g, int start, boolean memoize) { return dist(g.nodes(), start, memoize); }
	public static final int[] dist(UnweightedNode[] nodes, int start) { return dist(nodes, start, false); }
	public static final int[] dist(UnweightedNode[] nodes, int start, boolean memoize) {
		int numNode = nodes.length;
		int dist[] = new int[numNode];
		boolean visited[] = new boolean[numNode];
		int dq[] = new int[numNode];
		int ptr = 0;
		int size = 0;
		if(memoize) {
			prv = new int[numNode];
			Arrays.fill(prv, -1);
			prvEdge = new UnweightedEdge[numNode];
		}

		dq[size ++] = start;
		dist[start] = 0;
		while(ptr != size) {
			int crt = dq[ptr ++];
			for(UnweightedEdge e : nodes[crt]) {
				if(!visited[e.target]) {
					dist[e.target] = dist[e.source] + 1;
					visited[e.target] = true;
					dq[size ++] = e.target;
					if(memoize) {
						prv[e.target] = e.source;
						prvEdge[e.target] = e;
					}
				}
			}
		}
		return dist;
	}
	public static final int[] path(final int start, final int goal) { return PathRestoration.path(prv, start, goal); }
	public static final ArrayUnweightedNode pathEdge(final int start, final int goal) { return PathRestoration.pathEdge(new ArrayUnweightedNode(-1), prv, prvEdge, start, goal); }
}