---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Convolution.java
    title: library/Convolution.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/convolution_mod
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Convolution998_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/convolution_mod\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Convolution;\n\n\
    public class Convolution998_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Convolution998_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tprtln(Convolution998.cnv.cnv(nl(n),\
    \ nl(m)));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Convolution.java
  isVerificationFile: true
  path: library/Convolution998_test.java
  requiredBy: []
  timestamp: '2022-09-20 15:28:33+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Convolution998_test.java
layout: document
redirect_from:
- /verify/library/Convolution998_test.java
- /verify/library/Convolution998_test.java.html
title: library/Convolution998_test.java
---
