// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_E

package library;

import library.Solver;
import library.TemplateDualSegmentTree;

public class TemplateDualSegmentTree_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateDualSegmentTree_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		TemplateDualSegmentTree<long[]> st = new TemplateDualSegmentTree<>(n,
				() -> new long[]{0}, (ele1, ele2) -> ele1[0] += ele2[0]);
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) st.update(ni() - 1, ni(), new long[]{nl()});
			else prtln(st.get(ni() - 1)[0]);
		}
	}
}