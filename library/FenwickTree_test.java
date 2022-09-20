// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum

package library;

import library.Solver;
import library.FenwickTree;

public class FenwickTree_test extends Solver {
	public static void main(final String[] args) { main(args, new FenwickTree_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		FenwickTree ft = new FenwickTree(nl(n));
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) ft.add(ni(), nl());
			else prtln(ft.sum(ni(), ni()));
		}
	}
}