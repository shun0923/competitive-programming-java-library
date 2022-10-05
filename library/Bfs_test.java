// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_11_C

package library;

import library.Solver;
import library.AbstractGraph;
import library.Bfs;

public class Bfs_test extends Solver {
	public static void main(final String[] args) { main(args, new Bfs_test()); }

	public void solve() {
		int n = ni();
		ArrayUnweightedGraph g = new ArrayUnweightedGraph(n, true);
		for(int i = 0; i < n; i ++) {
			int source = ni() - 1;
			int k = ni();
			for(int j = 0; j < k; j ++) g.add(source, ni() - 1);
		}
		int dist[] = Bfs.dist(g, 0);
		for(int i = 0; i < n; i ++) prtln(i + 1, dist[i]);
	}
}