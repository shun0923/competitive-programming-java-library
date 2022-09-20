---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryModCombination_test.java
    title: library/ArbitraryModCombination_test.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryModOperation_test.java
    title: library/ArbitraryModOperation_test.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryModPow_test.java
    title: library/ArbitraryModPow_test.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryModRandom_test.java
    title: library/ArbitraryModRandom_test.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryModSqrt_test.java
    title: library/ArbitraryModSqrt_test.java
  - icon: ':heavy_check_mark:'
    path: library/Convolution107_test.java
    title: library/Convolution107_test.java
  - icon: ':heavy_check_mark:'
    path: library/Convolution998_test.java
    title: library/Convolution998_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/ManyFastIO_test.java
    title: library/ManyFastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107ManyCombination_test.java
    title: library/Mod107ManyCombination_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107Pow_test.java
    title: library/Mod107Pow_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107Random_test.java
    title: library/Mod107Random_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod998ManyCombination_test.java
    title: library/Mod998ManyCombination_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod998Random_test.java
    title: library/Mod998Random_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Solver.java\n"
  code: "package library;\n\nimport library.Util;\n\nabstract class Solver extends\
    \ Util implements Runnable {\n\tpublic static void main(final String[] args, Runnable\
    \ solver) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"-DEBUG\");\n\t\t\
    Thread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace();\
    \ System.exit(1); });\n\t\tnew Thread(null, solver, \"\", 1 << 31).start();\n\t\
    }\n\t@Override\n\tpublic void run() { solve(); flush(); }\n\tabstract public void\
    \ solve();\n}"
  dependsOn:
  - library/Util.java
  isVerificationFile: false
  path: library/Solver.java
  requiredBy: []
  timestamp: '2022-09-20 14:50:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Convolution998_test.java
  - library/ArbitraryModOperation_test.java
  - library/HelloWorld_test.java
  - library/ArbitraryModCombination_test.java
  - library/Mod998Random_test.java
  - library/Mod998ManyCombination_test.java
  - library/Mod107Pow_test.java
  - library/Mod107Random_test.java
  - library/ArbitraryModSqrt_test.java
  - library/ManyFastIO_test.java
  - library/ArbitraryModPow_test.java
  - library/Mod107ManyCombination_test.java
  - library/Convolution107_test.java
  - library/FastIO_test.java
  - library/ArbitraryModRandom_test.java
documentation_of: library/Solver.java
layout: document
redirect_from:
- /library/library/Solver.java
- /library/library/Solver.java.html
title: library/Solver.java
---
