package library;

import library.SimpleUtil;

class Pair extends SimpleUtil {
	// Pair
	public static final II npii() { return new II(ni(), ni()); }
	public static final II[] npii(final int n) { final II a[] = new II[n]; for(int i = 0; i < n; i ++) a[i] = npii(); return a; }
	public static final IL npil() { return new IL(ni(), nl()); }
	public static final IL[] npil(final int n) { final IL a[] = new IL[n]; for(int i = 0; i < n; i ++) a[i] = npil(); return a; }
	public static final LI npli() { return new LI(nl(), ni()); }
	public static final LI[] npli(final int n) { final LI a[] = new LI[n]; for(int i = 0; i < n; i ++) a[i] = npli(); return a; }
	public static final LL npll() { return new LL(nl(), nl()); }
	public static final LL[] npll(final int n) { final LL a[] = new LL[n]; for(int i = 0; i < n; i ++) a[i] = npll(); return a; }
	public static final ID npid() { return new ID(ni(), nd()); }
	public static final ID[] npid(final int n) { final ID a[] = new ID[n]; for(int i = 0; i < n; i ++) a[i] = npid(); return a; }
	public static final LD npld() { return new LD(nl(), nd()); }
	public static final LD[] npld(final int n) { final LD a[] = new LD[n]; for(int i = 0; i < n; i ++) a[i] = npld(); return a; }
	public static final DI npdi() { return new DI(nd(), ni()); }
	public static final DI[] npdi(final int n) { final DI a[] = new DI[n]; for(int i = 0; i < n; i ++) a[i] = npdi(); return a; }
	public static final DL npdl() { return new DL(nd(), nl()); }
	public static final DL[] npdl(final int n) { final DL a[] = new DL[n]; for(int i = 0; i < n; i ++) a[i] = npdl(); return a; }
	public static final DD npdd() { return new DD(nd(), nd()); }
	public static final DD[] npdd(final int n) { final DD a[] = new DD[n]; for(int i = 0; i < n; i ++) a[i] = npdd(); return a; }
	public static final class TT<T extends Comparable<? super T>, U extends Comparable<? super U>> implements Comparable<TT<T, U>> {
		public T a; public U b;
		public TT() { }
		public TT(final T a, final U b) { this.a = a; this.b = b; }

		@Override public final String toString() { return "("+a.toString()+", "+b.toString()+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public final boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			TT that = (TT) obj;
			if(this.a.getClass() != that.a.getClass()) return false;
			if(this.b.getClass() != that.b.getClass()) return false;
			if(!this.a.equals(that.a)) return false;
			if(!this.b.equals(that.b)) return false;
			return true;
		}
		@Override public final int compareTo(final TT<T, U> that) { int c = (this.a).compareTo(that.a); if(c == 0) c = (this.b).compareTo(that.b); return c; }
	}
	public static final class II implements Comparable<II> {
		public int a; public int b;
		public II() { }
		public II(final int a, final int b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			II that = (II) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final II that) { int c = Integer.compare(this.a, that.a); if(c == 0) c = Integer.compare(this.b, that.b); return c; }
	}
	public static final class IL implements Comparable<IL> {
		public int a; public long b;
		public IL() { }
		public IL(final int a, final long b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			IL that = (IL) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final IL that) { int c = Integer.compare(this.a, that.a); if(c == 0) c = Long.compare(this.b, that.b); return c; }
	}
	public static final class LI implements Comparable<LI> {
		public long a; public int b;
		public LI() { }
		public LI(final long a, final int b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			LI that = (LI) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final LI that) { int c = Long.compare(this.a, that.a); if(c == 0) c = Integer.compare(this.b, that.b); return c; }
	}
	public static final class LL implements Comparable<LL> {
		public long a; public long b;
		public LL() { }
		public LL(final long a, final long b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			LL that = (LL) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final LL that) { int c = Long.compare(this.a, that.a); if(c == 0) c = Long.compare(this.b, that.b); return c; }
	}
	public static final class ID implements Comparable<ID> {
		public int a; public double b;
		public ID() { }
		public ID(final int a, final double b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			ID that = (ID) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final ID that) { int c = Integer.compare(this.a, that.a); if(c == 0) c = Double.compare(this.b, that.b); return c; }
	}
	public static final class LD implements Comparable<LD> {
		public long a; public double b;
		public LD() { }
		public LD(final long a, final double b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			LD that = (LD) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final LD that) { int c = Long.compare(this.a, that.a); if(c == 0) c = Double.compare(this.b, that.b); return c; }
	}
	public static final class DI implements Comparable<DI> {
		public double a; public int b;
		public DI() { }
		public DI(final double a, final int b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			DI that = (DI) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final DI that) { int c = Double.compare(this.a, that.a); if(c == 0) c = Integer.compare(this.b, that.b); return c; }
	}
	public static final class DL implements Comparable<DL> {
		public double a; public long b;
		public DL() { }
		public DL(final double a, final long b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			DL that = (DL) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final DL that) { int c = Double.compare(this.a, that.a); if(c == 0) c = Long.compare(this.b, that.b); return c; }
	}
	public static final class DD implements Comparable<DD> {
		public double a; public double b;
		public DD() { }
		public DD(final double a, final double b) { this.a = a; this.b = b; }
		@Override public final String toString() { return "("+a+", "+b+")"; }
		@Override public final int hashCode() { return Objects.hash(a, b); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			DD that = (DD) obj;
			if(this.a != that.a || this.b != that.b) return false;
			return true;
		}
		@Override public final int compareTo(final DD that) { int c = Double.compare(this.a, that.a); if(c == 0) c = Double.compare(this.b, that.b); return c; }
	}
}