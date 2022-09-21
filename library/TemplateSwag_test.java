// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_3_D

package library;

import library.Solver;
import library.TemplateSwag;

public class TemplateSwag_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateSwag_test()); }

	public void solve() {
		int n = ni();
		int l = ni();
		Long a[] = new Long[n];
		for(int i = 0; i < n; i ++) a[i] = nl();
		TemplateSwag<Long> swag = new TemplateSwag<>(a, () -> INF, (ele1, ele2) -> min(ele1, ele2));
		long ans[] = new long[n - l + 1];
		for(int i = 0; i + l <= n; i ++) ans[i] = swag.fold(i, i + l);
		prtln(ans);
	}
}