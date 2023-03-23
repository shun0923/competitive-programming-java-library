package library;

import library.FastInputStream;
import library.FastOutputStream;

class FastIO {
	public static boolean DEBUG;

	private static final FastInputStream in = new FastInputStream(System.in);
	public static final String nline() { return in.nextLine(); }
	public static final String[] nline(final int n) { final String a[] = new String[n]; for(int i = 0; i < n; i ++) a[i] = nline(); return a; }
	public static final char nc() { return in.nextChar(); }
	public static final char[] nc(int n) {
		if(n >= 0) {
			final char a[] = new char[n];
			for(int i = 0; i < n; i ++) a[i] = nc();
			return a;
		}else {
			final String str = ns();
			n = str.length();
			final char a[] = new char[n];
			for(int i = 0; i < n; i ++) a[i] = str.charAt(i);
			return a;
		}
	}
	public static final char[][] nc(final int n, final int m) { final char a[][] = new char[n][m]; for(int i = 0; i < n; i ++) a[i] = nc(m); return a; }
	public static final boolean[] nb(int n, final char t) {
		final char c[] = nc(n);
		if(n < 0) n = c.length;
		final boolean a[] = new boolean[n];
		for(int i = 0; i < n; i ++) a[i] = c[i] == t;
		return a;
	}
	public static final boolean[][] nb(final int n, final int m, final char t) { final boolean a[][] = new boolean[n][]; for(int i = 0; i < n; i ++) a[i] = nb(m, t); return a; }
	public static final int ni() { return in.nextInt(); }
	public static final int[] ni(final int n) { final int a[] = new int[n]; for(int i = 0; i < n; i ++) a[i] = ni(); return a; }
	public static final int[][] ni(final int n, final int m) { final int a[][] = new int[n][]; for(int i = 0; i < n; i ++) a[i] = ni(m); return a; }
	public static final long nl() { return in.nextLong(); }
	public static final long[] nl(final int n) { final long a[] = new long[n]; for(int i = 0; i < n; i ++) a[i] = nl(); return a; }
	public static final long[][] nl(final int n, final int m) { final long a[][] = new long[n][]; for(int i = 0; i < n; i ++) a[i] = nl(m); return a; }
	public static final double nd() { return in.nextDouble(); }
	public static final double[] nd(final int n) { final double a[] = new double[n]; for(int i = 0; i < n; i ++) a[i] = nd(); return a; }
	public static final double[][] nd(final int n, final int m) { final double a[][] = new double[n][]; for(int i = 0; i < n; i ++) a[i] = nd(m); return a; }
	public static final String ns() { return in.next(); }
	public static final String[] ns(final int n) { final String a[] = new String[n]; for(int i = 0; i < n; i ++) a[i] = ns(); return a; }
	public static final String[][] ns(final int n, final int m) { final String a[][] = new String[n][]; for(int i = 0; i < n; i ++) a[i] = ns(m); return a; }

	private static final FastOutputStream out = new FastOutputStream(System.out);
	private static final FastOutputStream err = new FastOutputStream(System.err);
	public static final void prt() { out.print(); }
	public static final void prt(final char c) { out.print(c); }
	public static final void prt(final boolean b) { out.print(b); }
	public static final void prt(final int x) { out.print(x); }
	public static final void prt(final long x) { out.print(x); }
	public static final void prt(final double d) { out.print(d); }
	public static final void prt(final String s) { out.print(s); }
	public static final void prt(final Object o) { out.print(o); }
	public static final void prtln() { out.println(); }
	public static final void prtln(final char c) { out.println(c); }
	public static final void prtln(final boolean b) { out.println(b); }
	public static final void prtln(final int x) { out.println(x); }
	public static final void prtln(final long x) { out.println(x); }
	public static final void prtln(final double d) { out.println(d); }
	public static final void prtln(final String s) { out.println(s); }
	public static final void prtln(final Object o) { out.println(o); }
	public static final void prtln(final char... a) { out.println(a); }
	public static final void prtln(final boolean... a) { out.println(booleanToChar(a)); }
	public static final void prtln(final int... a) { out.println(a); }
	public static final void prtln(final long... a) { out.println(a); }
	public static final void prtln(final double... a) { out.println(a); }
	public static final void prtln(final double[] a, int precision) { out.println(a, precision); }
	public static final void prtln(final String... a) { out.println(a); }
	public static final void prtln(final Object[] a) { out.println(a); }
	public static final void prtlns(final char... a) { for(char ele : a) prtln(ele); }
	public static final void prtlns(final boolean... a) { for(boolean ele : a) prtln(ele); }
	public static final void prtlns(final int... a) { for(int ele : a) prtln(ele); }
	public static final void prtlns(final long... a) { for(long ele : a) prtln(ele); }
	public static final void prtlns(final double... a) { for(double ele : a) prtln(ele); }
	public static final void prtlns(final Object[] a) { for(Object ele : a) prtln(ele); }
	public static final void prtln(final char[][] a) { for(char[] ele : a) prtln(ele); }
	public static final void prtln(final boolean[][] a) { for(boolean[] ele : a) prtln(ele); }
	public static final void prtln(final int[][] a) { for(int[] ele : a) prtln(ele); }
	public static final void prtln(final long[][] a) { for(long[] ele : a) prtln(ele); }
	public static final void prtln(final double[][] a) { for(double[] ele : a) prtln(ele); }
	public static final void prtln(final double[][] a, int precision) { for(double[] ele : a) prtln(ele, precision); }
	public static final void prtln(final String[][] a) { for(String[] ele : a) prtln(ele); }
	public static final void prtln(final Object[][] a) { for(Object[] ele : a) prtln(ele); }

