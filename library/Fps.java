package library;

import java.util.*;
import library.SimpleUtil;
import library.Mod;
import library.Convolution;

class CnvFpsOperator extends FpsOperator {
	Convolution cnv;
	CnvFpsOperator(Convolution cnv) { super(cnv.md); this.cnv = cnv; }

	public final Fps butterfly(final Fps f) { return butterfly(f, f.a.length); }
	public final Fps butterfly(final Fps f, int l) { return butterflyEquals(resize(f, l)); }
	public final Fps butterflyEquals(final Fps f) { cnv.butterfly(f.a); return f; }
	public final Fps butterflyInv(final Fps f) { return butterflyInv(f, f.a.length); }
	public final Fps butterflyInv(final Fps f, int l) { return butterflyInvEquals(resize(f, l)); }
	public final Fps butterflyInvEquals(final Fps f) { cnv.butterflyInv(f.a); return f; }

	public final Fps mul(final Fps f, final Fps g, final int l) { return new Fps(this, cnv.cnv(f.a, g.a, l)); }
	public final Fps inv(final Fps f, final int l) {
		if(f.get(0) == 0) return null;
		if(l == 0) return zero(0);
		int m = 1;
		Fps g = zero(l);
		g.a[0] = md.inv(f.a[0]);
		long inv4 = md.inv(4);
		long div = md.mod(-1);
		while(m < l) {
			m <<= 1;
			Fps f1 = butterfly(f, m);
			Fps g1 = butterfly(g, m);
			mulElemwiseEquals(f1, g1);
			butterflyInvEquals(f1);
			m >>= 1;
			rshiftEquals(f1, m);
			butterflyEquals(f1);
			mulElemwiseEquals(f1, g1);
			butterflyInvEquals(f1);
			div = md.mul(div, inv4);
			f1 = resize(f1, Math.min(l - m, m));
			mulEquals(f1, div);
			System.arraycopy(f1.a, 0, g.a, m, f1.a.length);
			m <<= 1;
		}
		return g;
	}
	public final Fps div(final Fps f, final Fps g, final int l) { return mul(f, inv(g, l), l); }
	protected final Fps calPow(final Fps f, final long n, final int l) {
		return mulEquals(expEquals(mulEquals(log(div(f, f.a[0]), l), n)), md.pow(f.a[0], n));
	}
	public final Fps exp(Fps f, final int l) {
		if(f.get(0) != 0) return null;
		if(l == 0) return zero(0);
		int size = 1;
		Fps h = one(l);
		Fps diff = diff(f);
		Fps inv = one(l << 1);
		Fps btfInv = zero(0);
		long inv4 = md.inv(4);
		long invLen2 = md.mod(-1);
		long inv2 = md.inv(2);
		long invLen = 1;
		while(size < l) {
			Fps btf = resize(h, size << 1);
			butterflyEquals(btf);

			if(size > 1) {
				Fps g = mulElemwise(btf, btfInv, size);
				butterflyInvEquals(g);
				size >>= 1;
				rshiftEquals(g, size);
				butterflyEquals(g);
				mulElemwiseEquals(g, btfInv);
				butterflyInvEquals(g);
				invLen2 = md.mul(invLen2, inv4);
				mulEquals(g, invLen2);
				System.arraycopy(g.a, 0, inv.a, size, size);
				size <<= 1;
			}

			Fps t = diff(h, size);
			{
				Fps r = resize(diff, size);
				r.a[size - 1] = 0;
				butterflyEquals(r);
				mulElemwiseEquals(r, btf);
				butterflyInvEquals(r);
				mulEquals(r, - invLen);
				addEquals(r, t);
				t = lshift(r, 1, size);
				t.a[0] = r.a[size - 1];
			}
			size <<= 1;

			t = butterfly(resize(t, size));
			btfInv = butterfly(resize(inv, size));
			mulElemwiseEquals(t, btfInv);
			butterflyInvEquals(t);
			size >>= 1;
			invLen = md.mul(invLen, inv2);
			mulEquals(t, invLen);

			t = rshift(integ(lshift(resize(t, size), size - 1)), size);
			Fps v = zero(size << 1);
			if(size < f.a.length) System.arraycopy(f.a, size, v.a, 0, Math.min(f.a.length - size, size));
			subEquals(v, t);

			butterflyEquals(v);
			mulElemwiseEquals(v, btf);
			butterflyInvEquals(v);
			v = resize(v, Math.min(size, l - size));
			mulEquals(v, invLen);
			System.arraycopy(v.a, 0, h.a, size, v.a.length);
			size <<= 1;
		}
		return h;
	}
	public final Fps calSqrt(final Fps f, final int l) {
		return calNaiveSqrt(f, l);
	}
}

