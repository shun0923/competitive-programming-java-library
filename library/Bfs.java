package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;
import library.PathRestoration;

final class Bfs {
	// O(V)
	public static final <Graph extends AbstractGraph<Node, Edge>, Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>> int[] dist(Graph g, int start) { return dist(g, start, null, null); }
	public static final <Graph extends AbstractGraph<Node, Edge>, Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>> int[] dist(Graph g, int start, int[] prv, Edge[] prvEdge) { return dist(g.nodes(), start, prv, prvEdge); }
	public static final <Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>>int[] dist(Node[] nodes, int start) { return dist(nodes, start, null, null); }
	public static final <Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>> int[] dist(Node[] nodes, int start, int[] prv, Edge[] prvEdge) {
		int numNode = nodes.length;
		int dist[] = new int[numNode];
		Arrays.fill(dist, -1);
		boolean visited[] = new boolean[numNode];
		int dq[] = new int[numNode];
		int ptr = 0;
		int size = 0;
		boolean memoize = prv != null;
		if(memoize) Arrays.fill(prv, -1);

		dq[size ++] = start;
		dist[start] = 0;
		visited[start] = true;
		while(ptr != size) {
			int crt = dq[ptr ++];
			for(Edge e : nodes[crt]) {
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
}