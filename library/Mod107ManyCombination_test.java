// verification-helper: PROBLEM https://yukicoder.me/problems/no/1044

package library;

import java.util.*;
import library.Util;
import library.Mod;

public class Mod107ManyCombination_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new Mod107ManyCombination_test(), "", 1 << 31).start();
	}

	public void solve() {
		Mod md = Mod107.md;
		int n = ni();
		int m = ni();
		int k = ni();
		long ans = 0;
		for(int x = 1; x <= n && x <= m && x <= (n + m - k) / 2; x ++) {
			ans = md.add(ans, md.mul(md.C(n, x), md.H(x, m - x)));
		}
		prtln(md.mul(ans, md.fact(m), md.fact(n - 1)));
	}
}