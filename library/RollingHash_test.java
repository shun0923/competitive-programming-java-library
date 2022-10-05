// verification-helper: PROBLEM https://judge.yosupo.jp/problem/zalgorithm

package library;

import library.Solver;
import library.RollingHash;

public class RollingHash_test extends Solver {
	public static void main(final String[] args) { main(args, new RollingHash_test()); }

	public void solve() {
		RollingHash rh = new RollingHash(ns());
		int lcp[] = new int[rh.len];
		for(int i = 0; i < rh.len; i ++) lcp[i] = RollingHash.lcp(rh, 0, rh, i);
		prtln(lcp);
	}
}