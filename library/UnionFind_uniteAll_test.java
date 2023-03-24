// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_D

package library;

import library.Solver;
import library.AbstractGraph;
import library.UnionFind;

public class UnionFind_uniteAll_test extends Solver {
	public static void main(final String[] args) { main(args, new UnionFind_uniteAll_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		var edges = new UnweightedListNode(-1);
		for(int i = 0; i < m; i ++) edges.add(ni(), ni());
		UnionFind uf = new UnionFind(n);
		uf.uniteAll(edges);
		int q = ni();
		for(int i = 0; i < q; i ++) prtln(uf.same(ni(), ni()) ? "yes" : "no");
	}
}