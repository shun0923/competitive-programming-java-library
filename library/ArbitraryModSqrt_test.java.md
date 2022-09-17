---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
  - icon: ':question:'
    path: library/Util.java
    title: library/Util.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/sqrt_mod
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ArbitraryModSqrt_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/sqrt_mod\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Util;\nimport library.ArbitraryMod;\n\
    \npublic class ArbitraryModSqrt_test extends Util {\n\tpublic static void main(final\
    \ String[] args) {\n\t\tDEBUG = args.length > 0 && args[0].equals(\"-DEBUG\");\n\
    \t\tThread.setDefaultUncaughtExceptionHandler((t, e) -> { flush(); e.printStackTrace();\
    \ System.exit(1); });\n\t\tnew Thread(null, new ArbitraryModSqrt_test(), \"\"\
    , 1 << 31).start();\n\t}\n\n\tpublic void solve() {\n\t\tint t = ni();\n\t\tfor(int\
    \ i = 0; i < t; i ++) {\n\t\t\tlong y = nl();\n\t\t\tlong p = nl();\n\t\t\tprtln(new\
    \ ArbitraryMod(p).sqrt(y));\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Util.java
  - library/ArbitraryMod.java
  isVerificationFile: true
  path: library/ArbitraryModSqrt_test.java
  requiredBy: []
  timestamp: '2022-09-17 17:52:24+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/ArbitraryModSqrt_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryModSqrt_test.java
- /verify/library/ArbitraryModSqrt_test.java.html
title: library/ArbitraryModSqrt_test.java
---
