// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B

package library;

import library.Solver;
import library.ArbitraryMod;

public class ArbitraryMod_pow_test extends Solver {
	public static void main(final String[] args) { main(args, new ArbitraryMod_pow_test()); }

	public void solve() {
		prtln(new ArbitraryMod(1_000_000_007).pow(nl(), nl()));
	}
}