class NaiveFpsOperator extends FpsOperator {
	NaiveFpsOperator(Mod md) { super(md); }
	public final Fps mul(final Fps f, final Fps g, final int l) { return naiveMul(f, g, l); }
	public final Fps inv(final Fps f, final int l) { return naiveInv(f, l); }
	public final Fps div(final Fps f, final Fps g, final int l) { return naiveDiv(f, g, l); }
	protected final Fps calPow(final Fps f, final long n, final int l) { return calNaivePow(f, n, l); }
	public final Fps exp(final Fps f, final int l) { return naiveExp(f, l); }
	protected final Fps calSqrt(final Fps f, final int l) { return calNaiveSqrt(f, l); }
}

abstract class FpsOperator {
	public final Mod md;

	FpsOperator(Mod md) { this.md = md; }

	public final Fps zero(final int l) { return new Fps(this, l); }
	public final Fps one(final int l) { return setEquals(new Fps(this, l), 0, 1); }
	public final Fps constant(final long c, final int l) { return setEquals(new Fps(this, l), 0, c); }

	public final long eval(final Fps f, final long x) {
		long ans = 0;
		long pow = 1;
		for(int i = 0; i < f.a.length; i ++) {
			ans = md.add(ans, md.mul(f.a[i], pow));
			pow = md.mul(pow, x);
		}
		return ans;
	}

	public final Fps resize(final Fps f, final int l) { return new Fps(f, l); }
	public final Fps resizeEquals(final Fps f, final int l) { f.a = resize(f, l).a; return f; }
	public final Fps shrink(final Fps f) {
		for(int i = f.a.length - 1; i >= 0; i --) if(f.a[i] != 0) return resize(f, i + 1);
		return zero(0);
	}
	public final Fps shrink(final Fps f, final int l) { return shrink(l > f.a.length ? f : resize(f, l)); }
	public final Fps lshift(final Fps f, final int k) { return lshift(f, k, Math.max(0, f.a.length + k)); }
	public final Fps lshift(final Fps f, final int k, final int l) {
		if(k < 0) return rshift(f, - k, l);
		Fps g = zero(l);
		if(l > k) System.arraycopy(f.a, 0, g.a, k, Math.min(f.a.length, l - k));
		return g;
	}
	public final Fps lshiftEquals(final Fps f, final int k) { f.a = lshift(f, k, f.a.length).a; return f; }
	public final Fps rshift(final Fps f, final int k) { return rshift(f, k, Math.max(0, f.a.length - k)); }
	public final Fps rshift(final Fps f, final int k, final int l) {
		if(k < 0) return lshift(f, - k, l);
		Fps g = zero(l);
		if(f.a.length > k) System.arraycopy(f.a, k, g.a, 0, Math.min(f.a.length - k, l));
		return g;
	}
	public final Fps rshiftEquals(final Fps f, final int k) { f.a = rshift(f, k, f.a.length).a; return f; }
	public final Fps reverse(final Fps f) { return reverseEquals(new Fps(f)); }
	public final Fps reverseEquals(final Fps f) {
		for(int i = 0, j = f.a.length - 1; i < j; i ++, j --) {
			long tmp = f.a[i];
			f.a[i] = f.a[j];
			f.a[j] = tmp;
		}
		return f;
	}
	public final Fps negate(final Fps f) { return negate(f, f.a.length); }
	public final Fps negate(final Fps f, final int l) { return negateEquals(resize(f, l)); }
	public final Fps negateEquals(final Fps f) {
		for(int i = 0; i < f.a.length; i ++) f.a[i] = md.mod(- f.a[i]);
		return f;
	}

