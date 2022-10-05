// verification-helper: PROBLEM https://judge.yosupo.jp/problem/number_of_substrings

package library;

import library.Solver;
import library.SuffixArray;
import library.LcpArray;

public class LcpArray_test extends Solver {
	public static void main(final String[] args) { main(args, new LcpArray_test()); }

	public void solve() {
		String s = ns();
		prtln((long)s.length() * (s.length() + 1) / 2 - sum(LcpArray.cal(s)));
	}
}