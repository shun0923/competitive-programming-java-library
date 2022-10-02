// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_C

package library;

import library.Solver;
import library.AbstractGraph;
import library.WarshallFloyd;

public class WarshallFloyd_test extends Solver {
	public static void main(final String[] args) { main(args, new WarshallFloyd_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		long dist[][] = WarshallFloyd.dist(g);
		for(int i = 0; i < n; i ++) if(dist[i][i] < 0) { prtln("NEGATIVE CYCLE"); return; }
		String ans[][] = new String[n][n];
		for(int i = 0; i < n; i ++) for(int j = 0; j < n; j ++) {
			ans[i][j] = isINF(dist[i][j]) ? "INF" : String.valueOf(dist[i][j]);
		}
		prtln(ans);
	}
}