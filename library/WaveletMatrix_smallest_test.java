// verification-helper: PROBLEM https://judge.yosupo.jp/problem/range_kth_smallest

package library;

import library.Solver;
import library.WaveletMatrix;

public class WaveletMatrix_smallest_test extends Solver {
	public static void main(final String[] args) { main(args, new WaveletMatrix_smallest_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		WaveletMatrix wm = new WaveletMatrix(ni(n));
		for(int i = 0; i < q; i ++) prtln(wm.smallest(ni(), ni(), ni()));
	}
}