// verification-helper: PROBLEM https://yukicoder.me/problems/no/1036

package library;

import library.Solver;
import library.TemplateSwag;

public class TemplateSwag_gcd_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateSwag_gcd_test()); }

	public void solve() {
		int n = ni();
		Long a[] = new Long[n];
		for(int i = 0; i < n; i ++) a[i] = nl();
		TemplateSwag<Long> swag = new TemplateSwag<>(a, () -> 0l, (ele1, ele2) -> gcd(ele1, ele2));
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