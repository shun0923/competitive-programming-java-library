// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path

package library;

import library.Solver;
import library.AbstractGraph;
import library.Dijkstra;
import library.RestorePath;

public class Dijkstra_path_test extends Solver {
	public static void main(final String[] args) { main(args, new Dijkstra_path_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		int s = ni();
		int t = ni();
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		long x = Dijkstra.dist(g, s, true)[t];
		if(isINF(x)) prtln(-1);
		else {
			int path[] = Dijkstra.path(s, t);
			prtln(x, path.length - 1);
			for(int i = 0; i < path.length - 1; i ++) prtln(path[i], path[i + 1]);
		}
	}
}