// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_6_A

package library;

import library.Solver;
import library.MaxFlow;

public class MaxFlow_test extends Solver {
	public static void main(final String[] args) { main(args, new MaxFlow_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		MaxFlow mf = new MaxFlow(n);
		for(int i = 0; i < m; i ++) mf.add(ni(), ni(), nl());
		prtln(mf.maxFlow(0, n - 1));
	}
}