// verification-helper: PROBLEM https://judge.yosupo.jp/problem/number_of_substrings

package library;

import library.Solver;
import library.Trie;

public class Trie_size_test extends Solver {
	public static void main(final String[] args) { main(args, new Trie_size_test()); }

	public void solve() {
		String t = ns();
		Trie trie = new Trie();
		for(int i = 0; i < t.length(); i ++) trie.add(t, i, t.length());
		prtln(trie.size() - 1);
	}
}