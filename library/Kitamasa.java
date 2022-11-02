package library;

import library.Fps;
import library.Convolution;

class Kitamasa {
		// O(LlogLlogN)
	// return a_n
	// a_k = sum c_i a_(k-i-1)
	public static final long cal(FpsOperator op, long[] a, long[] c, long n) {
		if(n < a.length) return a[(int)n];
		Fps q = op.lshift(new Fps(op, c), 1).negate().set(0, 1);
		if(a.length < q.size() - 1) return -1;
		Fps p = new Fps(op, a, q.size() - 1).mul(q);
		return linearRecurrence(op, p, q, n);
	}
	
	// return [x^n] p/q
	public static final long linearRecurrence(final FpsOperator op, Fps p, Fps q, final long n) {
		q = op.shrink(q);
		long ans = 0;
		if(p.size() >= q.size()) {
			Fps r = op.divfloor(p, q);
			if(n < r.size()) ans = r.a[(int)n];
			p.sub(r.mul(q));
			p = op.shrink(p);
		}
		if(p.size() == 0) return ans;
		return op.md.add(ans, calLinearRecurrence(op, p, q, n));
	}
	public static final long calLinearRecurrence(final CnvFpsOperator op, Fps p, Fps q, long n) {
		Mod md = op.md;
		int size = 1;
		int log = 0;
		while(size < q.size()) { size <<= 1; log ++; }
		Fps f = op.butterfly(p, size << 1);
		Fps g = op.butterfly(q, size << 1);

		int btr[] = new int[size];
		for(int i = 0; i < size; i ++) btr[i] = (btr[i >> 1] >> 1) + ((i & 1) << (log - 1));
		long dw = md.pow(md.inv(md.primitiveRoot()), (md.MOD - 1) / (size << 1));

		while(n > 0) {
			long inv2 = md.inv(2);
			long t[] = new long[size];
			for(int i = 0; i < size; i ++) t[i] = md.mul(g.a[(i << 1) | 0], g.a[(i << 1) | 1]);
			long s[] = new long[size];
			if((n & 1) != 0) {
				for(int i : btr) {
					s[i] = md.sub(md.mul(f.a[i << 1], g.a[(i << 1) | 1]), md.mul(f.a[(i << 1) | 1], g.a[i << 1]));
					s[i] = md.mul(s[i], inv2);
					inv2 = md.mul(inv2, dw);
				}
			}else {
				for(int i = 0; i < size; i ++) {
					s[i] = md.add(md.mul(f.a[i << 1], g.a[(i << 1) | 1]), md.mul(f.a[(i << 1) | 1], g.a[i << 1]));
					s[i] = md.mul(s[i], inv2);
				}
			}
			f.a = s;
			g.a = t;
			n >>= 1;
			if(n < size) break;
			op.doublingEquals(f);
			op.doublingEquals(g);
		}
		p = op.butterflyInv(f);
		q = op.butterflyInv(g);
		return op.div(p, q).get((int)n);
	}
	public static final long calLinearRecurrence(final FpsOperator op, Fps p, final Fps q, long n) {
		p = op.resize(p, q.size() - 1);
		while(n != 0) {
			Fps q2 = new Fps(q);
			for(int i = 1; i < q2.size(); i += 2) q2.mul(i, -1l);
			Fps s = op.mul(p, q2);
			Fps t = op.mul(q, q2);
			for(int i = (int)(n & 1); i < s.size(); i += 2) p.a[i >> 1] = s.a[i];
			for(int i = 0; i < t.size(); i += 2) q.a[i >> 1] = t.a[i];
			n >>= 1;
		}
		return p.a[0];
	}
}