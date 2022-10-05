package library;

import library.SimpleUtil;

final class ZAlgorithm {
	// return the length of the longest list starting from S[i] which is also a prefix of S
	// O(|S|)
	public static final int[] cal(String s) { return cal(s.toCharArray()); }
	public static final int[] cal(char[] c) { return cal(SimpleUtil.charToInt(c)); }
	public static final int[] cal(int[] a) {
		int len = a.length;
		int match[] = new int[len];
		match[0] = len;
		int i = 1;
		int j = 0;
		while(i < len) {
			while(i + j < len && a[j] == a[i + j]) j ++;
			match[i] = j;
			if(j == 0) { i ++; continue; }
			int k = 1;
			while(i + k < len && k + match[k] < j) { match[i + k] = match[k]; k ++; }
			i += k;
			j -= k;
		}
		return match;
	}
}