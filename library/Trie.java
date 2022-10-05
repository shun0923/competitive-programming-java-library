package library;

import java.util.*;
import java.util.function.*;
import library.SimpleUtil;

final class TrieNode {
	public final int next[];
	public final List<Integer> accept = new ArrayList<Integer>();
	public int cnt = 0;

	public TrieNode(final int charSize) {
		next = new int[charSize];
		Arrays.fill(next, -1);
	}
}
final class Trie extends ArrayList<TrieNode> { // P=prefix, M=numPrefix
	public final int charSize;

	// O(1)
	public Trie() { this(26); }
	public Trie(int charSize) { this.charSize = charSize; add(new TrieNode(charSize)); }

	// O(|P|)
	public final void add(final String str) { add(str, get(0).cnt); }
	public final void add(final char[] c) { add(c, get(0).cnt); }
	public final void add(final int[] a) { add(a, get(0).cnt); }
	public final void add(final String str, final int id) { add(str, id, 0, str.length()); }
	public final void add(final char[] c, final int id) { add(c, id, 0, c.length); }
	public final void add(final int[] a, final int id) { add(a, id, 0, a.length); }
	public final void add(final String str, final int l, final int r) { add(str, get(0).cnt, l, r); }
	public final void add(final char[] c, final int l, final int r) { add(c, get(0).cnt, l, r); }
	public final void add(final int[] a, final int l, final int r) { add(a, get(0).cnt, l, r); }
	public final void add(final String str, final int id, final int l, final int r) { add(str.toCharArray(), id, l, r); }
	public final void add(final char[] c, final int id, final int l, final int r) { add(SimpleUtil.charToInt(c), id, l, r); }
	public final void add(final int[] a, final int id, final int l, final int r) {
		SimpleUtil.inclusiveRangeCheck(l, a.length);
		SimpleUtil.inclusiveRangeCheck(r, a.length);
		SimpleUtil.assertion(l <= r, "l is larger than r.");
		int crt = 0;
		get(crt).cnt ++;
		for(int i = l; i < r; i ++) {
			int next = get(crt).next[a[i]];
			if(next == -1) {
				next = size();
				get(crt).next[a[i]] = next;
				add(new TrieNode(charSize));
			}
			crt = next;
			get(crt).cnt ++;
		}
		get(crt).accept.add(id);
	}

	// O(min(|S|,|P|))
	public final boolean search(final String str) { return search(str, false); }
	public final boolean search(final char[] c) { return search(c, false); }
	public final boolean search(final int[] a) { return search(a, false); }
	public final boolean startWith(final String str) { return search(str, true); }
	public final boolean startWith(final char[] c) { return search(c, true); }
	public final boolean startWith(final int[] a) { return search(a, true); }
	public final boolean search(final String str, final int l, final int r) { return search(str, false, l, r); }
	public final boolean search(final char[] c, final int l, final int r) { return search(c, false, l, r); }
	public final boolean search(final int[] a, final int l, final int r) { return search(a, false, l, r); }
	public final boolean startWith(final String str, final int l, final int r) { return search(str, true, l, r); }
	public final boolean startWith(final char[] c, final int l, final int r) { return search(c, true, l, r); }
	public final boolean startWith(final int[] a, final int l, final int r) { return search(a, true, l, r); }
	public final boolean search(final String str, final boolean prefix) { return search(str, prefix, 0, str.length()); }
	public final boolean search(final char[] c, final boolean prefix) { return search(c, prefix, 0, c.length); }
	public final boolean search(final int[] a, final boolean prefix) { return search(a, prefix, 0, a.length); }
	public final boolean search(final String str, final boolean prefix, final int l, final int r) { return search(str.toCharArray(), prefix, l, r); }
	public final boolean search(final char[] c, final boolean prefix, final int l, final int r) { return search(SimpleUtil.charToInt(c), prefix, l, r); }
	public final boolean search(final int[] a, final boolean prefix, final int l, final int r) {
		SimpleUtil.inclusiveRangeCheck(l, a.length);
		SimpleUtil.inclusiveRangeCheck(r, a.length);
		SimpleUtil.assertion(l <= r, "l is larger than r.");
		int crt = 0;
		for(int i = l; i < r; i ++) {
			crt = get(crt).next[a[i]];
			if(crt == -1) return false;
		}
		return prefix || get(crt).accept.size() != 0;
	}

	// O(min(|S|,|P|,M))
	public final List<Integer> prefix(final String str) { return prefix(str, 0, str.length()); }
	public final List<Integer> prefix(final char[] c) { return prefix(c, 0, c.length); }
	public final List<Integer> prefix(final int[] a) { return prefix(a, 0, a.length); }
	public final List<Integer> prefix(final String str, final int l, final int r) { return prefix(str.toCharArray(), l, r); }
	public final List<Integer> prefix(final char[] c, final int l, final int r) { return prefix(SimpleUtil.charToInt(c), l, r); }
	public final List<Integer> prefix(final int[] a, final int l, final int r) {
		SimpleUtil.inclusiveRangeCheck(l, a.length);
		SimpleUtil.inclusiveRangeCheck(r, a.length);
		SimpleUtil.assertion(l <= r, "l is larger than r.");
		List<Integer> prefix = new ArrayList<Integer>();
		int crt = 0;
		for(int i = l; i <= r; i ++) {
			for(int ele : get(crt).accept) prefix.add(ele);
			if(i == r) break;
			crt = get(crt).next[a[i]];
			if(crt == -1) break;
		}
		return prefix;
	}

	// O(min(|S|,|P|)+M)
	public final void query(final String str, final IntConsumer f) { query(str, f, 0, str.length()); }
	public final void query(final char[] c, final IntConsumer f) { query(c, f, 0, c.length); }
	public final void query(final int[] a, final IntConsumer f) { query(a, f, 0, a.length); }
	public final void query(final String str, final IntConsumer f, final int l, final int r) { query(str.toCharArray(), f, l, r); }
	public final void query(final char[] c, final IntConsumer f, final int l, final int r) { query(SimpleUtil.charToInt(c), f, l, r); }
	public final void query(final int[] a, final IntConsumer f, final int l, final int r) {
		int crt = 0;
		for(int i = l; i <= r; i ++) {
			for(int ele : get(crt).accept) f.accept(ele);
			if(i == r) break;
			crt = get(crt).next[a[i]];
			if(crt == -1) break;
		}
	}
	// O(min(|S|,|P|)+M)
	public final long query(final String str, final long e, final LongBinaryOperator f) { return query(str, e, f, 0, str.length()); }
	public final long query(final char[] c, final long e, final LongBinaryOperator f) { return query(c, e, f, 0, c.length); }
	public final long query(final int[] a, final long e, final LongBinaryOperator f) { return query(a, e, f, 0, a.length); }
	public final long query(final String str, final long e, final LongBinaryOperator f, final int l, final int r) { return query(str.toCharArray(), e, f, l, r); }
	public final long query(final char[] c, final long e, final LongBinaryOperator f, final int l, final int r) { return query(SimpleUtil.charToInt(c), e, f, l, r); }
	public final long query(final int[] a, final long e, final LongBinaryOperator f, final int l, final int r) {
		int crt = 0;
		long ans = e;
		for(int i = l; i <= r; i ++) {
			for(int ele : get(crt).accept) ans = f.applyAsLong(ans, ele);
			if(i == r) break;
			crt = get(crt).next[a[i]];
			if(crt != -1) break;
		}
		return ans;
	}

	public final int count() { return get(0).cnt; } // O(1)
}