// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_3_C

package library;

import library.Solver;
import library.AbstractGraph;
import library.Scc;

public class Scc_ids_test extends Solver {
	public static void main(final String[] args) { main(args, new Scc_ids_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		ArrayUnweightedGraph g = new ArrayUnweightedGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni());
		int ids[] = Scc.calIds(g);
		int q = ni();
		for(int i = 0; i < q; i ++) prtln(ids[ni()] == ids[ni()] ? 1 : 0);
	}
}