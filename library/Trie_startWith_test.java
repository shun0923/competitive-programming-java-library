// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_14_D

package library;

import library.Solver;
import library.Trie;

public class Trie_startWith_test extends Solver {
	public static void main(final String[] args) { main(args, new Trie_startWith_test()); }

	public void solve() {
		String t = ns();
		int a[] = StringToInt(t);
		Trie trie = new Trie(36);
		for(int i = 0; i < t.length(); i ++) trie.add(a, i, a.length);
		int q = ni();
		for(int i = 0; i < q; i ++) prtln(trie.startWith(StringToInt(ns())) ? 1 : 0);
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