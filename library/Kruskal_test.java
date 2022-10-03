// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_2_A

package library;

import library.Solver;
import library.AbstractGraph;
import library.Kruskal;

public class Kruskal_test extends Solver {
	public static void main(final String[] args) { main(args, new Kruskal_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, false);
		for(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());
		prtln(Kruskal.cal(g));
	}
}