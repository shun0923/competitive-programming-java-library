// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B

package library;

import java.util.*;
import library.Util;
import library.ArbitraryMod;

public class ArbitraryModPow_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new ArbitraryModPow_test(), "", 1 << 31).start();
	}

	public void solve() {
		prtln(new ArbitraryMod(1_000_000_007).pow(nl(), nl()));
	}
}