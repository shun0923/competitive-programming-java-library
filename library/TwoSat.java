package library;

import library.SimpleUtil;
import library.AbstractGraph;
import library.Scc;

class TwoSat extends ArrayUnweightedGraph {
	private final int n;
	private final boolean ans[];

	// O(V)
	TwoSat(int n, boolean directed) { super(n * 2, directed); this.n = n; ans = new boolean[n]; }
	TwoSat(int n) { this(n, true); }

	// O(1)
	public final void addClause(int i, boolean f, int j, boolean g) {
		SimpleUtil.rangeCheck(i, n);
		SimpleUtil.rangeCheck(j, n);
		add((i << 1) + (f ? 0 : 1), (j << 1) + (g ? 1 : 0));
		add((j << 1) + (g ? 0 : 1), (i << 1) + (f ? 1 : 0));
	}
	public final void addImplication(int i, boolean f, int j, boolean g) { addClause(i, !f, j, g); }
	public final void addNand(int i, boolean f, int j, boolean g) { addClause(i, !f, j, !g); }

	// O(V+E)
	public final boolean satisfiable() {
		int id[] = Scc.calIds(this);
		for(int i = 0; i < n; i++) {
			if(id[i << 1] == id[(i << 1) | 1]) return false;
			ans[i] = id[i << 1] < id[(i << 1) | 1];
		}
		return true;
	}
	public final boolean[] cal() { satisfiable(); return ans; }
}