package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;
import library.UnionFind;

class Kruskal {
	private static UnionFind uf;
	// O(ElogV)
	public static final long cal(AbstractGraph<? extends WeightedNode, WeightedEdge> g) { return cal(g, null); }
	public static final long cal(AbstractGraph<? extends WeightedNode, WeightedEdge> g, WeightedNode used) { return cal(g.numNode, g.edges(), used); }
	public static final long cal(int numNode, WeightedNode edges) { return cal(numNode, edges, null); }
	public static final long cal(int numNode, WeightedNode edges, WeightedNode used) {
		uf = new UnionFind(numNode);
		if(used != null) used.clear();
		Queue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>();
		for(WeightedEdge e : edges) if(!FastIO.isINF(e.cost)) pq.add(e);

		long cost = 0;
		while(!pq.isEmpty()) {
			WeightedEdge e = pq.poll();
			if(!uf.same(e.source, e.target)) {
				cost += e.cost;
				uf.unite(e);
				if(used != null) used.add(e);
			}
		}
		return cost;
	}
}