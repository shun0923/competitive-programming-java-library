// verification-helper: PROBLEM https://yukicoder.me/problems/no/1013

package library;

import library.Solver;
import library.AbstractGraph;
import library.WeightedDoubling;

public class WeightedDoubling_test extends Solver {
	public static void main(final String[] args) { main(args, new WeightedDoubling_test()); }

	public void solve() {
		int n = ni();
		long k = nl();
		ArrayWeightedNode edges = new ArrayWeightedNode(-1);
		for(int i = 0; i < n; i ++) {
			int target = i + ni();
			if(target < n) edges.add(i, target, 0);
			else edges.add(i, target - n, 1);
		}
		WeightedDoubling db = new WeightedDoubling(n, k, 0, (cost1, cost2) -> cost1 + cost2, edges);
		for(int i = 0; i < n; i ++) {
			WeightedEdge e = db.cal(i, k);
			prtln(e.target + e.cost * n + 1);
		}
	}
}