	public final Fps op(final Fps f, final int i, final LongUnaryOperator op) { return op(f, i, op, Math.max(f.a.length, i + 1)); }
	public final Fps op(final Fps f, final int i, final LongUnaryOperator op, final int l) { return opEquals(resize(f, l), i, op); }
	public final Fps opEquals(final Fps f, final int i, final LongUnaryOperator op) { f.a[i] = md.mod(op.applyAsLong(f.a[i])); return f; }
	public final Fps set(final Fps f, final int i, final long x) { return set(f, i, x, Math.max(f.a.length, i + 1)); }
	public final Fps set(final Fps f, final int i, final long x, final int l) { return setEquals(resize(f, l), i, x); }
	public final Fps setEquals(final Fps f, final int i, final long x) { f.a[i] = md.mod(x); return f; }
	public final Fps add(final Fps f, final int i, final long x) { return add(f, i, x, Math.max(f.a.length, i + 1)); }
	public final Fps add(final Fps f, final int i, final long x, final int l) { return addEquals(resize(f, l), i, x); }
	public final Fps addEquals(final Fps f, final int i, final long x) { f.a[i] = md.add(f.a[i], x); return f; }
	public final Fps sub(final Fps f, final int i, final long x) { return sub(f, i, x, Math.max(f.a.length, i + 1)); }
	public final Fps sub(final Fps f, final int i, final long x, final int l) { return subEquals(resize(f, l), i, x); }
	public final Fps subEquals(final Fps f, final int i, final long x) { f.a[i] = md.sub(f.a[i], x); return f; }
	public final Fps mul(final Fps f, final int i, final long x) { return mul(f, i, x, Math.max(f.a.length, i + 1)); }
	public final Fps mul(final Fps f, final int i, final long x, final int l) { return mulEquals(resize(f, l), i, x); }
	public final Fps mulEquals(final Fps f, final int i, final long x) { f.a[i] = md.mul(f.a[i], x); return f; }
	public final Fps div(final Fps f, final int i, final long x) { return div(f, i, x, Math.max(f.a.length, i + 1)); }
	public final Fps div(final Fps f, final int i, final long x, final int l) { return divEquals(resize(f, l), i, x); }
	public final Fps divEquals(final Fps f, final int i, final long x) { f.a[i] = md.div(f.a[i], x); return f; }

	public final Fps op(final Fps f, final LongUnaryOperator op) { return op(f, op, f.a.length); }
	public final Fps op(final Fps f, final LongUnaryOperator op, final int l) { return opEquals(resize(f, l), op); }
	public final Fps opEquals(final Fps f, final LongUnaryOperator op) { for(int i = 0; i < f.a.length; i ++) opEquals(f, i, op); return f; }
	public final Fps mul(final Fps f, final long x) { return mul(f, x, f.a.length); }
	public final Fps mul(final Fps f, final long x, final int l) { return mulEquals(resize(f, l), x); }
	public final Fps mulEquals(final Fps f, final long x) { for(int i = 0; i < f.a.length; i ++) f.a[i] = md.mul(f.a[i], x); return f; }
	public final Fps div(final Fps f, final long x) { return div(f, x, f.a.length); }
	public final Fps div(final Fps f, final long x, final int l) { return divEquals(resize(f, l), x); }
	public final Fps divEquals(final Fps f, final long x) { return mulEquals(f, md.inv(x)); }

	public final Fps add(final Fps f, final Fps g) { return add(f, g, Math.max(f.a.length, g.a.length)); }
	public final Fps add(final Fps f, final Fps g, final int l) { return addEquals(resize(f, l), g); }
	public final Fps addEquals(final Fps f, final Fps g) {
		for(int i = 0, l = Math.min(f.a.length, g.a.length); i < l; i ++) addEquals(f, i, g.a[i]);
		return f;
	}
	public final Fps sub(final Fps f, final Fps g) { return sub(f, g, Math.max(f.a.length, g.a.length)); }
	public final Fps sub(final Fps f, final Fps g, final int l) { return subEquals(resize(f, l), g); }
	public final Fps subEquals(final Fps f, final Fps g) {
		for(int i = 0, l = Math.min(f.a.length, g.a.length); i < l; i ++) subEquals(f, i, g.a[i]);
		return f;
	}
	public final Fps mulElemwise(final Fps f, final Fps g) { return mulElemwise(f, g, Math.min(f.a.length, g.a.length)); }
	public final Fps mulElemwise(final Fps f, final Fps g, final int l) { return mulElemwiseEquals(resize(f, l), g); }
	public final Fps mulElemwiseEquals(final Fps f, final Fps g) {
		for(int i = 0, l = Math.min(f.a.length, g.a.length); i < l; i ++) mulEquals(f, i, g.a[i]);
		for(int i = g.a.length; i < f.a.length; i ++) f.a[i] = 0;
		return f;
	}

