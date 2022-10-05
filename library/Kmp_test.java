// verification-helper: PROBLEM https://yukicoder.me/problems/no/430

package library;

import library.Solver;
import library.Kmp;

public class Kmp_test extends Solver {
	public static void main(final String[] args) { main(args, new Kmp_test()); }

	public void solve() {
		String s = ns();
		int m = ni();
		long ans = 0;
		for(int i = 0; i < m; i ++) ans += Kmp.cal(s, ns()).length;
		prtln(ans);
	}
}