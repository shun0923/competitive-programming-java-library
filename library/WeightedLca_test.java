// verification-helper: PROBLEM https://yukicoder.me/problems/no/898

package library;

import library.Solver;
import library.AbstractGraph;
import library.WeightedLca;

public class WeightedLca_test extends Solver {
	public static void main(final String[] args) { main(args, new WeightedLca_test()); }

	public void solve() {
		int n = ni();
		ArrayWeightedGraph g = new ArrayWeightedGraph(n, true);
		for(int i = 0; i < n - 1; i ++) g.add(ni(), ni(), nl());
		WeightedLca lca = new WeightedLca(g, 0, 0, (cost1, cost2) -> cost1 + cost2);
		int q = ni();
		for(int query = 0; query < q; query ++) {
			int x[] = ni(3);
			long ans = 0;
			for(int i = 0; i < 3; i ++) ans += lca.cal(x[i == 0 ? 2 : i - 1], x[i]).cost;
			prtln(ans / 2);
		}
	}
}