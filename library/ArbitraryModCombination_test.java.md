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
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=1501
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/ArbitraryModCombination_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=1501\n\
    \npackage library;\n\nimport library.Solver;\nimport library.ArbitraryMod;\n\n\
    public class ArbitraryModCombination_test extends Solver {\n\tpublic static void\
    \ main(final String[] args) { main(args, new ArbitraryModCombination_test());\
    \ }\n\n\tpublic void solve() {\n\t\tMod md = new ArbitraryMod(100_000_007);\n\t\
    \tint r = ni();\n\t\tint c = ni();\n\t\tint a1 = ni();\n\t\tint a2 = ni();\n\t\
    \tint b1 = ni();\n\t\tint b2 = ni();\n\t\tint x = Math.min(Math.abs(a1 - b1),\
    \ r - Math.abs(a1 - b1));\n\t\tint y = Math.min(Math.abs(a2 - b2), c - Math.abs(a2\
    \ - b2));\n\t\tlong ans = md.C(x + y, x);\n\t\tif(x * 2 == r) ans = md.mul(ans,\
    \ 2);\n\t\tif(y * 2 == c) ans = md.mul(ans, 2);\n\t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/ArbitraryMod.java
  isVerificationFile: true
  path: library/ArbitraryModCombination_test.java
  requiredBy: []
  timestamp: '2022-09-20 14:50:17+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/ArbitraryModCombination_test.java
layout: document
redirect_from:
- /verify/library/ArbitraryModCombination_test.java
- /verify/library/ArbitraryModCombination_test.java.html
title: library/ArbitraryModCombination_test.java
---
