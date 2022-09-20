---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/FastInputStream.java
    title: library/FastInputStream.java
  - icon: ':heavy_check_mark:'
    path: library/FastOutputStream.java
    title: library/FastOutputStream.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
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
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/aplusb\n\n\
    package library;\n\nimport library.Solver;\nimport library.FastInputStream;\n\
    import library.FastOutputStream;\n\npublic class FastIO_test extends Solver {\n\
    \tpublic static void main(final String[] args) { main(args, new FastIO_test());\
    \ }\n\n\tpublic void solve() {\n\t\tprtln(nl() + nl());\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/FastInputStream.java
  - library/FastOutputStream.java
  isVerificationFile: true
  path: library/FastIO_test.java
  requiredBy: []
  timestamp: '2022-09-20 14:50:17+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/FastIO_test.java
layout: document
redirect_from:
- /verify/library/FastIO_test.java
- /verify/library/FastIO_test.java.html
title: library/FastIO_test.java
---
