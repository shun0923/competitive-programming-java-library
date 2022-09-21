// verification-helper: PROBLEM https://judge.yosupo.jp/problem/queue_operate_all_composite

package library;

import library.Solver;
import library.Mod;
import library.DynamicSwag;

public class DynamicSwag_test extends Solver {
	public static void main(final String[] args) { main(args, new DynamicSwag_test()); }

	public void solve() {
		long mask = (1 << 31) - 1;
		Mod md = Mod998.md;
		int q = ni();
		DynamicSwag swag = new DynamicSwag(
			1l << 31,
			(ele1, ele2) -> md.mul(ele1 >> 31, ele2 >> 31) << 31 | md.mod((ele2 >> 31) * (ele1 & mask) + (ele2 & mask)));
		for(int i = 0; i < q; i ++) {
			switch(ni()) {
			case 0: swag.push(nl() << 31 | nl()); break;
			case 1: swag.pop(); break;
			case 2: long p = swag.fold(); prtln(md.mod((p >> 31) * nl() + (p & mask))); break;
			}
		}
	}
}