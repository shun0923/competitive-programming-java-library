// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path

package library;

import library.Solver;
import library.AbstractGraph;
import library.Dijkstra;

public class Dijkstra_pass_test extends Solver {
	public static void main(final String[] args) { main(args, new Dijkstra_pass_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		int s = ni();
		int t = ni();
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		long x = Dijkstra.dist(g, s)[t];
		if(isINF(x)) prtln(-1);
		else {
			int pass[] = Dijkstra.pass(s, t);
			prtln(x, pass.length - 1);
			for(int i = 0; i < pass.length - 1; i ++) prtln(pass[i], pass[i + 1]);
		}
	}
}