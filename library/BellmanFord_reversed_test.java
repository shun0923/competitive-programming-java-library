// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2005

package library;

import library.Solver;
import library.AbstractGraph;
import library.BellmanFord;

public class BellmanFord_reversed_test extends Solver {
	public static void main(final String[] args) { main(args, new BellmanFord_reversed_test()); }

	public void solve() {
		while(true) {
			int n = ni();
			int m = ni();
			int s = ni() - 1;
			int g1 = ni() - 1;
			int g2 = ni() - 1;
			if(n == 0) return;
			var g = new ArrayWeightedGraph(n, true);
			for(int i = 0; i < m; i ++) g.add(ni() - 1, ni() - 1, nl());
			long distS[] = BellmanFord.dist(g, s);
			long distG1[] = BellmanFord.dist(g.numNode, g.reverseEdges(), g1);
			long distG2[] = BellmanFord.dist(g.numNode, g.reverseEdges(), g2);
			long min = INF;
			for(int i = 0; i < n; i ++) min = min(min, distS[i] + distG1[i] + distG2[i]);
			prtln(min);
		}
	}
}