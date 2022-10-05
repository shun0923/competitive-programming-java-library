// verification-helper: PROBLEM https://judge.yosupo.jp/problem/zalgorithm

package library;

import library.Solver;
import library.ZAlgorithm;

public class ZAlgorithm_test extends Solver {
	public static void main(final String[] args) { main(args, new ZAlgorithm_test()); }

	public void solve() {
		prtln(ZAlgorithm.cal(ns()));
	}
}