// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_4_B

package library;

import library.Solver;
import library.AbstractGraph;
import library.TopologicalSort;

public class TopologicalSort_test extends Solver {
	public static void main(final String[] args) { main(args, new TopologicalSort_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		ArrayUnweightedGraph g = new ArrayUnweightedGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni());
		prtlns(TopologicalSort.sort(g));
	}
}