// verification-helper: PROBLEM https://judge.yosupo.jp/problem/many_aplusb

package library;

import library.Solver;
import library.FastInputStream;
import library.FastOutputStream;

public class ManyFastIO_test extends Solver {
	public static void main(final String[] args) { main(args, new ManyFastIO_test()); }

	public void solve() {
		int t = ni();
		for(int i = 0; i < t; i ++) prtln(nl() + nl());
	}
}