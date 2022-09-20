// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_set_range_composite

package library;

import library.Solver;
import library.Mod;
import library.SegmentTree;

public class SegmentTree_Composite_test extends Solver {
	public static void main(final String[] args) { main(args, new SegmentTree_Composite_test()); }

	public void solve() {
		long mask = (1 << 31) - 1;
		Mod md = Mod998.md;
		int n = ni();
		int q = ni();
		long f[] = new long[n];
		for(int i = 0; i < n; i ++) f[i] = nl() << 31 | nl();
		SegmentTree st = new SegmentTree(f,
			1l << 31,
			(ele1, ele2) -> md.mul(ele1 >> 31, ele2 >> 31) << 31 | md.mod((ele2 >> 31) * (ele1 & mask) + (ele2 & mask)));
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) st.set(ni(), nl() << 31 | nl());
			else {
				long p = st.find(ni(), ni());
				prtln(md.mod((p >> 31) * nl() + (p & mask)));
			}
		}
	}
}