	public final Fps mul(final Fps f, final Fps g) { return mul(f, g, f.a.length + g.a.length - 1); }
	public abstract Fps mul(final Fps f, final Fps g, final int l);
	public final Fps mulEquals(final Fps f, final Fps g) { f.a = mul(f, g, f.a.length).a; return f; }
	public final Fps mulShrink(final Fps f, final Fps g, final int l) { return shrink(mul(f, g, Math.min(l, f.a.length + g.a.length - 1))); }
	public final Fps inv(final Fps f) { return inv(f, f.a.length); }
	public abstract Fps inv(final Fps f, final int l);
	public final Fps invEquals(final Fps f) { f.a = inv(f, f.a.length).a; return f; }
	public final Fps div(final Fps f, final Fps g) { return div(f, g, f.a.length); }
	public abstract Fps div(final Fps f, final Fps g, final int l);
	public final Fps divEquals(final Fps f, final Fps g) { f.a = div(f, g).a; return f; }
	public final Fps divfloor(final Fps f, final Fps g) { return divfloor(f, g, Math.max(0, f.a.length - g.a.length + 1)); }
	public final Fps divfloor(final Fps f, final Fps g, final int l) {
		return resize(reverse(div(reverse(f), reverse(g), Math.max(0, f.a.length - g.a.length + 1))), l);
	}
	public final Fps divfloorEquals(final Fps f, final Fps g) { f.a = divfloor(f, g, f.a.length).a; return f; }
	public final Fps mod(final Fps f, final Fps g) { return mod(f, g, Math.min(f.a.length, g.a.length - 1)); }
	public final Fps mod(final Fps f, final Fps g, final int l) { return sub(f, mulShrink(divfloor(f, g), g, l), l); }
	public final Fps modEquals(final Fps f, final Fps g) { f.a = mod(f, g, f.a.length).a; return f; }
	public final Fps modShrink(final Fps f, final Fps g, final int l) { return shrink(mod(f, g, Math.min(l, Math.min(f.a.length, g.a.length - 1)))); }
	public final Fps pow(final Fps f, final long k) { return pow(f, k, f.a.length); }
	public final Fps pow(final Fps f, final long n, final int l) {
		if(l == 0) return zero(0);
		if(n == 0) return one(l);
		if(n == 1) return resize(f, l);
		if(n == 2) return mul(f, f, l);
		if(f.get(0) == 0) {
			int i = f.lowest();
			if(n < 0) return null;
			if(n * i >= l) return zero(l);
			return lshift(calPow(rshift(f, i), n, l - (int)n * i), (int)n * i);
		}
		if(n < 0) return invEquals(calPow(f, - n, l));
		return calPow(f, n, l);
	}
	protected abstract Fps calPow(final Fps f, final long k, final int l);
	public final Fps powEquals(final Fps f, final long k) { f.a = pow(f, k).a; return f; }
	public final Fps powShrink(final Fps f, final long k, final int l) { return shrink(pow(f, k, (int)Math.min(l, (f.a.length - 1) * k + 1))); }

