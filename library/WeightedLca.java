package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;

final class WeightedLca {
	private final long id;
	private final LongBinaryOperator f;
	private final int numNode;
	private WeightedDoubling db;
	public final int depth[];

	// O(VlogV)
	public WeightedLca(final int numNode, final WeightedNode[] nodes, final int root, final long id, final LongBinaryOperator f) {
		SimpleUtil.nonNegativeCheck(numNode);
		SimpleUtil.rangeCheck(root, numNode);
		this.numNode = numNode;
		this.id = id;
		this.f = f;
		depth = new int[numNode];
		db = new WeightedDoubling(numNode, numNode, id, f, bfs(root, nodes));
	}
	public WeightedLca(final WeightedGraph g, final int root, final long id, final LongBinaryOperator f) {
		this(g.numNode, g.nodes(), root, id, f);
	}

	private final WeightedNode bfs(final int start, final WeightedNode[] nodes) { // O(V)
		ArrayWeightedNode edges = new ArrayWeightedNode(-1);
		int stack[] = new int[numNode];
		int ptr = 0;
		int size = 0;

		Arrays.fill(depth, -1);
		depth[start] = 0;
		depth[start] = 0;
		stack[size ++] = 0;
		while(ptr != size) {
			int crt = stack[ptr ++];
			for(WeightedEdge e : nodes[crt]) {
				if(depth[e.target] == -1) {
					depth[e.target] = depth[crt] + 1;
					edges.add(e.reverse());
					stack[size ++] = e.target;
				}
			}
		}
		return edges;
	}

	public final WeightedEdge cal(int u, int v) { // O(logV)
		SimpleUtil.rangeCheck(u, numNode);
		SimpleUtil.rangeCheck(v, numNode);
		if(depth[u] > depth[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		long cost = id;
		for(int k = 0; k < db.log; k ++) {
			if((depth[v] - depth[u] & 1 << k) != 0) {
				cost = f.applyAsLong(cost, db.val[k][v]);
				v = db.next[k][v];
			}
		}
		for(int k = db.log - 1; k >= 0; k --) {
			if(u != v && db.next[k][u] != db.next[k][v]) {
				cost = f.applyAsLong(cost, db.val[k][u]);
				u = db.next[k][u];
				cost = f.applyAsLong(cost, db.val[k][v]);
				v = db.next[k][v];
			}
		}
		if(u != v) {
			cost = f.applyAsLong(cost, db.val[0][u]);
			u = db.next[0][u];
			cost = f.applyAsLong(cost, db.val[0][v]);
			v = db.next[0][v];
		}
		return new WeightedEdge(-1, u, cost);
	}
}