	public static final void errprt() { if(DEBUG) err.print(); }
	public static final void errprt(final char c) { if(DEBUG) err.print(c); }
	public static final void errprt(final boolean b) { if(DEBUG) err.print(booleanToChar(b)); }
	public static final void errprt(final int x) { if(DEBUG) if(isINF(x)) err.print('_'); else err.print(x); }
	public static final void errprt(final long x) { if(DEBUG) if(isINF(x)) err.print('_'); else err.print(x); }
	public static final void errprt(final double d) { if(DEBUG) err.print(d); }
	public static final void errprt(final String s) { if(DEBUG) err.print(s); }
	public static final void errprt(final Object o) { if(DEBUG) err.print(o); }
	public static final void errprtln() { if(DEBUG) err.println(); }
	public static final void errprtln(final char c) { if(DEBUG) err.println(c); }
	public static final void errprtln(final boolean b) { if(DEBUG) err.println(booleanToChar(b)); }
	public static final void errprtln(final int x) { if(DEBUG) if(isINF(x)) err.println('_'); else err.println(x); }
	public static final void errprtln(final long x) { if(DEBUG) if(isINF(x)) err.println('_'); else err.println(x); }
	public static final void errprtln(final double d) { if(DEBUG) err.println(d); }
	public static final void errprtln(final String s) { if(DEBUG) err.println(s); }
	public static final void errprtln(final Object o) { if(DEBUG) err.println(o); }
	public static final void errprtln(final char... a) { if(DEBUG) err.println(a); }
	public static final void errprtln(final boolean... a) { if(DEBUG) err.println(booleanToChar(a)); }
	public static final void errprtln(final int... a) {
		if(DEBUG) {
			boolean start = false;
			for(int ele : a) {
				errprt(ele);
				if(!start) errprt(' ');
				start = false;
			}
			err.println();
		}
	}
	public static final void errprtln(final long... a) {
		if(DEBUG) {
			boolean start = false;
			for(long ele : a) {
				errprt(ele);
				if(!start) errprt(' ');
				start = false;
			}
			err.println();
		}
	}
	public static final void errprtln(final double... a) { if(DEBUG) err.println(a); }
	public static final void errprtln(final double[] a, final int precision) { if(DEBUG) err.println(a, precision); }
	public static final void errprtln(final String... a) { if(DEBUG) err.println(a); }
	public static final void errprtln(final Object[] a) { if(DEBUG) err.println(a); }
	public static final void errprtlns(final char... a) { if(DEBUG) for(char ele : a) errprtln(ele); }
	public static final void errprtlns(final boolean... a) { if(DEBUG) for(boolean ele : a) errprtln(ele); }
	public static final void errprtlns(final int... a) { if(DEBUG) for(int ele : a) errprtln(ele); }
	public static final void errprtlns(final long... a) { if(DEBUG) for(long ele : a) errprtln(ele); }
	public static final void errprtlns(final double... a) { if(DEBUG) for(double ele : a) errprtln(ele); }
	public static final void errprtlns(final Object[] a) { if(DEBUG) for(Object ele : a) errprtln(ele); }
	public static final void errprtln(final char[][] a) { if(DEBUG) for(char[] ele : a) errprtln(ele); }
	public static final void errprtln(final boolean[][] a) { if(DEBUG) for(boolean[] ele : a) errprtln(ele); }
	public static final void errprtln(final int[][] a) { if(DEBUG) for(int[] ele : a) errprtln(ele); }
	public static final void errprtln(final long[][] a) { if(DEBUG) for(long[] ele : a) errprtln(ele); }
	public static final void errprtln(final double[][] a) { if(DEBUG) for(double[] ele : a) errprtln(ele); }
	public static final void errprtln(final double[][] a, int precision) { if(DEBUG) for(double[] ele : a) errprtln(ele, precision); }
	public static final void errprtln(final String[][] a) { if(DEBUG) for(String[] ele : a) errprtln(ele); }
	public static final void errprtln(final Object[][] a) { if(DEBUG) for(Object[] ele : a) errprtln(ele); }
	public static final void errprtlns(final Object[][] a) { if(DEBUG) for(Object[] ele : a) { errprtlns(ele); errprtln(); } }

	public static final void reply(final boolean b) { prtln(b ? "Yes" : "No"); }
	public static final void REPLY(final boolean b) { prtln(b ? "YES" : "NO"); }