	public final Fps naiveMul(final Fps f, final Fps g) { return naiveMul(f, g, f.a.length + g.a.length - 1); }
	public final Fps naiveMul(Fps f, Fps g, final int l) {
		f = shrink(f, l);
		g = shrink(g, l);
		Fps h = zero(l);
		for(int i = 0; i < l; i ++) {
			long sum = 0;
			for(int j = Math.max(0, i - g.a.length + 1), k = i - j, m = Math.min(f.a.length, i + 1); j < m; j ++, k --) {
				sum = md.add(sum, md.mul(f.a[j], g.a[k]));
			}
			h.a[i] = sum;
		}
		return h;
	}
	public final Fps naiveMulEquals(final Fps f, final Fps g) { f.a = naiveMul(f, g, f.a.length).a; return f; }
	public final Fps naiveMulShrink(final Fps f, final Fps g, final int l) { return shrink(naiveMul(f, g, Math.min(l, f.a.length + g.a.length - 1))); }
	public final Fps naiveInv(final Fps f) { return naiveInv(f, f.a.length); }
	public final Fps naiveInv(final Fps f, final int l) { return naiveDiv(one(1), f, l); }
	public final Fps naiveInvEquals(final Fps f) { f.a = naiveInv(f).a; return f; }
	public final Fps naiveDiv(final Fps f, final Fps g) { return naiveDiv(f, g, f.a.length); }
	public final Fps naiveDiv(Fps f, Fps g, final int l) {
		if(g.get(0) == 0) return null;
		if(l == 0) return zero(0);
		f = shrink(f, l);
		g = shrink(g, l);
		Fps h = resize(f, l);
		long div = md.inv(g.a[0]);
		for(int i = 0; i < l; i ++) {
			long sum = 0;
			for(int j = Math.max(0, i - g.a.length + 1), k = i - j; k > 0; j ++, k --) {
				sum = md.add(sum, md.mul(h.a[j], g.a[k]));
			}
			h.a[i] = md.mul(md.sub(h.a[i], sum), div);
		}
		return h;
	}
	public final Fps naiveDivEquals(final Fps f, final Fps g) { f.a = naiveDiv(f, g).a; return f; }
	public final Fps naivePow(final Fps f, final long n) { return naivePow(f, n, f.a.length); }
	public final Fps naivePow(Fps f, long n, final int l) {
		if(l == 0) return zero(0);
		if(n == 0) return one(l);
		if(n == 1) return resize(f, l);
		if(n == 2) return mul(f, f, l);
		if(f.get(0) == 0) {
			int i = f.lowest();
			if(n < 0) return null;
			if(n * i >= l) return zero(l);
			return lshift(calNaivePow(rshift(f, i), n, l - (int)n * i), (int)n * i);
		}
		if(n < 0) return naiveInvEquals(calNaivePow(f, - n, l));
		return calNaivePow(f, n, l);
	}
	protected final Fps calNaivePow(Fps f, long n, final int l) {
		f = shrink(f, l);
		long inv[] = md.invs(l);
		long div = md.inv(f.a[0]);
		for(int i = 0; i < l; i ++) inv[i] = md.mul(inv[i], div);
		Fps g = constant(md.pow(f.a[0], n), l);
		for(int i = 1; i < l; i ++) {
			long sum = 0;
			for(int j = 1, k = i - 1, m = Math.min(i, f.a.length - 1); j <= m; j ++, k --) {
				sum = md.add(sum, md.mul((n + 1) * j - i, f.a[j], g.a[k]));
			}
			g.a[i] = md.mul(sum, inv[i]);
		}
		return g;
	}
	public final Fps naivePowEquals(final Fps f, final long n) { f.a = naivePow(f, n).a; return f; }
	public final Fps binaryPow(final Fps f, final long n) { return binaryPow(f, n, f.a.length); }
	public final Fps binaryPow(final Fps f, long n, final int l) {
		if(l == 0) return zero(0);
		if(n == 0) return one(l);
		if(n == 1) return resize(f, l);
		if(n == 2) return mul(f, f, l);
		if(f.get(0) == 0) {
			int i = f.lowest();
			if(n < 0) return null;
			if(n * i >= l) return zero(l);
			return lshift(binaryPow(rshift(f, i), n, l - (int)n * i), (int)n * i);
		}
		if(n < 0) return invEquals(binaryPow(f, - n, l));
		Fps g = shrink(f, l);
		Fps h = one(1);
		while(true) {
			if((n & 1) != 0) h = mulShrink(h, g, l);
			n >>= 1;
			if(n == 0) return resize(h, l);
			g = mulShrink(g, g, l);
		}
	}
	public final Fps binaryPowEquals(final Fps f, final long n) { f.a = binaryPow(f, n).a; return f; }

