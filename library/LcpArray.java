package library;

import java.util.*;
import library.SimpleUtil;
import library.SuffixArray;

final class LcpArray {
	// O(|S|)
	public static final int[] cal(String s) { return cal(s, SuffixArray.cal(s)); }
	public static final int[] cal(char[] c) { return cal(c, SuffixArray.cal(c)); }
	public static final int[] cal(int[] a) { return cal(a, SuffixArray.cal(a)); }
	public static final int[] cal(String s, int[] sa) { return cal(s.toCharArray(), sa); }
	public static final int[] cal(char[] c, int[] sa) { return cal(SimpleUtil.charToInt(c), sa); }
	public static final int[] cal(int[] a, int[] sa) {
		int n = a.length;
		int rnk[] = new int[n];
		for(int i = 0; i < n; i ++) rnk[sa[i]] = i;
		int[] lcp = new int[n - 1];
		int h = 0;
		for(int i = 0; i < n; i ++) {
			if(h > 0) h --;
			if(rnk[i] == 0) continue;
			int j = sa[rnk[i] - 1];
			for(; j + h < n && i + h < n; h ++) {
				if(a[j + h] != a[i + h]) break;
			}
			lcp[rnk[i] - 1] = h;
		}
		return lcp;
	}
}