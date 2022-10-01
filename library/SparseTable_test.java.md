---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/SparseTable.java
    title: library/SparseTable.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/staticrmq
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/SparseTable_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/staticrmq\n\
    \npackage library;\n\nimport library.Solver;\nimport library.SparseTable;\n\n\
    public class SparseTable_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new SparseTable_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tSparseTable st = new SparseTable(nl(n),\
    \ (ele1, ele2) -> min(ele1, ele2));\n\t\tfor(int i = 0; i < q; i ++) prtln(st.find(ni(),\
    \ ni()));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/SparseTable.java
  isVerificationFile: true
  path: library/SparseTable_test.java
  requiredBy: []
  timestamp: '2022-09-20 19:18:27+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/SparseTable_test.java
layout: document
redirect_from:
- /verify/library/SparseTable_test.java
- /verify/library/SparseTable_test.java.html
title: library/SparseTable_test.java
---
