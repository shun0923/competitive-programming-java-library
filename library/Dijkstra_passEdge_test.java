// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path

package library;

import library.Solver;
import library.AbstractGraph;
import library.Dijkstra;

public class Dijkstra_passEdge_test extends Solver {
	public static void main(final String[] args) { main(args, new Dijkstra_passEdge_test()); }

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
			WeightedEdge pass[] = Dijkstra.passEdge(s, t);
			prtln(x, pass.length);
			for(WeightedEdge e : pass) prtln(e.source, e.target);
		}
	}
}