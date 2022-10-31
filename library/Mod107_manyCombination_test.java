// verification-helper: PROBLEM https://yukicoder.me/problems/no/1044

package library;

import library.Solver;
import library.Mod;

public class Mod107_manyCombination_test extends Solver {
	public static void main(final String[] args) { main(args, new Mod107_manyCombination_test()); }

	public void solve() {
		Mod md = Mod107.md;
		int n = ni();
		int m = ni();
		int k = ni();
		long ans = 0;
		for(int x = 1; x <= n && x <= m && x <= (n + m - k) / 2; x ++) {
			ans = md.add(ans, md.mul(md.C(n, x), md.H(x, m - x)));
		}
		prtln(md.mul(ans, md.fact(m), md.fact(n - 1)));
	}
}