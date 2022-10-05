package library;

import java.util.*;
import library.SimpleUtil;

final class Kmp {
	// return all the occurrences of P in S
	// O(|S|)
	public static final int[] cal(String s, String p) { return cal(s.toCharArray(), p.toCharArray()); }
	public static final int[] cal(char[] s, char[] p) { return cal(SimpleUtil.charToInt(s), SimpleUtil.charToInt(p)); }
	public static final int[] cal(int[] s, int[] p) {
		int sLen = s.length;
		int pLen = p.length;

		int sIndex = 1;
		int pIndex = 0;

		int skip[] = new int[pLen + 1];
		Arrays.fill(skip, 0);
		while(sIndex < pLen) {
			if(p[sIndex] == p[pIndex]) {
				sIndex ++;
				pIndex ++;
				skip[sIndex] = pIndex;
			}else if(pIndex == 0) {
				sIndex ++;
				skip[sIndex] = 0;
			}else {
				pIndex = skip[pIndex];
			}
		}

		ArrayList<Integer> matchIndex = new ArrayList<Integer>();
		sIndex = 0;
		pIndex = 0;
		while(true) {
			while(sIndex < sLen && pIndex < pLen && s[sIndex] == p[pIndex]) {
				sIndex ++;
				pIndex ++;
			}
			if(pIndex >= pLen) {
				matchIndex.add(sIndex - pLen);
				pIndex = skip[pIndex];
			}else if(pIndex == 0) {
				sIndex ++;
			}else {
				pIndex = skip[pIndex];
			}
			if(sIndex >= sLen) break;
		}

		int matchIndexList[] = new int[matchIndex.size()];
		for(int i = 0; i < matchIndex.size(); i ++) matchIndexList[i] = matchIndex.get(i);
		return matchIndexList;
	}
}