// verification-helper: PROBLEM https://yukicoder.me/problems/no/2007

package library;

import java.util.*;
import library.Util;
import library.Mod;

public class Mod998Pow_test extends Util {
	public static void main(final String[] args) {
		DEBUG = args.length > 0 && args[0].equals("-DEBUG");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace(); System.exit(1); });
		new Thread(null, new Mod998Pow_test(), "", 1 << 31).start();
	}

	public void solve() {
		prtln(Mod998.MOD);
		prtln(Mod998.md.pow(nl(), nl()));
	}
}