---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':x:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':x:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':x:'
    path: library/Util.java
    title: library/Util.java
  - icon: ':x:'
    path: test/ArbitraryMod_test.java
    title: test/ArbitraryMod_test.java
  - icon: ':x:'
    path: test/FastIO_test.java
    title: test/FastIO_test.java
  - icon: ':x:'
    path: test/HelloWorld_test.java
    title: test/HelloWorld_test.java
  - icon: ':x:'
    path: test/ManyFastIO_test.java
    title: test/ManyFastIO_test.java
  - icon: ':x:'
    path: test/Mod998_test.java
    title: test/Mod998_test.java
  _extendedRequiredBy:
  - icon: ':x:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':x:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':x:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':x:'
    path: library/Util.java
    title: library/Util.java
  _extendedVerifiedWith:
  - icon: ':x:'
    path: test/ArbitraryMod_test.java
    title: test/ArbitraryMod_test.java
  - icon: ':x:'
    path: test/FastIO_test.java
    title: test/FastIO_test.java
  - icon: ':x:'
    path: test/HelloWorld_test.java
    title: test/HelloWorld_test.java
  - icon: ':x:'
    path: test/ManyFastIO_test.java
    title: test/ManyFastIO_test.java
  - icon: ':x:'
    path: test/Mod998_test.java
    title: test/Mod998_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: test/Mod107_test.java\n"
  code: "// verification-helper: PROBLEM https://onlinejudge.u-aizu.ac.jp/courses/lesson/2/ITP1/1/ITP1_1_A\n\
    package test;\n\nimport library.Util;\nimport library.Mod107;\n\npublic class\
    \ Mod107_test extends Util {\n\tpublic static void main(final String[] args) {\n\
    \t\tDEBUG = args.length > 0 && args[0].equals(\"-DEBUG\");\n\t\tThread.setDefaultUncaughtExceptionHandler((t,\
    \ e) -> { flush(); e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null,\
    \ new Mod107_test(), \"\", 1 << 31).start();\n\t}\n\n\tpublic void solve() {\n\
    \t\tRandom rnd = new Random(0);\n\t\tfor(int i = 0; i < 10000000; i ++) checkAdd(rnd.nextInt(),\
    \ rnd.nextInt());\n\t\tfor(int i = 0; i < 10000000; i ++) checkMul(rnd.nextInt(),\
    \ rnd.nextInt());\n\t\tfor(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(),\
    \ rnd.nextInt());\n\t\tfor(int i = 0; i < 10000000; i ++) checkDiv(rnd.nextInt(),\
    \ rnd.nextInt());\n\t\tfor(int x = -3000; x <= 3000; x ++) {\n\t\t\tfor(int y\
    \ = -3000; y <= 3000; y ++) {\n\t\t\t\tcheckDiv(x, y);\n\t\t\t}\n\t\t}\n\t\tprtln(\"\
    Hello World\");\n\t}\n\n\tpublic void checkAdd(long x, long y) {\n\t\tlong z =\
    \ (x + y) % 1_000_000_007; if(z < 0) z += 1_000_000_007;\n\t\tassertion(z == Mod107.md.add(x,\
    \ y));\n\t}\n\tpublic void checkMul(long x, long y) {\n\t\tlong z = (x * y) %\
    \ 1_000_000_007; if(z < 0) z += 1_000_000_007;\n\t\tassertion(z == Mod107.md.mul(x,\
    \ y));\n\t}\n\tpublic void checkDiv(long x, long y) {\n\t\tif(y == 0) return;\n\
    \t\tlong z = Mod107.md.div(x, y);\n\t\tassertion(z >= 0 && z < 1_000_000_007 &&\
    \ (z * y - x) % 1_000_000_007 == 0);\n\t}\n}"
  dependsOn:
  - test/HelloWorld_test.java
  - test/ArbitraryMod_test.java
  - test/ManyFastIO_test.java
  - test/Mod998_test.java
  - test/FastIO_test.java
  - library/Util.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  - library/Mod.java
  isVerificationFile: true
  path: test/Mod107_test.java
  requiredBy:
  - library/Util.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  - library/Mod.java
  timestamp: '2022-09-16 20:39:02+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith:
  - test/HelloWorld_test.java
  - test/ArbitraryMod_test.java
  - test/ManyFastIO_test.java
  - test/Mod998_test.java
  - test/FastIO_test.java
documentation_of: test/Mod107_test.java
layout: document
redirect_from:
- /verify/test/Mod107_test.java
- /verify/test/Mod107_test.java.html
title: test/Mod107_test.java
---
