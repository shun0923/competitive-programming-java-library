// verification-helper: PROBLEM https://judge.yosupo.jp/problem/scc

package library;

import library.Solver;
import library.AbstractGraph;
import library.Scc;

public class Scc_groups_test extends Solver {
	public static void main(final String[] args) { main(args, new Scc_groups_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		var g = new UnweightedListGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni());
		int groups[][] = Scc.calGroups(g);
		prtln(groups.length);
		for(int[] a : groups) {
			prt(a.length);
			prt(' ');
			prtln(a);
		}
	}
}