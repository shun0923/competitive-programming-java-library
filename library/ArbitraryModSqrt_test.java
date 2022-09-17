// verification-helper: PROBLEM https://judge.yosupo.jp/problem/sqrt_mod

package library;

import java.util.*;
import library.Util;
import library.ArbitraryMod;

public class ArbitraryModSqrt_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new ArbitraryModSqrt_test(), "", 1 << 31).start();
	}

	public void solve() {
		int t = ni();
		for(int i = 0; i < t; i ++) {
			long y = nl();
			long p = nl();
			prtln(new ArbitraryMod(p).sqrt(y));
		}
	}
}