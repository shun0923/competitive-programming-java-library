// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_5_A

package library;

import library.Solver;
import library.AbstractGraph;
import library.TemplateRerooting;

public class TemplateRerooting_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateRerooting_test()); }

	public void solve() {
		int n = ni();
		ArrayTemplateGraph<Long> g = new ArrayTemplateGraph<>(n, false);
		for(int i = 0; i < n - 1; i ++) g.add(ni(), ni(), nl());
		TemplateRerooting<Long> rr = new TemplateRerooting<>(n, g.nodes(), 0,
				() -> 0l,
				(x1, x2) -> max(x1, x2),
				(e, x) -> e.cost + x,
				(v, x) -> x,
				(v) -> 0l);
		rr.cal();
		long ans = 0;
		for(int i = 0; i < n; i ++) ans = max(ans, (long)rr.get(i));
		prtln(ans);
	}
}