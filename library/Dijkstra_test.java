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
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		long dist[] = Dijkstra.dist(g, r);
		for(long ele : dist) prtln(isINF(ele) ? "INF" : ele);
	}
}