// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A

package library;

import library.Solver;
import library.AbstractGraph;
import library.Dijkstra;

public class Dijkstra_test extends Solver {
	public static void main(final String[] args) { main(args, new Dijkstra_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		int r = ni();
		var g = new WeightedListGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		for(long ele : Dijkstra.dist(g, r)) prtln(isINF(ele) ? "INF" : ele);
	}
}