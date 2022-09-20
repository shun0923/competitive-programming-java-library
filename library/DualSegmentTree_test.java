// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_E

package library;

import library.Solver;
import library.DualSegmentTree;

public class DualSegmentTree_test extends Solver {
	public static void main(final String[] args) { main(args, new DualSegmentTree_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		DualSegmentTree st = new DualSegmentTree(n,
				0, (ele1, ele2) -> ele1 + ele2);
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) st.update(ni() - 1, ni(), nl());
			else prtln(st.get(ni() - 1));
		}
	}
}