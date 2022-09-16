---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_test.java
    title: library/ArbitraryMod_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':heavy_check_mark:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod998_test.java
    title: library/Mod998_test.java
  - icon: ':heavy_check_mark:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
  - icon: ':heavy_check_mark:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':heavy_check_mark:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':heavy_check_mark:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':heavy_check_mark:'
    path: library/Util.java
    title: library/Util.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod_test.java
    title: library/ArbitraryMod_test.java
  - icon: ':heavy_check_mark:'
    path: library/FastIO_test.java
    title: library/FastIO_test.java
  - icon: ':heavy_check_mark:'
    path: library/HelloWorld_test.java
    title: library/HelloWorld_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod107_test.java
    title: library/Mod107_test.java
  - icon: ':heavy_check_mark:'
    path: library/Mod998_test.java
    title: library/Mod998_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/many_aplusb
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ManyFastIO_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/many_aplusb\n\
    \npackage library;\n\npublic class ManyFastIO_test extends Util {\n\tpublic static\
    \ void main(final String[] args) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"\
    -DEBUG\");\n\t\tThread.setDefaultUncaughtExceptionHandler((t, e) -> { flush();\
    \ e.printStackTrace(); System.exit(1); });\n\t\tnew Thread(null, new ManyFastIO_test(),\
    \ \"\", 1 << 31).start();\n\t}\n\n\tpublic void solve() {\n\t\tint t = ni();\n\
    \t\tfor(int i = 0; i < t; i ++) prtln(nl() + nl());\n\t}\n}"
  dependsOn:
  - library/HelloWorld_test.java
  - library/ArbitraryMod_test.java
  - library/Util.java
  - library/FastInputStream.java
  - library/Mod998_test.java
  - library/FastIO_test.java
  - library/FastOutputStream.java
  - library/Mod.java
  - library/ArbitraryMod.java
  - library/Mod107_test.java
  isVerificationFile: true
  path: library/ManyFastIO_test.java
  requiredBy:
  - library/Util.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  - library/Mod.java
  - library/ArbitraryMod.java
  timestamp: '2022-09-16 23:37:24+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith:
  - library/HelloWorld_test.java
  - library/ArbitraryMod_test.java
  - library/Mod998_test.java
  - library/FastIO_test.java
  - library/Mod107_test.java
documentation_of: library/ManyFastIO_test.java
layout: document
redirect_from:
- /verify/library/ManyFastIO_test.java
- /verify/library/ManyFastIO_test.java.html
title: library/ManyFastIO_test.java
---
