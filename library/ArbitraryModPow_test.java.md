---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
  - icon: ':heavy_check_mark:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ArbitraryModPow_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Util;\nimport library.ArbitraryMod;\n\
    \npublic class ArbitraryModPow_test extends Util {\n\tpublic static void main(final\
    \ String[] args) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"-DEBUG\");\n\
    \t\tThread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace();\
    \ System.exit(1); });\n\t\tnew Thread(null, new ArbitraryModPow_test(), \"\",\
    \ 1 << 31).start();\n\t}\n\n\tpublic void solve() {\n\t\tprtln(new ArbitraryMod(1_000_000_007).pow(nl(),\
    \ nl()));\n\t}\n}"
  dependsOn:
  - library/Util.java
  - library/ArbitraryMod.java
  isVerificationFile: true
  path: library/ArbitraryModPow_test.java
  requiredBy: []
  timestamp: '2022-09-17 17:14:12+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ArbitraryModPow_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryModPow_test.java
- /verify/library/ArbitraryModPow_test.java.html
title: library/ArbitraryModPow_test.java
---
