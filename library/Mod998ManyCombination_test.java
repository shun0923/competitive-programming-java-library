// verification-helper: PROBLEM https://yukicoder.me/problems/no/1186

package library;

import java.util.*;
import library.Util;
import library.Mod;

public class Mod998ManyCombination_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new Mod998ManyCombination_test(), "", 1 << 31).start();
	}

	public void solve() {
		Mod md = Mod998.md;
		int n = ni();
		int m = ni();
		if(n == 1) prtln(1);
		else {
			long ans = 0;
			for(int x = 0; x <= m / n; x ++) {
				ans = md.add(ans, md.H(x + 1, m - x * n));
			}
			prtln(ans);
		}
	}
}