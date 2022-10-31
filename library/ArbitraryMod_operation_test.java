// verification-helper: PROBLEM https://yukicoder.me/problems/no/1092

package library;

import library.Solver;
import library.ArbitraryMod;

public class ArbitraryMod_operation_test extends Solver {
	public static void main(final String[] args) { main(args, new ArbitraryMod_operation_test()); }

	public void solve() {
		Mod md = new ArbitraryMod(nl());
		int n = ni() - 1;
		long ans = nl();
		long a[] = nl(n);
		for(long ele : a) {
			switch(nc()) {
			case '+': ans = md.add(ans, ele); break;
			case '-': ans = md.sub(ans, ele); break;
			case '*': ans = md.mul(ans, ele); break;
			case '/': ans = md.div(ans, ele); break;
			}
		}
		prtln(ans);
	}
}