	// f<-f*(1+cx^d) // O(N)
	public final Fps mulSparseEquals(final Fps f, final int d, long c) {
		if(c == 1) for(int i = f.a.length - 1; i >= d; i --) addEquals(f, i, f.a[i - d]);
		else if(c == -1) for(int i = f.a.length - 1; i >= d; i --) subEquals(f, i, f.a[i - d]);
		else {
			c = md.mod(c);
			for(int i = f.a.length - 1; i >= d; i --) addEquals(f, i, md.mul(f.a[i - d], c));
		}
		return f;
	}
	// f<-f/(1+cx^d) // O(N)
	public final Fps divSparseEquals(final Fps f, final int d, long c) {
		if(c == 1) for(int i = d; i < f.a.length; i ++) subEquals(f, i, f.a[i - d]);
		else if(c == -1) for(int i = d; i < f.a.length; i ++) addEquals(f, i, f.a[i - d]);
		else {
			c = md.mod(c);
			for(int i = d; i < f.a.length; i ++) subEquals(f, i, md.mul(f.a[i - d], c));
		}
		return f;
	}

	public final Fps diff(final Fps f) { return diff(f, Math.max(0, f.a.length - 1)); }
	public final Fps diff(final Fps f, final int l) {
		Fps g = zero(l);
		for(int i = 1, m = Math.min(l + 1, f.a.length); i < m; i ++) g.a[i - 1] = md.mul(f.a[i], i);
		return g;
	}
	public final Fps diffEquals(final Fps f) { f.a = diff(f, f.a.length).a; return f; }
	public final Fps integ(final Fps f) { return integ(f, f.a.length + 1); }
	public final Fps integ(final Fps f, final int l) {
		if(l == 0) return zero(0);
		Fps g = zero(l);
		long inv[] = md.invs(Math.min(l - 1, f.a.length));
		for(int i = 1; i < inv.length; i ++) g.a[i] = md.mul(f.a[i - 1], inv[i]);
		return g;
	}
	public final Fps integEquals(final Fps f) { f.a = integ(f, f.a.length).a; return f; }
	public final Fps log(final Fps f) { return log(f, f.a.length); }
	public final Fps log(final Fps f, final int l) {
		if(f.get(0) != 1) return null;
		return integEquals(divEquals(diff(f, l), f));
	}
	public final Fps logEquals(final Fps f) { f.a = log(f).a; return f; }
	public final Fps exp(final Fps f) { return exp(f, f.a.length); }
	public abstract Fps exp(final Fps f, final int l);
	public final Fps expEquals(final Fps f) { f.a = exp(f).a; return f; }
	public final Fps sqrt(final Fps f) { return sqrt(f, f.a.length); }
	public final Fps sqrt(final Fps f, final int l) {
		if(l == 0) return zero(0);
		if(f.get(0) == 0) {
			int i = f.lowest();
			if(i == f.a.length) return zero(l);
			if((i & 1) != 0) return null;
			if(i << 1 >= l) return zero(l);
			Fps g = calSqrt(rshift(f, i), l - (i >> 1));
			return g == null ? null : lshift(g, i >> 1);
		}
		return calSqrt(f, l);
	}
	protected abstract Fps calSqrt(final Fps f, final int l);
	public final Fps sqrtEquals(final Fps f) { f.a = sqrt(f).a; return f; }

