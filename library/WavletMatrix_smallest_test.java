// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_6_A

package library;

import library.Solver;
import library.WavletMatrix;

public class WavletMatrix_test extends Solver {
	public static void main(final String[] args) { main(args, new WavletMatrix_test()); }

	public void solve() {
		int n = ni();
		WaveletMatrix wm = new WaveletMatrix(ni(n));
		long sorted[] = new long[n];
		for(int i = 0; i < n; i ++) sorted[i] = wm.smallest(0, n, i);
		prtln(sorted);
	}
}