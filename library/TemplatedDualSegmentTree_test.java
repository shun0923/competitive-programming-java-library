// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_E

package library;

import library.Solver;
import library.TemplatedDualSegmentTree;

public class TemplatedDualSegmentTree_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplatedDualSegmentTree_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		TemplatedDualSegmentTree<long[]> st = new TemplatedDualSegmentTree<>(n,
				() -> new long[]{0}, (ele1, ele2) -> ele1[0] += ele2[0]);
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) st.update(ni() - 1, ni(), new long[]{nl()});
			else prtln(st.get(ni() - 1)[0]);
		}
	}
}