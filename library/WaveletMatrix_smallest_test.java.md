---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/WaveletMatrix.java
    title: library/WaveletMatrix.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/range_kth_smallest
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/WaveletMatrix_smallest_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/range_kth_smallest\n\
    \npackage library;\n\nimport library.Solver;\nimport library.WaveletMatrix;\n\n\
    public class WaveletMatrix_smallest_test extends Solver {\n\tpublic static void\
    \ main(final String[] args) { main(args, new WaveletMatrix_smallest_test()); }\n\
    \n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tWaveletMatrix\
    \ wm = new WaveletMatrix(ni(n));\n\t\tfor(int i = 0; i < q; i ++) prtln(wm.smallest(ni(),\
    \ ni(), ni()));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/WaveletMatrix.java
  isVerificationFile: true
  path: library/WaveletMatrix_smallest_test.java
  requiredBy: []
  timestamp: '2022-09-22 21:14:01+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/WaveletMatrix_smallest_test.java
layout: document
redirect_from:
- /verify/library/WaveletMatrix_smallest_test.java
- /verify/library/WaveletMatrix_smallest_test.java.html
title: library/WaveletMatrix_smallest_test.java
---
