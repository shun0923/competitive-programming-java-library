// verification-helper: PROBLEM https://yukicoder.me/problems/no/1186

package library;

import library.Solver;
import library.Mod;

public class Mod998ManyCombination_test extends Solver {
	public static void main(final String[] args) { main(args, new Mod998ManyCombination_test()); }

	public void solve() {
		Mod md = Mod998.md;
		int n = ni();
		int m = ni();
		if(n == 1) prtln(1);
		else {
			long ans = 0;
			for(int x = 0; x <= m / n; x ++) {
				ans = md.add(ans, md.H(x + 1, m - x * n));
			}
			prtln(ans);
		}
	}
}