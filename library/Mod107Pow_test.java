// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B

package library;

import library.Solver;
import library.Mod;

public class Mod107Pow_test extends Solver {
	public static void main(final String[] args) { main(args, new Mod107Pow_test()); }

	public void solve() {
		prtln(Mod107.md.pow(nl(), nl()));
	}
}