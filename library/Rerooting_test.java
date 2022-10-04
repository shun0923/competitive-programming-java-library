// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_5_A

package library;

import library.Solver;
import library.AbstractGraph;
import library.Rerooting;

public class Rerooting_test extends Solver {
	public static void main(final String[] args) { main(args, new Rerooting_test()); }

	public void solve() {
		int n = ni();
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, false);
		for(int i = 0; i < n - 1; i ++) g.add(ni(), ni(), nl());
		Rerooting rr = new Rerooting(n, g.nodes(), 0, 0,
				(x1, x2) -> max(x1, x2),
				(e, x) -> e.cost + x,
				(v, x) -> x,
				(v) -> 0);
		prtln(max(rr.cal()));
	}
}