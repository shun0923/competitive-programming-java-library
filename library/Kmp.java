package library;

import java.util.*;
import library.SimpleUtil;

final class Kmp {
	// O(|S|)
	public final int a[];
	public final int kmp[];
	public Kmp(String s) { this(s.toCharArray()); }
	public Kmp(char[] c) { this(SimpleUtil.charToInt(c)); }
	public Kmp(int[] a) {
		this.a = a;
		kmp = new int[a.length + 1];
		kmp[0] = -1;
		int r = -1;
		for(int l = 0; l < a.length; l ++) {
			while(r != -1 && a[l] != a[r]) r = kmp[r];
			r ++;
			if(l + 1 < a.length && a[l + 1] == a[r]) kmp[l + 1] = kmp[r];
			else kmp[l + 1] = r;
		}

	}

	// return all the occurrences of S in T
	// O(|S|+|T|)
	public final int[] match(String t) { return match(t.toCharArray()); }
	public final int[] match(char[] c) { return match(SimpleUtil.charToInt(c)); }
	public final int[] match(int[] b) {
		ArrayList<Integer> match = new ArrayList<Integer>();
		int j = 0;
		for(int i = 0; i < b.length; ) {
			while(i != b.length && j != a.length && b[i] == a[j]) { i ++; j ++; }
			if(j == a.length) match.add(i - j);
			j = kmp[j];
			if(j == -1) { i ++; j ++; }
		}
		int matchList[] = new int[match.size()];
		for(int i = 0; i < match.size(); i ++) matchList[i] = match.get(i);
		return matchList;
	}
}