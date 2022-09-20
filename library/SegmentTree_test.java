// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum

package library;

import library.Solver;
import library.SegmentTree;

public class SegmentTree_test extends Solver {
	public static void main(final String[] args) { main(args, new SegmentTree_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		SegmentTree st = new SegmentTree(nl(n),
				0, (ele1, ele2) -> ele1 + ele2);
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) st.update(ni(), nl());
			else prtln(st.find(ni(), ni()));
		}
	}
}