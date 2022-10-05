// verification-helper: PROBLEM https://judge.yosupo.jp/problem/suffixarray

package library;

import library.Solver;
import library.SuffixArray;

public class SuffixArray_test extends Solver {
	public static void main(final String[] args) { main(args, new SuffixArray_test()); }

	public void solve() {
		prtln(SuffixArray.cal(ns()));
	}
}