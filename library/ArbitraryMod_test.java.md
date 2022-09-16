---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':question:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':question:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/ManyFastIO_test.java
    title: library/ManyFastIO_test.java
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':x:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':x:'
    path: library/Mod998_test.java
    title: library/Mod998_test.java
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy:
  - icon: ':question:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':question:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/ManyFastIO_test.java
    title: library/ManyFastIO_test.java
  - icon: ':x:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':x:'
    path: library/Mod998_test.java
    title: library/Mod998_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ArbitraryMod_test.java\n"
  code: "// verification-helper: PROBLEM https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A\n\
    package library;\n\nimport library.ArbitraryMod;\nimport java.util.*;\n\npublic\
    \ class ArbitraryMod_test extends Util {\n\tpublic static void main(final String[]\
    \ args) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"-DEBUG\");\n\t\tThread.setDefaultUncaughtExceptionHandler((t,\
    \ e) -> { flush(); e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null,\
    \ new ArbitraryMod_test(), \"\", 1 << 31).start();\n\t}\n\n\tpublic void solve()\
    \ {\n\t\tRandom rnd = new Random(0);\n\t\tfor(int i = 0; i < 10000000; i ++) checkAdd(rnd.nextInt(),\
    \ rnd.nextInt(), rnd.nextInt(Integer.MAX_VALUE - 1) + 1);\n\t\tfor(int i = 0;\
    \ i < 10000000; i ++) checkMul(rnd.nextInt(), rnd.nextInt(), rnd.nextInt(Integer.MAX_VALUE\
    \ - 1) + 1);\n\t\tfor(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(), rnd.nextInt(),\
    \ 998_244_353);\n\t\tfor(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(),\
    \ rnd.nextInt(), 1_000_000_007);\n\t\tfor(int x = -100; x <= 100; x ++) {\n\t\t\
    \tfor(int y = -100; y <= 100; y ++) {\n\t\t\t\tfor(int m = 1; m <= 1000; m ++)\
    \ {\n\t\t\t\t\tcheckAdd(x, y, m);\n\t\t\t\t\tcheckMul(x, y, m);\n\t\t\t\t}\n\t\
    \t\t\tcheckDiv(x, y, 998_244_353);\n\t\t\t}\n\t\t}\n\t\tprtln(\"Hello World\"\
    );\n\t}\n\n\tpublic void checkAdd(long x, long y, long m) {\n\t\tlong z = (x +\
    \ y) % m; if(z < 0) z += m;\n\t\tassertion(z == new ArbitraryMod(m).add(x, y));\n\
    \t}\n\tpublic void checkMul(long x, long y, long m) {\n\t\tlong z = (x * y) %\
    \ m; if(z < 0) z += m;\n\t\tassertion(z == new ArbitraryMod(m).mul(x, y));\n\t\
    }\n\tpublic void checkDiv(long x, long y, long m) {\n\t\tif(y == 0) return;\n\t\
    \tlong z = new ArbitraryMod(m).div(x, y);\n\t\tassertion(z >= 0 && z < m && (z\
    \ * y - x) % m == 0);\n\t}\n}"
  dependsOn:
  - library/HelloWorld_test.java
  - library/Util.java
  - library/FastInputStream.java
  - library/ManyFastIO_test.java
  - library/Mod998_test.java
  - library/FastIO_test.java
  - library/FastOutputStream.java
  - library/Mod.java
  - library/Mod107_test.java
  isVerificationFile: true
  path: library/ArbitraryMod_test.java
  requiredBy:
  - library/Util.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  - library/Mod.java
  timestamp: '2022-09-16 23:13:20+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith:
  - library/HelloWorld_test.java
  - library/ManyFastIO_test.java
  - library/Mod998_test.java
  - library/FastIO_test.java
  - library/Mod107_test.java
documentation_of: library/ArbitraryMod_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryMod_test.java
- /verify/library/ArbitraryMod_test.java.html
title: library/ArbitraryMod_test.java
---