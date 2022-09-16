package library;

import java.util.*;
import java.math.*;
import java.util.function.*;

abstract public class Util implements Runnable {
	@Override
	public void run() { solve(); flush(); }

	abstract public void solve();

	public static boolean DEBUG;

	private static final FastInputStream in = new FastInputStream(System.in);
	public static final String nline() { return in.nextLine(); }
	public static final String[] nline(final int n) { final String a[] = new String[n]; for(int i = 0; i < n; i ++) a[i] = nline(); return a; }
	public static final char nc() { return in.nextChar(); }
	public static final char[] nc(int n) {
		final String str = nline();
		if(n < 0) n = str.length();
		final char a[] = new char[n];
		for(int i = 0; i < n; i ++) a[i] = str.charAt(i);
		return a;
	}
	public static final char[][] nc(final int n, final int m) { final char a[][] = new char[n][m]; for(int i = 0; i < n; i ++) a[i] = nc(m); return a; }
	public static final boolean[] nb(int n, final char t) {
		final char c[] = nc(-1);
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


	public static final long INF = (long)4e18;
	public static final boolean isPlusINF(final long x) { return x > INF / 10; }
	public static final boolean isMinusINF(final long x) { return isPlusINF(- x); }
	public static final boolean isINF(final long x) { return isPlusINF(x) || isMinusINF(x); }
	public static final int I_INF = (int)1e9 + 1000;
	public static final boolean isPlusINF(final int x) { return x > I_INF / 10; }
	public static final boolean isMinusINF(final int x) { return isPlusINF(- x); }
	public static final boolean isINF(final int x) { return isPlusINF(x) || isMinusINF(x); }

	public static final int min(final int a, final int b) { return Math.min(a, b); }
	public static final long min(final long a, final long b) { return Math.min(a, b); }
	public static final double min(final double a, final double b) { return Math.min(a, b); }
	public static final <T extends Comparable<T>> T min(final T a, final T b) { return a.compareTo(b) <= 0 ? a : b; }
	public static final int min(final int... x) { int min = x[0]; for(int val : x) min = min(min, val); return min; }
	public static final long min(final long... x) { long min = x[0]; for(long val : x) min = min(min, val); return min; }
	public static final double min(final double... x) { double min = x[0]; for(double val : x) min = min(min, val); return min; }
	public static final int max(final int a, final int b) { return Math.max(a, b); }
	public static final long max(final long a, final long b) { return Math.max(a, b); }
	public static final double max(final double a, final double b) { return Math.max(a, b); }
	public static final <T extends Comparable<T>> T max(final T a, final T b) { return a.compareTo(b) >= 0 ? a : b; }
	public static final int max(final int... x) { int max = x[0]; for(int val : x) max = max(max, val); return max; }
	public static final long max(final long... x) { long max = x[0]; for(long val : x) max = max(max, val); return max; }
	public static final double max(final double... x) { double max = x[0]; for(double val : x) max = max(max, val); return max; }
	public static final <T extends Comparable<T>> T max(final T[] x) { T max = x[0]; for(T val : x) max = max(max, val); return max; }
	public static final int max(final int[][] a) { int max = a[0][0]; for(int[] ele : a) max = max(max, max(ele)); return max; }
	public static final long max(final long[][] a) { long max = a[0][0]; for(long[] ele : a) max = max(max, max(ele)); return max; }
	public static final double max(final double[][] a) { double max = a[0][0]; for(double[] ele : a) max = max(max, max(ele)); return max; }
	public static final <T extends Comparable<T>> T max(final T[][] a) { T max = a[0][0]; for(T[] ele : a) max = max(max, max(ele)); return max; }
	public static final long sum(final int... a) { long sum = 0; for(int ele : a) sum += ele; return sum; }
	public static final long sum(final long... a) { long sum = 0; for(long ele : a) sum += ele; return sum; }
	public static final double sum(final double... a) { double sum = 0; for(double ele : a) sum += ele; return sum; }
	public static final int sum(final boolean... a) { int sum = 0; for(boolean ele : a) sum += ele ? 1 : 0; return sum; }
	public static final long[] sums(final int[] a) { long sum[] = new long[a.length + 1]; sum[0] = 0; for(int i = 0; i < a.length; i ++) sum[i + 1] = sum[i] + a[i]; return sum; }
	public static final long[] sums(final long[] a) { long sum[] = new long[a.length + 1]; sum[0] = 0; for(int i = 0; i < a.length; i ++) sum[i + 1] = sum[i] + a[i]; return sum; }
	public static final double[] sums(final double[] a) { double sum[] = new double[a.length + 1]; sum[0] = 0; for(int i = 0; i < a.length; i ++) sum[i + 1] = sum[i] + a[i]; return sum; }
	public static final int[] sums(final boolean[] a) { int sum[] = new int[a.length + 1]; sum[0] = 0; for(int i = 0; i < a.length; i ++) sum[i + 1] = sum[i] + (a[i] ? 1 : 0); return sum; }
	public static final long[][] sums(final int[][] a) {
		final long sum[][] = new long[a.length + 1][a[0].length + 1];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < a[i].length; j ++) sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + a[i][j];
		}
		return sum;
	}
	public static final long[][] sums(final long[][] a) {
		final long sum[][] = new long[a.length + 1][a[0].length + 1];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < a[i].length; j ++) sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + a[i][j];
		}
		return sum;
	}
	public static final double[][] sums(final double[][] a) {
		final double sum[][] = new double[a.length + 1][a[0].length + 1];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < a[i].length; j ++) sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + a[i][j];
		}
		return sum;
	}
	public static final int[][] sums(final boolean[][] a) {
		final int sum[][] = new int[a.length + 1][a[0].length + 1];
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < a[i].length; j ++) sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (a[i][j] ? 1 : 0);
		}
		return sum;
	}
	public static final int constrain(final int x, final int l, final int r) { return min(max(x, min(l, r)), max(l, r)); }
	public static final long constrain(final long x, final long l, final long r) { return min(max(x, min(l, r)), max(l, r)); }
	public static final double constrain(final double x, final double l, final double r) { return min(max(x, min(l, r)), max(l, r)); }
	public static final int abs(final int x) { return x >= 0 ? x : - x; }
	public static final long abs(final long x) { return x >= 0 ? x : - x; }
	public static final double abs(final double x) { return x >= 0 ? x : - x; }
	public static final int signum(final int x) { return x > 0 ? 1 : x < 0 ? -1 : 0; }
	public static final int signum(final long x) { return x > 0 ? 1 : x < 0 ? -1 : 0; }
	public static final int signum(final double x) { return x > 0 ? 1 : x < 0 ? -1 : 0; }
	public static final long round(final double x) { return Math.round(x); }
	public static final long floor(final double x) { return round(Math.floor(x)); }
	public static final int divfloor(final int a, final int b) { return signum(a) == signum(b) ? a / b : - divceil(abs(a), abs(b)); }
	public static final long divfloor(final long a, final long b) { return signum(a) == signum(b) ? a / b : - divceil(abs(a), abs(b)); }
	public static final long ceil(final double x) { return round(Math.ceil(x)); }
	public static final int divceil(final int a, final int b) { return a >= 0 && b > 0 ? (a + b - 1) / b : a < 0 && b < 0 ? divceil(abs(a), abs(b)) : - divfloor(abs(a), abs(b)); }
	public static final long divceil(final long a, final long b) { return a >= 0 && b > 0 ? (a + b - 1) / b : a < 0 && b < 0 ? divceil(abs(a), abs(b)) : - divfloor(abs(a), abs(b)); }
	public static final boolean mulGreater(final long a, final long b, long c) { return b == 0 ? c < 0 : b < 0 ? mulLess(a, - b, - c) : a > divfloor(c, b); } // a * b > c
	public static final boolean mulGreaterEquals(final long a, final long b, final long c) { return b == 0 ? c <= 0 : b < 0 ? mulLessEquals(a, - b, - c) : a >= divceil(c, b); } // a * b >= c
	public static final boolean mulLess(final long a, final long b, final long c) { return !mulGreaterEquals(a, b, c); } // a * b < c
	public static final boolean mulLessEquals(final long a, final long b, final long c) { return !mulGreater(a, b, c); } // a * b <= c
	public static final double sqrt(final int x) { return Math.sqrt((double)x); }
	public static final double sqrt(final long x) { return Math.sqrt((double)x); }
	public static final double sqrt(final double x) { return Math.sqrt(x); }
	public static final int floorsqrt(final int x) { int s = (int)floor(sqrt(x)) + 1; while(s * s > x) s --; return s; }
	public static final long floorsqrt(final long x) { long s = floor(sqrt(x)) + 1; while(s * s > x) s --; return s; }
	public static final int ceilsqrt(final int x) { int s = (int)ceil(sqrt(x)); while(s * s >= x) s --; s ++; return s; }
	public static final long ceilsqrt(final long x) { long s = ceil(sqrt(x)); while(s * s >= x) s --; s ++; return s; }
	public static final long fact(final int n) { long ans = 1; for(int i = 1; i <= n; i ++) ans = Math.multiplyExact(ans, i); return ans; }
	public static final long naiveP(final long n, final long r) { long ans = 1; for(int i = 0; i < r; i ++) ans = Math.multiplyExact(ans, n - i); return ans; }
	public static final long naiveC(final long n, final long r) { long ans = 1; for(int i = 0; i < r; i ++) { ans = Math.multiplyExact(ans, n - i); ans /= (i + 1); } return ans; }
	public static final double pow(final double x, final double y) { return Math.pow(x, y); }
	public static final long pow(long x, long y) {
		long ans = 1;
		while(true) {
			if((y & 1) != 0) ans = Math.multiplyExact(ans, x);
			y >>= 1;
			if(y <= 0) return ans;
			x = Math.multiplyExact(x, x);
		}
	}
	public static final double pow(double x, long y) {
		double ans = 1;
		while(true) {
			if((y & 1) != 0) ans *= x;
			y >>= 1;
			if(y <= 0) return ans;
			x *= x;
		}
	}
	public static final int gcd(int a, int b) { while(true) { if(b == 0) return a; int tmp = a; a = b; b = tmp % b; } }
	public static final long gcd(long a, long b) { while(true) { if(b == 0) return a; long tmp = a; a = b; b = tmp % b; } }
	public static final long lcm(final long a, final long b) { return a / gcd(a, b) * b; }
	public static final int gcd(final int... a) { int gcd = 0; for(int ele : a) gcd = gcd(ele, gcd); return gcd; }
	public static final long gcd(final long... a) { long gcd = 0; for(long ele : a) gcd = gcd(ele, gcd); return gcd; }
	public static final long mod(long x, final long mod) {
		if(0 <= x && x < mod) return x;
		if(- mod <= x && x < 0) return x + mod;
		return (x %= mod) < 0 ? x + mod : x;
	}
	public static final long pow(long x, long y, final long mod) {
		nonNegativeCheck(y);
		x = mod(x, mod);
		long ans = 1;
		for(; y > 0; y >>= 1) {
			if((y & 1) != 0) ans = mod(ans * x, mod);
			x = mod(x * x, mod);
		}
		return ans;
	}
	public static final long triangular(final long n) { return n * (n + 1) / 2; }
	public static final long arctriangularfloor(final long m) {
		long n = (floor(sqrt(m * 8 + 1)) - 1) / 2 + 1;
		while(triangular(n) > m) n --;
		return n;
	}
	public static final long arctriangularceil(final long m) {
		long n = max(0, (ceil(sqrt(m * 8 + 1)) + 1) / 2 - 1);
		while(triangular(n) < m) n ++;
		return n;
	}

	public static final double random() { return Math.random(); }
	public static final int random(final int max) { return (int)floor(random() * max); }
	public static final long random(final long max) { return floor(random() * max); }
	public static final double random(final double max) { return random() * max; }
	public static final int random(final int min, final int max) { return random(max - min) + min; }
	public static final long random(final long min, final long max) { return random(max - min) + min; }
	public static final double random(final double min, final double max) { return random(max - min) + min; }
	public static final int[] randomi(final int n, final int max) { nonNegativeCheck(n); final int a[] = new int[n]; for(int i = 0; i < n; i ++) a[i] = random(max); return a; }
	public static final long[] randoml(final int n, final long max) { nonNegativeCheck(n); final long a[] = new long[n]; for(int i = 0; i < n; i ++) a[i] = random(max); return a; }
	public static final double[] randomd(final int n, final double max) { nonNegativeCheck(n); final double a[] = new double[n]; for(int i = 0; i < n; i ++) a[i] = random(max); return a; }
	public static final int[] randomi(final int n, final int min, final int max) { nonNegativeCheck(n); final int a[] = new int[n]; for(int i = 0; i < n; i ++) a[i] = random(min, max); return a; }
	public static final long[] randoml(final int n, final long min, final long max) { nonNegativeCheck(n); final long a[] = new long[n]; for(int i = 0; i < n; i ++) a[i] = random(min, max); return a; }
	public static final double[] randomd(final int n, final double min, final double max) { nonNegativeCheck(n); final double a[] = new double[n]; for(int i = 0; i < n; i ++) a[i] = random(min, max); return a; }

	public static final long[] div(final long x) {
		nonNegativeCheck(x);
		final List<Long> divList = new ArrayList<>();
		for(long i = 1; i * i <= x; i ++) if(x % i == 0) { divList.add(i); if(i * i != x) divList.add(x / i); }
		final long div[] = new long[divList.size()];
		for(int i = 0; i < divList.size(); i ++) div[i] = divList.get(i);
		Arrays.sort(div);
		return div;
	}
	// public static final PairLL[] factor(long x) {
	// 	nonNegativeCheck(x);
	// 	final List<PairLL> factorList = new ArrayList<>();
	// 	for(long i = 2; i * i <= x; i ++) {
	// 		if(x % i == 0) {
	// 			long cnt = 0;
	// 			while(x % i == 0) { x /= i; cnt ++; }
	// 			factorList.add(new PairLL(i, cnt));
	// 		}
	// 	}
	// 	if(x > 1) factorList.add(new PairLL(x, 1));
	// 	final PairLL factor[] = new PairLL[factorList.size()];
	// 	for(int i = 0; i < factorList.size(); i ++) factor[i] = factorList.get(i);
	// 	Arrays.sort(factor);
	// 	return factor;
	// }
	public static final boolean isPrime(final long x) { if(x <= 1) return false; for(long i = 2; i * i <= x; i ++) if(x % i == 0) return false; return true; }
	public static final boolean[] prime(final int n) {
		nonNegativeCheck(n);
		final boolean prime[] = new boolean[n];
		fill(prime, true);
		if(n > 0) prime[0] = false;
		if(n > 1) prime[1] = false;
		for(int i = 2; i < n; i ++) if(prime[i]) for(int j = 2; i * j < n; j ++) prime[i * j] = false;
		return prime;
	}

	public static final int[] baseConvert(long x, final int n, final int len) {
		nonNegativeCheck(x);
		nonNegativeCheck(n);
		nonNegativeCheck(len);
		final int digit[] = new int[len];
		int i = 0;
		while(x > 0 && i < len) { digit[i ++] = (int)(x % n); x /= n; }
		return digit;
	}
	public static final int[] baseConvert(final long x, final int n) {
		nonNegativeCheck(x);
		nonNegativeCheck(n);
		long tmp = x;
		int len = 0;
		while(tmp > 0) { tmp /= n; len ++; }
		return baseConvert(x, n, len);
	}
	public static final int[] baseConvert(int x, final int n, final int len) {
		nonNegativeCheck(x);
		nonNegativeCheck(n);
		nonNegativeCheck(len);
		final int digit[] = new int[len];
		int i = 0;
		while(x > 0 && i < len) { digit[i ++] = (int)(x % n); x /= n; }
		return digit;
	}
	public static final int[] baseConvert(final int x, final int n) {
		nonNegativeCheck(x);
		nonNegativeCheck(n);
		int tmp = x;
		int len = 0;
		while(tmp > 0) { tmp /= n; len ++; }
		return baseConvert(x, n, len);
	}
	public static final long[] baseConvert(long x, final long n, final int len) {
		nonNegativeCheck(x);
		nonNegativeCheck(n);
		nonNegativeCheck(len);
		final long digit[] = new long[len];
		int i = 0;
		while(x > 0 && i < len) { digit[i ++] = x % n; x /= n; }
		return digit;
	}
	public static final long[] baseConvert(final long x, final long n) {
		nonNegativeCheck(x);
		nonNegativeCheck(n);
		long tmp = x;
		int len = 0;
		while(tmp > 0) { tmp /= n; len ++; }
		return baseConvert(x, n, len);
	}

	public static final int numDigits(final long x) { nonNegativeCheck(x); return Long.toString(x).length(); }
	public static final long bitFlag(final int i) { nonNegativeCheck(i); return 1L << i; }
	public static final boolean isFlagged(final long x, final int i) { nonNegativeCheck(x); nonNegativeCheck(i); return (x >> i & 1) != 0; }


	public static final char booleanToChar(final boolean b) { return b ? '#' : '.'; }
	public static final char[] booleanToChar(final boolean... a) {
		final char c[] = new char[a.length];
		for(int i = 0; i < a.length; i ++) c[i] = booleanToChar(a[i]);
		return c;
	}
	public static final boolean isUpper(final char c) { return c >= 'A' && c <= 'Z'; }
	public static final boolean isLower(final char c) { return c >= 'a' && c <= 'z'; }
	public static final int upperToInt(final char c) { return c - 'A'; }
	public static final int lowerToInt(final char c) { return c - 'a'; }
	public static final int numToInt(final char c) { return c - '0'; }
	public static final int charToInt(final char c) { return isLower(c) ? lowerToInt(c) : isUpper(c) ? upperToInt(c) : numToInt(c); }
	public static final int alphabetToInt(final char c) { return isLower(c) ? lowerToInt(c) : isUpper(c) ? upperToInt(c) + 26 : 52; }
	public static final char intToUpper(final int x) { return (char)(x + 'A'); }
	public static final char intToLower(final int x) { return (char)(x + 'a'); }
	public static final char intToNum(final int x) { return (char)(x + '0'); }
	public static final int[] charToInt(final char[] a) { final int toint[] = new int[a.length]; for(int i = 0; i < a.length; i ++) toint[i] = charToInt(a[i]); return toint; }
	public static final int[][] charToInt(final char[][] a) { final int toint[][] = new int[a.length][]; for(int i = 0; i < a.length; i ++) toint[i] = charToInt(a[i]); return toint; }


	public static final String reverse(final String s) { return (new StringBuilder(s)).reverse().toString(); }
	public static final char[] reverse(final char[] a) { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }
	public static final boolean[] reverse(final boolean[] a) { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }
	public static final int[] reverse(final int[] a) { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }
	public static final long[] reverse(final long[] a) { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }
	public static final double[] reverse(final double[] a) { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }
	public static final String[] reverse(final String[] a) { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }
	public static final Object[] reverse(final Object[] a) { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }
	public static final void fill(final char[] a, final char x) { Arrays.fill(a, x); }
	public static final void fill(final boolean[] a, final boolean x) { Arrays.fill(a, x); }
	public static final void fill(final int[] a, final int x) { Arrays.fill(a, x); }
	public static final void fill(final long[] a, final long x) { Arrays.fill(a, x); }
	public static final void fill(final double[] a, final double x) { Arrays.fill(a, x); }
	public static final void fill(final char[][] a, final char x) { for(char[] ele : a) fill(ele, x); }
	public static final void fill(final boolean[][] a, final boolean x) { for(boolean[] ele : a) fill(ele, x); }
	public static final void fill(final int[][] a, final int x) { for(int[] ele : a) fill(ele, x); }
	public static final void fill(final long[][] a, final long x) { for(long[] ele : a) fill(ele, x); }
	public static final void fill(final double[][] a, final double x) { for(double[] ele : a) fill(ele, x); }
	public static final void fill(final char[][][] a, final char x) { for(char[][] ele : a) fill(ele, x); }
	public static final void fill(final boolean[][][] a, final boolean x) { for(boolean[][] ele : a) fill(ele, x); }
	public static final void fill(final int[][][] a, final int x) { for(int[][] ele : a) fill(ele, x); }
	public static final void fill(final long[][][] a, final long x) { for(long[][] ele : a) fill(ele, x); }
	public static final void fill(final double[][][] a, final double x) { for(double[][] ele : a) fill(ele, x); }
	public static final char[] resize(final char[] a, final int m, final int x) {
		nonNegativeCheck(m);
		final char resized[] = new char[m];
		if(x <= - a.length || x >= m) return resized;
		if(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));
		else System.arraycopy(a, - x, resized, 0, min(a.length + x, m));
		return resized;
	}
	public static final boolean[] resize(final boolean[] a, final int m, final int x) {
		nonNegativeCheck(m);
		final boolean resized[] = new boolean[m];
		if(x <= - a.length || x >= m) return resized;
		if(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));
		else System.arraycopy(a, - x, resized, 0, min(a.length + x, m));
		return resized;
	}
	public static final int[] resize(final int[] a, final int m, final int x) {
		nonNegativeCheck(m);
		final int resized[] = new int[m];
		if(x <= - a.length || x >= m) return resized;
		if(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));
		else System.arraycopy(a, - x, resized, 0, min(a.length + x, m));
		return resized;
	}
	public static final long[] resize(final long[] a, final int m, final int x) {
		nonNegativeCheck(m);
		final long resized[] = new long[m];
		if(x <= - a.length || x >= m) return resized;
		if(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));
		else System.arraycopy(a, - x, resized, 0, min(a.length + x, m));
		return resized;
	}
	public static final double[] resize(final double[] a, final int m, final int x) {
		nonNegativeCheck(m);
		final double resized[] = new double[m];
		if(x <= - a.length || x >= m) return resized;
		if(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));
		else System.arraycopy(a, - x, resized, 0, min(a.length + x, m));
		return resized;
	}
	public static final String[] resize(final String[] a, final int m, final int x) {
		nonNegativeCheck(m);
		final String resized[] = new String[m];
		if(x <= - a.length || x >= m) return resized;
		if(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));
		else System.arraycopy(a, - x, resized, 0, min(a.length + x, m));
		return resized;
	}
	public static final Object[] resize(final Object[] a, final int m, final int x) {
		nonNegativeCheck(m);
		final Object resized[] = new Object[m];
		if(x <= - a.length || x >= m) return resized;
		if(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));
		else System.arraycopy(a, - x, resized, 0, min(a.length + x, m));
		return resized;
	}
	public static final char[][] rotate(final char[][] a) {
		final char[][] ans = new char[a[0].length][a.length];
		for(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length - i - 1] = a[i][j];
		return ans;
	}
	public static final boolean[][] rotate(final boolean[][] a) {
		final boolean[][] ans = new boolean[a[0].length][a.length];
		for(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length - i - 1] = a[i][j];
		return ans;
	}
	public static final int[][] rotate(final int[][] a) {
		final int[][] ans = new int[a[0].length][a.length];
		for(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length - i - 1] = a[i][j];
		return ans;
	}
	public static final long[][] rotate(final long[][] a) {
		final long[][] ans = new long[a[0].length][a.length];
		for(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length - i - 1] = a[i][j];
		return ans;
	}
	public static final double[][] rotate(final double[][] a) {
		final double[][] ans = new double[a[0].length][a.length];
		for(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length - i - 1] = a[i][j];
		return ans;
	}
	public static final Object[][] rotate(final Object[][] a) {
		final Object[][] ans = new Object[a[0].length][a.length];
		for(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length - i - 1] = a[i][j];
		return ans;
	}
	public static final int[] compress(final int[] a) {
		final int n = a.length;
		final Set<Integer> ts = new TreeSet<>();
		for(int i = 0; i < n; i ++) ts.add(a[i]);
		final int compressed[] = new int[ts.size()];
		int j = 0;
		for(int x : ts) compressed[j ++] = x;
		for(int i = 0; i < n; i ++) a[i] = lowerBound(compressed, a[i]);
		return compressed;
	}
	public static final long[] compress(final long[] a) {
		final int n = a.length;
		final Set<Long> ts = new TreeSet<>();
		for(int i = 0; i < n; i ++) ts.add(a[i]);
		final long compressed[] = new long[ts.size()];
		int j = 0;
		for(long x : ts) compressed[j ++] = x;
		for(int i = 0; i < n; i ++) a[i] = lowerBound(compressed, a[i]);
		return compressed;
	}
	public static final double[] compress(final double[] a) {
		final int n = a.length;
		final Set<Double> ts = new TreeSet<>();
		for(int i = 0; i < n; i ++) ts.add(a[i]);
		final double compressed[] = new double[ts.size()];
		int j = 0;
		for(double x : ts) compressed[j ++] = x;
		for(int i = 0; i < n; i ++) a[i] = lowerBound(compressed, a[i]);
		return compressed;
	}
	public static final void swap(final char[] a, final int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); char tmp = a[i]; a[i] = a[j]; a[j] = tmp; }
	public static final void swap(final boolean[] a, final int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); boolean tmp = a[i]; a[i] = a[j]; a[j] = tmp; }
	public static final void swap(final int[] a, final int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); int tmp = a[i]; a[i] = a[j]; a[j] = tmp; }
	public static final void swap(final long[] a, final int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); long tmp = a[i]; a[i] = a[j]; a[j] = tmp; }
	public static final void swap(final double[] a, final int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); double tmp = a[i]; a[i] = a[j]; a[j] = tmp; }
	public static final void swap(final String[] a, final int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); String tmp = a[i]; a[i] = a[j]; a[j] = tmp; }
	public static final void swap(final Object[] a, final int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); Object tmp = a[i]; a[i] = a[j]; a[j] = tmp; }
	public static final void shuffleArray(final int[] a) { for(int i = 0; i < a.length; i ++) swap(a, i, random(i, a.length)); }
	public static final void shuffleArray(final long[] a) { for(int i = 0; i < a.length; i ++) swap(a, i, random(i, a.length)); }
	public static final void shuffleArray(final double[] a) { for(int i = 0; i < a.length; i ++) swap(a, i, random(i, a.length)); }

	public static final int[] toIntArray(final List<Integer> list) { final int a[] = new int[list.size()]; int idx = 0; for(int ele : list) a[idx ++] = ele; return a; }
	public static final long[] toLongArray(final List<Long> list) { final long a[] = new long[list.size()]; int idx = 0; for(long ele : list) a[idx ++] = ele; return a; }
	public static final double[] toDoubleArray(final List<Double> list) { final double a[] = new double[list.size()]; int idx = 0; for(double ele : list) a[idx ++] = ele; return a; }
	public static final char[] toCharArray(final List<Character> list) { final char a[] = new char[list.size()]; int idx = 0; for(char ele : list) a[idx ++] = ele; return a; }
	public static final boolean[] toBooleanArray(final List<Boolean> list) { final boolean a[] = new boolean[list.size()]; int idx = 0; for(boolean ele : list) a[idx ++] = ele; return a; }
	public static final String[] toStringArray(final List<String> list) { final String a[] = new String[list.size()]; int idx = 0; for(String ele : list) a[idx ++] = ele; return a; }
	public static final <T> void toArray(final List<T> list, final T a[]) { int idx = 0; for(T ele : list) a[idx ++] = ele; }


	// public static final PairIL[] countElements(final int[] a, final boolean sort) {
	// 	final int len = a.length;
	// 	final int array[] = new int[len];
	// 	for(int i = 0; i < len; i ++) array[i] = a[i];
	// 	if(sort) Arrays.sort(array);
	// 	final List<PairIL> cntsList = new ArrayList<>();
	// 	long tmp = 1;
	// 	for(int i = 1; i <= len; i ++) {
	// 		if(i == len || array[i] != array[i - 1]) {
	// 			cntsList.add(new PairIL(array[i - 1], tmp));
	// 			tmp = 1;
	// 		}else tmp ++;
	// 	}
	// 	final PairIL cnts[] = new PairIL[cntsList.size()];
	// 	for(int i = 0; i < cntsList.size(); i ++) cnts[i] = cntsList.get(i);
	// 	return cnts;
	// }
	// public static final PairLL[] countElements(final long[] a, final boolean sort) {
	// 	final int len = a.length;
	// 	final long array[] = new long[len];
	// 	for(int i = 0; i < len; i ++) array[i] = a[i];
	// 	if(sort) Arrays.sort(array);
	// 	final List<PairLL> cntsList = new ArrayList<>();
	// 	long tmp = 1;
	// 	for(int i = 1; i <= len; i ++) {
	// 		if(i == len || array[i] != array[i - 1]) {
	// 			cntsList.add(new PairLL(array[i - 1], tmp));
	// 			tmp = 1;
	// 		}else tmp ++;
	// 	}
	// 	final PairLL cnts[] = new PairLL[cntsList.size()];
	// 	for(int i = 0; i < cntsList.size(); i ++) cnts[i] = cntsList.get(i);
	// 	return cnts;
	// }
	// public static final PairIL[] countElements(final String s, final boolean sort) {
	// 	final int len = s.length();
	// 	final char array[] = s.toCharArray();
	// 	if(sort) Arrays.sort(array);
	// 	final List<PairIL> cntsList = new ArrayList<>();
	// 	long tmp = 1;
	// 	for(int i = 1; i <= len; i ++) {
	// 		if(i == len || array[i] != array[i - 1]) {
	// 			cntsList.add(new PairIL((int)array[i - 1], tmp));
	// 			tmp = 1;
	// 		}else tmp ++;
	// 	}
	// 	final PairIL cnts[] = new PairIL[cntsList.size()];
	// 	for(int i = 0; i < cntsList.size(); i ++) cnts[i] = cntsList.get(i);
	// 	return cnts;
	// }
	public static final long countString(final String s, final String t) { return (s.length() - s.replace(t, "").length()) / t.length(); }
	public static final long countStringAll(final String s, final String t) { return s.length() - s.replaceAll(t, "").length(); }


	// binary search
	public static final int lowerBound(final int[] a, final int key) { return BS(a, key, true, true, true); }
	public static final int lowerBound(final int[] a, final int key, final int ng, final int ok) { return BS(a, key, true, true, true, ng, ok); }
	public static final int upperBound(final int[] a, final int key) { return BS(a, key, true, true, false); }
	public static final int upperBound(final int[] a, final int key, final int ng, final int ok) { return BS(a, key, true, true, false, ng, ok); }
	public static final int cntBS(final int[] a, final int key, final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, true); }
	public static final int cntBS(final int[] a, final int key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, true, ng, ok); }
	public static final int BS(final int[] a, final int key,
			final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, false); }
	public static final int BS(final int[] a, final int key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, false, ng, ok); }
	public static final int BS(final int[] a, final int key,
			final boolean asc, final boolean gt, final boolean eq, final boolean cnt) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.length : -1, asc ^ gt ? -1 : a.length); }
	public static final int BS(final int[] a, final int key, final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final int ok) {
		int index = binarySearch(a, key, gt, eq, ng, ok);
		return cnt ? (int)abs(ok - index) : index;
	}
	public static final int binarySearch(final int[] a, final int key, final boolean gt, final boolean eq, int ng, int ok) {
		while(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key, gt, eq)) ok = mid; else ng = mid; }
		return ok;
	}
	public static final boolean isOKforBS(final int[] a, final int index, final int key, final boolean gt, final boolean eq) {
		return (a[index] > key && gt) || (a[index] < key && !gt) || (a[index] == key && eq);
	}
	public static final int lowerBound(final long[] a, final long key) { return BS(a, key, true, true, true); }
	public static final int lowerBound(final long[] a, final long key, final int ng, final int ok) { return BS(a, key, true, true, true, ng, ok); }
	public static final int upperBound(final long[] a, final long key) { return BS(a, key, true, true, false); }
	public static final int upperBound(final long[] a, final long key, final int ng, final int ok) { return BS(a, key, true, true, false, ng, ok); }
	public static final int cntBS(final long[] a, final long key, final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, true); }
	public static final int cntBS(final long[] a, final long key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, true, ng, ok); }
	public static final int BS(final long[] a, final long key,
			final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, false); }
	public static final int BS(final long[] a, final long key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, false, ng, ok); }
	public static final int BS(final long[] a, final long key,
			final boolean asc, final boolean gt, final boolean eq, final boolean cnt) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.length : -1, asc ^ gt ? -1 : a.length); }
	public static final int BS(final long[] a, final long key, final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final int ok) {
		int index = binarySearch(a, key, gt, eq, ng, ok);
		return cnt ? (int)abs(ok - index) : index;
	}
	public static final int binarySearch(final long[] a, final long key, final boolean gt, final boolean eq, int ng, int ok) {
		while(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key, gt, eq)) ok = mid; else ng = mid; }
		return ok;
	}
	public static final boolean isOKforBS(final long[] a, final int index, final long key, final boolean gt, final boolean eq) {
		return (a[index] > key && gt) || (a[index] < key && !gt) || (a[index] == key && eq);
	}
	public static final int lowerBound(final double[] a, final double key) { return BS(a, key, true, true, true); }
	public static final int lowerBound(final double[] a, final double key, final int ng, final int ok) { return BS(a, key, true, true, true, ng, ok); }
	public static final int upperBound(final double[] a, final double key) { return BS(a, key, true, true, false); }
	public static final int upperBound(final double[] a, final double key, final int ng, final int ok) { return BS(a, key, true, true, false, ng, ok); }
	public static final int cntBS(final double[] a, final double key, final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, true); }
	public static final int cntBS(final double[] a, final double key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, true, ng, ok); }
	public static final int BS(final double[] a, final double key,
			final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, false); }
	public static final int BS(final double[] a, final double key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, false, ng, ok); }
	public static final int BS(final double[] a, final double key,
			final boolean asc, final boolean gt, final boolean eq, final boolean cnt) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.length : -1, asc ^ gt ? -1 : a.length); }
	public static final int BS(final double[] a, final double key, final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final int ok) {
		int index = binarySearch(a, key, gt, eq, ng, ok);
		return cnt ? (int)abs(ok - index) : index;
	}
	public static final int binarySearch(final double[] a, final double key, final boolean gt, final boolean eq, int ng, int ok) {
		while(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key, gt, eq)) ok = mid; else ng = mid; }
		return ok;
	}
	public static final boolean isOKforBS(final double[] a, final int index, final double key, final boolean gt, final boolean eq) {
		return (a[index] > key && gt) || (a[index] < key && !gt) || (a[index] == key && eq);
	}
	public static final <T extends Comparable<? super T>> int lowerBound(final T[] a, final T key) { return BS(a, key, true, true, true); }
	public static final <T extends Comparable<? super T>> int lowerBound(final T[] a, final T key, final int ng, final int ok) { return BS(a, key, true, true, true, ng, ok); }
	public static final <T extends Comparable<? super T>> int upperBound(final T[] a, final T key) { return BS(a, key, true, true, false); }
	public static final <T extends Comparable<? super T>> int upperBound(final T[] a, final T key, final int ng, final int ok) { return BS(a, key, true, true, false, ng, ok); }
	public static final <T extends Comparable<? super T>> int cntBS(final T[] a, final T key, final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, true); }
	public static final <T extends Comparable<? super T>> int cntBS(final T[] a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, true, ng, ok); }
	public static final <T extends Comparable<? super T>> int BS(final T[] a, final T key,
			final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, false); }
	public static final <T extends Comparable<? super T>> int BS(final T[] a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, false, ng, ok); }
	public static final <T extends Comparable<? super T>> int BS(final T[] a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final boolean cnt) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.length : -1, asc ^ gt ? -1 : a.length); }
	public static final <T extends Comparable<? super T>> int BS(final T[] a, final T key, final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final int ok) {
		int index = binarySearch(a, key, gt, eq, ng, ok);
		return cnt ? (int)abs(ok - index) : index;
	}
	public static final <T extends Comparable<? super T>> int binarySearch(final T[] a, final T key, final boolean gt, final boolean eq, int ng, int ok) {
		while(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key, gt, eq)) ok = mid; else ng = mid; }
		return ok;
	}
	public static final <T extends Comparable<? super T>> boolean isOKforBS(final T[] a, final int index, final T key, final boolean gt, final boolean eq) {
		int compare = a[index].compareTo(key);
		return (compare > 0 && gt) || (compare < 0 && !gt) || (compare == 0 && eq);
	}
	public static final <T> int lowerBound(final T[] a, final T key, final Comparator<? super T> c) { return BS(a, key, true, true, true, c); }
	public static final <T> int lowerBound(final T[] a, final T key, final int ng, final int ok, final Comparator<? super T> c) { return BS(a, key, true, true, true, ng, ok, c); }
	public static final <T> int upperBound(final T[] a, final T key, final Comparator<? super T> c) { return BS(a, key, true, true, false, c); }
	public static final <T> int upperBound(final T[] a, final T key, final int ng, final int ok, final Comparator<? super T> c) { return BS(a, key, true, true, false, ng, ok, c); }
	public static final <T> int cntBS(final T[] a, final T key, final boolean asc, final boolean gt, final boolean eq, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, true, c); }
	public static final <T> int cntBS(final T[] a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, true, ng, ok, c); }
	public static final <T> int BS(final T[] a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, false, c); }
	public static final <T> int BS(final T[] a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, false, ng, ok, c); }
	public static final <T> int BS(final T[] a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.length : -1, asc ^ gt ? -1 : a.length, c); }
	public static final <T> int BS(final T[] a, final T key, final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final int ok, final Comparator<? super T> c) {
		int index = binarySearch(a, key, gt, eq, ng, ok, c);
		return cnt ? (int)abs(ok - index) : index;
	}
	public static final <T> int binarySearch(final T[] a, final T key, final boolean gt, final boolean eq, int ng, int ok, final Comparator<? super T> c) {
		while(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key, gt, eq, c)) ok = mid; else ng = mid; }
		return ok;
	}
	public static final <T> boolean isOKforBS(final T[] a, final int index, T key, final boolean gt, final boolean eq, final Comparator<? super T> c) {
		int compare = c.compare(a[index], key);
		return (compare > 0 && gt) || (compare < 0 && !gt) || (compare == 0 && eq);
	}
	public static final <T extends Comparable<? super T>> int lowerBound(final List<T> a, final T key) { return BS(a, key, true, true, true); }
	public static final <T extends Comparable<? super T>> int lowerBound(final List<T> a, final T key, final int ng, final int ok) { return BS(a, key, true, true, true, ng, ok); }
	public static final <T extends Comparable<? super T>> int upperBound(final List<T> a, final T key) { return BS(a, key, true, true, false); }
	public static final <T extends Comparable<? super T>> int upperBound(final List<T> a, final T key, final int ng, final int ok) { return BS(a, key, true, true, false, ng, ok); }
	public static final <T extends Comparable<? super T>> int cntBS(final List<T> a, final T key, final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, true); }
	public static final <T extends Comparable<? super T>> int cntBS(final List<T> a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, true, ng, ok); }
	public static final <T extends Comparable<? super T>> int BS(final List<T> a, final T key,
			final boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, false); }
	public static final <T extends Comparable<? super T>> int BS(final List<T> a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, false, ng, ok); }
	public static final <T extends Comparable<? super T>> int BS(final List<T> a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final boolean cnt) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.size() : -1, asc ^ gt ? -1 : a.size()); }
	public static final <T extends Comparable<? super T>> int BS(final List<T> a, final T key, final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final int ok) {
		int index = binarySearch(a, key, gt, eq, ng, ok);
		return cnt ? (int)abs(ok - index) : index;
	}
	public static final <T extends Comparable<? super T>> int binarySearch(final List<T> a, final T key, final boolean gt, final boolean eq, int ng, int ok) {
		while(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key, gt, eq)) ok = mid; else ng = mid; }
		return ok;
	}
	public static final <T extends Comparable<? super T>> boolean isOKforBS(final List<T> a, final int index, T key, final boolean gt, final boolean eq) {
		int compare = a.get(index).compareTo(key);
		return (compare > 0 && gt) || (compare < 0 && !gt) || (compare == 0 && eq);
	}
	public static final <T> int lowerBound(final List<T> a, final T key, final Comparator<? super T> c) { return BS(a, key, true, true, true, c); }
	public static final <T> int lowerBound(final List<T> a, final T key, final int ng, final int ok, final Comparator<? super T> c) { return BS(a, key, true, true, true, ng, ok, c); }
	public static final <T> int upperBound(final List<T> a, final T key, final Comparator<? super T> c) { return BS(a, key, true, true, false, c); }
	public static final <T> int upperBound(final List<T> a, final T key, final int ng, final int ok, final Comparator<? super T> c) { return BS(a, key, true, true, false, ng, ok, c); }
	public static final <T> int cntBS(final List<T> a, final T key, final boolean asc, final boolean gt, final boolean eq, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, true, c); }
	public static final <T> int cntBS(final List<T> a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, true, ng, ok, c); }
	public static final <T> int BS(final List<T> a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, false, c); }
	public static final <T> int BS(final List<T> a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final int ng, final int ok, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, false, ng, ok, c); }
	public static final <T> int BS(final List<T> a, final T key,
			final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.size() : -1, asc ^ gt ? -1 : a.size(), c); }
	public static final <T> int BS(final List<T> a, final T key, final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final int ok, final Comparator<? super T> c) {
		int index = binarySearch(a, key, gt, eq, ng, ok, c);
		return cnt ? (int)abs(ok - index) : index;
	}
	public static final <T> int binarySearch(final List<T> a, final T key, final boolean gt, final boolean eq, int ng, int ok, final Comparator<? super T> c) {
		while(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key, gt, eq, c)) ok = mid; else ng = mid; }
		return ok;
	}
	public static final <T> boolean isOKforBS(final List<T> a, final int index, final T key, final boolean gt, final boolean eq, final Comparator<? super T> c) {
		int compare = c.compare(a.get(index), key);
		return (compare > 0 && gt) || (compare < 0 && !gt) || (compare == 0 && eq);
	}

	// public static final PairLL binaryRangeSearch(final long left, final long right, final UnaryOperator<Long> op, final boolean minimize) {
	// 	long ok1 = right, ng1 = left;
	// 	while(abs(ok1 - ng1) > 1) {
	// 		long mid = (ok1 + ng1) >> 1;
	// 		boolean isOK = (op.apply(mid + 1) - op.apply(mid)) * (minimize ? 1 : -1) >= 0;
	// 		if(isOK) ok1 = mid; else ng1 = mid;
	// 	}
	// 	long ok2 = left, ng2 = right;
	// 	while(abs(ok2 - ng2) > 1) {
	// 		long mid = (ok2 + ng2) >> 1;
	// 		boolean isOK = (op.apply(mid - 1) - op.apply(mid)) * (minimize ? 1 : -1) >= 0;
	// 		if(isOK) ok2 = mid; else ng2 = mid;
	// 	}
	// 	return new PairLL(ok1, ok2); //[l, r]
	// }

	public static final double ternarySearch(double left, double right, final UnaryOperator<Double> op, final boolean minimize, final int loop) {
		for(int cnt = 0; cnt < loop; cnt ++) {
			double m1 = (left * 2 + right) / 3.0;
			double m2 = (left + right * 2) / 3.0;
			if(op.apply(m1) > op.apply(m2) ^ minimize) right = m2; else left = m1;
		}
		return (left + right) / 2.0;
	}
}