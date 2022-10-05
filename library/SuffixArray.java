package library;

import java.util.*;
import java.util.function.*;
import library.SimpleUtil;

final class SuffixArray {
	public static final int[] cal(String s) { return cal(s.toCharArray()); } // O(|S|)
	public static final int[] cal(char[] c) {
		int a[] = SimpleUtil.charToInt(c);
		int max = 0;
		for(int ele : a) if(max < ele) max = ele;
		return sais(a, max);
	} // O(|S|)
	public static final int[] cal(int[] a, int max) { return sais(a, max); } // O(|S|+M)
	public static final int[] cal(int[] a) { // O(NlogN)
		int n = a.length;
		Integer[] idx = new Integer[n];
		for(int i = 0; i < n; i++) idx[i] = i;
		Arrays.sort(idx, (l, r) -> Integer.compare(a[l], a[r]));
		int[] a2 = new int[n];
		int crt = 0;
		a2[0] = 0;
		for(int i = 1; i < n; i ++) {
			if(a[idx[i - 1]] != a[idx[i]]) crt ++;
			a2[idx[i]] = crt;
		}
		return sais(a2, crt);
	}

	public static final int[] sais(int[] s, int max) { // O(|S|+M)
		SimpleUtil.nonNegativeCheck(max);
		int n = s.length;
		if(n == 0) return new int[0];
		if(n == 1) return new int[]{0};
		if(n == 2) {
			if(s[0] < s[1]) {
				return new int[]{0, 1};
			}else {
				return new int[]{1, 0};
			}
		}

		int sa[] = new int[n];
		boolean ls[] = new boolean[n];
		for(int i = n - 2; i >= 0; i --) ls[i] = s[i] == s[i + 1] ? ls[i + 1] : s[i] < s[i + 1];

		int sumL[] = new int[max + 1];
		int sumS[] = new int[max + 1];

		for(int i = 0; i < n; i ++) {
			if(ls[i]) sumL[s[i] + 1]++;
			else sumS[s[i]]++;
		}

		for(int i = 0; i <= max; i ++) {
			sumS[i] += sumL[i];
			if(i < max) sumL[i + 1] += sumS[i];
		}

		Consumer<int[]> induce = lms -> {
			Arrays.fill(sa, -1);
			int[] buf = new int[max + 1];
			for(int i = 0; i < max + 1; i ++) buf[i] = sumS[i];
			for(int d : lms) {
				if(d == n) continue;
				sa[buf[s[d]]++] = d;
			}
			for(int i = 0; i < max + 1; i ++) buf[i] = sumL[i];
			sa[buf[s[n - 1]] ++] = n - 1;
			for(int i = 0; i < n; i++) {
				int v = sa[i];
				if(v >= 1 && !ls[v - 1]) sa[buf[s[v - 1]]++] = v - 1;
			}
			for(int i = 0; i < max + 1; i ++) buf[i] = sumL[i];
			for(int i = n - 1; i >= 0; i --) {
				int v = sa[i];
				if(v >= 1 && ls[v - 1]) {
					sa[-- buf[s[v - 1] + 1]] = v - 1;
				}
			}
		};

		int[] lmsMap = new int[n + 1];
		Arrays.fill(lmsMap, -1);
		int m = 0;
		for(int i = 1; i < n; i ++) if(!ls[i - 1] && ls[i]) lmsMap[i] = m ++;

		int[] lms = new int[m];
		{
			int p = 0;
			for(int i = 1; i < n; i++) if(!ls[i - 1] && ls[i]) lms[p ++] = i;
		}

		induce.accept(lms);

		if(m > 0) {
			int sortedLms[] = new int[m];
			{
				int p = 0;
				for(int v : sa) if(lmsMap[v] != -1) sortedLms[p ++] = v;
			}
			int recS[] = new int[m];
			int recUpper = 0;
			recS[lmsMap[sortedLms[0]]] = 0;
			for(int i = 1; i < m; i ++) {
				int l = sortedLms[i - 1], r = sortedLms[i];
				int endL = (lmsMap[l] + 1 < m) ? lms[lmsMap[l] + 1] : n;
				int endR = (lmsMap[r] + 1 < m) ? lms[lmsMap[r] + 1] : n;
				boolean same = true;
				if(endL - l != endR - r) same = false;
				else {
					while(l < endL && s[l] == s[r]) { l++; r++; }
					if(l == n || s[l] != s[r]) same = false;
				}
				if(!same) recUpper++;
				recS[lmsMap[sortedLms[i]]] = recUpper;
			}

			int[] recSA = sais(recS, recUpper);

			for(int i = 0; i < m; i ++) sortedLms[i] = lms[recSA[i]];
			induce.accept(sortedLms);
		}

		return sa;
	}
}