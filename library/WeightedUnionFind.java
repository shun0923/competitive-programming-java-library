package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

class WeightedUnionFind { // N=numNode
	public final int n;
	private final int nodes[]; // non neg: parent idx, neg: - size
	private final long weight[];
	public int numGroups;

	public WeightedUnionFind(final int n) { // O(N)
		FastIO.nonNegativeCheck(n);
		this.n = n;
		nodes = new int[n];
		weight = new long[n];
		numGroups = n;
		Arrays.fill(nodes, -1);
	}

	public final void uniteAll(final Collection<WeightedEdge> edges) { for(WeightedEdge e : edges) unite(e); } // O(a(N)M)
	public final void uniteAll(final WeightedEdge[] edges) { for(WeightedEdge e : edges) unite(e); } // O(a(N)M)
	public final boolean unite(final WeightedEdge e) { return unite(e.source, e.target, e.cost); }
	public final boolean unite(final int x, final int y, long w) { // O(a(N))
		FastIO.rangeCheck(x, n);
		FastIO.rangeCheck(y, n);
		int xRoot = root(x);
		int yRoot = root(y);
		if(xRoot == yRoot) return diff(x, y) == w;
		numGroups --;
		w += weight(x) - weight(y);
		if(nodes[yRoot] < nodes[xRoot]) {
			nodes[yRoot] += nodes[xRoot];
			nodes[xRoot] = yRoot;
			weight[xRoot] = - w;
		}else {
			nodes[xRoot] += nodes[yRoot];
			nodes[yRoot] = xRoot;
			weight[yRoot] = w;
		}
		return false;
	}

	public final int size(final int i) { FastIO.rangeCheck(i, n); return - nodes[root(i)]; } // O(a(N))

	public final long weight(final int i) { FastIO.rangeCheck(i, n); root(i); return weight[i]; } // O(a(N))

	public final long diff(final int x, final int y) { FastIO.rangeCheck(x, n); FastIO.rangeCheck(y, n); return same(x, y) ? weight(y) - weight(x) : FastIO.INF; } // O(a(N))

	public final int root(final int i) { // O(a(N))
		FastIO.rangeCheck(i, n);
		if(nodes[i] < 0) return i;
		int root = root(nodes[i]);
		weight[i] += weight[nodes[i]];
		nodes[i] = root;
		return root;
	}

	public final boolean same(final int x, final int y) { FastIO.rangeCheck(x, n); FastIO.rangeCheck(y, n); return root(x) == root(y); } // O(a(N))

	public final HashMap<Integer, HashSet<Integer>> groups() { // O(N)
		HashMap<Integer, HashSet<Integer>> groups = new HashMap<>();
		for(int i = 0; i < n; i ++) {
			int root = root(i);
			groups.putIfAbsent(root, new HashSet<>());
			groups.get(root).add(i);
		}
		return groups;
	}
}