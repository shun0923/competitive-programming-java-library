package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class TopologicalSort {
	// O(E+V)
	public static final <Graph extends AbstractGraph<? extends AbstractNode<Edge>, Edge>, Edge extends AbstractEdge<Edge>> int[] sort(Graph g) { return sort(g.nodes(), g.edges()); }
	public static final <Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>> int[] sort(Node[] nodes, Node edges) {
		int numNode = nodes.length;
		int dq[] = new int[numNode];
		int ptr = 0;
		int size = 0;
		int deg[] = new int[numNode];
		Arrays.fill(deg, 0);
		for(Edge e : edges) deg[e.target] ++;
		for(int i = 0; i < numNode; i ++) if(deg[i] == 0) dq[size ++] = i;
		int ans[] = new int[numNode];
		int idx = 0;
		while(ptr != size) {
			int crt = dq[ptr ++];
			ans[idx ++] = crt;
			for(Edge e : nodes[crt]) if(-- deg[e.target] == 0) dq[size ++] = e.target;
		}
		return idx == numNode ? ans : null;
	}
}