	public final Fps naiveExp(final Fps f) { return naiveExp(f, f.a.length); }
	public final Fps naiveExp(Fps f, final int l) {
		if(f.get(0) != 0) return null;
		long inv[] = md.invs(l);
		f = shrink(f);
		Fps g = one(l);
		for(int i = 1; i < l; i ++) {
			long sum = 0;
			for(int j = 1, k = i - 1, m = Math.min(i, f.a.length - 1); j <= m; j ++, k --) {
				sum = md.add(sum, md.mul(j, f.a[j], g.a[k]));
			}
			g.a[i] = md.mul(sum, inv[i]);
		}
		return g;
	}
	public final Fps naiveExpEquals(final Fps f) { f.a = naiveExp(f).a; return f; }
	public final Fps naiveSqrt(final Fps f) { return naiveSqrt(f, f.a.length); }
	public final Fps naiveSqrt(final Fps f, final int l) {
		if(l == 0) return zero(0);
		if(f.get(0) == 0) {
			int i = f.lowest();
			if(i == f.a.length) return zero(l);
			if((i & 1) != 0) return null;
			if(i << 1 >= l) return zero(l);
			Fps g = calNaiveSqrt(rshift(f, i), l - (i >> 1));
			return g == null ? null : lshift(g, i >> 1);
		}
		return calNaiveSqrt(f, l);
	}
	protected final Fps calNaiveSqrt(final Fps f, final int l) {
		Fps g = resize(f, l);
		long inv[] = md.invs(l);
		long sqrt = md.sqrt(g.a[0]);
		if(sqrt == -1) return null;
		long div = md.inv(sqrt);
		mulEquals(g, md.div(div, 2));
		g.a[0] = sqrt;
		for(int i = 0; i < l; i ++) inv[i] = md.mul(inv[i], div);
		for(int i = 1; i < l; i ++) {
			long sum = 0;
			for(int j = 1, k = i - 1; j < i; j ++, k --) {
				sum = md.add(sum, md.mul(j, g.a[j], g.a[k]));
			}
			subEquals(g, i, md.mul(sum, inv[i]));
		}
		return g;
	}
	public final Fps naiveSqrtEquals(final Fps f) { f.a = naiveSqrt(f).a; return f; }

	// f <- 1/(1-f)=1+f+f^2+f^3+...=sum_{k=0}^inf f^k = 1/(1-f)
	public final Fps geomSeries(final Fps f) { return geomSeries(f, f.a.length); }
	public final Fps geomSeries(final Fps f, final int l) { return inv(add(negate(f), 0, 1), l); }
	public final Fps geomSeriesEquals(final Fps f) { f.a = geomSeries(f).a; return f; }
	// f <- (1-f^n)/(1-f)=1+f+f^2+...+f^(n-1)=sum_{k=0}^{n-1} f^k = (f^n-1)/(f-1)
	public final Fps geomPartialSeries(final Fps f, final int n) { return geomPartialSeries(f, n, f.a.length); }
	public final Fps geomPartialSeries(final Fps f, final int n, final int l) { return div(sub(powShrink(f, n, l), 0, 1), sub(f, 0, 1), l); }
	public final Fps geomPartialSeriesEquals(final Fps f, final int n) { f.a = geomPartialSeries(f, n).a; return f; }

