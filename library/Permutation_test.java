// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A

package library;

import library.Solver;
import library.Permutation;

public class Permutation_test extends Solver {
	public static void main(final String[] args) { main(args, new Permutation_test()); }

	public void solve() {
		int n = ni();
		int a0[] = new int[n];
		for(int i = 0; i < n; i ++) a0[i] = i + 1;
		for(int[] a : new Permutation(a0)) prtln(a);
	}
}