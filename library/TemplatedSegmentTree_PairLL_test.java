// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum

package library;

import library.Solver;
import library.Mod;
import library.TemplatedSegmentTree;

public class TemplatedSegmentTree_PairLL_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplatedSegmentTree_PairLL_test()); }

	public void solve() {
		Mod md = Mod998.md;
		int n = ni();
		int q = ni();
		PairLL f[] = npll(n);
		TemplatedSegmentTree<PairLL> st = new TemplatedSegmentTree<>(f,
			() -> new PairLL(1, 0),
			(ele1, ele2) -> new PairLL(md.mul(ele1.a, ele2.a), md.mod(ele2.a * ele1.b + ele2.b)));
		for(int i = 0; i < q; i ++) {
			if(ni() == 0) st.set(ni(), npll());
			else {
				PairLL p = st.find(ni(), ni());
				prtln(md.mod(p.a * nl() + p.b));
			}
		}
	}
}