---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/ArbitraryMod_test.java
    title: library/ArbitraryMod_test.java
  - icon: ':question:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':question:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':x:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  - icon: ':heavy_check_mark:'
    path: test/FastIO_test.java
    title: test/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: test/HelloWorld_test.java
    title: test/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: test/ManyFastIO_test.java
    title: test/ManyFastIO_test.java
  - icon: ':x:'
    path: test/Mod998_test.java
    title: test/Mod998_test.java
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
  - icon: ':x:'
    path: library/ArbitraryMod_test.java
    title: library/ArbitraryMod_test.java
  - icon: ':x:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':heavy_check_mark:'
    path: test/FastIO_test.java
    title: test/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: test/HelloWorld_test.java
    title: test/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: test/ManyFastIO_test.java
    title: test/ManyFastIO_test.java
  - icon: ':x:'
    path: test/Mod998_test.java
    title: test/Mod998_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/aplusb
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/FastIO_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/aplusb\n\
    package library;\n\npublic class FastIO_test extends Util {\n\tpublic static void\
    \ main(final String[] args) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"\
    -DEBUG\");\n\t\tThread.setDefaultUncaughtExceptionHandler((t, e) -> { flush();\
    \ e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null, new FastIO_test(),\
    \ \"\", 1 << 31).start();\n\t}\n\n\tpublic void solve() {\n\t\tprtln(nl() + nl());\n\
    \t}\n}"
  dependsOn:
  - test/HelloWorld_test.java
  - test/ManyFastIO_test.java
  - test/Mod998_test.java
  - test/FastIO_test.java
  - library/ArbitraryMod_test.java
  - library/Util.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  - library/Mod.java
  - library/Mod107_test.java
  isVerificationFile: true
  path: library/FastIO_test.java
  requiredBy:
  - library/Util.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  - library/Mod.java
  timestamp: '2022-09-16 21:13:27+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith:
  - test/HelloWorld_test.java
  - test/ManyFastIO_test.java
  - test/Mod998_test.java
  - test/FastIO_test.java
  - library/ArbitraryMod_test.java
  - library/Mod107_test.java
documentation_of: library/FastIO_test.java
layout: document
redirect_from:
- /verify/library/FastIO_test.java
- /verify/library/FastIO_test.java.html
title: library/FastIO_test.java
---
