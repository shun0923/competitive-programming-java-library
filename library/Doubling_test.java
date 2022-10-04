// verification-helper: PROBLEM https://yukicoder.me/problems/no/1211

package library;

import java.util.*;
import library.Solver;
import library.Doubling;

public class Doubling_test extends Solver {
	public static void main(final String[] args) { main(args, new Doubling_test()); }

	public void solve() {
		int n = ni();
		int k = ni();
		long a[] = new long[n * 2];
		for(int i = 0; i < n; i ++) { a[i] = ni(); a[n + i] = a[i]; }
		n *= 2;
		int edges[] = new int[n + 1];
		Doubling db;
		long ok = 0;
		long ng = sum(a) + 1;
		while(abs(ok - ng) > 1) {
			long mid = ng + (ok - ng) / 2;
			Arrays.fill(edges, -1);
			long sum = 0;
			int r = 0;
			for(int l = 0; l < n; l ++) {
				for(; r < n; r ++) {
					if(sum >= mid) break;
					sum += a[r];
				}
				if(sum >= mid) edges[l] = r;
				sum -= a[l];
			}
			db = new Doubling(n + 1, k, edges);
			boolean isOK = false;
			for(int i = 0; i < n; i ++) {
				int to = db.cal(i, k);
				isOK |= to != -1 && to <= i + n / 2;
			}
			if(isOK) ok = mid;
			else ng = mid;
		}
		prtln(ok);
	}
}