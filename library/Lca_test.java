// verification-helper: PROBLEM https://judge.yosupo.jp/problem/lca

package library;

import library.Solver;
import library.AbstractGraph;
import library.Lca;

public class Lca_test extends Solver {
	public static void main(final String[] args) { main(args, new Lca_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		ArrayUnweightedGraph g = new ArrayUnweightedGraph(n, false);
		for(int i = 1; i < n; i ++) g.add(ni(), i);
		Lca lca = new Lca(g, 0);
		for(int i = 0; i < q; i ++) prtln(lca.cal(ni(), ni()));
	}
}