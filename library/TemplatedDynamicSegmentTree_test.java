// verification-helper: PROBLEM https://yukicoder.me/problems/no/789

package library;

import library.Solver;
import library.TemplatedDynamicSegmentTree;

public class TemplatedDynamicSegmentTree_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplatedDynamicSegmentTree_test()); }

	public void solve() {
		int n = ni();
		TemplatedDynamicSegmentTree<Long> st = new TemplatedDynamicSegmentTree<>(1_000_000_001,
				() -> 0l, (ele1, ele2) -> ele1 + ele2);
		long ans = 0;
		for(int i = 0; i < n; i ++) {
			if(ni() == 0) st.update(ni(), nl());
			else ans += st.find(ni(), ni() + 1);
		}
		prtln(ans);
	}
}