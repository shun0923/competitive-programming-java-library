// verification-helper: PROBLEM https://yukicoder.me/problems/no/1036

package library;

import library.Solver;
import library.Swag;

public class Swag_gcd_test extends Solver {
	public static void main(final String[] args) { main(args, new Swag_gcd_test()); }

	public void solve() {
		int n = ni();
		long a[] = nl(n);
		Swag swag = new Swag(a, 0, (ele1, ele2) -> gcd(ele1, ele2));
		long ans = 0;
		int r = 0;
		for(int l = 0; l < n; l ++) {
			for(; r <= n; r ++) {
				if(swag.fold(l, r) == 1) { ans += n - r + 1; break; }
			}
		}
		prtln(ans);
	}
}