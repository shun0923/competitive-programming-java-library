// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_14_B

package library;

import library.Solver;
import library.Kmp;

public class Kmp_test extends Solver {
	public static void main(final String[] args) { main(args, new Kmp_test()); }

	public void solve() {
		String t = ns();
		prtlns(new Kmp(ns()).match(t));
	}
}