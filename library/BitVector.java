package library;

import library.SimpleUtil;

class BitVector {
	final int lg = 5;
	final int bitSize = 1 << lg;
	final int mask = bitSize - 1;
	final int n;
	final int len;
	int bit[];
	int sum[];
	int head0[];
	int head1[];
	int pos0[];
	int pos1[];

	// O(1)
	BitVector(int n) {
		this.n = n;
		len = (n >> lg) + 1;
		bit = new int[len];
		sum = new int[len + 1];
		pos0 = new int[len];
		pos1 = new int[len];
	}

	// O(N)
	final void init(boolean b[]) {
		for(int i = 0, j = 0; i < b.length; i += bitSize, j ++) {
			bit[j] = 0;
			for(int i2 = min(b.length, i + bitSize) - 1; i2 >= i; i2 --) {
				bit[j] <<= 1;
				if(b[i2]) bit[j] |= 1;
			}
		}
		init();
	}
	final void init() {
		sum[0] = 0;
		for(int i = 0; i < len; i ++) sum[i + 1] = sum[i] + Integer.bitCount(bit[i]);

		{
			int size = 0;
			for(int i = 0, cnt = 0; i < n; i ++) if(get(i) && ((cnt ++) & mask) == 0) size ++;
			head1 = new int[++ size];
			size = 0;
			for(int i = 0, cnt = 0; i < n; i ++) if(get(i) && ((cnt ++) & mask) == 0) head1[size ++] = i;
			head1[size] = n;
			for(int i = 0; i < size; i ++) {
				int l = head1[i] >> lg;
				if((head1[i + 1] + mask >> lg) - l > bitSize) {
					for(int j = head1[i], idx = 0; j < head1[i + 1]; j ++) if(get(j)) pos1[l + (idx ++)] = j;
				}
			}
		}
		{
			int size = 0;
			for(int i = 0, cnt = 0; i < n; i ++) if(!get(i) && ((cnt ++) & mask) == 0) size ++;
			head0 = new int[++ size];
			size = 0;
			for(int i = 0, cnt = 0; i < n; i ++) if(!get(i) && ((cnt ++) & mask) == 0) head0[size ++] = i;
			head0[size] = n;
			for(int i = 0; i < size; i ++) {
				int l = head0[i] >> lg;
				if((head0[i + 1] + mask >> lg) - l > bitSize) {
					for(int j = head0[i], idx = 0; j < head0[i + 1]; j ++) if(!get(j)) pos0[l + (idx ++)] = j;
				}
			}
		}
	}

	StringBuilder sb = new StringBuilder();
	// O(N)
	@Override public String toString() {
		sb.setLength(0);
		for(int i = 0; i < n; i ++) sb.append(booleanToChar(get(i)));
		return sb.toString();
	}

	// O(1)
	final boolean get(int k) { SimpleUtil.rangeCheck(k, n); return (bit[k >> lg] >> (k & mask) & 1) != 0; }

	// O(1)
	final void set(int k) { set(true, k); }
	final void set(boolean b, int k) { SimpleUtil.rangeCheck(k, n); if(b) bit[k >> lg] |= 1 << (k & mask); else bit[k >> lg] &= ~(1 << (k & mask)); }

	// O(loglogN)
	// count b in [0, k)
	final int rank(int k) { SimpleUtil.inclusiveRangeCheck(k, n); return sum[k >> lg] + Integer.bitCount(bit[k >> lg] & ((1 << (k & mask)) - 1)); }
	final int rank(boolean b, int k) { return b ? rank(k) : k - rank(k); }

	// O(loglogN)
	// position of k-th occurrence of b
	final int select(int k) { return select(true, k); }
	final int select(boolean b, int k) {
		if(k >= (b ? sum[len] : n - sum[len])) return n;
		int l = (b ? head1 : head0)[k >> lg] >> lg;
		int r = (b ? head1 : head0)[(k >> lg) + 1] + mask >> lg;
		if(r - l > bitSize) return (b ? pos1 : pos0)[l + (k & mask)];
		while(r - l != 1) {
			int m = (l + r) >> 1;
			if((b ? sum[m] : (m << lg) - sum[m]) <= k) l = m; else r = m;
		}
		return (l << lg) + (b ? select32(bit[l], k - sum[l]) : select32(~bit[l], k + sum[l] - (l << lg)));
	}
	final int select32(int c, int k) {
		k ++;
		int c2 = (c & 0x55555555) + (c >> 1 & 0x55555555);
		int c4 = (c2 & 0x33333333) + (c2 >> 2 & 0x33333333);
		int c8 = (c4 + (c4 >> 4)) & 0x0F0F0F0F;
		int c16 = (c8 + (c8 >> 8)) & 0x000000FF;
		int idx = 0;
		idx |= ((c16 - k) & 128) >> 3;
		k -= c16 & ((c16 - k) >> 7);
		c8 = c8 >> idx & 0xf;
		idx |= ((c8 - k) & 128) >> 4;
		k -= c8 & ((c8 - k) >> 7);
		c4 = c4 >> idx & 0x7;
		idx |= ((c4 - k) & 128) >> 5;
		k -= c4 & ((c4 - k) >> 7);
		c2 = c2 >> idx & 0x3;
		idx |= ((c2 - k) & 128) >> 6;
		k -= c2 & ((c2 - k) >> 7);
		idx |= (((c >> idx & 0x1) - k) & 128) >> 7;
		return idx;
	}
}