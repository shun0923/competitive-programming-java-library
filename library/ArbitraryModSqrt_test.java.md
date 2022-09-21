---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/ArbitraryMod.java
    title: library/ArbitraryMod.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/sqrt_mod
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ArbitraryModSqrt_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/sqrt_mod\n\
    \npackage library;\n\nimport library.Solver;\nimport library.ArbitraryMod;\n\n\
    public class ArbitraryModSqrt_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new ArbitraryModSqrt_test()); }\n\n\tpublic void\
    \ solve() {\n\t\tint t = ni();\n\t\tfor(int i = 0; i < t; i ++) {\n\t\t\tlong\
    \ y = nl();\n\t\t\tlong p = nl();\n\t\t\tprtln(new ArbitraryMod(p).sqrt(y));\n\
    \t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/ArbitraryMod.java
  isVerificationFile: true
  path: library/ArbitraryModSqrt_test.java
  requiredBy: []
  timestamp: '2022-09-20 14:50:17+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ArbitraryModSqrt_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryModSqrt_test.java
- /verify/library/ArbitraryModSqrt_test.java.html
title: library/ArbitraryModSqrt_test.java
---
