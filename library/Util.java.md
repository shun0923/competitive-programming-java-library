---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':heavy_check_mark:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':heavy_check_mark:'
    path: library/ExtendedConvolution.java
    title: library/ExtendedConvolution.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Util.java\n"
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.FastInputStream;\nimport library.FastOutputStream;\n\nclass FastIO {\n\
    \tpublic static boolean DEBUG;\n\n\tprivate static final FastInputStream in =\
    \ new FastInputStream(System.in);\n\tpublic static final String nline() { return\
    \ in.nextLine(); }\n\tpublic static final String[] nline(final int n) { final\
    \ String a[] = new String[n]; for(int i = 0; i < n; i ++) a[i] = nline(); return\
    \ a; }\n\tpublic static final char nc() { return in.nextChar(); }\n\tpublic static\
    \ final char[] nc(int n) {\n\t\tfinal String str = nline();\n\t\tif(n < 0) n =\
    \ str.length();\n\t\tfinal char a[] = new char[n];\n\t\tfor(int i = 0; i < n;\
    \ i ++) a[i] = str.charAt(i);\n\t\treturn a;\n\t}\n\tpublic static final char[][]\
    \ nc(final int n, final int m) { final char a[][] = new char[n][m]; for(int i\
    \ = 0; i < n; i ++) a[i] = nc(m); return a; }\n\tpublic static final boolean[]\
    \ nb(int n, final char t) {\n\t\tfinal char c[] = nc(-1);\n\t\tif(n < 0) n = c.length;\n\
    \t\tfinal boolean a[] = new boolean[n];\n\t\tfor(int i = 0; i < n; i ++) a[i]\
    \ = c[i] == t;\n\t\treturn a;\n\t}\n\tpublic static final boolean[][] nb(final\
    \ int n, final int m, final char t) { final boolean a[][] = new boolean[n][];\
    \ for(int i = 0; i < n; i ++) a[i] = nb(m, t); return a; }\n\tpublic static final\
    \ int ni() { return in.nextInt(); }\n\tpublic static final int[] ni(final int\
    \ n) { final int a[] = new int[n]; for(int i = 0; i < n; i ++) a[i] = ni(); return\
    \ a; }\n\tpublic static final int[][] ni(final int n, final int m) { final int\
    \ a[][] = new int[n][]; for(int i = 0; i < n; i ++) a[i] = ni(m); return a; }\n\
    \tpublic static final long nl() { return in.nextLong(); }\n\tpublic static final\
    \ long[] nl(final int n) { final long a[] = new long[n]; for(int i = 0; i < n;\
    \ i ++) a[i] = nl(); return a; }\n\tpublic static final long[][] nl(final int\
    \ n, final int m) { final long a[][] = new long[n][]; for(int i = 0; i < n; i\
    \ ++) a[i] = nl(m); return a; }\n\tpublic static final double nd() { return in.nextDouble();\
    \ }\n\tpublic static final double[] nd(final int n) { final double a[] = new double[n];\
    \ for(int i = 0; i < n; i ++) a[i] = nd(); return a; }\n\tpublic static final\
    \ double[][] nd(final int n, final int m) { final double a[][] = new double[n][];\
    \ for(int i = 0; i < n; i ++) a[i] = nd(m); return a; }\n\tpublic static final\
    \ String ns() { return in.next(); }\n\tpublic static final String[] ns(final int\
    \ n) { final String a[] = new String[n]; for(int i = 0; i < n; i ++) a[i] = ns();\
    \ return a; }\n\tpublic static final String[][] ns(final int n, final int m) {\
    \ final String a[][] = new String[n][]; for(int i = 0; i < n; i ++) a[i] = ns(m);\
    \ return a; }\n\n\tprivate static final FastOutputStream out = new FastOutputStream(System.out);\n\
    \tprivate static final FastOutputStream err = new FastOutputStream(System.err);\n\
    \tpublic static final void prt() { out.print(); }\n\tpublic static final void\
    \ prt(final char c) { out.print(c); }\n\tpublic static final void prt(final boolean\
    \ b) { out.print(b); }\n\tpublic static final void prt(final int x) { out.print(x);\
    \ }\n\tpublic static final void prt(final long x) { out.print(x); }\n\tpublic\
    \ static final void prt(final double d) { out.print(d); }\n\tpublic static final\
    \ void prt(final String s) { out.print(s); }\n\tpublic static final void prt(final\
    \ Object o) { out.print(o); }\n\tpublic static final void prtln() { out.println();\
    \ }\n\tpublic static final void prtln(final char c) { out.println(c); }\n\tpublic\
    \ static final void prtln(final boolean b) { out.println(b); }\n\tpublic static\
    \ final void prtln(final int x) { out.println(x); }\n\tpublic static final void\
    \ prtln(final long x) { out.println(x); }\n\tpublic static final void prtln(final\
    \ double d) { out.println(d); }\n\tpublic static final void prtln(final String\
    \ s) { out.println(s); }\n\tpublic static final void prtln(final Object o) { out.println(o);\
    \ }\n\tpublic static final void prtln(final char... a) { out.println(a); }\n\t\
    public static final void prtln(final boolean... a) { out.println(booleanToChar(a));\
    \ }\n\tpublic static final void prtln(final int... a) { out.println(a); }\n\t\
    public static final void prtln(final long... a) { out.println(a); }\n\tpublic\
    \ static final void prtln(final double... a) { out.println(a); }\n\tpublic static\
    \ final void prtln(final double[] a, int precision) { out.println(a, precision);\
    \ }\n\tpublic static final void prtln(final String... a) { out.println(a); }\n\
    \tpublic static final void prtln(final Object[] a) { out.println(a); }\n\tpublic\
    \ static final void prtlns(final char... a) { for(char ele : a) prtln(ele); }\n\
    \tpublic static final void prtlns(final boolean... a) { for(boolean ele : a) prtln(ele);\
    \ }\n\tpublic static final void prtlns(final int... a) { for(int ele : a) prtln(ele);\
    \ }\n\tpublic static final void prtlns(final long... a) { for(long ele : a) prtln(ele);\
    \ }\n\tpublic static final void prtlns(final double... a) { for(double ele : a)\
    \ prtln(ele); }\n\tpublic static final void prtlns(final Object[] a) { for(Object\
    \ ele : a) prtln(ele); }\n\tpublic static final void prtln(final char[][] a) {\
    \ for(char[] ele : a) prtln(ele); }\n\tpublic static final void prtln(final boolean[][]\
    \ a) { for(boolean[] ele : a) prtln(ele); }\n\tpublic static final void prtln(final\
    \ int[][] a) { for(int[] ele : a) prtln(ele); }\n\tpublic static final void prtln(final\
    \ long[][] a) { for(long[] ele : a) prtln(ele); }\n\tpublic static final void\
    \ prtln(final double[][] a) { for(double[] ele : a) prtln(ele); }\n\tpublic static\
    \ final void prtln(final double[][] a, int precision) { for(double[] ele : a)\
    \ prtln(ele, precision); }\n\tpublic static final void prtln(final String[][]\
    \ a) { for(String[] ele : a) prtln(ele); }\n\tpublic static final void prtln(final\
    \ Object[][] a) { for(Object[] ele : a) prtln(ele); }\n\n\tpublic static final\
    \ void errprt() { if(DEBUG) err.print(); }\n\tpublic static final void errprt(final\
    \ char c) { if(DEBUG) err.print(c); }\n\tpublic static final void errprt(final\
    \ boolean b) { if(DEBUG) err.print(booleanToChar(b)); }\n\tpublic static final\
    \ void errprt(final int x) { if(DEBUG) if(isINF(x)) err.print('_'); else err.print(x);\
    \ }\n\tpublic static final void errprt(final long x) { if(DEBUG) if(isINF(x))\
    \ err.print('_'); else err.print(x); }\n\tpublic static final void errprt(final\
    \ double d) { if(DEBUG) err.print(d); }\n\tpublic static final void errprt(final\
    \ String s) { if(DEBUG) err.print(s); }\n\tpublic static final void errprt(final\
    \ Object o) { if(DEBUG) err.print(o); }\n\tpublic static final void errprtln()\
    \ { if(DEBUG) err.println(); }\n\tpublic static final void errprtln(final char\
    \ c) { if(DEBUG) err.println(c); }\n\tpublic static final void errprtln(final\
    \ boolean b) { if(DEBUG) err.println(booleanToChar(b)); }\n\tpublic static final\
    \ void errprtln(final int x) { if(DEBUG) if(isINF(x)) err.println('_'); else err.println(x);\
    \ }\n\tpublic static final void errprtln(final long x) { if(DEBUG) if(isINF(x))\
    \ err.println('_'); else err.println(x); }\n\tpublic static final void errprtln(final\
    \ double d) { if(DEBUG) err.println(d); }\n\tpublic static final void errprtln(final\
    \ String s) { if(DEBUG) err.println(s); }\n\tpublic static final void errprtln(final\
    \ Object o) { if(DEBUG) err.println(o); }\n\tpublic static final void errprtln(final\
    \ char... a) { if(DEBUG) err.println(a); }\n\tpublic static final void errprtln(final\
    \ boolean... a) { if(DEBUG) err.println(booleanToChar(a)); }\n\tpublic static\
    \ final void errprtln(final int... a) {\n\t\tif(DEBUG) {\n\t\t\tboolean start\
    \ = false;\n\t\t\tfor(int ele : a) {\n\t\t\t\terrprt(ele);\n\t\t\t\tif(!start)\
    \ errprt(' ');\n\t\t\t\tstart = false;\n\t\t\t}\n\t\t\terr.println();\n\t\t}\n\
    \t}\n\tpublic static final void errprtln(final long... a) {\n\t\tif(DEBUG) {\n\
    \t\t\tboolean start = false;\n\t\t\tfor(long ele : a) {\n\t\t\t\terrprt(ele);\n\
    \t\t\t\tif(!start) errprt(' ');\n\t\t\t\tstart = false;\n\t\t\t}\n\t\t\terr.println();\n\
    \t\t}\n\t}\n\tpublic static final void errprtln(final double... a) { if(DEBUG)\
    \ err.println(a); }\n\tpublic static final void errprtln(final double[] a, final\
    \ int precision) { if(DEBUG) err.println(a, precision); }\n\tpublic static final\
    \ void errprtln(final String... a) { if(DEBUG) err.println(a); }\n\tpublic static\
    \ final void errprtln(final Object[] a) { if(DEBUG) err.println(a); }\n\tpublic\
    \ static final void errprtlns(final char... a) { if(DEBUG) for(char ele : a) errprtln(ele);\
    \ }\n\tpublic static final void errprtlns(final boolean... a) { if(DEBUG) for(boolean\
    \ ele : a) errprtln(ele); }\n\tpublic static final void errprtlns(final int...\
    \ a) { if(DEBUG) for(int ele : a) errprtln(ele); }\n\tpublic static final void\
    \ errprtlns(final long... a) { if(DEBUG) for(long ele : a) errprtln(ele); }\n\t\
    public static final void errprtlns(final double... a) { if(DEBUG) for(double ele\
    \ : a) errprtln(ele); }\n\tpublic static final void errprtlns(final Object[] a)\
    \ { if(DEBUG) for(Object ele : a) errprtln(ele); }\n\tpublic static final void\
    \ errprtln(final char[][] a) { if(DEBUG) for(char[] ele : a) errprtln(ele); }\n\
    \tpublic static final void errprtln(final boolean[][] a) { if(DEBUG) for(boolean[]\
    \ ele : a) errprtln(ele); }\n\tpublic static final void errprtln(final int[][]\
    \ a) { if(DEBUG) for(int[] ele : a) errprtln(ele); }\n\tpublic static final void\
    \ errprtln(final long[][] a) { if(DEBUG) for(long[] ele : a) errprtln(ele); }\n\
    \tpublic static final void errprtln(final double[][] a) { if(DEBUG) for(double[]\
    \ ele : a) errprtln(ele); }\n\tpublic static final void errprtln(final double[][]\
    \ a, int precision) { if(DEBUG) for(double[] ele : a) errprtln(ele, precision);\
    \ }\n\tpublic static final void errprtln(final String[][] a) { if(DEBUG) for(String[]\
    \ ele : a) errprtln(ele); }\n\tpublic static final void errprtln(final Object[][]\
    \ a) { if(DEBUG) for(Object[] ele : a) errprtln(ele); }\n\tpublic static final\
    \ void errprtlns(final Object[][] a) { if(DEBUG) for(Object[] ele : a) { errprtlns(ele);\
    \ errprtln(); } }\n\n\tpublic static final void reply(final boolean b) { prtln(b\
    \ ? \"Yes\" : \"No\"); }\n\tpublic static final void REPLY(final boolean b) {\
    \ prtln(b ? \"YES\" : \"NO\"); }\n\n\tpublic static final void flush() { out.flush();\
    \ if(DEBUG) err.flush(); }\n\tpublic static final void assertion(final boolean\
    \ b) { if(!b) { flush(); throw new AssertionError(); } }\n\tpublic static final\
    \ void assertion(final boolean b, final char c) { if(!b) { errprtln(c); flush();\
    \ throw new AssertionError(); } }\n\tpublic static final void assertion(final\
    \ boolean b, final boolean b2) { if(!b) { errprtln(b2); flush(); throw new AssertionError();\
    \ } }\n\tpublic static final void assertion(final boolean b, final int x) { if(!b)\
    \ { errprtln(x); flush(); throw new AssertionError(); } }\n\tpublic static final\
    \ void assertion(final boolean b, final long x) { if(!b) { errprtln(x); flush();\
    \ throw new AssertionError(); } }\n\tpublic static final void assertion(final\
    \ boolean b, final double d) { if(!b) { errprtln(d); flush(); throw new AssertionError();\
    \ } }\n\tpublic static final void assertion(final boolean b, final String s) {\
    \ if(!b) { errprtln(s); flush(); throw new AssertionError(); } }\n\tpublic static\
    \ final void assertion(final boolean b, final Object o) { if(!b) { errprtln(o);\
    \ flush(); throw new AssertionError(); } }\n\tpublic static final void assertion(final\
    \ boolean b, final char... a) { if(!b) { errprtln(a); flush(); throw new AssertionError();\
    \ } }\n\tpublic static final void assertion(final boolean b, final boolean...\
    \ a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }\n\tpublic\
    \ static final void assertion(final boolean b, final int... a) { if(!b) { errprtln(a);\
    \ flush(); throw new AssertionError(); } }\n\tpublic static final void assertion(final\
    \ boolean b, final long... a) { if(!b) { errprtln(a); flush(); throw new AssertionError();\
    \ } }\n\tpublic static final void assertion(final boolean b, final double... a)\
    \ { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }\n\tpublic static\
    \ final void assertion(final boolean b, final String... a) { if(!b) { errprtln(a);\
    \ flush(); throw new AssertionError(); } }\n\tpublic static final void assertion(final\
    \ boolean b, final Object[] a) { if(!b) { errprtln(a); flush(); throw new AssertionError();\
    \ } }\n\tpublic static final void assertion(final boolean b, final char[][] a)\
    \ { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }\n\tpublic static\
    \ final void assertion(final boolean b, final boolean[][] a) { if(!b) { errprtln(a);\
    \ flush(); throw new AssertionError(); } }\n\tpublic static final void assertion(final\
    \ boolean b, final int[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError();\
    \ } }\n\tpublic static final void assertion(final boolean b, final long[][] a)\
    \ { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }\n\tpublic static\
    \ final void assertion(final boolean b, final double[][] a) { if(!b) { errprtln(a);\
    \ flush(); throw new AssertionError(); } }\n\tpublic static final void assertion(final\
    \ boolean b, final String[][] a) { if(!b) { errprtln(a); flush(); throw new AssertionError();\
    \ } }\n\tpublic static final void assertion(final boolean b, final Object[][]\
    \ a) { if(!b) { errprtln(a); flush(); throw new AssertionError(); } }\n\tpublic\
    \ static final void inclusiveRangeCheck(final int i, final int max) { inclusiveRangeCheck(i,\
    \ 0, max); }\n\tpublic static final void inclusiveRangeCheck(final int i, final\
    \ int min, final int max) { rangeCheck(i, min, max + 1); }\n\tpublic static final\
    \ void inclusiveRangeCheck(final long i, final long max) { inclusiveRangeCheck(i,\
    \ 0, max); }\n\tpublic static final void inclusiveRangeCheck(final long i, final\
    \ long min, final long max) { rangeCheck(i, min, max + 1); }\n\tpublic static\
    \ final void rangeCheck(final int i, final int max) { rangeCheck(i, 0, max); }\n\
    \tpublic static final void rangeCheck(final int i, final int min, final int max)\
    \ { if(i < min || i >= max) throw new IndexOutOfBoundsException(String.format(\"\
    Index %d out of bounds for length %d\", i, max)); }\n\tpublic static final void\
    \ rangeCheck(final long i, final long max) { rangeCheck(i, 0, max); }\n\tpublic\
    \ static final void rangeCheck(final long i, final long min, final long max) {\
    \ if(i < min || i >= max) throw new IndexOutOfBoundsException(String.format(\"\
    Index %d out of bounds for length %d\", i, max)); }\n\tpublic static final void\
    \ nonNegativeCheck(final long x) { nonNegativeCheck(x, \"the argument\"); }\n\t\
    public static final void nonNegativeCheck(final long x, final String attribute)\
    \ { if(x < 0) throw new IllegalArgumentException(String.format(\"%s %d is negative\"\
    , attribute, x)); }\n\tpublic static final void positiveCheck(final long x) {\
    \ positiveCheck(x, \"the argument\"); }\n\tpublic static final void positiveCheck(final\
    \ long x, final String attribute) { if(x <= 0) throw new IllegalArgumentException(String.format(\"\
    %s %d is negative\", attribute, x)); }\n\n\tpublic static final void exit() {\
    \ flush(); System.exit(0); }\n\tpublic static final void exit(final char c) {\
    \ prtln(c); exit(); }\n\tpublic static final void exit(final boolean b) { prtln(b);\
    \ exit(); }\n\tpublic static final void exit(final int x) { prtln(x); exit();\
    \ }\n\tpublic static final void exit(final long x) { prtln(x); exit(); }\n\tpublic\
    \ static final void exit(final double d) { prtln(d); exit(); }\n\tpublic static\
    \ final void exit(final String s) { prtln(s); exit(); }\n\tpublic static final\
    \ void exit(final Object o) { prtln(o); exit(); }\n\tpublic static final void\
    \ exit(final char... a) { prtln(a); exit(); }\n\tpublic static final void exit(final\
    \ boolean... a) { prtln(a); exit(); }\n\tpublic static final void exit(final int...\
    \ a) { prtln(a); exit(); }\n\tpublic static final void exit(final long... a) {\
    \ prtln(a); exit(); }\n\tpublic static final void exit(final double... a) { prtln(a);\
    \ exit(); }\n\tpublic static final void exit(final String... a) { prtln(a); exit();\
    \ }\n\tpublic static final void exit(final Object[] a) { prtln(a); exit(); }\n\
    \tpublic static final void exit(final char[][] a) { prtln(a); exit(); }\n\tpublic\
    \ static final void exit(final boolean[][] a) { prtln(a); exit(); }\n\tpublic\
    \ static final void exit(final int[][] a) { prtln(a); exit(); }\n\tpublic static\
    \ final void exit(final long[][] a) { prtln(a); exit(); }\n\tpublic static final\
    \ void exit(final double[][] a) { prtln(a); exit(); }\n\tpublic static final void\
    \ exit(final String[][] a) { prtln(a); exit(); }\n\tpublic static final void exit(final\
    \ Object[][] a) { prtln(a); exit(); }\n\n\n\tpublic static final char booleanToChar(final\
    \ boolean b) { return b ? '#' : '.'; }\n\tpublic static final char[] booleanToChar(final\
    \ boolean... a) {\n\t\tfinal char c[] = new char[a.length];\n\t\tfor(int i = 0;\
    \ i < a.length; i ++) c[i] = booleanToChar(a[i]);\n\t\treturn c;\n\t}\n\tpublic\
    \ static final long INF = (long)4e18;\n\tpublic static final boolean isPlusINF(final\
    \ long x) { return x > INF / 10; }\n\tpublic static final boolean isMinusINF(final\
    \ long x) { return isPlusINF(- x); }\n\tpublic static final boolean isINF(final\
    \ long x) { return isPlusINF(x) || isMinusINF(x); }\n\tpublic static final int\
    \ I_INF = (int)1e9 + 1000;\n\tpublic static final boolean isPlusINF(final int\
    \ x) { return x > I_INF / 10; }\n\tpublic static final boolean isMinusINF(final\
    \ int x) { return isPlusINF(- x); }\n\tpublic static final boolean isINF(final\
    \ int x) { return isPlusINF(x) || isMinusINF(x); }\n}\nclass Util extends FastIO\
    \ {\n\tpublic static final int min(final int a, final int b) { return Math.min(a,\
    \ b); }\n\tpublic static final long min(final long a, final long b) { return Math.min(a,\
    \ b); }\n\tpublic static final double min(final double a, final double b) { return\
    \ Math.min(a, b); }\n\tpublic static final <T extends Comparable<T>> T min(final\
    \ T a, final T b) { return a.compareTo(b) <= 0 ? a : b; }\n\tpublic static final\
    \ int min(final int... x) { int min = x[0]; for(int val : x) min = min(min, val);\
    \ return min; }\n\tpublic static final long min(final long... x) { long min =\
    \ x[0]; for(long val : x) min = min(min, val); return min; }\n\tpublic static\
    \ final double min(final double... x) { double min = x[0]; for(double val : x)\
    \ min = min(min, val); return min; }\n\tpublic static final int max(final int\
    \ a, final int b) { return Math.max(a, b); }\n\tpublic static final long max(final\
    \ long a, final long b) { return Math.max(a, b); }\n\tpublic static final double\
    \ max(final double a, final double b) { return Math.max(a, b); }\n\tpublic static\
    \ final <T extends Comparable<T>> T max(final T a, final T b) { return a.compareTo(b)\
    \ >= 0 ? a : b; }\n\tpublic static final int max(final int... x) { int max = x[0];\
    \ for(int val : x) max = max(max, val); return max; }\n\tpublic static final long\
    \ max(final long... x) { long max = x[0]; for(long val : x) max = max(max, val);\
    \ return max; }\n\tpublic static final double max(final double... x) { double\
    \ max = x[0]; for(double val : x) max = max(max, val); return max; }\n\tpublic\
    \ static final <T extends Comparable<T>> T max(final T[] x) { T max = x[0]; for(T\
    \ val : x) max = max(max, val); return max; }\n\tpublic static final int max(final\
    \ int[][] a) { int max = a[0][0]; for(int[] ele : a) max = max(max, max(ele));\
    \ return max; }\n\tpublic static final long max(final long[][] a) { long max =\
    \ a[0][0]; for(long[] ele : a) max = max(max, max(ele)); return max; }\n\tpublic\
    \ static final double max(final double[][] a) { double max = a[0][0]; for(double[]\
    \ ele : a) max = max(max, max(ele)); return max; }\n\tpublic static final <T extends\
    \ Comparable<T>> T max(final T[][] a) { T max = a[0][0]; for(T[] ele : a) max\
    \ = max(max, max(ele)); return max; }\n\tpublic static final long sum(final int...\
    \ a) { long sum = 0; for(int ele : a) sum += ele; return sum; }\n\tpublic static\
    \ final long sum(final long... a) { long sum = 0; for(long ele : a) sum += ele;\
    \ return sum; }\n\tpublic static final double sum(final double... a) { double\
    \ sum = 0; for(double ele : a) sum += ele; return sum; }\n\tpublic static final\
    \ int sum(final boolean... a) { int sum = 0; for(boolean ele : a) sum += ele ?\
    \ 1 : 0; return sum; }\n\tpublic static final long[] sums(final int[] a) { long\
    \ sum[] = new long[a.length + 1]; sum[0] = 0; for(int i = 0; i < a.length; i ++)\
    \ sum[i + 1] = sum[i] + a[i]; return sum; }\n\tpublic static final long[] sums(final\
    \ long[] a) { long sum[] = new long[a.length + 1]; sum[0] = 0; for(int i = 0;\
    \ i < a.length; i ++) sum[i + 1] = sum[i] + a[i]; return sum; }\n\tpublic static\
    \ final double[] sums(final double[] a) { double sum[] = new double[a.length +\
    \ 1]; sum[0] = 0; for(int i = 0; i < a.length; i ++) sum[i + 1] = sum[i] + a[i];\
    \ return sum; }\n\tpublic static final int[] sums(final boolean[] a) { int sum[]\
    \ = new int[a.length + 1]; sum[0] = 0; for(int i = 0; i < a.length; i ++) sum[i\
    \ + 1] = sum[i] + (a[i] ? 1 : 0); return sum; }\n\tpublic static final long[][]\
    \ sums(final int[][] a) {\n\t\tfinal long sum[][] = new long[a.length + 1][a[0].length\
    \ + 1];\n\t\tfor(int i = 0; i < a.length; i ++) {\n\t\t\tfor(int j = 0; j < a[i].length;\
    \ j ++) sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + a[i][j];\n\
    \t\t}\n\t\treturn sum;\n\t}\n\tpublic static final long[][] sums(final long[][]\
    \ a) {\n\t\tfinal long sum[][] = new long[a.length + 1][a[0].length + 1];\n\t\t\
    for(int i = 0; i < a.length; i ++) {\n\t\t\tfor(int j = 0; j < a[i].length; j\
    \ ++) sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + a[i][j];\n\
    \t\t}\n\t\treturn sum;\n\t}\n\tpublic static final double[][] sums(final double[][]\
    \ a) {\n\t\tfinal double sum[][] = new double[a.length + 1][a[0].length + 1];\n\
    \t\tfor(int i = 0; i < a.length; i ++) {\n\t\t\tfor(int j = 0; j < a[i].length;\
    \ j ++) sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + a[i][j];\n\
    \t\t}\n\t\treturn sum;\n\t}\n\tpublic static final int[][] sums(final boolean[][]\
    \ a) {\n\t\tfinal int sum[][] = new int[a.length + 1][a[0].length + 1];\n\t\t\
    for(int i = 0; i < a.length; i ++) {\n\t\t\tfor(int j = 0; j < a[i].length; j\
    \ ++) sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + (a[i][j]\
    \ ? 1 : 0);\n\t\t}\n\t\treturn sum;\n\t}\n\tpublic static final int constrain(final\
    \ int x, final int l, final int r) { return min(max(x, min(l, r)), max(l, r));\
    \ }\n\tpublic static final long constrain(final long x, final long l, final long\
    \ r) { return min(max(x, min(l, r)), max(l, r)); }\n\tpublic static final double\
    \ constrain(final double x, final double l, final double r) { return min(max(x,\
    \ min(l, r)), max(l, r)); }\n\tpublic static final int abs(final int x) { return\
    \ x >= 0 ? x : - x; }\n\tpublic static final long abs(final long x) { return x\
    \ >= 0 ? x : - x; }\n\tpublic static final double abs(final double x) { return\
    \ x >= 0 ? x : - x; }\n\tpublic static final int signum(final int x) { return\
    \ x > 0 ? 1 : x < 0 ? -1 : 0; }\n\tpublic static final int signum(final long x)\
    \ { return x > 0 ? 1 : x < 0 ? -1 : 0; }\n\tpublic static final int signum(final\
    \ double x) { return x > 0 ? 1 : x < 0 ? -1 : 0; }\n\tpublic static final long\
    \ round(final double x) { return Math.round(x); }\n\tpublic static final long\
    \ floor(final double x) { return round(Math.floor(x)); }\n\tpublic static final\
    \ int divfloor(final int a, final int b) { return signum(a) == signum(b) ? a /\
    \ b : - divceil(abs(a), abs(b)); }\n\tpublic static final long divfloor(final\
    \ long a, final long b) { return signum(a) == signum(b) ? a / b : - divceil(abs(a),\
    \ abs(b)); }\n\tpublic static final long ceil(final double x) { return round(Math.ceil(x));\
    \ }\n\tpublic static final int divceil(final int a, final int b) { return a >=\
    \ 0 && b > 0 ? (a + b - 1) / b : a < 0 && b < 0 ? divceil(abs(a), abs(b)) : -\
    \ divfloor(abs(a), abs(b)); }\n\tpublic static final long divceil(final long a,\
    \ final long b) { return a >= 0 && b > 0 ? (a + b - 1) / b : a < 0 && b < 0 ?\
    \ divceil(abs(a), abs(b)) : - divfloor(abs(a), abs(b)); }\n\tpublic static final\
    \ boolean mulGreater(final long a, final long b, long c) { return b == 0 ? c <\
    \ 0 : b < 0 ? mulLess(a, - b, - c) : a > divfloor(c, b); } // a * b > c\n\tpublic\
    \ static final boolean mulGreaterEquals(final long a, final long b, final long\
    \ c) { return b == 0 ? c <= 0 : b < 0 ? mulLessEquals(a, - b, - c) : a >= divceil(c,\
    \ b); } // a * b >= c\n\tpublic static final boolean mulLess(final long a, final\
    \ long b, final long c) { return !mulGreaterEquals(a, b, c); } // a * b < c\n\t\
    public static final boolean mulLessEquals(final long a, final long b, final long\
    \ c) { return !mulGreater(a, b, c); } // a * b <= c\n\tpublic static final double\
    \ sqrt(final int x) { return Math.sqrt((double)x); }\n\tpublic static final double\
    \ sqrt(final long x) { return Math.sqrt((double)x); }\n\tpublic static final double\
    \ sqrt(final double x) { return Math.sqrt(x); }\n\tpublic static final int floorsqrt(final\
    \ int x) { int s = (int)floor(sqrt(x)) + 1; while(s * s > x) s --; return s; }\n\
    \tpublic static final long floorsqrt(final long x) { long s = floor(sqrt(x)) +\
    \ 1; while(s * s > x) s --; return s; }\n\tpublic static final int ceilsqrt(final\
    \ int x) { int s = (int)ceil(sqrt(x)); while(s * s >= x) s --; s ++; return s;\
    \ }\n\tpublic static final long ceilsqrt(final long x) { long s = ceil(sqrt(x));\
    \ while(s * s >= x) s --; s ++; return s; }\n\tpublic static final long fact(final\
    \ int n) { long ans = 1; for(int i = 1; i <= n; i ++) ans = Math.multiplyExact(ans,\
    \ i); return ans; }\n\tpublic static final long naiveP(final long n, final long\
    \ r) { long ans = 1; for(int i = 0; i < r; i ++) ans = Math.multiplyExact(ans,\
    \ n - i); return ans; }\n\tpublic static final long naiveC(final long n, final\
    \ long r) { long ans = 1; for(int i = 0; i < r; i ++) { ans = Math.multiplyExact(ans,\
    \ n - i); ans /= (i + 1); } return ans; }\n\tpublic static final double pow(final\
    \ double x, final double y) { return Math.pow(x, y); }\n\tpublic static final\
    \ long pow(long x, long y) {\n\t\tlong ans = 1;\n\t\twhile(true) {\n\t\t\tif((y\
    \ & 1) != 0) ans = Math.multiplyExact(ans, x);\n\t\t\ty >>= 1;\n\t\t\tif(y <=\
    \ 0) return ans;\n\t\t\tx = Math.multiplyExact(x, x);\n\t\t}\n\t}\n\tpublic static\
    \ final double pow(double x, long y) {\n\t\tdouble ans = 1;\n\t\twhile(true) {\n\
    \t\t\tif((y & 1) != 0) ans *= x;\n\t\t\ty >>= 1;\n\t\t\tif(y <= 0) return ans;\n\
    \t\t\tx *= x;\n\t\t}\n\t}\n\tpublic static final int gcd(int a, int b) { while(true)\
    \ { if(b == 0) return a; int tmp = a; a = b; b = tmp % b; } }\n\tpublic static\
    \ final long gcd(long a, long b) { while(true) { if(b == 0) return a; long tmp\
    \ = a; a = b; b = tmp % b; } }\n\tpublic static final long lcm(final long a, final\
    \ long b) { return a / gcd(a, b) * b; }\n\tpublic static final int gcd(final int...\
    \ a) { int gcd = 0; for(int ele : a) gcd = gcd(ele, gcd); return gcd; }\n\tpublic\
    \ static final long gcd(final long... a) { long gcd = 0; for(long ele : a) gcd\
    \ = gcd(ele, gcd); return gcd; }\n\tpublic static final long mod(long x, final\
    \ long mod) {\n\t\tif(0 <= x && x < mod) return x;\n\t\tif(- mod <= x && x < 0)\
    \ return x + mod;\n\t\treturn (x %= mod) < 0 ? x + mod : x;\n\t}\n\tpublic static\
    \ final long pow(long x, long y, final long mod) {\n\t\tnonNegativeCheck(y);\n\
    \t\tx = mod(x, mod);\n\t\tlong ans = 1;\n\t\tfor(; y > 0; y >>= 1) {\n\t\t\tif((y\
    \ & 1) != 0) ans = mod(ans * x, mod);\n\t\t\tx = mod(x * x, mod);\n\t\t}\n\t\t\
    return ans;\n\t}\n\tpublic static final long triangular(final long n) { return\
    \ n * (n + 1) / 2; }\n\tpublic static final long arctriangularfloor(final long\
    \ m) {\n\t\tlong n = (floor(sqrt(m * 8 + 1)) - 1) / 2 + 1;\n\t\twhile(triangular(n)\
    \ > m) n --;\n\t\treturn n;\n\t}\n\tpublic static final long arctriangularceil(final\
    \ long m) {\n\t\tlong n = max(0, (ceil(sqrt(m * 8 + 1)) + 1) / 2 - 1);\n\t\twhile(triangular(n)\
    \ < m) n ++;\n\t\treturn n;\n\t}\n\n\tpublic static final double random() { return\
    \ Math.random(); }\n\tpublic static final int random(final int max) { return (int)floor(random()\
    \ * max); }\n\tpublic static final long random(final long max) { return floor(random()\
    \ * max); }\n\tpublic static final double random(final double max) { return random()\
    \ * max; }\n\tpublic static final int random(final int min, final int max) { return\
    \ random(max - min) + min; }\n\tpublic static final long random(final long min,\
    \ final long max) { return random(max - min) + min; }\n\tpublic static final double\
    \ random(final double min, final double max) { return random(max - min) + min;\
    \ }\n\tpublic static final int[] randomi(final int n, final int max) { nonNegativeCheck(n);\
    \ final int a[] = new int[n]; for(int i = 0; i < n; i ++) a[i] = random(max);\
    \ return a; }\n\tpublic static final long[] randoml(final int n, final long max)\
    \ { nonNegativeCheck(n); final long a[] = new long[n]; for(int i = 0; i < n; i\
    \ ++) a[i] = random(max); return a; }\n\tpublic static final double[] randomd(final\
    \ int n, final double max) { nonNegativeCheck(n); final double a[] = new double[n];\
    \ for(int i = 0; i < n; i ++) a[i] = random(max); return a; }\n\tpublic static\
    \ final int[] randomi(final int n, final int min, final int max) { nonNegativeCheck(n);\
    \ final int a[] = new int[n]; for(int i = 0; i < n; i ++) a[i] = random(min, max);\
    \ return a; }\n\tpublic static final long[] randoml(final int n, final long min,\
    \ final long max) { nonNegativeCheck(n); final long a[] = new long[n]; for(int\
    \ i = 0; i < n; i ++) a[i] = random(min, max); return a; }\n\tpublic static final\
    \ double[] randomd(final int n, final double min, final double max) { nonNegativeCheck(n);\
    \ final double a[] = new double[n]; for(int i = 0; i < n; i ++) a[i] = random(min,\
    \ max); return a; }\n\n\tpublic static final long[] div(final long x) {\n\t\t\
    nonNegativeCheck(x);\n\t\tfinal List<Long> divList = new ArrayList<>();\n\t\t\
    for(long i = 1; i * i <= x; i ++) if(x % i == 0) { divList.add(i); if(i * i !=\
    \ x) divList.add(x / i); }\n\t\tfinal long div[] = new long[divList.size()];\n\
    \t\tfor(int i = 0; i < divList.size(); i ++) div[i] = divList.get(i);\n\t\tArrays.sort(div);\n\
    \t\treturn div;\n\t}\n\t// public static final PairLL[] factor(long x) {\n\t//\
    \ \tnonNegativeCheck(x);\n\t// \tfinal List<PairLL> factorList = new ArrayList<>();\n\
    \t// \tfor(long i = 2; i * i <= x; i ++) {\n\t// \t\tif(x % i == 0) {\n\t// \t\
    \t\tlong cnt = 0;\n\t// \t\t\twhile(x % i == 0) { x /= i; cnt ++; }\n\t// \t\t\
    \tfactorList.add(new PairLL(i, cnt));\n\t// \t\t}\n\t// \t}\n\t// \tif(x > 1)\
    \ factorList.add(new PairLL(x, 1));\n\t// \tfinal PairLL factor[] = new PairLL[factorList.size()];\n\
    \t// \tfor(int i = 0; i < factorList.size(); i ++) factor[i] = factorList.get(i);\n\
    \t// \tArrays.sort(factor);\n\t// \treturn factor;\n\t// }\n\tpublic static final\
    \ boolean isPrime(final long x) { if(x <= 1) return false; for(long i = 2; i *\
    \ i <= x; i ++) if(x % i == 0) return false; return true; }\n\tpublic static final\
    \ boolean[] prime(final int n) {\n\t\tnonNegativeCheck(n);\n\t\tfinal boolean\
    \ prime[] = new boolean[n];\n\t\tfill(prime, true);\n\t\tif(n > 0) prime[0] =\
    \ false;\n\t\tif(n > 1) prime[1] = false;\n\t\tfor(int i = 2; i < n; i ++) if(prime[i])\
    \ for(int j = 2; i * j < n; j ++) prime[i * j] = false;\n\t\treturn prime;\n\t\
    }\n\n\tpublic static final int[] baseConvert(long x, final int n, final int len)\
    \ {\n\t\tnonNegativeCheck(x);\n\t\tnonNegativeCheck(n);\n\t\tnonNegativeCheck(len);\n\
    \t\tfinal int digit[] = new int[len];\n\t\tint i = 0;\n\t\twhile(x > 0 && i <\
    \ len) { digit[i ++] = (int)(x % n); x /= n; }\n\t\treturn digit;\n\t}\n\tpublic\
    \ static final int[] baseConvert(final long x, final int n) {\n\t\tnonNegativeCheck(x);\n\
    \t\tnonNegativeCheck(n);\n\t\tlong tmp = x;\n\t\tint len = 0;\n\t\twhile(tmp >\
    \ 0) { tmp /= n; len ++; }\n\t\treturn baseConvert(x, n, len);\n\t}\n\tpublic\
    \ static final int[] baseConvert(int x, final int n, final int len) {\n\t\tnonNegativeCheck(x);\n\
    \t\tnonNegativeCheck(n);\n\t\tnonNegativeCheck(len);\n\t\tfinal int digit[] =\
    \ new int[len];\n\t\tint i = 0;\n\t\twhile(x > 0 && i < len) { digit[i ++] = (int)(x\
    \ % n); x /= n; }\n\t\treturn digit;\n\t}\n\tpublic static final int[] baseConvert(final\
    \ int x, final int n) {\n\t\tnonNegativeCheck(x);\n\t\tnonNegativeCheck(n);\n\t\
    \tint tmp = x;\n\t\tint len = 0;\n\t\twhile(tmp > 0) { tmp /= n; len ++; }\n\t\
    \treturn baseConvert(x, n, len);\n\t}\n\tpublic static final long[] baseConvert(long\
    \ x, final long n, final int len) {\n\t\tnonNegativeCheck(x);\n\t\tnonNegativeCheck(n);\n\
    \t\tnonNegativeCheck(len);\n\t\tfinal long digit[] = new long[len];\n\t\tint i\
    \ = 0;\n\t\twhile(x > 0 && i < len) { digit[i ++] = x % n; x /= n; }\n\t\treturn\
    \ digit;\n\t}\n\tpublic static final long[] baseConvert(final long x, final long\
    \ n) {\n\t\tnonNegativeCheck(x);\n\t\tnonNegativeCheck(n);\n\t\tlong tmp = x;\n\
    \t\tint len = 0;\n\t\twhile(tmp > 0) { tmp /= n; len ++; }\n\t\treturn baseConvert(x,\
    \ n, len);\n\t}\n\n\tpublic static final int numDigits(final long x) { nonNegativeCheck(x);\
    \ return Long.toString(x).length(); }\n\tpublic static final long bitFlag(final\
    \ int i) { nonNegativeCheck(i); return 1L << i; }\n\tpublic static final boolean\
    \ isFlagged(final long x, final int i) { nonNegativeCheck(x); nonNegativeCheck(i);\
    \ return (x >> i & 1) != 0; }\n\n\n\tpublic static final boolean isUpper(final\
    \ char c) { return c >= 'A' && c <= 'Z'; }\n\tpublic static final boolean isLower(final\
    \ char c) { return c >= 'a' && c <= 'z'; }\n\tpublic static final int upperToInt(final\
    \ char c) { return c - 'A'; }\n\tpublic static final int lowerToInt(final char\
    \ c) { return c - 'a'; }\n\tpublic static final int numToInt(final char c) { return\
    \ c - '0'; }\n\tpublic static final int charToInt(final char c) { return isLower(c)\
    \ ? lowerToInt(c) : isUpper(c) ? upperToInt(c) : numToInt(c); }\n\tpublic static\
    \ final int alphabetToInt(final char c) { return isLower(c) ? lowerToInt(c) :\
    \ isUpper(c) ? upperToInt(c) + 26 : 52; }\n\tpublic static final char intToUpper(final\
    \ int x) { return (char)(x + 'A'); }\n\tpublic static final char intToLower(final\
    \ int x) { return (char)(x + 'a'); }\n\tpublic static final char intToNum(final\
    \ int x) { return (char)(x + '0'); }\n\tpublic static final int[] charToInt(final\
    \ char[] a) { final int toint[] = new int[a.length]; for(int i = 0; i < a.length;\
    \ i ++) toint[i] = charToInt(a[i]); return toint; }\n\tpublic static final int[][]\
    \ charToInt(final char[][] a) { final int toint[][] = new int[a.length][]; for(int\
    \ i = 0; i < a.length; i ++) toint[i] = charToInt(a[i]); return toint; }\n\n\n\
    \tpublic static final String reverse(final String s) { return (new StringBuilder(s)).reverse().toString();\
    \ }\n\tpublic static final char[] reverse(final char[] a) { for(int i = 0; i <\
    \ a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }\n\tpublic static\
    \ final boolean[] reverse(final boolean[] a) { for(int i = 0; i < a.length / 2;\
    \ i ++) swap(a, i, a.length - i - 1); return a; }\n\tpublic static final int[]\
    \ reverse(final int[] a) { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length\
    \ - i - 1); return a; }\n\tpublic static final long[] reverse(final long[] a)\
    \ { for(int i = 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return\
    \ a; }\n\tpublic static final double[] reverse(final double[] a) { for(int i =\
    \ 0; i < a.length / 2; i ++) swap(a, i, a.length - i - 1); return a; }\n\tpublic\
    \ static final String[] reverse(final String[] a) { for(int i = 0; i < a.length\
    \ / 2; i ++) swap(a, i, a.length - i - 1); return a; }\n\tpublic static final\
    \ Object[] reverse(final Object[] a) { for(int i = 0; i < a.length / 2; i ++)\
    \ swap(a, i, a.length - i - 1); return a; }\n\tpublic static final void fill(final\
    \ char[] a, final char x) { Arrays.fill(a, x); }\n\tpublic static final void fill(final\
    \ boolean[] a, final boolean x) { Arrays.fill(a, x); }\n\tpublic static final\
    \ void fill(final int[] a, final int x) { Arrays.fill(a, x); }\n\tpublic static\
    \ final void fill(final long[] a, final long x) { Arrays.fill(a, x); }\n\tpublic\
    \ static final void fill(final double[] a, final double x) { Arrays.fill(a, x);\
    \ }\n\tpublic static final void fill(final char[][] a, final char x) { for(char[]\
    \ ele : a) fill(ele, x); }\n\tpublic static final void fill(final boolean[][]\
    \ a, final boolean x) { for(boolean[] ele : a) fill(ele, x); }\n\tpublic static\
    \ final void fill(final int[][] a, final int x) { for(int[] ele : a) fill(ele,\
    \ x); }\n\tpublic static final void fill(final long[][] a, final long x) { for(long[]\
    \ ele : a) fill(ele, x); }\n\tpublic static final void fill(final double[][] a,\
    \ final double x) { for(double[] ele : a) fill(ele, x); }\n\tpublic static final\
    \ void fill(final char[][][] a, final char x) { for(char[][] ele : a) fill(ele,\
    \ x); }\n\tpublic static final void fill(final boolean[][][] a, final boolean\
    \ x) { for(boolean[][] ele : a) fill(ele, x); }\n\tpublic static final void fill(final\
    \ int[][][] a, final int x) { for(int[][] ele : a) fill(ele, x); }\n\tpublic static\
    \ final void fill(final long[][][] a, final long x) { for(long[][] ele : a) fill(ele,\
    \ x); }\n\tpublic static final void fill(final double[][][] a, final double x)\
    \ { for(double[][] ele : a) fill(ele, x); }\n\tpublic static final char[] resize(final\
    \ char[] a, final int m, final int x) {\n\t\tnonNegativeCheck(m);\n\t\tfinal char\
    \ resized[] = new char[m];\n\t\tif(x <= - a.length || x >= m) return resized;\n\
    \t\tif(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));\n\t\t\
    else System.arraycopy(a, - x, resized, 0, min(a.length + x, m));\n\t\treturn resized;\n\
    \t}\n\tpublic static final boolean[] resize(final boolean[] a, final int m, final\
    \ int x) {\n\t\tnonNegativeCheck(m);\n\t\tfinal boolean resized[] = new boolean[m];\n\
    \t\tif(x <= - a.length || x >= m) return resized;\n\t\tif(x >= 0) System.arraycopy(a,\
    \ 0, resized, x, min(a.length, m - x));\n\t\telse System.arraycopy(a, - x, resized,\
    \ 0, min(a.length + x, m));\n\t\treturn resized;\n\t}\n\tpublic static final int[]\
    \ resize(final int[] a, final int m, final int x) {\n\t\tnonNegativeCheck(m);\n\
    \t\tfinal int resized[] = new int[m];\n\t\tif(x <= - a.length || x >= m) return\
    \ resized;\n\t\tif(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m\
    \ - x));\n\t\telse System.arraycopy(a, - x, resized, 0, min(a.length + x, m));\n\
    \t\treturn resized;\n\t}\n\tpublic static final long[] resize(final long[] a,\
    \ final int m, final int x) {\n\t\tnonNegativeCheck(m);\n\t\tfinal long resized[]\
    \ = new long[m];\n\t\tif(x <= - a.length || x >= m) return resized;\n\t\tif(x\
    \ >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));\n\t\telse System.arraycopy(a,\
    \ - x, resized, 0, min(a.length + x, m));\n\t\treturn resized;\n\t}\n\tpublic\
    \ static final double[] resize(final double[] a, final int m, final int x) {\n\
    \t\tnonNegativeCheck(m);\n\t\tfinal double resized[] = new double[m];\n\t\tif(x\
    \ <= - a.length || x >= m) return resized;\n\t\tif(x >= 0) System.arraycopy(a,\
    \ 0, resized, x, min(a.length, m - x));\n\t\telse System.arraycopy(a, - x, resized,\
    \ 0, min(a.length + x, m));\n\t\treturn resized;\n\t}\n\tpublic static final String[]\
    \ resize(final String[] a, final int m, final int x) {\n\t\tnonNegativeCheck(m);\n\
    \t\tfinal String resized[] = new String[m];\n\t\tif(x <= - a.length || x >= m)\
    \ return resized;\n\t\tif(x >= 0) System.arraycopy(a, 0, resized, x, min(a.length,\
    \ m - x));\n\t\telse System.arraycopy(a, - x, resized, 0, min(a.length + x, m));\n\
    \t\treturn resized;\n\t}\n\tpublic static final Object[] resize(final Object[]\
    \ a, final int m, final int x) {\n\t\tnonNegativeCheck(m);\n\t\tfinal Object resized[]\
    \ = new Object[m];\n\t\tif(x <= - a.length || x >= m) return resized;\n\t\tif(x\
    \ >= 0) System.arraycopy(a, 0, resized, x, min(a.length, m - x));\n\t\telse System.arraycopy(a,\
    \ - x, resized, 0, min(a.length + x, m));\n\t\treturn resized;\n\t}\n\tpublic\
    \ static final char[][] rotate(final char[][] a) {\n\t\tfinal char[][] ans = new\
    \ char[a[0].length][a.length];\n\t\tfor(int i = 0; i < a.length; i ++) for(int\
    \ j = 0; j < a[i].length; j ++) ans[j][a.length - i - 1] = a[i][j];\n\t\treturn\
    \ ans;\n\t}\n\tpublic static final boolean[][] rotate(final boolean[][] a) {\n\
    \t\tfinal boolean[][] ans = new boolean[a[0].length][a.length];\n\t\tfor(int i\
    \ = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length\
    \ - i - 1] = a[i][j];\n\t\treturn ans;\n\t}\n\tpublic static final int[][] rotate(final\
    \ int[][] a) {\n\t\tfinal int[][] ans = new int[a[0].length][a.length];\n\t\t\
    for(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length\
    \ - i - 1] = a[i][j];\n\t\treturn ans;\n\t}\n\tpublic static final long[][] rotate(final\
    \ long[][] a) {\n\t\tfinal long[][] ans = new long[a[0].length][a.length];\n\t\
    \tfor(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length\
    \ - i - 1] = a[i][j];\n\t\treturn ans;\n\t}\n\tpublic static final double[][]\
    \ rotate(final double[][] a) {\n\t\tfinal double[][] ans = new double[a[0].length][a.length];\n\
    \t\tfor(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length\
    \ - i - 1] = a[i][j];\n\t\treturn ans;\n\t}\n\tpublic static final Object[][]\
    \ rotate(final Object[][] a) {\n\t\tfinal Object[][] ans = new Object[a[0].length][a.length];\n\
    \t\tfor(int i = 0; i < a.length; i ++) for(int j = 0; j < a[i].length; j ++) ans[j][a.length\
    \ - i - 1] = a[i][j];\n\t\treturn ans;\n\t}\n\tpublic static final int[] compress(final\
    \ int[] a) {\n\t\tfinal int n = a.length;\n\t\tfinal Set<Integer> ts = new TreeSet<>();\n\
    \t\tfor(int i = 0; i < n; i ++) ts.add(a[i]);\n\t\tfinal int compressed[] = new\
    \ int[ts.size()];\n\t\tint j = 0;\n\t\tfor(int x : ts) compressed[j ++] = x;\n\
    \t\tfor(int i = 0; i < n; i ++) a[i] = lowerBound(compressed, a[i]);\n\t\treturn\
    \ compressed;\n\t}\n\tpublic static final long[] compress(final long[] a) {\n\t\
    \tfinal int n = a.length;\n\t\tfinal Set<Long> ts = new TreeSet<>();\n\t\tfor(int\
    \ i = 0; i < n; i ++) ts.add(a[i]);\n\t\tfinal long compressed[] = new long[ts.size()];\n\
    \t\tint j = 0;\n\t\tfor(long x : ts) compressed[j ++] = x;\n\t\tfor(int i = 0;\
    \ i < n; i ++) a[i] = lowerBound(compressed, a[i]);\n\t\treturn compressed;\n\t\
    }\n\tpublic static final double[] compress(final double[] a) {\n\t\tfinal int\
    \ n = a.length;\n\t\tfinal Set<Double> ts = new TreeSet<>();\n\t\tfor(int i =\
    \ 0; i < n; i ++) ts.add(a[i]);\n\t\tfinal double compressed[] = new double[ts.size()];\n\
    \t\tint j = 0;\n\t\tfor(double x : ts) compressed[j ++] = x;\n\t\tfor(int i =\
    \ 0; i < n; i ++) a[i] = lowerBound(compressed, a[i]);\n\t\treturn compressed;\n\
    \t}\n\tpublic static final void swap(final char[] a, final int i, final int j)\
    \ { rangeCheck(i, a.length); rangeCheck(j, a.length); char tmp = a[i]; a[i] =\
    \ a[j]; a[j] = tmp; }\n\tpublic static final void swap(final boolean[] a, final\
    \ int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); boolean\
    \ tmp = a[i]; a[i] = a[j]; a[j] = tmp; }\n\tpublic static final void swap(final\
    \ int[] a, final int i, final int j) { rangeCheck(i, a.length); rangeCheck(j,\
    \ a.length); int tmp = a[i]; a[i] = a[j]; a[j] = tmp; }\n\tpublic static final\
    \ void swap(final long[] a, final int i, final int j) { rangeCheck(i, a.length);\
    \ rangeCheck(j, a.length); long tmp = a[i]; a[i] = a[j]; a[j] = tmp; }\n\tpublic\
    \ static final void swap(final double[] a, final int i, final int j) { rangeCheck(i,\
    \ a.length); rangeCheck(j, a.length); double tmp = a[i]; a[i] = a[j]; a[j] = tmp;\
    \ }\n\tpublic static final void swap(final String[] a, final int i, final int\
    \ j) { rangeCheck(i, a.length); rangeCheck(j, a.length); String tmp = a[i]; a[i]\
    \ = a[j]; a[j] = tmp; }\n\tpublic static final void swap(final Object[] a, final\
    \ int i, final int j) { rangeCheck(i, a.length); rangeCheck(j, a.length); Object\
    \ tmp = a[i]; a[i] = a[j]; a[j] = tmp; }\n\tpublic static final void shuffleArray(final\
    \ int[] a) { for(int i = 0; i < a.length; i ++) swap(a, i, random(i, a.length));\
    \ }\n\tpublic static final void shuffleArray(final long[] a) { for(int i = 0;\
    \ i < a.length; i ++) swap(a, i, random(i, a.length)); }\n\tpublic static final\
    \ void shuffleArray(final double[] a) { for(int i = 0; i < a.length; i ++) swap(a,\
    \ i, random(i, a.length)); }\n\n\tpublic static final int[] toIntArray(final List<Integer>\
    \ list) { final int a[] = new int[list.size()]; int idx = 0; for(int ele : list)\
    \ a[idx ++] = ele; return a; }\n\tpublic static final long[] toLongArray(final\
    \ List<Long> list) { final long a[] = new long[list.size()]; int idx = 0; for(long\
    \ ele : list) a[idx ++] = ele; return a; }\n\tpublic static final double[] toDoubleArray(final\
    \ List<Double> list) { final double a[] = new double[list.size()]; int idx = 0;\
    \ for(double ele : list) a[idx ++] = ele; return a; }\n\tpublic static final char[]\
    \ toCharArray(final List<Character> list) { final char a[] = new char[list.size()];\
    \ int idx = 0; for(char ele : list) a[idx ++] = ele; return a; }\n\tpublic static\
    \ final boolean[] toBooleanArray(final List<Boolean> list) { final boolean a[]\
    \ = new boolean[list.size()]; int idx = 0; for(boolean ele : list) a[idx ++] =\
    \ ele; return a; }\n\tpublic static final String[] toStringArray(final List<String>\
    \ list) { final String a[] = new String[list.size()]; int idx = 0; for(String\
    \ ele : list) a[idx ++] = ele; return a; }\n\tpublic static final <T> void toArray(final\
    \ List<T> list, final T a[]) { int idx = 0; for(T ele : list) a[idx ++] = ele;\
    \ }\n\n\n\t// public static final PairIL[] countElements(final int[] a, final\
    \ boolean sort) {\n\t// \tfinal int len = a.length;\n\t// \tfinal int array[]\
    \ = new int[len];\n\t// \tfor(int i = 0; i < len; i ++) array[i] = a[i];\n\t//\
    \ \tif(sort) Arrays.sort(array);\n\t// \tfinal List<PairIL> cntsList = new ArrayList<>();\n\
    \t// \tlong tmp = 1;\n\t// \tfor(int i = 1; i <= len; i ++) {\n\t// \t\tif(i ==\
    \ len || array[i] != array[i - 1]) {\n\t// \t\t\tcntsList.add(new PairIL(array[i\
    \ - 1], tmp));\n\t// \t\t\ttmp = 1;\n\t// \t\t}else tmp ++;\n\t// \t}\n\t// \t\
    final PairIL cnts[] = new PairIL[cntsList.size()];\n\t// \tfor(int i = 0; i <\
    \ cntsList.size(); i ++) cnts[i] = cntsList.get(i);\n\t// \treturn cnts;\n\t//\
    \ }\n\t// public static final PairLL[] countElements(final long[] a, final boolean\
    \ sort) {\n\t// \tfinal int len = a.length;\n\t// \tfinal long array[] = new long[len];\n\
    \t// \tfor(int i = 0; i < len; i ++) array[i] = a[i];\n\t// \tif(sort) Arrays.sort(array);\n\
    \t// \tfinal List<PairLL> cntsList = new ArrayList<>();\n\t// \tlong tmp = 1;\n\
    \t// \tfor(int i = 1; i <= len; i ++) {\n\t// \t\tif(i == len || array[i] != array[i\
    \ - 1]) {\n\t// \t\t\tcntsList.add(new PairLL(array[i - 1], tmp));\n\t// \t\t\t\
    tmp = 1;\n\t// \t\t}else tmp ++;\n\t// \t}\n\t// \tfinal PairLL cnts[] = new PairLL[cntsList.size()];\n\
    \t// \tfor(int i = 0; i < cntsList.size(); i ++) cnts[i] = cntsList.get(i);\n\t\
    // \treturn cnts;\n\t// }\n\t// public static final PairIL[] countElements(final\
    \ String s, final boolean sort) {\n\t// \tfinal int len = s.length();\n\t// \t\
    final char array[] = s.toCharArray();\n\t// \tif(sort) Arrays.sort(array);\n\t\
    // \tfinal List<PairIL> cntsList = new ArrayList<>();\n\t// \tlong tmp = 1;\n\t\
    // \tfor(int i = 1; i <= len; i ++) {\n\t// \t\tif(i == len || array[i] != array[i\
    \ - 1]) {\n\t// \t\t\tcntsList.add(new PairIL((int)array[i - 1], tmp));\n\t//\
    \ \t\t\ttmp = 1;\n\t// \t\t}else tmp ++;\n\t// \t}\n\t// \tfinal PairIL cnts[]\
    \ = new PairIL[cntsList.size()];\n\t// \tfor(int i = 0; i < cntsList.size(); i\
    \ ++) cnts[i] = cntsList.get(i);\n\t// \treturn cnts;\n\t// }\n\tpublic static\
    \ final long countString(final String s, final String t) { return (s.length()\
    \ - s.replace(t, \"\").length()) / t.length(); }\n\tpublic static final long countStringAll(final\
    \ String s, final String t) { return s.length() - s.replaceAll(t, \"\").length();\
    \ }\n\n\n\t// binary search\n\tpublic static final int lowerBound(final int[]\
    \ a, final int key) { return BS(a, key, true, true, true); }\n\tpublic static\
    \ final int lowerBound(final int[] a, final int key, final int ng, final int ok)\
    \ { return BS(a, key, true, true, true, ng, ok); }\n\tpublic static final int\
    \ upperBound(final int[] a, final int key) { return BS(a, key, true, true, false);\
    \ }\n\tpublic static final int upperBound(final int[] a, final int key, final\
    \ int ng, final int ok) { return BS(a, key, true, true, false, ng, ok); }\n\t\
    public static final int cntBS(final int[] a, final int key, final boolean asc,\
    \ final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, true);\
    \ }\n\tpublic static final int cntBS(final int[] a, final int key,\n\t\t\tfinal\
    \ boolean asc, final boolean gt, final boolean eq, final int ng, final int ok)\
    \ { return BS(a, key, asc, gt, eq, true, ng, ok); }\n\tpublic static final int\
    \ BS(final int[] a, final int key,\n\t\t\tfinal boolean asc, final boolean gt,\
    \ final boolean eq) { return BS(a, key, asc, gt, eq, false); }\n\tpublic static\
    \ final int BS(final int[] a, final int key,\n\t\t\tfinal boolean asc, final boolean\
    \ gt, final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt,\
    \ eq, false, ng, ok); }\n\tpublic static final int BS(final int[] a, final int\
    \ key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean eq, final boolean\
    \ cnt) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.length : -1, asc ^ gt\
    \ ? -1 : a.length); }\n\tpublic static final int BS(final int[] a, final int key,\
    \ final boolean asc, final boolean gt, final boolean eq, final boolean cnt, final\
    \ int ng, final int ok) {\n\t\tint index = binarySearch(a, key, gt, eq, ng, ok);\n\
    \t\treturn cnt ? (int)abs(ok - index) : index;\n\t}\n\tpublic static final int\
    \ binarySearch(final int[] a, final int key, final boolean gt, final boolean eq,\
    \ int ng, int ok) {\n\t\twhile(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a,\
    \ mid, key, gt, eq)) ok = mid; else ng = mid; }\n\t\treturn ok;\n\t}\n\tpublic\
    \ static final boolean isOKforBS(final int[] a, final int index, final int key,\
    \ final boolean gt, final boolean eq) {\n\t\treturn (a[index] > key && gt) ||\
    \ (a[index] < key && !gt) || (a[index] == key && eq);\n\t}\n\tpublic static final\
    \ int lowerBound(final long[] a, final long key) { return BS(a, key, true, true,\
    \ true); }\n\tpublic static final int lowerBound(final long[] a, final long key,\
    \ final int ng, final int ok) { return BS(a, key, true, true, true, ng, ok); }\n\
    \tpublic static final int upperBound(final long[] a, final long key) { return\
    \ BS(a, key, true, true, false); }\n\tpublic static final int upperBound(final\
    \ long[] a, final long key, final int ng, final int ok) { return BS(a, key, true,\
    \ true, false, ng, ok); }\n\tpublic static final int cntBS(final long[] a, final\
    \ long key, final boolean asc, final boolean gt, final boolean eq) { return BS(a,\
    \ key, asc, gt, eq, true); }\n\tpublic static final int cntBS(final long[] a,\
    \ final long key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean eq,\
    \ final int ng, final int ok) { return BS(a, key, asc, gt, eq, true, ng, ok);\
    \ }\n\tpublic static final int BS(final long[] a, final long key,\n\t\t\tfinal\
    \ boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt,\
    \ eq, false); }\n\tpublic static final int BS(final long[] a, final long key,\n\
    \t\t\tfinal boolean asc, final boolean gt, final boolean eq, final int ng, final\
    \ int ok) { return BS(a, key, asc, gt, eq, false, ng, ok); }\n\tpublic static\
    \ final int BS(final long[] a, final long key,\n\t\t\tfinal boolean asc, final\
    \ boolean gt, final boolean eq, final boolean cnt) { return BS(a, key, asc, gt,\
    \ eq, cnt, asc ^ gt ? a.length : -1, asc ^ gt ? -1 : a.length); }\n\tpublic static\
    \ final int BS(final long[] a, final long key, final boolean asc, final boolean\
    \ gt, final boolean eq, final boolean cnt, final int ng, final int ok) {\n\t\t\
    int index = binarySearch(a, key, gt, eq, ng, ok);\n\t\treturn cnt ? (int)abs(ok\
    \ - index) : index;\n\t}\n\tpublic static final int binarySearch(final long[]\
    \ a, final long key, final boolean gt, final boolean eq, int ng, int ok) {\n\t\
    \twhile(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key,\
    \ gt, eq)) ok = mid; else ng = mid; }\n\t\treturn ok;\n\t}\n\tpublic static final\
    \ boolean isOKforBS(final long[] a, final int index, final long key, final boolean\
    \ gt, final boolean eq) {\n\t\treturn (a[index] > key && gt) || (a[index] < key\
    \ && !gt) || (a[index] == key && eq);\n\t}\n\tpublic static final int lowerBound(final\
    \ double[] a, final double key) { return BS(a, key, true, true, true); }\n\tpublic\
    \ static final int lowerBound(final double[] a, final double key, final int ng,\
    \ final int ok) { return BS(a, key, true, true, true, ng, ok); }\n\tpublic static\
    \ final int upperBound(final double[] a, final double key) { return BS(a, key,\
    \ true, true, false); }\n\tpublic static final int upperBound(final double[] a,\
    \ final double key, final int ng, final int ok) { return BS(a, key, true, true,\
    \ false, ng, ok); }\n\tpublic static final int cntBS(final double[] a, final double\
    \ key, final boolean asc, final boolean gt, final boolean eq) { return BS(a, key,\
    \ asc, gt, eq, true); }\n\tpublic static final int cntBS(final double[] a, final\
    \ double key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean eq, final\
    \ int ng, final int ok) { return BS(a, key, asc, gt, eq, true, ng, ok); }\n\t\
    public static final int BS(final double[] a, final double key,\n\t\t\tfinal boolean\
    \ asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt, eq, false);\
    \ }\n\tpublic static final int BS(final double[] a, final double key,\n\t\t\t\
    final boolean asc, final boolean gt, final boolean eq, final int ng, final int\
    \ ok) { return BS(a, key, asc, gt, eq, false, ng, ok); }\n\tpublic static final\
    \ int BS(final double[] a, final double key,\n\t\t\tfinal boolean asc, final boolean\
    \ gt, final boolean eq, final boolean cnt) { return BS(a, key, asc, gt, eq, cnt,\
    \ asc ^ gt ? a.length : -1, asc ^ gt ? -1 : a.length); }\n\tpublic static final\
    \ int BS(final double[] a, final double key, final boolean asc, final boolean\
    \ gt, final boolean eq, final boolean cnt, final int ng, final int ok) {\n\t\t\
    int index = binarySearch(a, key, gt, eq, ng, ok);\n\t\treturn cnt ? (int)abs(ok\
    \ - index) : index;\n\t}\n\tpublic static final int binarySearch(final double[]\
    \ a, final double key, final boolean gt, final boolean eq, int ng, int ok) {\n\
    \t\twhile(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key,\
    \ gt, eq)) ok = mid; else ng = mid; }\n\t\treturn ok;\n\t}\n\tpublic static final\
    \ boolean isOKforBS(final double[] a, final int index, final double key, final\
    \ boolean gt, final boolean eq) {\n\t\treturn (a[index] > key && gt) || (a[index]\
    \ < key && !gt) || (a[index] == key && eq);\n\t}\n\tpublic static final <T extends\
    \ Comparable<? super T>> int lowerBound(final T[] a, final T key) { return BS(a,\
    \ key, true, true, true); }\n\tpublic static final <T extends Comparable<? super\
    \ T>> int lowerBound(final T[] a, final T key, final int ng, final int ok) { return\
    \ BS(a, key, true, true, true, ng, ok); }\n\tpublic static final <T extends Comparable<?\
    \ super T>> int upperBound(final T[] a, final T key) { return BS(a, key, true,\
    \ true, false); }\n\tpublic static final <T extends Comparable<? super T>> int\
    \ upperBound(final T[] a, final T key, final int ng, final int ok) { return BS(a,\
    \ key, true, true, false, ng, ok); }\n\tpublic static final <T extends Comparable<?\
    \ super T>> int cntBS(final T[] a, final T key, final boolean asc, final boolean\
    \ gt, final boolean eq) { return BS(a, key, asc, gt, eq, true); }\n\tpublic static\
    \ final <T extends Comparable<? super T>> int cntBS(final T[] a, final T key,\n\
    \t\t\tfinal boolean asc, final boolean gt, final boolean eq, final int ng, final\
    \ int ok) { return BS(a, key, asc, gt, eq, true, ng, ok); }\n\tpublic static final\
    \ <T extends Comparable<? super T>> int BS(final T[] a, final T key,\n\t\t\tfinal\
    \ boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc, gt,\
    \ eq, false); }\n\tpublic static final <T extends Comparable<? super T>> int BS(final\
    \ T[] a, final T key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean\
    \ eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq, false, ng,\
    \ ok); }\n\tpublic static final <T extends Comparable<? super T>> int BS(final\
    \ T[] a, final T key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean\
    \ eq, final boolean cnt) { return BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.length\
    \ : -1, asc ^ gt ? -1 : a.length); }\n\tpublic static final <T extends Comparable<?\
    \ super T>> int BS(final T[] a, final T key, final boolean asc, final boolean\
    \ gt, final boolean eq, final boolean cnt, final int ng, final int ok) {\n\t\t\
    int index = binarySearch(a, key, gt, eq, ng, ok);\n\t\treturn cnt ? (int)abs(ok\
    \ - index) : index;\n\t}\n\tpublic static final <T extends Comparable<? super\
    \ T>> int binarySearch(final T[] a, final T key, final boolean gt, final boolean\
    \ eq, int ng, int ok) {\n\t\twhile(abs(ok - ng) > 1) { int mid = (ok + ng) >>\
    \ 1; if(isOKforBS(a, mid, key, gt, eq)) ok = mid; else ng = mid; }\n\t\treturn\
    \ ok;\n\t}\n\tpublic static final <T extends Comparable<? super T>> boolean isOKforBS(final\
    \ T[] a, final int index, final T key, final boolean gt, final boolean eq) {\n\
    \t\tint compare = a[index].compareTo(key);\n\t\treturn (compare > 0 && gt) ||\
    \ (compare < 0 && !gt) || (compare == 0 && eq);\n\t}\n\tpublic static final <T>\
    \ int lowerBound(final T[] a, final T key, final Comparator<? super T> c) { return\
    \ BS(a, key, true, true, true, c); }\n\tpublic static final <T> int lowerBound(final\
    \ T[] a, final T key, final int ng, final int ok, final Comparator<? super T>\
    \ c) { return BS(a, key, true, true, true, ng, ok, c); }\n\tpublic static final\
    \ <T> int upperBound(final T[] a, final T key, final Comparator<? super T> c)\
    \ { return BS(a, key, true, true, false, c); }\n\tpublic static final <T> int\
    \ upperBound(final T[] a, final T key, final int ng, final int ok, final Comparator<?\
    \ super T> c) { return BS(a, key, true, true, false, ng, ok, c); }\n\tpublic static\
    \ final <T> int cntBS(final T[] a, final T key, final boolean asc, final boolean\
    \ gt, final boolean eq, final Comparator<? super T> c) { return BS(a, key, asc,\
    \ gt, eq, true, c); }\n\tpublic static final <T> int cntBS(final T[] a, final\
    \ T key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean eq, final int\
    \ ng, final int ok, final Comparator<? super T> c) { return BS(a, key, asc, gt,\
    \ eq, true, ng, ok, c); }\n\tpublic static final <T> int BS(final T[] a, final\
    \ T key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean eq, final Comparator<?\
    \ super T> c) { return BS(a, key, asc, gt, eq, false, c); }\n\tpublic static final\
    \ <T> int BS(final T[] a, final T key,\n\t\t\tfinal boolean asc, final boolean\
    \ gt, final boolean eq, final int ng, final int ok, final Comparator<? super T>\
    \ c) { return BS(a, key, asc, gt, eq, false, ng, ok, c); }\n\tpublic static final\
    \ <T> int BS(final T[] a, final T key,\n\t\t\tfinal boolean asc, final boolean\
    \ gt, final boolean eq, final boolean cnt, final Comparator<? super T> c) { return\
    \ BS(a, key, asc, gt, eq, cnt, asc ^ gt ? a.length : -1, asc ^ gt ? -1 : a.length,\
    \ c); }\n\tpublic static final <T> int BS(final T[] a, final T key, final boolean\
    \ asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final\
    \ int ok, final Comparator<? super T> c) {\n\t\tint index = binarySearch(a, key,\
    \ gt, eq, ng, ok, c);\n\t\treturn cnt ? (int)abs(ok - index) : index;\n\t}\n\t\
    public static final <T> int binarySearch(final T[] a, final T key, final boolean\
    \ gt, final boolean eq, int ng, int ok, final Comparator<? super T> c) {\n\t\t\
    while(abs(ok - ng) > 1) { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key,\
    \ gt, eq, c)) ok = mid; else ng = mid; }\n\t\treturn ok;\n\t}\n\tpublic static\
    \ final <T> boolean isOKforBS(final T[] a, final int index, T key, final boolean\
    \ gt, final boolean eq, final Comparator<? super T> c) {\n\t\tint compare = c.compare(a[index],\
    \ key);\n\t\treturn (compare > 0 && gt) || (compare < 0 && !gt) || (compare ==\
    \ 0 && eq);\n\t}\n\tpublic static final <T extends Comparable<? super T>> int\
    \ lowerBound(final List<T> a, final T key) { return BS(a, key, true, true, true);\
    \ }\n\tpublic static final <T extends Comparable<? super T>> int lowerBound(final\
    \ List<T> a, final T key, final int ng, final int ok) { return BS(a, key, true,\
    \ true, true, ng, ok); }\n\tpublic static final <T extends Comparable<? super\
    \ T>> int upperBound(final List<T> a, final T key) { return BS(a, key, true, true,\
    \ false); }\n\tpublic static final <T extends Comparable<? super T>> int upperBound(final\
    \ List<T> a, final T key, final int ng, final int ok) { return BS(a, key, true,\
    \ true, false, ng, ok); }\n\tpublic static final <T extends Comparable<? super\
    \ T>> int cntBS(final List<T> a, final T key, final boolean asc, final boolean\
    \ gt, final boolean eq) { return BS(a, key, asc, gt, eq, true); }\n\tpublic static\
    \ final <T extends Comparable<? super T>> int cntBS(final List<T> a, final T key,\n\
    \t\t\tfinal boolean asc, final boolean gt, final boolean eq, final int ng, final\
    \ int ok) { return BS(a, key, asc, gt, eq, true, ng, ok); }\n\tpublic static final\
    \ <T extends Comparable<? super T>> int BS(final List<T> a, final T key,\n\t\t\
    \tfinal boolean asc, final boolean gt, final boolean eq) { return BS(a, key, asc,\
    \ gt, eq, false); }\n\tpublic static final <T extends Comparable<? super T>> int\
    \ BS(final List<T> a, final T key,\n\t\t\tfinal boolean asc, final boolean gt,\
    \ final boolean eq, final int ng, final int ok) { return BS(a, key, asc, gt, eq,\
    \ false, ng, ok); }\n\tpublic static final <T extends Comparable<? super T>> int\
    \ BS(final List<T> a, final T key,\n\t\t\tfinal boolean asc, final boolean gt,\
    \ final boolean eq, final boolean cnt) { return BS(a, key, asc, gt, eq, cnt, asc\
    \ ^ gt ? a.size() : -1, asc ^ gt ? -1 : a.size()); }\n\tpublic static final <T\
    \ extends Comparable<? super T>> int BS(final List<T> a, final T key, final boolean\
    \ asc, final boolean gt, final boolean eq, final boolean cnt, final int ng, final\
    \ int ok) {\n\t\tint index = binarySearch(a, key, gt, eq, ng, ok);\n\t\treturn\
    \ cnt ? (int)abs(ok - index) : index;\n\t}\n\tpublic static final <T extends Comparable<?\
    \ super T>> int binarySearch(final List<T> a, final T key, final boolean gt, final\
    \ boolean eq, int ng, int ok) {\n\t\twhile(abs(ok - ng) > 1) { int mid = (ok +\
    \ ng) >> 1; if(isOKforBS(a, mid, key, gt, eq)) ok = mid; else ng = mid; }\n\t\t\
    return ok;\n\t}\n\tpublic static final <T extends Comparable<? super T>> boolean\
    \ isOKforBS(final List<T> a, final int index, T key, final boolean gt, final boolean\
    \ eq) {\n\t\tint compare = a.get(index).compareTo(key);\n\t\treturn (compare >\
    \ 0 && gt) || (compare < 0 && !gt) || (compare == 0 && eq);\n\t}\n\tpublic static\
    \ final <T> int lowerBound(final List<T> a, final T key, final Comparator<? super\
    \ T> c) { return BS(a, key, true, true, true, c); }\n\tpublic static final <T>\
    \ int lowerBound(final List<T> a, final T key, final int ng, final int ok, final\
    \ Comparator<? super T> c) { return BS(a, key, true, true, true, ng, ok, c); }\n\
    \tpublic static final <T> int upperBound(final List<T> a, final T key, final Comparator<?\
    \ super T> c) { return BS(a, key, true, true, false, c); }\n\tpublic static final\
    \ <T> int upperBound(final List<T> a, final T key, final int ng, final int ok,\
    \ final Comparator<? super T> c) { return BS(a, key, true, true, false, ng, ok,\
    \ c); }\n\tpublic static final <T> int cntBS(final List<T> a, final T key, final\
    \ boolean asc, final boolean gt, final boolean eq, final Comparator<? super T>\
    \ c) { return BS(a, key, asc, gt, eq, true, c); }\n\tpublic static final <T> int\
    \ cntBS(final List<T> a, final T key,\n\t\t\tfinal boolean asc, final boolean\
    \ gt, final boolean eq, final int ng, final int ok, final Comparator<? super T>\
    \ c) { return BS(a, key, asc, gt, eq, true, ng, ok, c); }\n\tpublic static final\
    \ <T> int BS(final List<T> a, final T key,\n\t\t\tfinal boolean asc, final boolean\
    \ gt, final boolean eq, final Comparator<? super T> c) { return BS(a, key, asc,\
    \ gt, eq, false, c); }\n\tpublic static final <T> int BS(final List<T> a, final\
    \ T key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean eq, final int\
    \ ng, final int ok, final Comparator<? super T> c) { return BS(a, key, asc, gt,\
    \ eq, false, ng, ok, c); }\n\tpublic static final <T> int BS(final List<T> a,\
    \ final T key,\n\t\t\tfinal boolean asc, final boolean gt, final boolean eq, final\
    \ boolean cnt, final Comparator<? super T> c) { return BS(a, key, asc, gt, eq,\
    \ cnt, asc ^ gt ? a.size() : -1, asc ^ gt ? -1 : a.size(), c); }\n\tpublic static\
    \ final <T> int BS(final List<T> a, final T key, final boolean asc, final boolean\
    \ gt, final boolean eq, final boolean cnt, final int ng, final int ok, final Comparator<?\
    \ super T> c) {\n\t\tint index = binarySearch(a, key, gt, eq, ng, ok, c);\n\t\t\
    return cnt ? (int)abs(ok - index) : index;\n\t}\n\tpublic static final <T> int\
    \ binarySearch(final List<T> a, final T key, final boolean gt, final boolean eq,\
    \ int ng, int ok, final Comparator<? super T> c) {\n\t\twhile(abs(ok - ng) > 1)\
    \ { int mid = (ok + ng) >> 1; if(isOKforBS(a, mid, key, gt, eq, c)) ok = mid;\
    \ else ng = mid; }\n\t\treturn ok;\n\t}\n\tpublic static final <T> boolean isOKforBS(final\
    \ List<T> a, final int index, final T key, final boolean gt, final boolean eq,\
    \ final Comparator<? super T> c) {\n\t\tint compare = c.compare(a.get(index),\
    \ key);\n\t\treturn (compare > 0 && gt) || (compare < 0 && !gt) || (compare ==\
    \ 0 && eq);\n\t}\n\n\t// public static final PairLL binaryRangeSearch(final long\
    \ left, final long right, final UnaryOperator<Long> op, final boolean minimize)\
    \ {\n\t// \tlong ok1 = right, ng1 = left;\n\t// \twhile(abs(ok1 - ng1) > 1) {\n\
    \t// \t\tlong mid = (ok1 + ng1) >> 1;\n\t// \t\tboolean isOK = (op.apply(mid +\
    \ 1) - op.apply(mid)) * (minimize ? 1 : -1) >= 0;\n\t// \t\tif(isOK) ok1 = mid;\
    \ else ng1 = mid;\n\t// \t}\n\t// \tlong ok2 = left, ng2 = right;\n\t// \twhile(abs(ok2\
    \ - ng2) > 1) {\n\t// \t\tlong mid = (ok2 + ng2) >> 1;\n\t// \t\tboolean isOK\
    \ = (op.apply(mid - 1) - op.apply(mid)) * (minimize ? 1 : -1) >= 0;\n\t// \t\t\
    if(isOK) ok2 = mid; else ng2 = mid;\n\t// \t}\n\t// \treturn new PairLL(ok1, ok2);\
    \ //[l, r]\n\t// }\n\n\tpublic static final double ternarySearch(double left,\
    \ double right, final UnaryOperator<Double> op, final boolean minimize, final\
    \ int loop) {\n\t\tfor(int cnt = 0; cnt < loop; cnt ++) {\n\t\t\tdouble m1 = (left\
    \ * 2 + right) / 3.0;\n\t\t\tdouble m2 = (left + right * 2) / 3.0;\n\t\t\tif(op.apply(m1)\
    \ > op.apply(m2) ^ minimize) right = m2; else left = m1;\n\t\t}\n\t\treturn (left\
    \ + right) / 2.0;\n\t}\n}"
  dependsOn:
  - library/FastInputStream.java
  - library/FastOutputStream.java
  isVerificationFile: false
  path: library/Util.java
  requiredBy:
  - library/Convolution.java
  - library/Solver.java
  - library/ExtendedConvolution.java
  - library/Mod.java
  timestamp: '2022-09-20 14:50:17+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/Util.java
layout: document
redirect_from:
- /library/library/Util.java
- /library/library/Util.java.html
title: library/Util.java
---
