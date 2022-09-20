// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum

package library;

import library.Solver;
import library.TemplatedSegmentTree;

public class TemplatedSegmentTree_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplatedSegmentTree_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		Long a[] = new Long[n];
		for(int i = 0; i < n; i ++) a[i] = nl();
		TemplatedSegmentTree<Long> st = new TemplatedSegmentTree<>(a,
				() -> 0l, (ele1, ele2) -> ele1 + ele2);
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) st.update(ni(), nl());
			else prtln(st.find(ni(), ni()));
		}
	}
}