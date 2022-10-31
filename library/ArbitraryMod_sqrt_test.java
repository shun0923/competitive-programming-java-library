// verification-helper: PROBLEM https://judge.yosupo.jp/problem/sqrt_mod

package library;

import library.Solver;
import library.ArbitraryMod;

public class ArbitraryMod_sqrt_test extends Solver {
	public static void main(final String[] args) { main(args, new ArbitraryMod_sqrt_test()); }

	public void solve() {
		int t = ni();
		for(int i = 0; i < t; i ++) {
			long y = nl();
			long p = nl();
			prtln(new ArbitraryMod(p).sqrt(y));
		}
	}
}