// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_14_D

package library;

import library.Solver;
import library.Trie;

public class Trie_test extends Solver {
	public static void main(final String[] args) { main(args, new Trie_test()); }

	public void solve() {
		String t = ns();
		Trie trie = new Trie();
		for(int i = 0; i < t.length(); i ++) trie.add(t, i, t.length());
		int q = ni();
		for(int i = 0; i < q; i ++) prtln(trie.startWith(ns()) ? 1 : 0);
	}
}