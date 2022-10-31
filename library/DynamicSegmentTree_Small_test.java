// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum

package library;

import library.Solver;
import library.DynamicSegmentTree;

public class DynamicSegmentTree_small_test extends Solver {
	public static void main(final String[] args) { main(args, new DynamicSegmentTree_small_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		DynamicSegmentTree st = new DynamicSegmentTree(n,
				0, (ele1, ele2) -> ele1 + ele2);
		for(int i = 0; i < n; i ++) st.set(i, nl());
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) st.update(ni(), nl());
			else prtln(st.find(ni(), ni()));
		}
	}
}