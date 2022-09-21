// verification-helper: PROBLEM https://judge.yosupo.jp/problem/queue_operate_all_composite

package library;

import library.Solver;
import library.Pair;
import library.Mod;
import library.TemplateDynamicSwag;

public class TemplateDynamicSwag_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateDynamicSwag_test()); }

	public void solve() {
		Mod md = Mod998.md;
		int q = ni();
		TemplateDynamicSwag<Pair.LL> swag = new TemplateDynamicSwag<>(
			() -> new Pair.LL(1, 0),
			(ele1, ele2) -> new Pair.LL(md.mul(ele1.a, ele2.a), md.mod(ele2.a * ele1.b + ele2.b)));
		for(int i = 0; i < q; i ++) {
			switch(ni()) {
			case 0: swag.push(Pair.npll()); break;
			case 1: swag.pop(); break;
			case 2: Pair.LL p = swag.fold(); prtln(md.mod(p.a * nl() + p.b)); break;
			}
		}
	}
}