// verification-helper: PROBLEM https://judge.yosupo.jp/problem/staticrmq

package library;

import library.Solver;
import library.TemplateSparseTable;

public class TemplateSparseTable_test extends Solver {
	public static void main(final String[] args) { main(args, new TemplateSparseTable_test()); }

	public void solve() {
		int n = ni();
		int q = ni();
		Long a[] = new Long[n];
		for(int i = 0; i < n; i ++) a[i] = nl();
		SparseTable<Long> st = new SparseTable<>(a, (ele1, ele2) -> min(ele1, ele2));
		for(int i = 0; i < q; i ++) prtln(st.find(ni(), ni()));
	}
}