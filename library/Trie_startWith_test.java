// verification-helper: PROBLEM https://yukicoder.me/problems/no/430

package library;

import library.Solver;
import library.Trie;

public class Trie_startWith_test extends Solver {
	public static void main(final String[] args) { main(args, new Trie_startWith_test()); }

	public void solve() {
		String t = ns();
		Trie trie = new Trie();
		for(int i = 0; i < t.length(); i ++) trie.add(t, i, t.length());
		int m = ni();
		long ans = 0;
		for(int i = 0; i < m; i ++) ans += trie.startWith(ns());
		prtln(ans);
	}
}