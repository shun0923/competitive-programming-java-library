// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2674

package library;

import library.Solver;
import library.WaveletMatrix;

public class WaveletMatrix_freq_test extends Solver {
	public static void main(final String[] args) { main(args, new WaveletMatrix_freq_test()); }

	public void solve() {
		int d = ni();
		int x[] = ni(d);
		for(int i = 0; i < d; i ++) x[i] += 100_000_000;
		WaveletMatrix wm = new WaveletMatrix(x);
		int q = ni();
		for(int i = 0; i < q; i ++) {
			int l = ni() - 1;
			int r = ni() - 1;
			int e = ni();
			prtln(r - l + 1 - wm.rangeFreq(min(x[l], x[r]) - e, max(x[l], x[r]) + e + 1, l, r + 1));
		}
	}
}