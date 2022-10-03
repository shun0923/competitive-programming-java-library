---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/Permutation.java
    title: library/Permutation.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Permutation_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Permutation;\n\n\
    public class Permutation_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new Permutation_test()); }\n\n\tpublic void solve()\
    \ {\n\t\tint n = ni();\n\t\tint a0[] = new int[n];\n\t\tfor(int i = 0; i < n;\
    \ i ++) a0[i] = i + 1;\n\t\tfor(int[] a : new Permutation(a0)) prtln(a);\n\t}\n\
    }"
  dependsOn:
  - library/Solver.java
  - library/Permutation.java
  isVerificationFile: true
  path: library/Permutation_test.java
  requiredBy: []
  timestamp: '2022-10-03 14:51:55+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/Permutation_test.java
layout: document
redirect_from:
- /verify/library/Permutation_test.java
- /verify/library/Permutation_test.java.html
title: library/Permutation_test.java
---
