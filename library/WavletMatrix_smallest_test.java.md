---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':x:'
    path: library/WavletMatrix.java
    title: library/WavletMatrix.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_6_A
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/WavletMatrix_smallest_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_6_A\n\
    \npackage library;\n\nimport library.Solver;\nimport library.WavletMatrix;\n\n\
    public class WavletMatrix_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new WavletMatrix_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tWaveletMatrix wm = new WaveletMatrix(ni(n));\n\t\t\
    long sorted[] = new long[n];\n\t\tfor(int i = 0; i < n; i ++) sorted[i] = wm.smallest(0,\
    \ n, i);\n\t\tprtln(sorted);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/WavletMatrix.java
  isVerificationFile: true
  path: library/WavletMatrix_smallest_test.java
  requiredBy: []
  timestamp: '2022-09-22 16:52:53+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/WavletMatrix_smallest_test.java
layout: document
redirect_from:
- /verify/library/WavletMatrix_smallest_test.java
- /verify/library/WavletMatrix_smallest_test.java.html
title: library/WavletMatrix_smallest_test.java
---
