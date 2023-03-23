package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

class UnionFind { // N=numNode
	public final int n;
	private final int nodes[]; // non neg: parent idx, neg: - size
	public int numGroups;

	public UnionFind(final int n) { // O(N)
		FastIO.nonNegativeCheck(n);
		this.n = n;
		nodes = new int[n];
		numGroups = n;
		Arrays.fill(nodes, -1);
	}

	public final void uniteAll(final AbstractNode<? extends AbstractEdge> edges) { for(AbstractEdge e : edges) unite(e); } // O(a(N)M)
	public final void uniteAll(final AbstractEdge[] edges) { for(AbstractEdge e : edges) unite(e); } // O(a(N)M)
	public final boolean unite(final AbstractEdge e) { return unite(e.source, e.target); }
	public final boolean unite(final int x, final int y) { // O(a(N))
		FastIO.rangeCheck(x, n);
		FastIO.rangeCheck(y, n);
		int xRoot = root(x);
		int yRoot = root(y);
		if(xRoot == yRoot) return true;
		numGroups --;
		if(nodes[yRoot] < nodes[xRoot]) {
			nodes[yRoot] += nodes[xRoot];
			nodes[xRoot] = yRoot;
		}else {
			nodes[xRoot] += nodes[yRoot];
			nodes[yRoot] = xRoot;
		}
		return false;
	}

	public final int size(final int i) { FastIO.rangeCheck(i, n); return - nodes[root(i)]; } // O(a(N))

	public final int root(final int i) { // O(a(N))
		FastIO.rangeCheck(i, n);
		if(nodes[i] < 0) return i;
		return nodes[i] = root(nodes[i]);
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