package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class Lca {
	private final int numNode;
	private Doubling db;
	public final int depth[];

	// O(VlogV)
	public <Edge extends AbstractEdge<Edge>> Lca(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g, final int root) { this(g.numNode, g.nodes(), root); }
	public <Edge extends AbstractEdge<Edge>> Lca(final int numNode, final AbstractNode<Edge>[] nodes, final int root) {
		FastIO.nonNegativeCheck(numNode);
		FastIO.rangeCheck(root, numNode);
		this.numNode = numNode;
		depth = new int[numNode];
		db = new Doubling(numNode, numNode, bfs(root, nodes));
	}

	private final <Edge extends AbstractEdge<Edge>> int[] bfs(final int start, final AbstractNode<Edge>[] nodes) { // O(V)
		int edges[] = new int[numNode];
		int stack[] = new int[numNode];
		int ptr = 0;
		int size = 0;

		Arrays.fill(depth, -1);
		depth[start] = 0;
		edges[start] = -1;
		depth[start] = 0;
		stack[size ++] = 0;
		while(ptr != size) {
			int crt = stack[ptr ++];
			for(Edge e : nodes[crt]) {
				if(depth[e.target] == -1) {
					depth[e.target] = depth[crt] + 1;
					edges[e.target] = crt;
					stack[size ++] = e.target;
				}
			}
		}
		return edges;
	}

	public final int cal(int u, int v) { // O(logV)
		FastIO.rangeCheck(u, numNode);
		FastIO.rangeCheck(v, numNode);
		if(depth[u] > depth[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		for(int k = 0; k < db.log; k ++) {
			if((depth[v] - depth[u] & 1 << k) != 0) v = db.next[k][v];
		}
		for(int k = db.log - 1; k >= 0; k --) {
			if(u != v && db.next[k][u] != db.next[k][v]) {
				u = db.next[k][u];
				v = db.next[k][v];
			}
		}
		if(u != v) {
			u = db.next[0][u];
			v = db.next[0][v];
		}
		return u;
	}
}