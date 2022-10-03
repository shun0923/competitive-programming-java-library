// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_12_C

package library;

import library.Solver;
import library.AbstractGraph;
import library.Dijkstra;

public class Dijkstra_forDenseGraph_test extends Solver {
	public static void main(final String[] args) { main(args, new Dijkstra_forDenseGraph_test()); }

	public void solve() {
		int n = ni();
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, true);
		for(int i = 0; i < n; i ++) {
			int u = ni();
			int k = ni();
			for(int j = 0; j < k; j ++) g.add(u, ni(), nl());
		}
		long dist[] = Dijkstra.distForDenseGraph(g, 0);
		for(int i = 0; i < n; i ++) prtln(i, dist[i]);
	}
}