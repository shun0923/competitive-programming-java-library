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
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/BellmanFord.java
    title: library/BellmanFord.java
  - icon: ':warning:'
    path: library/BitVector.java
    title: library/BitVector.java
  - icon: ':heavy_check_mark:'
    path: library/CompressedWaveletMatrix.java
    title: library/CompressedWaveletMatrix.java
  - icon: ':heavy_check_mark:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':heavy_check_mark:'
    path: library/Dijkstra.java
    title: library/Dijkstra.java
  - icon: ':heavy_check_mark:'
    path: library/DualSegmentTree.java
    title: library/DualSegmentTree.java
  - icon: ':heavy_check_mark:'
    path: library/DynamicSegmentTree.java
    title: library/DynamicSegmentTree.java
  - icon: ':heavy_check_mark:'
    path: library/DynamicSwag.java
    title: library/DynamicSwag.java
  - icon: ':heavy_check_mark:'
    path: library/ExtendedConvolution.java
    title: library/ExtendedConvolution.java
  - icon: ':heavy_check_mark:'
    path: library/FenwickTree.java
    title: library/FenwickTree.java
  - icon: ':heavy_check_mark:'
    path: library/Kruskal.java
    title: library/Kruskal.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Pair.java
    title: library/Pair.java
  - icon: ':heavy_check_mark:'
    path: library/PathRestoration.java
    title: library/PathRestoration.java
  - icon: ':heavy_check_mark:'
    path: library/Permutation.java
    title: library/Permutation.java
  - icon: ':x:'
    path: library/Scc.java
    title: library/Scc.java
  - icon: ':heavy_check_mark:'
    path: library/SegmentTree.java
    title: library/SegmentTree.java
  - icon: ':heavy_check_mark:'
    path: library/SparseTable.java
    title: library/SparseTable.java
  - icon: ':heavy_check_mark:'
    path: library/Swag.java
    title: library/Swag.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra.java
    title: library/TemplateDijkstra.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDualSegmentTree.java
    title: library/TemplateDualSegmentTree.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDynamicSegmentTree.java
    title: library/TemplateDynamicSegmentTree.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDynamicSwag.java
    title: library/TemplateDynamicSwag.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSegmentTree.java
    title: library/TemplateSegmentTree.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSparseTable.java
    title: library/TemplateSparseTable.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSwag.java
    title: library/TemplateSwag.java
  - icon: ':heavy_check_mark:'
    path: library/UnionFind.java
    title: library/UnionFind.java
  - icon: ':warning:'
    path: library/Util.java
    title: library/Util.java
  - icon: ':heavy_check_mark:'
    path: library/WarshallFloyd.java
    title: library/WarshallFloyd.java
  - icon: ':heavy_check_mark:'
    path: library/WaveletMatrix.java
    title: library/WaveletMatrix.java
  - icon: ':x:'
    path: library/WeightedUnionFind.java
    title: library/WeightedUnionFind.java
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport library.FastInputStream;\nimport library.FastOutputStream;\n\
    \nclass SimpleUtil {\n\tpublic static boolean DEBUG;\n\n\tprivate static final\
    \ FastInputStream in = new FastInputStream(System.in);\n\tpublic static final\
    \ String nline() { return in.nextLine(); }\n\tpublic static final String[] nline(final\
    \ int n) { final String a[] = new String[n]; for(int i = 0; i < n; i ++) a[i]\
    \ = nline(); return a; }\n\tpublic static final char nc() { return in.nextChar();\
    \ }\n\tpublic static final char[] nc(int n) {\n\t\tfinal String str = nline();\n\
    \t\tif(n < 0) n = str.length();\n\t\tfinal char a[] = new char[n];\n\t\tfor(int\
    \ i = 0; i < n; i ++) a[i] = str.charAt(i);\n\t\treturn a;\n\t}\n\tpublic static\
    \ final char[][] nc(final int n, final int m) { final char a[][] = new char[n][m];\
    \ for(int i = 0; i < n; i ++) a[i] = nc(m); return a; }\n\tpublic static final\
    \ boolean[] nb(int n, final char t) {\n\t\tfinal char c[] = nc(-1);\n\t\tif(n\
    \ < 0) n = c.length;\n\t\tfinal boolean a[] = new boolean[n];\n\t\tfor(int i =\
    \ 0; i < n; i ++) a[i] = c[i] == t;\n\t\treturn a;\n\t}\n\tpublic static final\
    \ boolean[][] nb(final int n, final int m, final char t) { final boolean a[][]\
    \ = new boolean[n][]; for(int i = 0; i < n; i ++) a[i] = nb(m, t); return a; }\n\
    \tpublic static final int ni() { return in.nextInt(); }\n\tpublic static final\
    \ int[] ni(final int n) { final int a[] = new int[n]; for(int i = 0; i < n; i\
    \ ++) a[i] = ni(); return a; }\n\tpublic static final int[][] ni(final int n,\
    \ final int m) { final int a[][] = new int[n][]; for(int i = 0; i < n; i ++) a[i]\
    \ = ni(m); return a; }\n\tpublic static final long nl() { return in.nextLong();\
    \ }\n\tpublic static final long[] nl(final int n) { final long a[] = new long[n];\
    \ for(int i = 0; i < n; i ++) a[i] = nl(); return a; }\n\tpublic static final\
    \ long[][] nl(final int n, final int m) { final long a[][] = new long[n][]; for(int\
    \ i = 0; i < n; i ++) a[i] = nl(m); return a; }\n\tpublic static final double\
    \ nd() { return in.nextDouble(); }\n\tpublic static final double[] nd(final int\
    \ n) { final double a[] = new double[n]; for(int i = 0; i < n; i ++) a[i] = nd();\
    \ return a; }\n\tpublic static final double[][] nd(final int n, final int m) {\
    \ final double a[][] = new double[n][]; for(int i = 0; i < n; i ++) a[i] = nd(m);\
    \ return a; }\n\tpublic static final String ns() { return in.next(); }\n\tpublic\
    \ static final String[] ns(final int n) { final String a[] = new String[n]; for(int\
    \ i = 0; i < n; i ++) a[i] = ns(); return a; }\n\tpublic static final String[][]\
    \ ns(final int n, final int m) { final String a[][] = new String[n][]; for(int\
    \ i = 0; i < n; i ++) a[i] = ns(m); return a; }\n\n\tprivate static final FastOutputStream\
    \ out = new FastOutputStream(System.out);\n\tprivate static final FastOutputStream\
    \ err = new FastOutputStream(System.err);\n\tpublic static final void prt() {\
    \ out.print(); }\n\tpublic static final void prt(final char c) { out.print(c);\
    \ }\n\tpublic static final void prt(final boolean b) { out.print(b); }\n\tpublic\
    \ static final void prt(final int x) { out.print(x); }\n\tpublic static final\
    \ void prt(final long x) { out.print(x); }\n\tpublic static final void prt(final\
    \ double d) { out.print(d); }\n\tpublic static final void prt(final String s)\
    \ { out.print(s); }\n\tpublic static final void prt(final Object o) { out.print(o);\
    \ }\n\tpublic static final void prtln() { out.println(); }\n\tpublic static final\
    \ void prtln(final char c) { out.println(c); }\n\tpublic static final void prtln(final\
    \ boolean b) { out.println(b); }\n\tpublic static final void prtln(final int x)\
    \ { out.println(x); }\n\tpublic static final void prtln(final long x) { out.println(x);\
    \ }\n\tpublic static final void prtln(final double d) { out.println(d); }\n\t\
    public static final void prtln(final String s) { out.println(s); }\n\tpublic static\
    \ final void prtln(final Object o) { out.println(o); }\n\tpublic static final\
    \ void prtln(final char... a) { out.println(a); }\n\tpublic static final void\
    \ prtln(final boolean... a) { out.println(booleanToChar(a)); }\n\tpublic static\
    \ final void prtln(final int... a) { out.println(a); }\n\tpublic static final\
    \ void prtln(final long... a) { out.println(a); }\n\tpublic static final void\
    \ prtln(final double... a) { out.println(a); }\n\tpublic static final void prtln(final\
    \ double[] a, int precision) { out.println(a, precision); }\n\tpublic static final\
    \ void prtln(final String... a) { out.println(a); }\n\tpublic static final void\
    \ prtln(final Object[] a) { out.println(a); }\n\tpublic static final void prtlns(final\
    \ char... a) { for(char ele : a) prtln(ele); }\n\tpublic static final void prtlns(final\
    \ boolean... a) { for(boolean ele : a) prtln(ele); }\n\tpublic static final void\
    \ prtlns(final int... a) { for(int ele : a) prtln(ele); }\n\tpublic static final\
    \ void prtlns(final long... a) { for(long ele : a) prtln(ele); }\n\tpublic static\
    \ final void prtlns(final double... a) { for(double ele : a) prtln(ele); }\n\t\
    public static final void prtlns(final Object[] a) { for(Object ele : a) prtln(ele);\
    \ }\n\tpublic static final void prtln(final char[][] a) { for(char[] ele : a)\
    \ prtln(ele); }\n\tpublic static final void prtln(final boolean[][] a) { for(boolean[]\
    \ ele : a) prtln(ele); }\n\tpublic static final void prtln(final int[][] a) {\
    \ for(int[] ele : a) prtln(ele); }\n\tpublic static final void prtln(final long[][]\
    \ a) { for(long[] ele : a) prtln(ele); }\n\tpublic static final void prtln(final\
    \ double[][] a) { for(double[] ele : a) prtln(ele); }\n\tpublic static final void\
    \ prtln(final double[][] a, int precision) { for(double[] ele : a) prtln(ele,\
    \ precision); }\n\tpublic static final void prtln(final String[][] a) { for(String[]\
    \ ele : a) prtln(ele); }\n\tpublic static final void prtln(final Object[][] a)\
    \ { for(Object[] ele : a) prtln(ele); }\n\n\tpublic static final void errprt()\
    \ { if(DEBUG) err.print(); }\n\tpublic static final void errprt(final char c)\
    \ { if(DEBUG) err.print(c); }\n\tpublic static final void errprt(final boolean\
    \ b) { if(DEBUG) err.print(booleanToChar(b)); }\n\tpublic static final void errprt(final\
    \ int x) { if(DEBUG) if(isINF(x)) err.print('_'); else err.print(x); }\n\tpublic\
    \ static final void errprt(final long x) { if(DEBUG) if(isINF(x)) err.print('_');\
    \ else err.print(x); }\n\tpublic static final void errprt(final double d) { if(DEBUG)\
    \ err.print(d); }\n\tpublic static final void errprt(final String s) { if(DEBUG)\
    \ err.print(s); }\n\tpublic static final void errprt(final Object o) { if(DEBUG)\
    \ err.print(o); }\n\tpublic static final void errprtln() { if(DEBUG) err.println();\
    \ }\n\tpublic static final void errprtln(final char c) { if(DEBUG) err.println(c);\
    \ }\n\tpublic static final void errprtln(final boolean b) { if(DEBUG) err.println(booleanToChar(b));\
    \ }\n\tpublic static final void errprtln(final int x) { if(DEBUG) if(isINF(x))\
    \ err.println('_'); else err.println(x); }\n\tpublic static final void errprtln(final\
    \ long x) { if(DEBUG) if(isINF(x)) err.println('_'); else err.println(x); }\n\t\
    public static final void errprtln(final double d) { if(DEBUG) err.println(d);\
    \ }\n\tpublic static final void errprtln(final String s) { if(DEBUG) err.println(s);\
    \ }\n\tpublic static final void errprtln(final Object o) { if(DEBUG) err.println(o);\
    \ }\n\tpublic static final void errprtln(final char... a) { if(DEBUG) err.println(a);\
    \ }\n\tpublic static final void errprtln(final boolean... a) { if(DEBUG) err.println(booleanToChar(a));\
    \ }\n\tpublic static final void errprtln(final int... a) {\n\t\tif(DEBUG) {\n\t\
    \t\tboolean start = false;\n\t\t\tfor(int ele : a) {\n\t\t\t\terrprt(ele);\n\t\
    \t\t\tif(!start) errprt(' ');\n\t\t\t\tstart = false;\n\t\t\t}\n\t\t\terr.println();\n\
    \t\t}\n\t}\n\tpublic static final void errprtln(final long... a) {\n\t\tif(DEBUG)\
    \ {\n\t\t\tboolean start = false;\n\t\t\tfor(long ele : a) {\n\t\t\t\terrprt(ele);\n\
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
    \ int x) { return isPlusINF(x) || isMinusINF(x); }\n}"
  dependsOn:
  - library/FastInputStream.java
  - library/FastOutputStream.java
  isVerificationFile: false
  path: library/SimpleUtil.java
  requiredBy:
  - library/WaveletMatrix.java
  - library/DynamicSegmentTree.java
  - library/TemplateDualSegmentTree.java
  - library/Util.java
  - library/Mod.java
  - library/Pair.java
  - library/TemplateSwag.java
  - library/Kruskal.java
  - library/UnionFind.java
  - library/TemplateDijkstra.java
  - library/BellmanFord.java
  - library/WarshallFloyd.java
  - library/ExtendedConvolution.java
  - library/SegmentTree.java
  - library/TemplateDynamicSwag.java
  - library/Dijkstra.java
  - library/TemplateSegmentTree.java
  - library/SparseTable.java
  - library/DualSegmentTree.java
  - library/Swag.java
  - library/Convolution.java
  - library/Scc.java
  - library/Permutation.java
  - library/AbstractGraph.java
  - library/BitVector.java
  - library/WeightedUnionFind.java
  - library/FenwickTree.java
  - library/DynamicSwag.java
  - library/TemplateDynamicSegmentTree.java
  - library/CompressedWaveletMatrix.java
  - library/TemplateSparseTable.java
  - library/PathRestoration.java
  timestamp: '2022-10-03 15:04:10+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/SimpleUtil.java
layout: document
redirect_from:
- /library/library/SimpleUtil.java
- /library/library/SimpleUtil.java.html
title: library/SimpleUtil.java
---
