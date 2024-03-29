package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class Bfs {
	// O(V)
	public static final <Edge extends AbstractEdge<Edge>> int[] dist(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g, final int start) { return dist(g, start, null, null); }
	public static final <Edge extends AbstractEdge<Edge>> int[] dist(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g, final int start, final int[] prv) { return dist(g, start, prv, null); }
	public static final <Edge extends AbstractEdge<Edge>> int[] dist(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g, final int start, final int[] prv, final Edge[] prvEdge) { return dist(g.nodes(), start, prv, prvEdge); }
	public static final <Edge extends AbstractEdge<Edge>> int[] dist(final AbstractNode<Edge>[] nodes, final int start) { return dist(nodes, start, null, null); }
	public static final <Edge extends AbstractEdge<Edge>> int[] dist(final AbstractNode<Edge>[] nodes, final int start, final int[] prv) { return dist(nodes, start, prv, null); }
	public static final <Edge extends AbstractEdge<Edge>> int[] dist(final AbstractNode<Edge>[] nodes, final int start, final int[] prv, final Edge[] prvEdge) {
		int numNode = nodes.length;
		int dist[] = new int[numNode];
		Arrays.fill(dist, -1);
		boolean visited[] = new boolean[numNode];
		int dq[] = new int[numNode];
		int ptr = 0;
		int size = 0;
		if(prv != null) Arrays.fill(prv, -1);

		dist[start] = 0;
		visited[start] = true;
		dq[size ++] = start;
		while(ptr != size) {
			int crt = dq[ptr ++];
			for(Edge e : nodes[crt]) {
				if(!visited[e.target]) {
					dist[e.target] = dist[e.source] + 1;
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