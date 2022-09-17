// verification-helper: PROBLEM https://yukicoder.me/problems/no/1092

package library;

import java.util.*;
import library.Util;
import library.ArbitraryMod;

public class ArbitraryModOperation_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new ArbitraryModOperation_test(), "", 1 << 31).start();
	}

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