// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path

package library;

import library.Solver;
import library.AbstractGraph;
import library.PathRestoration;
import library.Dijkstra;

public class Dijkstra_pathEdge_test extends Solver {
	public static void main(final String[] args) { main(args, new Dijkstra_pathEdge_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		int s = ni();
		int t = ni();
		var g = new WeightedListGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		int prv[] = new int[n];
		WeightedEdge prvEdge[] = new WeightedEdge[n];
		long x = Dijkstra.dist(g, s, prv, prvEdge)[t];
		if(isINF(x)) prtln(-1);
		else {
			var path = PathRestoration.pathEdge(prv, prvEdge, s, t);
			prtln(x, path.size());
			for(WeightedEdge e : path) prtln(e.source, e.target);
		}
	}
}