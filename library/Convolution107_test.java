// verification-helper: PROBLEM https://judge.yosupo.jp/problem/convolution_mod_1000000007

package library;

import library.Solver;
import library.ExtendedConvolution;

public class Convolution107_test extends Solver {
	public static void main(final String[] args) { main(args, new Convolution107_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		prtln(Convolution107.cnv.cnv(nl(n), nl(m)));
	}
}