// verification-helper: PROBLEM https://yukicoder.me/problems/no/789

package library;

import library.Solver;
import library.TemplateDynamicSegmentTree;

public class TemplateDynamicSegmentTree_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateDynamicSegmentTree_test()); }

	public void solve() {
		int n = ni();
		TemplateDynamicSegmentTree<Long> st = new TemplateDynamicSegmentTree<>(1_000_000_001,
				() -> 0l, (ele1, ele2) -> ele1 + ele2);
		long ans = 0;
		for(int i = 0; i < n; i ++) {
			if(ni() == 0) st.update(ni(), nl());
			else ans += st.find(ni(), ni() + 1);
		}
		prtln(ans);
	}
}