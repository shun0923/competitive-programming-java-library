// verification-helper: PROBLEM https://yukicoder.me/problems/no/1097

package library;

import library.Solver;
import library.AbstractGraph;
import library.WeightedDoubling;

public class WeightedDoubling_test extends Solver {
	public static void main(final String[] args) { main(args, new WeightedDoubling_test()); }

	public void solve() {
		int n = ni();
		ArrayWeightedNode edges = new ArrayWeightedNode(-1);
		for(int i = 0; i < n; i ++) {
			int target = i + ni();
			edges.add(i, target % n, target / n);
		}
		WeightedDoubling db = new WeightedDoubling(n, (long)1e12, 0, (cost1, cost2) -> cost1 + cost2, edges);
		int q = ni();
		for(int i = 0; i < q; i ++) {
			WeightedEdge e = db.cal(0, nl());
			prtln(e.target + e.cost * n);
		}
	}
}