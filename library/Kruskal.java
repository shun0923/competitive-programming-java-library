package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.UnionFind;

class Kruskal {
	private static UnionFind uf;
	private static ArrayWeightedNode used = new ArrayWeightedNode(-1);
	// O(ElogV)
	public static final long cal(WeightedGraph g) { return cal(g.numNode, g.edges()); }
	public static final long cal(int numNode, WeightedNode edges) {
		uf = new UnionFind(numNode);
		used.clear();
		Queue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>();
		for(WeightedEdge e : edges) if(!SimpleUtil.isINF(e.cost)) pq.add(e);

		long cost = 0;
		while(!pq.isEmpty()) {
			WeightedEdge e = pq.poll();
			if(!uf.same(e.source, e.target)) {
				cost += e.cost;
				uf.unite(e);
				used.add(e);
			}
		}
		return cost;
	}
}