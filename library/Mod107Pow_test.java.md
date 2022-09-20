---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Mod.java
    title: library/Mod.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.6/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/Mod107Pow_test.java\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=NTL_1_B\n\
    \npackage library;\n\nimport library.Solver;\nimport library.Mod;\n\npublic class\
    \ Mod107Pow_test extends Solver {\n\tpublic static void main(final String[] args)\
    \ { main(args, new Mod107Pow_test()); }\n\n\tpublic void solve() {\n\t\tprtln(Mod107.md.pow(nl(),\
    \ nl()));\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/Mod.java
  isVerificationFile: true
  path: library/Mod107Pow_test.java
  requiredBy: []
  timestamp: '2022-09-20 15:28:33+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/Mod107Pow_test.java
layout: document
redirect_from:
- /verify/library/Mod107Pow_test.java
- /verify/library/Mod107Pow_test.java.html
title: library/Mod107Pow_test.java
---
