// verification-helper: PROBLEM https://judge.yosupo.jp/problem/convolution_mod

package library;

import java.util.*;
import library.Util;
import library.Convolution998;

public class Convolution998_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new Convolution998_test(), "", 1 << 31).start();
	}

	public void solve() {
		int n = ni();
		int m = ni();
		prtln(Convolution998.cnv.cnv(nl(n), nl(m)));
	}
}