	public static final void flush() { out.flush(); if(DEBUG) err.flush(); }
	public static final void assertion(final boolean b) { if(!b) { flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final char c) { if(!b) { errprtln(c); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final boolean b2) { if(!b) { errprtln(b2); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final int x) { if(!b) { errprtln(x); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final long x) { if(!b) { errprtln(x); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final double d) { if(!b) { errprtln(d); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final String s) { if(!b) { errprtln(s); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final Object o) { if(!b) { errprtln(o); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final char... a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final boolean... a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final int... a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final long... a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final double... a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final String... a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final Object[] a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final char[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final boolean[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final int[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final long[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final double[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final String[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void assertion(final boolean b, final Object[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }
	public static final void inclusiveRangeCheck(final int i, final int max) { inclusiveRangeCheck(i, 0, max); }
	public static final void inclusiveRangeCheck(final int i, final int min, final int max) { rangeCheck(i, min, max + 1); }
	public static final void inclusiveRangeCheck(final long i, final long max) { inclusiveRangeCheck(i, 0, max); }
	public static final void inclusiveRangeCheck(final long i, final long min, final long max) { rangeCheck(i, min, max + 1); }
	public static final void rangeCheck(final int i, final int max) { rangeCheck(i, 0, max); }
	public static final void rangeCheck(final int i, final int min, final int max) { if(i < min || i >= max) throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", i, max)); }
	public static final void rangeCheck(final long i, final long max) { rangeCheck(i, 0, max); }
	public static final void rangeCheck(final long i, final long min, final long max) { if(i < min || i >= max) throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", i, max)); }
	public static final void nonNegativeCheck(final long x) { nonNegativeCheck(x, "the argument"); }
	public static final void nonNegativeCheck(final long x, final String attribute) { if(x < 0) throw new IllegalArgumentException(String.format("%s %d is negative", attribute, x)); }
	public static final void positiveCheck(final long x) { positiveCheck(x, "the argument"); }
	public static final void positiveCheck(final long x, final String attribute) { if(x <= 0) throw new IllegalArgumentException(String.format("%s %d is negative", attribute, x)); }

	public static final void exit() { flush(); System.exit(0); }
	public static final void exit(final char c) { prtln(c); exit(); }
	public static final void exit(final boolean b) { prtln(b); exit(); }
	public static final void exit(final int x) { prtln(x); exit(); }
	public static final void exit(final long x) { prtln(x); exit(); }
	public static final void exit(final double d) { prtln(d); exit(); }
	public static final void exit(final String s) { prtln(s); exit(); }
	public static final void exit(final Object o) { prtln(o); exit(); }
	public static final void exit(final char... a) { prtln(a); exit(); }
	public static final void exit(final boolean... a) { prtln(a); exit(); }
	public static final void exit(final int... a) { prtln(a); exit(); }
	public static final void exit(final long... a) { prtln(a); exit(); }
	public static final void exit(final double... a) { prtln(a); exit(); }
	public static final void exit(final String... a) { prtln(a); exit(); }
	public static final void exit(final Object[] a) { prtln(a); exit(); }
	public static final void exit(final char[][] a) { prtln(a); exit(); }
	public static final void exit(final boolean[][] a) { prtln(a); exit(); }
	public static final void exit(final int[][] a) { prtln(a); exit(); }
	public static final void exit(final long[][] a) { prtln(a); exit(); }
	public static final void exit(final double[][] a) { prtln(a); exit(); }
	public static final void exit(final String[][] a) { prtln(a); exit(); }
	public static final void exit(final Object[][] a) { prtln(a); exit(); }

	public static final char booleanToChar(final boolean b) { return b ? '#' : '.'; }
	public static final char[] booleanToChar(final boolean... a) {
		final char c[] = new char[a.length];
		for(int i = 0; i < a.length; i ++) c[i] = booleanToChar(a[i]);
		return c;
	}
	public static final int[] charToInt(char[] c) {
		final int a[] = new int[c.length];
		for(int i = 0; i < c.length; i ++) {
			if('a' <= c[i] && c[i] <= 'z') a[i] = c[i] - 'a';
			else if('A' <= c[i] && c[i] <= 'Z') a[i] = c[i] - 'A';
			else if('0' <= c[i] && c[i] <= '9') a[i] = c[i] - '0';
			else a[i] = c[i];
		}
		return a;
	}

	public static final long INF = (long)4e18;
	public static final boolean isPlusINF(final long x) { return x > INF / 10; }
	public static final boolean isMinusINF(final long x) { return isPlusINF(- x); }
	public static final boolean isINF(final long x) { return isPlusINF(x) || isMinusINF(x); }
	public static final int I_INF = (int)1e9 + 1000;
	public static final boolean isPlusINF(final int x) { return x > I_INF / 10; }
	public static final boolean isMinusINF(final int x) { return isPlusINF(- x); }
	public static final boolean isINF(final int x) { return isPlusINF(x) || isMinusINF(x); }
}