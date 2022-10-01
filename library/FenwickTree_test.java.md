---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/FenwickTree.java
    title: library/FenwickTree.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/point_add_range_sum
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/FenwickTree_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/point_add_range_sum\n\
    \npackage library;\n\nimport library.Solver;\nimport library.FenwickTree;\n\n\
    public class FenwickTree_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new FenwickTree_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tFenwickTree ft = new FenwickTree(nl(n));\n\
    \t\tfor(int i = 0; i < q; i ++) {\n\t\t\tif(ni() == 0) ft.add(ni(), nl());\n\t\
    \t\telse prtln(ft.sum(ni(), ni()));\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/FenwickTree.java
  isVerificationFile: true
  path: library/FenwickTree_test.java
  requiredBy: []
  timestamp: '2022-09-20 15:30:32+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/FenwickTree_test.java
layout: document
redirect_from:
- /verify/library/FenwickTree_test.java
- /verify/library/FenwickTree_test.java.html
title: library/FenwickTree_test.java
---
