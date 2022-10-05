// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_14_B

package library;

import library.Solver;
import library.Kmp;

public class Kmp_test extends Solver {
	public static void main(final String[] args) { main(args, new Kmp_test()); }

	public void solve() {
		String t = ns();
		prtlns(new Kmp(StringToInt(ns())).match(StringToInt(t)));
	}

	int[] StringToInt(String s) {
		int a[] = new int[s.length()];
		for(int i = 0; i < s.length(); i ++) {
			int c = s.charAt(i);
			if('0' <= c && c <= '9') a[i] = c - '0';
			else if('a' <= c && c <= 'z') a[i] = c - 'a' + 10;
		}
		return a;
	}
}