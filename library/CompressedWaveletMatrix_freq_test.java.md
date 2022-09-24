---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/CompressedWaveletMatrix.java
    title: library/CompressedWaveletMatrix.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2674
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/CompressedWaveletMatrix_freq_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=2674\n\
    \npackage library;\n\nimport library.Solver;\nimport library.CompressedWaveletMatrix;\n\
    \npublic class CompressedWaveletMatrix_freq_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new CompressedWaveletMatrix_freq_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint d = ni();\n\t\tlong x[] = nl(d);\n\t\t\
    CompressedWaveletMatrix wm = new CompressedWaveletMatrix(x);\n\t\tint q = ni();\n\
    \t\tfor(int i = 0; i < q; i ++) {\n\t\t\tint l = ni() - 1;\n\t\t\tint r = ni()\
    \ - 1;\n\t\t\tint e = ni();\n\t\t\tprtln(r - l + 1 - wm.rangeFreq(min(x[l], x[r])\
    \ - e, max(x[l], x[r]) + e + 1, l, r + 1));\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/CompressedWaveletMatrix.java
  isVerificationFile: true
  path: library/CompressedWaveletMatrix_freq_test.java
  requiredBy: []
  timestamp: '2022-09-22 21:14:25+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/CompressedWaveletMatrix_freq_test.java
layout: document
redirect_from:
- /verify/library/CompressedWaveletMatrix_freq_test.java
- /verify/library/CompressedWaveletMatrix_freq_test.java.html
title: library/CompressedWaveletMatrix_freq_test.java
---