	// return f(g)
	public final Fps composite(final Fps f, final Fps g) { return composite(f, g, f.a.length); }
	public final Fps composite(Fps f, Fps g, final int l) {
		if(l == 0) return zero(0);
		f = shrink(f);
		g = shrink(g);
		if(f.a.length == 0) return zero(l);
		if(g.a.length == 0) return constant(f.a[0], l);
		if(l == 1 || g.a.length == 1) return constant(eval(f, g.a[0]), l);

		int l2 = (int)Math.min(l, (long)(f.a.length - 1) * (g.a.length - 1) + 1);
		int m = Math.max((int)Math.ceil(Math.sqrt(l2)), 2);
		while(l2 > m * m) m ++;
		Fps pow[] = new Fps[m + 1];
		pow[0] = one(1);
		for(int i = 1; i <= m; i ++) pow[i] = mulShrink(pow[i - 1], g, l);

		Fps pow2[] = new Fps[m];
		pow2[0] = one(1);
		for(int i = 1; i < m; i ++) pow2[i] = mulShrink(pow2[i - 1], pow[m], l);

		Fps fg[] = new Fps[m];
		for(int i = 0; i < m; i ++) {
			fg[i] = zero(l);
			for(int j = 0; j < l; j ++) {
				long sum = 0;
				for(int k = 0, k2 = i * m, m2 = Math.min((i + 1) * m, f.a.length); k2 < m2; k ++, k2 ++) {
					if(j < pow[k].a.length) sum = md.add(sum, md.mul(f.a[k2], pow[k].a[j]));
				}
				fg[i].a[j] = sum;
			}
		}

		Fps h = zero(l);
		for(int i = 0; i < m; i ++) addEquals(h, mulShrink(fg[i], pow2[i], l));
		return h;
	}
	public final Fps compositeEquals(final Fps f, final Fps g) { f.a = composite(f, g).a; return f; }
	// return f(x+c)
	public final Fps addComposite(final Fps f, final long c) { return addComposite(f, c, f.a.length); }
	public final Fps addComposite(final Fps f, final long c, final int l) {
		Fps h = shrink(f, l);
		for(int i = 0; i < h.a.length; i ++) mulEquals(h, i, md.fact(i));
		reverseEquals(h);
		Fps g = one(h.a.length);
		for(int i = 1; i < g.a.length; i ++) g.a[i] = md.div(md.mul(g.a[i - 1], c), i);
		reverseEquals(mulEquals(h, g));
		for(int i = 0; i < h.a.length; i ++) mulEquals(h, i, md.invFact(i));
		return resize(h, l);
	}
	public final Fps addCompositeEquals(final Fps f, final long c) { f.a = addComposite(f, c).a; return f; }
	// return f(cx)
	// O(N)
	public final Fps mulComposite(final Fps f, final long c) { return mulComposite(f, c, f.a.length); }
	public final Fps mulComposite(final Fps f, final long c, final int l) { return mulCompositeEquals(resize(f, l), c); }
	public final Fps mulCompositeEquals(final Fps f, final long c) {
		long pow = 1;
		for(int i = 0; i < f.a.length; i ++) { mulEquals(f, i, pow); pow = md.mul(pow, c); }
		return f;
	}
	// return f(x^d)
	// O(N/d)
	public final Fps powComposite(final Fps f, final int d) { return powComposite(f, d, Math.max(0, f.a.length * d - d + 1)); }
	public final Fps powComposite(final Fps f, final int d, final int l) {
		SimpleUtil.nonNegativeCheck(d);
		if(d == 0) return constant(eval(f, 1), f.a.length);
		Fps g = zero(l);
		for(int i = 0, j = 0, m = Math.min(f.a.length, l / d + 1); i < m; i ++, j += d) g.a[j] = f.a[i];
		return g;
	}
	public final Fps powCompositeEquals(final Fps f, final int d) { f.a = powComposite(f, d).a; return f; }
	// return f(1+cx^d)
	public final Fps sparseComposite(final Fps f, final int d, final long c) { return sparseComposite(f, d, c, Math.max(0, f.a.length * d - d + 1)); }
	public final Fps sparseComposite(final Fps f, final int d, final long c, final int l) { return powCompositeEquals(mulCompositeEquals(addComposite(f, 1, l), c), d); }
	public final Fps sparseCompositeEquals(final Fps f, final int d, final long c) { f.a = sparseComposite(f, d, c).a; return f; }
}

class Fps implements Comparable<Fps> {
	private final FpsOperator op;
	public long a[];

	Fps(final FpsOperator op, final int l) { SimpleUtil.nonNegativeCheck(l); this.op = op; a = new long[l]; }
	Fps(final FpsOperator op, final int l, final long x) { this(op, l); Arrays.fill(a, op.md.mod(x)); }
	Fps(final FpsOperator op, final long[] a, final int l) { this(op, l); System.arraycopy(a, 0, this.a, 0, Math.min(a.length, l)); }
	Fps(final FpsOperator op, final long[] a) { this(op, a, a.length); }
	Fps(final FpsOperator op, final Fps g, final int l) { this(op, g.a, l); }
	Fps(final FpsOperator op, final Fps g) { this(op, g.a); }
	Fps(final Fps g, final int l) { this(g.op, g.a, l); }
	Fps(final Fps g) { this(g.op, g.a); }

	public int size() { return a.length; }
	public long[] get() { return a; }
	public long get(final int i) { return i < a.length ? a[i] : 0; }

	public int lowest() { for(int i = 0; i < a.length; i ++) if(a[i] != 0) return i; return a.length; }

	@Override public String toString() { return Arrays.toString(a); }
	@Override public int hashCode() { return Arrays.hashCode(a); }
	@Override
	public boolean equals(final Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Fps that = (Fps) obj;
		if(!Arrays.equals(a, that.a)) return false;
		return true;
	}
	@Override
	public int compareTo(final Fps that) { return Arrays.compare(a, that.a); }
}