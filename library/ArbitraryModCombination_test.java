// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=1501

package library;

import java.util.*;
import library.Util;
import library.ArbitraryMod;

public class ArbitraryModCombination_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new ArbitraryModCombination_test(), "", 1 << 31).start();
	}

	public void solve() {
		Mod md = new ArbitraryMod(100_000_007);
		int r = ni();
		int c = ni();
		int a1 = ni();
		int a2 = ni();
		int b1 = ni();
		int b2 = ni();
		int x = Math.min(Math.abs(a1 - b1), r - Math.abs(a1 - b1));
		int y = Math.min(Math.abs(a2 - b2), c - Math.abs(a2 - b2));
		long ans = md.C(x + y, x);
		if(x * 2 == r) ans = md.mul(ans, 2);
		if(y * 2 == c) ans = md.mul(ans, 2);
		prtln(ans);
	}
}