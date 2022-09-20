// verification-helper: PROBLEM https://judge.yosupo.jp/problem/convolution_mod

package library;

import library.Solver;
import library.Convolution;

public class Convolution998_test extends Solver {
	public static void main(final String[] args) { main(args, new Convolution998_test()); }

	public void solve() {
		int n = ni();
		int m = ni();
		prtln(Convolution998.cnv.cnv(nl(n), nl(m)));
	}
}