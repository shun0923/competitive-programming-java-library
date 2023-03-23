// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_B

package library;

import library.Solver;
import library.AbstractGraph;
import library.BellmanFord;

public class BellmanFord_test extends Solver {
	public static void main(final String[] args) { main(args, new BellmanFord_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		int r = ni();
		var g = new WeightedListGraph(n, true);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		long dist[] = BellmanFord.dist(g, r);
		if(isINF(min(dist))) prtln("NEGATIVE CYCLE");
		else for(long ele : dist) prtln(isINF(ele) ? "INF" : ele);
	}
}