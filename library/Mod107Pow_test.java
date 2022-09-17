// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B

package library;

import java.util.*;
import library.Util;
import library.Mod;

public class Mod107Pow_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new Mod107Pow_test(), "", 1 << 31).start();
	}

	public void solve() {
		prtln(Mod107.md.pow(nl(), nl()));
	}
}